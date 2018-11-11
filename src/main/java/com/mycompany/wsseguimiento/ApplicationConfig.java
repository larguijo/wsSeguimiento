/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsseguimiento;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author LAPTOP
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.wsseguimiento.ArticuloFacadeREST.class);
        resources.add(com.mycompany.wsseguimiento.IngresoResource.class);
        resources.add(com.mycompany.wsseguimiento.IniciarProcesoResource.class);
        resources.add(com.mycompany.wsseguimiento.NotificarOfResource.class);
        resources.add(com.mycompany.wsseguimiento.PausarProcesoResource.class);
        resources.add(com.mycompany.wsseguimiento.PingServerResource.class);
        resources.add(com.mycompany.wsseguimiento.TerminarProcesoResource.class);
        resources.add(com.mycompany.wsseguimiento.TrabajoActualResource.class);
        resources.add(com.mycompany.wsseguimiento.ValidarArticuloOfResource.class);
        resources.add(com.mycompany.wsseguimiento.ValidarEmpleadoResource.class);
        resources.add(com.mycompany.wsseguimiento.ValidarOfAvanceResource.class);
    }
    
}
