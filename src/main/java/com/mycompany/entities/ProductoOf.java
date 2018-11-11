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
@Table(name = "producto_of")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoOf.findAll", query = "SELECT p FROM ProductoOf p"),
    @NamedQuery(name = "ProductoOf.findByIdProductoOf", query = "SELECT p FROM ProductoOf p WHERE p.idProductoOf = :idProductoOf"),
    @NamedQuery(name = "ProductoOf.findByArticuloOf", query = "SELECT p FROM ProductoOf p WHERE p.idOrdenFabricacion.idOrdenFabricacion = :idOrdenFabricacion AND p.idArticulo.idArticulo = :idArticulo"),
    @NamedQuery(name = "ProductoOf.ingresosPendientesOf",query="SELECT p FROM ProductoOf p WHERE p.idOrdenFabricacion.idOrdenFabricacion = :idOrdenFabricacion AND p.cantidadSolicitada > p.cantidadProducida"),
    @NamedQuery(name = "ProductoOf.findByCantidadSolicitada", query = "SELECT p FROM ProductoOf p WHERE p.cantidadSolicitada = :cantidadSolicitada"),
    @NamedQuery(name = "ProductoOf.findByCantidadProducida", query = "SELECT p FROM ProductoOf p WHERE p.cantidadProducida = :cantidadProducida"),
    @NamedQuery(name = "ProductoOf.findByFechaGra", query = "SELECT p FROM ProductoOf p WHERE p.fechaGra = :fechaGra"),
    @NamedQuery(name = "ProductoOf.findByFechaMod", query = "SELECT p FROM ProductoOf p WHERE p.fechaMod = :fechaMod")})
public class ProductoOf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto_of")
    private Integer idProductoOf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_solicitada")
    private double cantidadSolicitada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producida")
    private double cantidadProducida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_unitario")
    private double costoUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
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
    @JoinColumn(name = "id_orden_fabricacion", referencedColumnName = "id_orden_fabricacion")
    @ManyToOne(optional = false)
    private OrdenFabricacion idOrdenFabricacion;

    public ProductoOf() {
    }

    public ProductoOf(Integer idProductoOf) {
        this.idProductoOf = idProductoOf;
    }

    public ProductoOf(Integer idProductoOf, double cantidadSolicitada, double cantidadProducida, double costoUnitario, double precioVenta, String usuarioGra, Date fechaGra, String usuarioMod, Date fechaMod) {
        this.idProductoOf = idProductoOf;
        this.cantidadSolicitada = cantidadSolicitada;
        this.cantidadProducida = cantidadProducida;
        this.costoUnitario = costoUnitario;
        this.precioVenta = precioVenta;
        this.usuarioGra = usuarioGra;
        this.fechaGra = fechaGra;
        this.usuarioMod = usuarioMod;
        this.fechaMod = fechaMod;
    }

    public Integer getIdProductoOf() {
        return idProductoOf;
    }

    public void setIdProductoOf(Integer idProductoOf) {
        this.idProductoOf = idProductoOf;
    }

    public double getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(double cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public double getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(double cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
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

    public OrdenFabricacion getIdOrdenFabricacion() {
        return idOrdenFabricacion;
    }

    public void setIdOrdenFabricacion(OrdenFabricacion idOrdenFabricacion) {
        this.idOrdenFabricacion = idOrdenFabricacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductoOf != null ? idProductoOf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoOf)) {
            return false;
        }
        ProductoOf other = (ProductoOf) object;
        if ((this.idProductoOf == null && other.idProductoOf != null) || (this.idProductoOf != null && !this.idProductoOf.equals(other.idProductoOf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.ProductoOf[ idProductoOf=" + idProductoOf + " ]";
    }
    
}
