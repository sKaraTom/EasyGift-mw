package fr.doranco.easygift.middleware.webservice;

import fr.doranco.easygift.middleware.objetmetier.Adresse;
import fr.doranco.easygift.middleware.objetmetier.AdresseExistanteException;
import fr.doranco.easygift.middleware.objetmetier.AdresseInexistanteException;
import fr.doranco.easygift.middleware.objetmetier.AdresseInvalideException;
import fr.doranco.easygift.middleware.service.AdresseService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@WebService
@Transactional
@Path("/adresse")
public class AdresseRS {

	@EJB
	private AdresseService adresseService;

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response obtenirAdresses() {

        List<Adresse> adresses = adresseService.obtenirAdresses();

	    final Response reponse = Response
                .ok(adresses)
                .build();

		return reponse;
	}

	@GET
	@Path("/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenirAdresse(@PathParam("uuid") final UUID identifiantAdresse) {

        Response.ResponseBuilder builder = null;

        try {

            // Cas Nominal

            final Adresse adresse = adresseService.obtenirAdresse(identifiantAdresse);

            builder = Response.ok(adresse);
            // builder = Response.status(Response.Status.OK).entity(adresse);

        } catch (final AdresseInexistanteException e) {

            // Cas alternatif : L'adresse recherchée n'existe pas.

            builder = Response.status(Response.Status.NOT_FOUND);

        }

		return builder.build();
	}
	
	/**
	 * Créer une nouvelle adresse.
	 */
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response creerAdresse(final Adresse adresse) {

	    Response.ResponseBuilder builder = null;

        try {

            // Cas nominal --> 200
            adresseService.creerAdresse(adresse);

            builder = Response.ok();

        } catch (final AdresseExistanteException e) {

            // Cas alternatif : L'adresse existe déjà. --> 409

            builder = Response.status(Response.Status.CONFLICT);

        } catch (final AdresseInvalideException e) {

            // Cas alternatif : L'adresse est invalide. --> 400 ou 422 ?

            builder = Response.status(Response.Status.BAD_REQUEST);
            // builder = Response.status(422);

        } catch (final Exception e) {

            // Cas alternatif autre --> 500

            builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR);

        }

        return builder.build();

    }
	
}
