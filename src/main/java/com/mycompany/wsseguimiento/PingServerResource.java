/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsseguimiento;

import com.mycompany.comunes.Respuesta;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author LAPTOP
 */
@Path("pingServer/{pc}")
public class PingServerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PingServerResource
     */
    public PingServerResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.wsseguimiento.PingServerResource
     *
     * @param pc resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("pc") String pc) {
        System.out.println("Ping desde: " + pc);
        Respuesta r = new Respuesta();
        r.setRespuesta("CONECTADO");
        return "<respuesta>" + r.toString() + "</respuesta>";
    }

    /**
     * PUT method for updating or creating an instance of PingServerResource
     *
     * @param pc resource URI parameter
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(@PathParam("pc") String pc, String content) {
    }
}
