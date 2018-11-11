/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAPTOP
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdCorrelativo", query = "SELECT i FROM Inventario i WHERE i.idCorrelativo = :idCorrelativo"),
    @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventario.findByUsuarioGra", query = "SELECT i FROM Inventario i WHERE i.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "Inventario.findByFechaGra", query = "SELECT i FROM Inventario i WHERE i.fechaGra = :fechaGra"),
    @NamedQuery(name = "Inventario.findByUsuarioMod", query = "SELECT i FROM Inventario i WHERE i.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "Inventario.findByFechaMod", query = "SELECT i FROM Inventario i WHERE i.fechaMod = :fechaMod")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_correlativo")
    private Integer idCorrelativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usuario_gra")
    private String usuarioGra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_gra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usuario_mod")
    private String usuarioMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private Articulo idArticulo;
    @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega")
    @ManyToOne(optional = false)
    private Bodega idBodega;

    public Inventario() {
    }

    public Inventario(Integer idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public Inventario(Integer idCorrelativo, double cantidad, String usuarioGra, Date fechaGra, String usuarioMod, Date fechaMod) {
        this.idCorrelativo = idCorrelativo;
        this.cantidad = cantidad;
        this.usuarioGra = usuarioGra;
        this.fechaGra = fechaGra;
        this.usuarioMod = usuarioMod;
        this.fechaMod = fechaMod;
    }

    public Integer getIdCorrelativo() {
        return idCorrelativo;
    }

    public void setIdCorrelativo(Integer idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUsuarioGra() {
        return usuarioGra;
    }

    public void setUsuarioGra(String usuarioGra) {
        this.usuarioGra = usuarioGra;
    }

    public Date getFechaGra() {
        return fechaGra;
    }

    public void setFechaGra(Date fechaGra) {
        this.fechaGra = fechaGra;
    }

    public String getUsuarioMod() {
        return usuarioMod;
    }

    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorrelativo != null ? idCorrelativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idCorrelativo == null && other.idCorrelativo != null) || (this.idCorrelativo != null && !this.idCorrelativo.equals(other.idCorrelativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Inventario[ idCorrelativo=" + idCorrelativo + " ]";
    }
    
}
