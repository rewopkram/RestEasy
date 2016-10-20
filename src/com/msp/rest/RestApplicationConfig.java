package com.msp.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.msp.rest.MessageRestService;


public class RestApplicationConfig extends Application {

	private Set<Object> singletons = new HashSet<Object>();

    public RestApplicationConfig() {
    	System.out.println("\n\n*********** RESTEasy is fabulous");
        singletons.add(new MessageRestService());
        singletons.add(new JsonRestService());
        singletons.add(new XmlRestService());
        singletons.add(new JsonListRestService());
        singletons.add(new JsonDetailsRestService());
        singletons.add(new ReactRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
