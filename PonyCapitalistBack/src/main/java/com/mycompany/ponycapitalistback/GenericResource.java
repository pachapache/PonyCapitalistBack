/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponycapitalistback;

import com.google.gson.Gson;
import generated.World;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

/**
 * REST Web Service
 *
 * @author chaum
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    static Services services;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        services = new Services();
    }

    /**
     * Retrieves representation of an instance of com.mycompany.ponycapitalistback.GenericResource
     * @return an instance of java.lang.String
     */
    /////////////////// Version SANS utilisateur ///////////////////
  
    @GET
    @Path("world")
    @Produces(MediaType.APPLICATION_XML)
    public World getXml() throws JAXBException {
        World world = services.readWorldFromXml();
        services.saveWorldToXml(world);
            return(world);
    }
    
    
    @GET
    @Path("world")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws JAXBException { 
        World world = services.readWorldFromXml();
        return(new Gson().toJson(world));
    }
    
    /////////////////////////////////////////////////////////
}
