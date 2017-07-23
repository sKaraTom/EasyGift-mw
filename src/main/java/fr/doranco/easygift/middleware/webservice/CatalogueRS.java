package fr.doranco.easygift.middleware.webservice;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.doranco.easygift.middleware.dao.MoteurJpaException;
import fr.doranco.easygift.middleware.objetmetier.catalogue.CatalogueInexistantException;
import fr.doranco.easygift.middleware.objetmetier.produit.Produit;
import fr.doranco.easygift.middleware.objetmetier.produit.ProduitDejaExistantException;
import fr.doranco.easygift.middleware.objetmetier.produit.ProduitInvalideException;
import fr.doranco.easygift.middleware.service.CatalogueService;

@WebService
@Path("/catalogue")
@Transactional
public class CatalogueRS {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(CatalogueRS.class);
	
	@EJB
	private CatalogueService catalogueService;
	
	@PUT
	@Path("/{referenceCatalogue}")
	@Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response ajouterProduitAuCatalogue(
			@PathParam("referenceCatalogue") final String referenceCatalogue,
			final Produit produit
		) {

		ResponseBuilder builder = null;
		
		try {
			// Nous déléguons la responsabilité de l'ajout au service.
			catalogueService.ajouterProduitAuCatalogue(produit, referenceCatalogue);
			
			builder = Response.ok(produit);
			
			LOGGER.info("Coucou Mounir, on a réussi !");
			
		} catch (final ProduitInvalideException e) {
			builder = Response.status(Status.BAD_REQUEST);
		} catch (final ProduitDejaExistantException inexistanceException) {
			builder = Response.status(Status.CONFLICT);
		} catch (final CatalogueInexistantException e) {
			builder = Response.status(Status.NOT_FOUND);
			
			// Garde programmatique
			if (LOGGER.isErrorEnabled())
				LOGGER.error("Salut Mounir, tu nous fais chier avec ton catalogue qui n'existe pas !");
			
		} catch (final MoteurJpaException e) {
			builder = Response.status(Status.INTERNAL_SERVER_ERROR);
		};
	
		return builder.build();
	}
	
}
