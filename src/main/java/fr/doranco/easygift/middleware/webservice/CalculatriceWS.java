package fr.doranco.easygift.middleware.webservice;

import java.math.BigDecimal;

import javax.jws.WebService;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@WebService
@Path("/calculatrice")
public class CalculatriceWS {

	@POST
	@Path("/additionner")
	public Double additionner(
			@QueryParam("x") final Double x,
			@QueryParam("y") final Double y
		) {
		
		return Double.sum(x, y);
	}
	
	@POST
	@Path("/multiplier")
	public Double multiplier(
			@FormParam("x") final Double x,
			@FormParam("y") final Double y
		) {
		
		BigDecimal bigX = BigDecimal.valueOf(x);
		BigDecimal bigY = BigDecimal.valueOf(y);
		
		return bigX.multiply(bigY).doubleValue();
	}
	
	@POST
	@Path("/{x}/modulo/{y}")
	public Integer modulo(
			@PathParam("x") final Integer x,
			@PathParam("y") final Integer y
		) {
		
		return x % y;
	}
	
}
