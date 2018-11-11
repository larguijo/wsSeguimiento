/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbs;

import com.mycompany.comunes.Fechas;
import com.mycompany.comunes.Respuesta;
import com.mycompany.entities.HojaRutaOf;
import com.mycompany.entities.ProcesoFabricacion;
import com.mycompany.entities.PuntoControl;
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
public class HojaRutaOfFacade extends AbstractFacade<HojaRutaOf> {

    @PersistenceContext(unitName = "com.mycompany_wsSeguimiento_war_1.0PU")
    private EntityManager em;

    @EJB
    SeguimientoEmpleadoOfFacade ejbSeguimientoEmpleadoOf;

    @EJB
    OrdenFabricacionFacade ejbOrdenFabricacion;

    @EJB
    PuntoControlFacade ejbPuntoControl;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HojaRutaOfFacade() {
        super(HojaRutaOf.class);
    }

    public Respuesta terminarProceso(int pc, int emp, int of) {
        Respuesta r = new Respuesta();
        r = ejbSeguimientoEmpleadoOf.validarEmpleadoOf(of, emp);

        if (r.getCodigo() == 0) {
            return r;
        }

        r = ejbOrdenFabricacion.validarPuntoOf(pc, of);

        if (r.getCodigo() == 0) {
            return r;
        }

        r = ejbSeguimientoEmpleadoOf.pausarEmpleadosPorProceso(of, pc);

        if (r.getCodigo() == 0) {
            return r;
        }

        //Si el punto de control pertence al último proceso, pausa a cualquier
        // empleado trabajo la OF.
        if (ultimoPuntoDelProceso(of, pc)) {
            r = ejbSeguimientoEmpleadoOf.pausarEmpleadosPorOf(of);
        }

        if (r.getCodigo() == 0) {
            return r;
        }

        r = marcarTerminado(of, pc);

        if (r.getCodigo() == 0) {
            return r;
        }

        r.setRespuesta("Proceso finalizado");

        return r;
    }

    /**
     * Procedimiento que verifica si el punto de control pertenece al último
     * proceso productivo de la hoja de ruta
     *
     * @param of
     * @param pc
     * @return true o false
     */
    public boolean ultimoPuntoDelProceso(int of, int pc) {
        PuntoControl puntoControl = ejbPuntoControl.find(pc);
        ProcesoFabricacion pf = puntoControl.getIdEstacionTrabajo().getIdProcesoFabricacion();

        //Consultando los procesos de fabricación que componen la linea productiva
        // donde se encuentra asignado el punto de control tomando el campo "orden"
        // de manera descendente.
        // Para luego identificar si es el último proceso o no.
        Query q = em.createQuery("Select pf FROM ProcesoFabricacion pf WHERE pf.idLineaProductiva = :linea ORDER BY pf.orden DESC");
        q.setParameter("linea", pf.getIdLineaProductiva());
        List<ProcesoFabricacion> listaProcesoFabricacion = q.getResultList();

        if (pf.getOrden() == listaProcesoFabricacion.get(0).getOrden()) {
            return true;
        }
        return false;
    }

    public Respuesta marcarTerminado(int of, int pc) {
        Respuesta r = new Respuesta();
        List<HojaRutaOf> proceso = ejbOrdenFabricacion.getProcesoOf(pc, of);

        if (proceso.get(0).getBanEstado().equals("I")) {
            proceso.get(0).setBanEstado("T");
            proceso.get(0).setFechaHoraFin(Fechas.getTimestamp());
            em.persist(proceso.get(0));
        }
        return r;
    }
    
    
}
