package fr.doranco.easygift.middleware.webservice;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import fr.doranco.easygift.middleware.objetmetier.occasion.Occasion;
import fr.doranco.easygift.middleware.objetmetier.occasion.OccasionExistanteException;
import fr.doranco.easygift.middleware.objetmetier.occasion.OccasionInvalideException;
import fr.doranco.easygift.middleware.service.OccasionService;

@WebService
@Transactional
@Path("/occasion")
public class OccasionRS {

	@EJB
	private OccasionService occasionService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ajouterOccasion(final Occasion occasion) {
		
		ResponseBuilder builder = null;
		
		try {
			final Occasion occasionCree = occasionService.ajouterOccasion(occasion);
			builder = Response.ok(occasionCree);
		} catch (final OccasionInvalideException exception) {
			builder = Response.status(Status.BAD_REQUEST);
		} catch (final OccasionExistanteException exception) {
			builder = Response.status(Status.CONFLICT);
		}
		
		return builder.build();
	}
	
}
