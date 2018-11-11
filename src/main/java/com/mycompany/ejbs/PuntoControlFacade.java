/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbs;

import com.mycompany.comunes.Respuesta;
import com.mycompany.entities.HojaRutaOf;
import com.mycompany.entities.OrdenFabricacion;
import com.mycompany.entities.PuntoControl;
import com.mycompany.entities.SeguimientoEmpleadoOf;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class PuntoControlFacade extends AbstractFacade<PuntoControl> {

    @PersistenceContext(unitName = "com.mycompany_wsSeguimiento_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuntoControlFacade() {
        super(PuntoControl.class);
    }

    /**
     * Devuelve una cadena con el detalle de OFs y cantidad empleados trabajando
     * ella.
     *
     * @param pc
     * @return
     */
    public Respuesta trabajoActualPunto(int pc) {
        Respuesta r = new Respuesta();
        Query q = em.createNamedQuery("SeguimientoEmpleadoOf.findTrabajoActual");
        q.setParameter("pc", pc);

        List<SeguimientoEmpleadoOf> listaSeguimiento = q.getResultList();
        OrdenFabricacion of = null;
        Integer contadorEmpleados = 0;
        boolean cambio = false;
        String texto;

        for (int i = 0; i < listaSeguimiento.size(); i++) {
            cambio = false;
            if (i == 0) {
                of = listaSeguimiento.get(i).getIdHojaRuta().getIdOrdenFabricacion();
                cambio = true;
            }

            if (!listaSeguimiento.get(i).getIdHojaRuta().getIdOrdenFabricacion().equals(of)) {
                of = listaSeguimiento.get(i).getIdHojaRuta().getIdOrdenFabricacion();
                cambio = true;
            }
        }

        return r;

    }

    public Respuesta trabajoActualPC(int pc) {
        Respuesta r = new Respuesta();
        Query q = em.createQuery("Select ofa.idOrdenFabricacion AS orden, COUNT(s.idEmpleado) cantEmpleados cantidad FROM SeguimientoEmpleadoOf s, s.idHojaRuta hr, hr.idOrdenFabricacion ofa WHERE s.idPuntoControl = :pc AND s.banEstado='P' GROUP BY ofa.idOrdenFabricacion");
        q.setParameter("pc", pc);
        String trabajoActual = "";

        List<Object[]> results = q.getResultList();
        for (Object[] result : results) {
            int orden = ((Number) result[0]).intValue();
            int cantEmpleados = ((Number) result[1]).intValue();
            trabajoActual += orden + "(" + cantEmpleados + ")";
        }

        if (results.size() == 0) {
            r.setRespuesta("Sin trabajos en curso");
        } else {
            r.setRespuesta(trabajoActual);
        }
        return r;

    }

    public Respuesta notificarNuevaOf(int pc) {
        Respuesta r = new Respuesta();
        List<HojaRutaOf> lista, lista2;
        lista = getPendientesDeNotificar(pc,"N");
        lista2 = getPendientesDeNotificar(pc,"S");
        if (lista.size() > 0) {
            r.setRespuesta("Nueva OF: " + lista.get(0).getIdOrdenFabricacion().getIdOrdenFabricacion());
            if (lista2.size() > 0) {
                r.setRespuesta(r.getRespuesta() + ", " + lista2.size() + " sin procesar");
            }
            lista.get(0).setBanOfNotificada("S");
            em.persist(lista.get(0));
        } else {
            r.setError("No hay OFs nuevas");
        }
        return r;
    }

    public List<HojaRutaOf> getPendientesDeNotificar(int pc, String notificada) {
        Query q = em.createQuery("Select hr FROM OrdenFabricacion ofab, ofab.hojaRutaOfList hr, hr.idProcesoFabricacion.estacionTrabajoList est, est.puntoControlList pc WHERE ofab.banEstado IN ('E','P') AND hr.banEstado = 'P' AND hr.banOfNotificada = :banOfNotificada AND pc.idPuntoControl = :pc");
        q.setParameter("pc", pc);
        q.setParameter("banOfNotificada", notificada);
        List<HojaRutaOf> lista = q.getResultList();
        return lista;
    }

}
