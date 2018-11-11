/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbs;

import com.mycompany.entities.LineaProductiva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class LineaProductivaFacade extends AbstractFacade<LineaProductiva> {

    @PersistenceContext(unitName = "com.mycompany_wsSeguimiento_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaProductivaFacade() {
        super(LineaProductiva.class);
    }
    
}
