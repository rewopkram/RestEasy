package com.msp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//@Path("/rest/message")
@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {
		System.out.println("****MessageRestService...should be printing msg [" + msg + "]");
		String res = "Restful example from tomcat hopefully....: " + msg;
		return Response.status(200).entity(res).build();
	}
	
}
