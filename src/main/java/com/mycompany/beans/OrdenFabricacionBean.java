/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.ejbs.OrdenFabricacionFacade;
import com.mycompany.ejbs.ProcesoFabricacionFacade;
import com.mycompany.entities.OrdenFabricacion;
import com.mycompany.entities.ProcesoFabricacion;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author LAPTOP
 */
@Named(value = "ordenFabricacionBean")
@ViewScoped
public class OrdenFabricacionBean {

    private List<OrdenFabricacion> list = null;
    private List<ProcesoFabricacion> listaProceso = null;
    String filtroEstado = "";
    ProcesoFabricacion procesoFabricacion;

    @EJB
    OrdenFabricacionFacade ejbOrdenFabricacion;
    
    @EJB
    ProcesoFabricacionFacade ejbProcesoFabricacion;

    /**
     * Creates a new instance of OrdenFabricacionBean
     */
    public OrdenFabricacionBean() {
    }

    public String getFiltroEstado() {
        return filtroEstado;
    }

    public void setFiltroEstado(String filtroEstado) {
        this.filtroEstado = filtroEstado;
    }

    public ProcesoFabricacion getProcesoFabricacion() {
        return procesoFabricacion;
    }

    public void setProcesoFabricacion(ProcesoFabricacion procesoFabricacion) {
        this.procesoFabricacion = procesoFabricacion;
    }

    
    public List<OrdenFabricacion> getList() {

        if (this.filtroEstado == null || this.filtroEstado.equals("")){
            this.list = ejbOrdenFabricacion.findAll();
        } else {
            this.list = ejbOrdenFabricacion.getListaOPsProceso(filtroEstado, null, null);
        }
        
        return this.list;
    }
    
    public List<ProcesoFabricacion> getListaProceso(){
        this.listaProceso = ejbProcesoFabricacion.findAll();
        return this.listaProceso;
    }
    
    public void buscarCriterio(){
        this.list = null;
        getList();
    }

}
