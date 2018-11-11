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
@Table(name = "proceso_fabricacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoFabricacion.findAll", query = "SELECT p FROM ProcesoFabricacion p"),
    @NamedQuery(name = "ProcesoFabricacion.findByIdProcesoFabricacion", query = "SELECT p FROM ProcesoFabricacion p WHERE p.idProcesoFabricacion = :idProcesoFabricacion"),
    @NamedQuery(name = "ProcesoFabricacion.findByIdSupervisor", query = "SELECT p FROM ProcesoFabricacion p WHERE p.idSupervisor = :idSupervisor"),
    @NamedQuery(name = "ProcesoFabricacion.findByNombre", query = "SELECT p FROM ProcesoFabricacion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProcesoFabricacion.findByOrden", query = "SELECT p FROM ProcesoFabricacion p WHERE p.orden = :orden"),
    @NamedQuery(name = "ProcesoFabricacion.findByBanEstado", query = "SELECT p FROM ProcesoFabricacion p WHERE p.banEstado = :banEstado"),
    @NamedQuery(name = "ProcesoFabricacion.findByUsuarioGra", query = "SELECT p FROM ProcesoFabricacion p WHERE p.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "ProcesoFabricacion.findByFechaGra", query = "SELECT p FROM ProcesoFabricacion p WHERE p.fechaGra = :fechaGra"),
    @NamedQuery(name = "ProcesoFabricacion.findByUsuarioMod", query = "SELECT p FROM ProcesoFabricacion p WHERE p.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "ProcesoFabricacion.findByFechaMod", query = "SELECT p FROM ProcesoFabricacion p WHERE p.fechaMod = :fechaMod")})
public class ProcesoFabricacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proceso_fabricacion")
    private Integer idProcesoFabricacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_supervisor")
    private int idSupervisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ban_estado")
    private String banEstado;
    @Size(max = 10)
    @Column(name = "usuario_gra")
    private String usuarioGra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_gra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGra;
    @Size(max = 10)
    @Column(name = "usuario_mod")
    private String usuarioMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;
    @JoinColumn(name = "id_linea_productiva", referencedColumnName = "id_linea_productiva")
    @ManyToOne(optional = false)
    private LineaProductiva idLineaProductiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcesoFabricacion")
    private List<EstacionTrabajo> estacionTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcesoFabricacion")
    private List<HojaRutaOf> hojaRutaOfList;

    public ProcesoFabricacion() {
    }

    public ProcesoFabricacion(Integer idProcesoFabricacion) {
        this.idProcesoFabricacion = idProcesoFabricacion;
    }

    public ProcesoFabricacion(Integer idProcesoFabricacion, int idSupervisor, String nombre, int orden, String banEstado, Date fechaGra, Date fechaMod) {
        this.idProcesoFabricacion = idProcesoFabricacion;
        this.idSupervisor = idSupervisor;
        this.nombre = nombre;
        this.orden = orden;
        this.banEstado = banEstado;
        this.fechaGra = fechaGra;
        this.fechaMod = fechaMod;
    }

    public Integer getIdProcesoFabricacion() {
        return idProcesoFabricacion;
    }

    public void setIdProcesoFabricacion(Integer idProcesoFabricacion) {
        this.idProcesoFabricacion = idProcesoFabricacion;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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

    public LineaProductiva getIdLineaProductiva() {
        return idLineaProductiva;
    }

    public void setIdLineaProductiva(LineaProductiva idLineaProductiva) {
        this.idLineaProductiva = idLineaProductiva;
    }

    @XmlTransient
    public List<EstacionTrabajo> getEstacionTrabajoList() {
        return estacionTrabajoList;
    }

    public void setEstacionTrabajoList(List<EstacionTrabajo> estacionTrabajoList) {
        this.estacionTrabajoList = estacionTrabajoList;
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
        hash += (idProcesoFabricacion != null ? idProcesoFabricacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoFabricacion)) {
            return false;
        }
        ProcesoFabricacion other = (ProcesoFabricacion) object;
        if ((this.idProcesoFabricacion == null && other.idProcesoFabricacion != null) || (this.idProcesoFabricacion != null && !this.idProcesoFabricacion.equals(other.idProcesoFabricacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.ProcesoFabricacion[ idProcesoFabricacion=" + idProcesoFabricacion + " ]";
    }
    
}
