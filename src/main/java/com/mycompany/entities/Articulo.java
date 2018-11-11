/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAPTOP
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo"),
    @NamedQuery(name = "Articulo.findByNombre", query = "SELECT a FROM Articulo a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Articulo.findByUnidadMedida", query = "SELECT a FROM Articulo a WHERE a.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Articulo.findByPresentacion", query = "SELECT a FROM Articulo a WHERE a.presentacion = :presentacion"),
    @NamedQuery(name = "Articulo.findByCostoUnitario", query = "SELECT a FROM Articulo a WHERE a.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "Articulo.findByPrecioVenta", query = "SELECT a FROM Articulo a WHERE a.precioVenta = :precioVenta"),
    @NamedQuery(name = "Articulo.findByAlto", query = "SELECT a FROM Articulo a WHERE a.alto = :alto"),
    @NamedQuery(name = "Articulo.findByAncho", query = "SELECT a FROM Articulo a WHERE a.ancho = :ancho"),
    @NamedQuery(name = "Articulo.findByLargo", query = "SELECT a FROM Articulo a WHERE a.largo = :largo"),
    @NamedQuery(name = "Articulo.findByBanEstado", query = "SELECT a FROM Articulo a WHERE a.banEstado = :banEstado"),
    @NamedQuery(name = "Articulo.findByUsuarioGra", query = "SELECT a FROM Articulo a WHERE a.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "Articulo.findByFechaGra", query = "SELECT a FROM Articulo a WHERE a.fechaGra = :fechaGra"),
    @NamedQuery(name = "Articulo.findByUsuarioMod", query = "SELECT a FROM Articulo a WHERE a.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "Articulo.findByFechaMod", query = "SELECT a FROM Articulo a WHERE a.fechaMod = :fechaMod")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo")
    private Integer idArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Size(max = 30)
    @Column(name = "presentacion")
    private String presentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_unitario")
    private double costoUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "alto")
    private Double alto;
    @Column(name = "ancho")
    private Double ancho;
    @Column(name = "largo")
    private Double largo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ban_estado")
    private String banEstado;
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
    @OneToMany(mappedBy = "idArticulo")
    private List<MateriaPrimaOf> materiaPrimaOfList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private List<ProductoOf> productoOfList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private List<Inventario> inventarioList;

    public Articulo() {
    }

    public Articulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(Integer idArticulo, String nombre, String unidadMedida, double costoUnitario, double precioVenta, String banEstado, String usuarioGra, Date fechaGra, String usuarioMod, Date fechaMod) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.costoUnitario = costoUnitario;
        this.precioVenta = precioVenta;
        this.banEstado = banEstado;
        this.usuarioGra = usuarioGra;
        this.fechaGra = fechaGra;
        this.usuarioMod = usuarioMod;
        this.fechaMod = fechaMod;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
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

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public String getBanEstado() {
        return banEstado;
    }

    public void setBanEstado(String banEstado) {
        this.banEstado = banEstado;
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

    @XmlTransient
    public List<MateriaPrimaOf> getMateriaPrimaOfList() {
        return materiaPrimaOfList;
    }

    public void setMateriaPrimaOfList(List<MateriaPrimaOf> materiaPrimaOfList) {
        this.materiaPrimaOfList = materiaPrimaOfList;
    }

    @XmlTransient
    public List<ProductoOf> getProductoOfList() {
        return productoOfList;
    }

    public void setProductoOfList(List<ProductoOf> productoOfList) {
        this.productoOfList = productoOfList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Articulo[ idArticulo=" + idArticulo + " ]";
    }
    
}
