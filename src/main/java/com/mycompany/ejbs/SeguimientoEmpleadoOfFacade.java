/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbs;

import com.mycompany.comunes.Respuesta;
import com.mycompany.entities.ProcesoFabricacion;
import com.mycompany.entities.PuntoControl;
import com.mycompany.entities.SeguimientoEmpleadoOf;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class SeguimientoEmpleadoOfFacade extends AbstractFacade<SeguimientoEmpleadoOf> {

    @PersistenceContext(unitName = "com.mycompany_wsSeguimiento_war_1.0PU")
    private EntityManager em;

    @EJB
    PuntoControlFacade ejbPuntoControl;

    @EJB
    OrdenFabricacionFacade ejbOrdenFabricacion;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientoEmpleadoOfFacade() {
        super(SeguimientoEmpleadoOf.class);
    }

    /**
     * Procedimiento que valida que el empledo que va a terminar el proceso,
     * realmente ha trabajado la OF.
     *
     * @param of Número de orden de fabricación
     * @param emp ID de empleado
     * @return clase Respuesta
     */
    public Respuesta validarEmpleadoOf(int of, int emp) {
        Respuesta r = new Respuesta();
        Query q = em.createQuery("Select seg FROM HojaRutaOf hr, hr.seguimientoEmpleadoOfList seg WHERE hr.idOrdenFabricacion.idOrdenFabricacion = :of AND seg.idEmpleado.idEmpleado = :emp");
        q.setParameter("emp", emp);
        q.setParameter("of", of);
        List<SeguimientoEmpleadoOf> lista = q.getResultList();

        if (lista.isEmpty()) {
            r.setError("Empleado no trabajó la OF");
        }

        return r;
    }

    /**
     * Procedimiento que pausa todos los empleados que estén con trabajo en proceso
     * para un mismo proceso de fabricación en la hoja de ruta de la OF.
     * @param of
     * @param pc
     * @return  Respuesta
     */
    public Respuesta pausarEmpleadosPorProceso(int of, int pc) {
        Respuesta r = new Respuesta();
        PuntoControl puntoControl = ejbPuntoControl.find(pc);
        Query q = em.createQuery("Select seg FROM SeguimientoEmpleadoOf seg WHERE seg.idHojaRuta.idOrdenFabricacion.idOrdenFabricacion = :of AND seg.idHojaRuta.idProcesoFabricacion = :proceso AND seg.banEstado = 'P'");
        q.setParameter("of", of);
        q.setParameter("proceso", puntoControl.getIdEstacionTrabajo().getIdProcesoFabricacion());
        List<SeguimientoEmpleadoOf> listaEmp = q.getResultList();

        for (int i = 0; i < listaEmp.size(); i++) {
            ejbOrdenFabricacion.pausarOF(listaEmp.get(i).getIdEmpleado().getIdEmpleado());
        }

        r.setRespuesta(listaEmp.size() + " empleados pausados");
        return r;
    }
    
    /**
     * Proceso que pausa todos los empleados activos trabajando en un Of específica
     * @param of
     * @return Respuesta
     */
    public Respuesta pausarEmpleadosPorOf(int of) {
        Respuesta r = new Respuesta();
        Query q = em.createQuery("Select seg FROM SeguimientoEmpleadoOf seg WHERE seg.idHojaRuta.idOrdenFabricacion.idOrdenFabricacion = :of AND seg.banEstado = 'P'");
        q.setParameter("of", of);
        List<SeguimientoEmpleadoOf> listaEmp = q.getResultList();

        for (int i = 0; i < listaEmp.size(); i++) {
            ejbOrdenFabricacion.pausarOF(listaEmp.get(i).getIdEmpleado().getIdEmpleado());
        }

        r.setRespuesta(listaEmp.size() + " empleados pausados");
        return r;
    }

}
