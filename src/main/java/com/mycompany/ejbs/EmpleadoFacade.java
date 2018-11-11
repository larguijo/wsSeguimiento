/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbs;

import com.mycompany.comunes.Respuesta;
import com.mycompany.entities.Empleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "com.mycompany_wsSeguimiento_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }
    
    public Respuesta validarEmpleado(int emp){
        Respuesta r = new Respuesta();
        Empleado empleado = this.find(emp);
        if (empleado == null){
            r.setError("Empleado no existe.");
            return r;
        }
        
        if (!empleado.getBanEstado().equals("A")){
            r.setError("Empleado está inactivo");
            return r;
        }
        
        r.setRespuesta(empleado.getNombreCompleto());
        return r;
    }
    
       
}
