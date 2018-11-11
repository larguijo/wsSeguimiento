/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbs;

import com.mycompany.entities.ProductoOf;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.comunes.Respuesta;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Query;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class ProductoOfFacade extends AbstractFacade<ProductoOf> {

    @PersistenceContext(unitName = "com.mycompany_wsSeguimiento_war_1.0PU")
    private EntityManager em;

    @EJB
    SeguimientoEmpleadoOfFacade ejbSeguimientoEmpleado;

    @EJB
    OrdenFabricacionFacade ejbOrdenFabricacion;

    @EJB
    HojaRutaOfFacade ejbHojaRutaOf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoOfFacade() {
        super(ProductoOf.class);
    }

    /**
     * Procedimiento que ingresa productos a bodega. Cambia la cantidad
     * producida del artículo en la OF. Al hacerlo, si ya no quedan más
     * artículos pendientes, finaliza la OF y todos sus procesos.
     *
     * @param emp
     * @param pc
     * @param of
     * @param art
     * @param cant
     * @return
     */
    public Respuesta ingresarProducto(int emp, int pc, int of, int art, int cant) {
        Respuesta r = new Respuesta();
        Respuesta r2 = new Respuesta();

        r = validarOfPuntoIngreso(emp, pc, of);

        if (r.getCodigo() == 0) {
            return r;
        }

        ProductoOf productoOf = getArticuloOf(of, art);

        r = validarArticuloIngreso(productoOf);

        if (r.getCodigo() == 0) {
            return r;
        }

        double cantidadPendiente = productoOf.getCantidadSolicitada() - productoOf.getCantidadProducida();
        if (cantidadPendiente < cant) {
            r.setError("Solo quedan " + (int) cantidadPendiente + " pendientes, revise cantidad");
            return r;
        }

        productoOf.setCantidadProducida(productoOf.getCantidadProducida() + cant);
        em.persist(productoOf);
        r.setRespuesta("Ingreso realizado.");

        if (!tieneIngresosPendientes(of)) {
            r2 = finalizarOf(emp, pc, of);
            r.setRespuesta(r.getRespuesta() + " " + r2.getRespuesta());
        }

        return r;
    }

    /**
     * Procedimiento que validará (al solicitar la OF desde el punto de control)
     * 1. Que se la ruta correcta, según el punto. 2. Que sea el último punto de
     * la hoja de ruta para hacer el ingreso. 3. Que la OF aún tenga ingresos
     * pendientes.
     *
     * @param emp
     * @param pc
     * @param of
     * @return Respuesta
     */
    public Respuesta validarOfPuntoIngreso(int emp, int pc, int of) {
        Respuesta r = new Respuesta();
        r = ejbOrdenFabricacion.validarPuntoOf(pc, of);

        if (r.getCodigo() == 0) {
            return r;
        }

        r = ejbSeguimientoEmpleado.validarEmpleadoOf(of, emp);

        if (r.getCodigo() == 0) {
            return r;
        }

        if (!ejbHojaRutaOf.ultimoPuntoDelProceso(of, pc)) {
            r.setError("No es el último punto de trabajo de la OF.");
            return r;
        }

        if (!tieneIngresosPendientes(of)) {
            r.setError("La OF no tiene ingresos pendientes.");
            return r;
        }

        return r;
    }

    public Respuesta validarArticuloIngreso(ProductoOf art) {
        Respuesta r = new Respuesta();

        if (art == null) {
            r.setError("El artículo no pertenece a la OF");
            return r;
        }

        if (art.getCantidadProducida() < art.getCantidadSolicitada()) {
            r.setRespuesta(art.getIdArticulo().getNombre()
                    + "("
                    + (int) art.getCantidadProducida()
                    + "/"
                    + (int) art.getCantidadSolicitada()
                    + ")");
        } else {
            r.setError("Ya no hay ingresos pendientes para el artículo");
        }

        return r;
    }

    public ProductoOf getArticuloOf(int of, int art) {
        Query q = em.createNamedQuery("ProductoOf.findByArticuloOf");
        q.setParameter("idOrdenFabricacion", of);
        q.setParameter("idArticulo", art);
        List<ProductoOf> lista = q.getResultList();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }

    public boolean tieneIngresosPendientes(int of) {
        Query q = em.createNamedQuery("ProductoOf.ingresosPendientesOf");
        q.setParameter("idOrdenFabricacion", of);

        if (q.getResultList().isEmpty()) {
            return false;
        }

        return true;
    }

    public Respuesta finalizarOf(int emp, int pc, int of) {
        Respuesta r = new Respuesta();

        r = ejbHojaRutaOf.terminarProceso(pc, emp, of);

        if (r.getCodigo() == 0) {
            return r;
        }

        r = ejbOrdenFabricacion.terminarOf(of);

        return r;
    }

}
