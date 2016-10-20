package com.msp.rest;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.msp.model.PaginatedListWrapper;
import com.msp.model.Person;


@Path("/jsonl")
public class JsonListRestService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public PaginatedListWrapper listPersons() {
		PaginatedListWrapper wrapper = new PaginatedListWrapper();
		getPersons(wrapper);
		return wrapper;
	}
	

	private void getPersons(PaginatedListWrapper wrapper) {
		ArrayList<Person> list = new ArrayList<Person>(0);
		Person p = new Person("Mark Power", "Perth", "Australia");
		list.add(p);
		p = new Person("Clive Levido", "Auckland", "New Zealand");
		list.add(p);
		p = new Person("Richie Taferner", "Bichling", "Austria");
		list.add(p);
		p = new Person("Georg Kurz", "Westendorf", "Austria");
		list.add(p);
		p = new Person("Tina Sorenson", "Copenhagen", "Denmark");
		list.add(p);
		
		wrapper.setList(list);
	}
	
}
