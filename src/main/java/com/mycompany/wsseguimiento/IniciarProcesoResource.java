/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsseguimiento;

import com.mycompany.comunes.Respuesta;
import com.mycompany.ejbs.OrdenFabricacionFacade;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("iniciarProceso/{pc}/{emp}/{of}")
public class IniciarProcesoResource {

    @Context
    private UriInfo context;

    @EJB
    OrdenFabricacionFacade ejbOrdenFabricacion;

    /**
     * Creates a new instance of IniciarProcesoResource
     */
    public IniciarProcesoResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.wsseguimiento.IniciarProcesoResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("pc") String pc,
            @PathParam("emp") String emp,
            @PathParam("of") String of) {
        Respuesta r = new Respuesta();

        r = ejbOrdenFabricacion.iniciarOF(
                Integer.parseInt(pc),
                Integer.parseInt(emp),
                Integer.parseInt(of));
        return "<respuesta>" + r.toString() + "</respuesta>";
    }

    /**
     * PUT method for updating or creating an instance of IniciarProcesoResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
