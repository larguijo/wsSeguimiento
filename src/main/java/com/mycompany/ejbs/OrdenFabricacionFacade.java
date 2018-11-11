/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbs;

import com.mycompany.comunes.Fechas;
import com.mycompany.comunes.Respuesta;
import com.mycompany.entities.HojaRutaOf;
import com.mycompany.entities.OrdenFabricacion;
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
public class OrdenFabricacionFacade extends AbstractFacade<OrdenFabricacion> {

    @PersistenceContext(unitName = "com.mycompany_wsSeguimiento_war_1.0PU")
    private EntityManager em;

    @EJB
    PuntoControlFacade ejbPuntoControl;

    @EJB
    EmpleadoFacade ejbEmpleado;

    @EJB
    HojaRutaOfFacade ejbHojaRutaOf;

    @EJB
    ProductoOfFacade ejbProductoOf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFabricacionFacade() {
        super(OrdenFabricacion.class);
    }

    public Respuesta validarEstado(int of) {
        Respuesta r = new Respuesta(1, "CORRECTO");
        OrdenFabricacion orden = this.find(of);
        if (orden == null) {
            r.setError("OF " + of + " no existe.");
            return r;
        }

        if (orden.getBanEstado().equals("T")) {
            r.setError("OF ya está terminada.");
            return r;
        }

        return r;
    }

    public Respuesta iniciarOF(int pc, int emp, int of) {
        Respuesta r = new Respuesta();
        r = validarEstado(of);
        if (r.getCodigo() == 0) {
            return r;
        }
        r = validarPuntoOf(pc, of);

        if (r.getCodigo() == 0) {
            return r;
        }

        r = pausarOF(emp);

        if (r.getCodigo() == 0) {
            return r;
        }

        r = marcarTrabajo(pc, emp, of);

        return r;
    }

    public Respuesta pausarOF(int emp) {
        Respuesta r = new Respuesta();
        r = ejbEmpleado.validarEmpleado(emp);

        if (r.getCodigo() == 0) {
            return r;
        }

        Query q = em.createNamedQuery("SeguimientoEmpleadoOf.findByEmpleadoEstado");
        q.setParameter("idEmpleado", emp);
        q.setParameter("banEstado", "P");
        List<SeguimientoEmpleadoOf> listaEnCurso = q.getResultList();
        for (int i = 0; i < listaEnCurso.size(); i++) {
            listaEnCurso.get(i).setBanEstado("T");
            listaEnCurso.get(i).setFechaHoraFin(Fechas.getTimestamp());
            em.merge(listaEnCurso.get(i));
        }

        if (listaEnCurso.isEmpty()) {
            r.setRespuesta("No hay trabajos en curso");
        } else {
            r.setRespuesta("Trabajos pausados");
        }

        return r;
    }

    public Respuesta marcarTrabajo(int puntoControl, int empleado, int ordenFabricacion) {
        Respuesta r = new Respuesta();
        SeguimientoEmpleadoOf nuevo = new SeguimientoEmpleadoOf();
        List<HojaRutaOf> hojaRutaOf = getProcesoOf(puntoControl, ordenFabricacion);

        if (hojaRutaOf.size() > 1) {
            r.setError("Más de un proceso asociado al punto de control.");
            return r;
        }
        //Guardando valores del registro.
        nuevo.setIdHojaRuta(hojaRutaOf.get(0));
        nuevo.setIdEmpleado(ejbEmpleado.find(empleado));
        nuevo.setFechaHoraInicio(Fechas.getTimestamp());
        nuevo.setIdPuntoControl(puntoControl);
        nuevo.setBanEstado("P");
        nuevo.setFechaGra(Fechas.getTimestamp());
        nuevo.setFechaMod(Fechas.getTimestamp());
        nuevo.setUsuarioGra("udb");
        nuevo.setUsuarioMod("udb");
        em.persist(nuevo);

        //Si el proceso en la hoja de ruta está Pendiente, lo cambia a iniciado
        HojaRutaOf hojaRuta = ejbHojaRutaOf.find(hojaRutaOf.get(0).getIdHojaRuta());

        if (hojaRuta.getBanEstado().equals("P")) {
            hojaRuta.setBanEstado("I");
            hojaRuta.setFechaHoraIni(Fechas.getTimestamp());
            em.persist(hojaRuta);
        }

        // Si la OF no está marcada como iniciada, se marca.
        OrdenFabricacion orden = this.find(ordenFabricacion);
        if (orden.getBanEstado().equals("E")) {
            orden.setBanEstado("P");
            orden.setFechaInicio(Fechas.getTimestamp());
        }

        r.setRespuesta("Iniciando actividad.");
        return r;
    }

    public Respuesta validarPuntoOf(int puntoControl, int ordenFabricacion) {
        Respuesta r = new Respuesta(1, "CORRECTO");
        //Validando si el punto existe.
        if (ejbPuntoControl.find(puntoControl) == null) {
            r.setError("Punto de control " + puntoControl + " no existe");
            return r;
        }

        if (getProcesoOf(puntoControl, ordenFabricacion).isEmpty()) {
            r.setError("OF no debe pasar por punto " + puntoControl);
        }

        return r;
    }

    public List<HojaRutaOf> getProcesoOf(int puntoControl, int ordenFabricacion) {
        Query query = em.createQuery("Select hr FROM OrdenFabricacion ofab, ofab.hojaRutaOfList hr, hr.idProcesoFabricacion.estacionTrabajoList est, est.puntoControlList pc WHERE ofab.idOrdenFabricacion = :ofa AND pc.idPuntoControl = :pc");
        query.setParameter("pc", puntoControl);
        query.setParameter("ofa", ordenFabricacion);
        List<HojaRutaOf> result = query.getResultList();
        return result;
    }

    public Respuesta terminarOf(int of) {
        Respuesta r = new Respuesta();

        if (ejbProductoOf.tieneIngresosPendientes(of)) {
            r.setError("Tiene ingresos pendientes, no puede finalizar");
            return r;
        }

        OrdenFabricacion orden = this.find(of);

        orden.setBanEstado("T");
        orden.setFechaTerminacion(Fechas.getTimestamp());
        em.persist(orden);
        r.setRespuesta("OF terminada");

        return r;
    }

    public List<OrdenFabricacion> getListaOPsProceso(String estado, String pc, String proceso) {
        List<OrdenFabricacion> lista;
        String sql = "Select ofa FROM OrdenFabricacion ofa ";
        String where = "";

        if (!estado.isEmpty()) {
            where += "WHERE ofa.banEstado = '" + estado + "'";
        }

        sql += where;

        Query q = em.createQuery(sql);
        lista = q.getResultList();

        return lista;
    }

}
