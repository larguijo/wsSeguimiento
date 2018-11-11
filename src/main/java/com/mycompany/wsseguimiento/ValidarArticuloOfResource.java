/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsseguimiento;

import com.mycompany.comunes.Respuesta;
import com.mycompany.ejbs.ProductoOfFacade;
import javax.ejb.EJB;
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
@Path("validarArticuloOf/{emp}/{pc}/{of}/{art}")
public class ValidarArticuloOfResource {

    @Context
    private UriInfo context;

    @EJB
    ProductoOfFacade ejbProductoOf;

    /**
     * Creates a new instance of ValidarArticuloOfResource
     */
    public ValidarArticuloOfResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.wsseguimiento.ValidarArticuloOfResource
     *
     * @param emp resource URI parameter
     * @param pc resource URI parameter
     * @param of resource URI parameter
     * @param art resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("emp") String emp, @PathParam("pc") String pc, @PathParam("of") String of, @PathParam("art") String art) {
        Respuesta r = new Respuesta();

        r = ejbProductoOf.validarArticuloIngreso(ejbProductoOf.getArticuloOf(Integer.parseInt(of), Integer.parseInt(art)));
        return "<respuesta>" + r.toString() + "</respuesta>";
    }

    /**
     * PUT method for updating or creating an instance of
     * ValidarArticuloOfResource
     *
     * @param emp resource URI parameter
     * @param pc resource URI parameter
     * @param of resource URI parameter
     * @param art resource URI parameter
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(@PathParam("emp") String emp, @PathParam("pc") String pc, @PathParam("of") String of, @PathParam("art") String art, String content) {
    }
}
