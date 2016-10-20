package com.msp.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.msp.model.Person;


@Path("/json")
public class JsonRestService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Person printMessage() {
		System.out.println("****JsonRestService...");
		Person p = new Person();
		p.setCity("Perth");
		p.setCountry("Australia");
		p.setName("Mark Power");
		
		return p;
	}
	
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
//	public String printMessage() {
//		System.out.println("****JsonRestService...");
//		return "{\"Name\": \"Jason\"}";
//	}
	
}
