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
@Table(name = "materia_prima_of")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaPrimaOf.findAll", query = "SELECT m FROM MateriaPrimaOf m"),
    @NamedQuery(name = "MateriaPrimaOf.findByIdMateriaPrimaOf", query = "SELECT m FROM MateriaPrimaOf m WHERE m.idMateriaPrimaOf = :idMateriaPrimaOf"),
    @NamedQuery(name = "MateriaPrimaOf.findByCantidadSolicitada", query = "SELECT m FROM MateriaPrimaOf m WHERE m.cantidadSolicitada = :cantidadSolicitada"),
    @NamedQuery(name = "MateriaPrimaOf.findByCantidadUtilizada", query = "SELECT m FROM MateriaPrimaOf m WHERE m.cantidadUtilizada = :cantidadUtilizada"),
    @NamedQuery(name = "MateriaPrimaOf.findByCostoUnitario", query = "SELECT m FROM MateriaPrimaOf m WHERE m.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "MateriaPrimaOf.findByFechaGra", query = "SELECT m FROM MateriaPrimaOf m WHERE m.fechaGra = :fechaGra"),
    @NamedQuery(name = "MateriaPrimaOf.findByUsuarioGra", query = "SELECT m FROM MateriaPrimaOf m WHERE m.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "MateriaPrimaOf.findByFechaMod", query = "SELECT m FROM MateriaPrimaOf m WHERE m.fechaMod = :fechaMod"),
    @NamedQuery(name = "MateriaPrimaOf.findByUsuarioMod", query = "SELECT m FROM MateriaPrimaOf m WHERE m.usuarioMod = :usuarioMod")})
public class MateriaPrimaOf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia_prima_of")
    private Integer idMateriaPrimaOf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_solicitada")
    private double cantidadSolicitada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_utilizada")
    private double cantidadUtilizada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_unitario")
    private double costoUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_gra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usuario_gra")
    private String usuarioGra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usuario_mod")
    private String usuarioMod;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne
    private Articulo idArticulo;
    @JoinColumn(name = "id_orden_fabricacion", referencedColumnName = "id_orden_fabricacion")
    @ManyToOne(optional = false)
    private OrdenFabricacion idOrdenFabricacion;

    public MateriaPrimaOf() {
    }

    public MateriaPrimaOf(Integer idMateriaPrimaOf) {
        this.idMateriaPrimaOf = idMateriaPrimaOf;
    }

    public MateriaPrimaOf(Integer idMateriaPrimaOf, double cantidadSolicitada, double cantidadUtilizada, double costoUnitario, Date fechaGra, String usuarioGra, Date fechaMod, String usuarioMod) {
        this.idMateriaPrimaOf = idMateriaPrimaOf;
        this.cantidadSolicitada = cantidadSolicitada;
        this.cantidadUtilizada = cantidadUtilizada;
        this.costoUnitario = costoUnitario;
        this.fechaGra = fechaGra;
        this.usuarioGra = usuarioGra;
        this.fechaMod = fechaMod;
        this.usuarioMod = usuarioMod;
    }

    public Integer getIdMateriaPrimaOf() {
        return idMateriaPrimaOf;
    }

    public void setIdMateriaPrimaOf(Integer idMateriaPrimaOf) {
        this.idMateriaPrimaOf = idMateriaPrimaOf;
    }

    public double getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(double cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public double getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(double cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Date getFechaGra() {
        return fechaGra;
    }

    public void setFechaGra(Date fechaGra) {
        this.fechaGra = fechaGra;
    }

    public String getUsuarioGra() {
        return usuarioGra;
    }

    public void setUsuarioGra(String usuarioGra) {
        this.usuarioGra = usuarioGra;
    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    public String getUsuarioMod() {
        return usuarioMod;
    }

    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public OrdenFabricacion getIdOrdenFabricacion() {
        return idOrdenFabricacion;
    }

    public void setIdOrdenFabricacion(OrdenFabricacion idOrdenFabricacion) {
        this.idOrdenFabricacion = idOrdenFabricacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaPrimaOf != null ? idMateriaPrimaOf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPrimaOf)) {
            return false;
        }
        MateriaPrimaOf other = (MateriaPrimaOf) object;
        if ((this.idMateriaPrimaOf == null && other.idMateriaPrimaOf != null) || (this.idMateriaPrimaOf != null && !this.idMateriaPrimaOf.equals(other.idMateriaPrimaOf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.MateriaPrimaOf[ idMateriaPrimaOf=" + idMateriaPrimaOf + " ]";
    }
    
}
