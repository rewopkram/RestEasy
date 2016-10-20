package com.msp.rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.msp.model.Person;


@Path("/jsond")
public class JsonDetailsRestService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Person personDetails(@DefaultValue("Mark Power") @QueryParam("name") String name) {
		System.out.println("JsonDetailsRestService searching with name [" + name +"]");
		for (Person p : getPersons()) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	
	private List<Person> getPersons() {
		ArrayList<Person> list = new ArrayList<Person>(0);
		Person p = new Person("Mark Power", "Perth", "Australia");
		p.setDob("21/10/1961");
		p.setHobbies("Tango,Skiing");
		list.add(p);
		p = new Person("Clive Levido", "Auckland", "New Zealand");
		list.add(p);
		p = new Person("Richie Taferner", "Bichling", "Austria");
		list.add(p);
		p = new Person("Georg Kurz", "Westendorf", "Austria");
		list.add(p);
		p = new Person("Tina Sorenson", "Copenhagen", "Denmark");
		list.add(p);
		
		return list;
	}
	
}
