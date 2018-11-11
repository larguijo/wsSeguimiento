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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "orden_fabricacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenFabricacion.findAll", query = "SELECT o FROM OrdenFabricacion o"),
    @NamedQuery(name = "OrdenFabricacion.findByIdOrdenFabricacion", query = "SELECT o FROM OrdenFabricacion o WHERE o.idOrdenFabricacion = :idOrdenFabricacion"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaEmision", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaEntrega", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaInicio", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaEstimadaTerminacion", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaEstimadaTerminacion = :fechaEstimadaTerminacion"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaTerminacion", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaTerminacion = :fechaTerminacion"),
    @NamedQuery(name = "OrdenFabricacion.findByBanTipo", query = "SELECT o FROM OrdenFabricacion o WHERE o.banTipo = :banTipo"),
    @NamedQuery(name = "OrdenFabricacion.findByBanEstado", query = "SELECT o FROM OrdenFabricacion o WHERE o.banEstado = :banEstado"),
    @NamedQuery(name = "OrdenFabricacion.findByObservaciones", query = "SELECT o FROM OrdenFabricacion o WHERE o.observaciones = :observaciones"),
    @NamedQuery(name = "OrdenFabricacion.findByUsuarioGra", query = "SELECT o FROM OrdenFabricacion o WHERE o.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaGra", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaGra = :fechaGra"),
    @NamedQuery(name = "OrdenFabricacion.findByUsuarioMod", query = "SELECT o FROM OrdenFabricacion o WHERE o.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaMod", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaMod = :fechaMod")})
public class OrdenFabricacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_fabricacion")
    private Integer idOrdenFabricacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_estimada_terminacion")
    @Temporal(TemporalType.DATE)
    private Date fechaEstimadaTerminacion;
    @Column(name = "fecha_terminacion")
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ban_tipo")
    private String banTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ban_estado")
    private String banEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(min = 1, max = 10)
    @Column(name = "usuario_gra")
    private String usuarioGra;
    @Column(name = "fecha_gra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGra;
    @Size(min = 1, max = 10)
    @Column(name = "usuario_mod")
    private String usuarioMod;
    @Column(name = "fecha_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenFabricacion")
    private List<MateriaPrimaOf> materiaPrimaOfList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenFabricacion")
    private List<ProductoOf> productoOfList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idSupervisor;
    @JoinColumn(name = "id_linea_productiva", referencedColumnName = "id_linea_productiva")
    @ManyToOne(optional = false)
    private LineaProductiva idLineaProductiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenFabricacion")
    private List<HojaRutaOf> hojaRutaOfList;

    public OrdenFabricacion() {
    }

    public OrdenFabricacion(Integer idOrdenFabricacion) {
        this.idOrdenFabricacion = idOrdenFabricacion;
    }

    public OrdenFabricacion(Integer idOrdenFabricacion, Date fechaEmision, Date fechaEntrega, Date fechaInicio, Date fechaEstimadaTerminacion, Date fechaTerminacion, String banTipo, String banEstado, String observaciones, String usuarioGra, Date fechaGra, String usuarioMod, Date fechaMod) {
        this.idOrdenFabricacion = idOrdenFabricacion;
        this.fechaEmision = fechaEmision;
        this.fechaEntrega = fechaEntrega;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaTerminacion = fechaEstimadaTerminacion;
        this.fechaTerminacion = fechaTerminacion;
        this.banTipo = banTipo;
        this.banEstado = banEstado;
        this.observaciones = observaciones;
        this.usuarioGra = usuarioGra;
        this.fechaGra = fechaGra;
        this.usuarioMod = usuarioMod;
        this.fechaMod = fechaMod;
    }

    public Integer getIdOrdenFabricacion() {
        return idOrdenFabricacion;
    }

    public void setIdOrdenFabricacion(Integer idOrdenFabricacion) {
        this.idOrdenFabricacion = idOrdenFabricacion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEstimadaTerminacion() {
        return fechaEstimadaTerminacion;
    }

    public void setFechaEstimadaTerminacion(Date fechaEstimadaTerminacion) {
        this.fechaEstimadaTerminacion = fechaEstimadaTerminacion;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public String getBanTipo() {
        return banTipo;
    }

    public void setBanTipo(String banTipo) {
        this.banTipo = banTipo;
    }

    public String getBanEstado() {
        return banEstado;
    }

    public String getBanEstadoDes() {
        String pincheEstado = "";
        if (banEstado.equals("E")) {
            pincheEstado = "EMITIDA";
        } else if (banEstado.equals("P")) {
            pincheEstado = "EN PROCESO";
        } else if (banEstado.equals("T")) {
            pincheEstado = "TERMINADO";
        }
        return pincheEstado;
    }

    public void setBanEstado(String banEstado) {
        this.banEstado = banEstado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Empleado idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public LineaProductiva getIdLineaProductiva() {
        return idLineaProductiva;
    }

    public void setIdLineaProductiva(LineaProductiva idLineaProductiva) {
        this.idLineaProductiva = idLineaProductiva;
    }

    @XmlTransient
    public List<HojaRutaOf> getHojaRutaOfList() {
        return hojaRutaOfList;
    }

    public void setHojaRutaOfList(List<HojaRutaOf> hojaRutaOfList) {
        this.hojaRutaOfList = hojaRutaOfList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenFabricacion != null ? idOrdenFabricacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenFabricacion)) {
            return false;
        }
        OrdenFabricacion other = (OrdenFabricacion) object;
        if ((this.idOrdenFabricacion == null && other.idOrdenFabricacion != null) || (this.idOrdenFabricacion != null && !this.idOrdenFabricacion.equals(other.idOrdenFabricacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.OrdenFabricacion[ idOrdenFabricacion=" + idOrdenFabricacion + " ]";
    }

}
