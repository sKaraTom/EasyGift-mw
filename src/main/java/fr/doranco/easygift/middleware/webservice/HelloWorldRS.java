package fr.doranco.easygift.middleware.webservice;

import java.time.Instant;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@WebService
@Path(value = "/helloworld")
public class HelloWorldRS {
	
	@GET
	public String helloWorld() {
		
		return "Hello World !";
	}
	
	@GET
	@Path(value = "/dateDuJour")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Instant obtenirDateJour() {
		
		return Instant.now();
	}
	
	@POST
	public Integer getUn() {
		
		return 1;
	}
	
	@PUT
	public String eleauWorld() {
		
		return "Eleau World !";
	}
	
	@DELETE
	public String helloOueurldeu() {
		
		return "Hello Oueurldeu !";
	}

}
