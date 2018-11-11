/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.ejbs.ArticuloFacade;
import com.mycompany.entities.Articulo;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author LAPTOP
 */
@Named(value = "articulosBean")
@ViewScoped
public class ArticulosBean {
    List<Articulo> list = null;
    
    @EJB
    ArticuloFacade ejbArticulo;
    /**
     * Creates a new instance of ArticulosBean
     */
    public ArticulosBean() {
    }

    public List<Articulo> getList() {
        return ejbArticulo.findAll();
    }
    
    
    
}
