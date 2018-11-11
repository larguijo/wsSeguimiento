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
@Table(name = "estacion_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstacionTrabajo.findAll", query = "SELECT e FROM EstacionTrabajo e"),
    @NamedQuery(name = "EstacionTrabajo.findByIdEstacionTrabajo", query = "SELECT e FROM EstacionTrabajo e WHERE e.idEstacionTrabajo = :idEstacionTrabajo"),
    @NamedQuery(name = "EstacionTrabajo.findByNombre", query = "SELECT e FROM EstacionTrabajo e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstacionTrabajo.findByBanEstado", query = "SELECT e FROM EstacionTrabajo e WHERE e.banEstado = :banEstado"),
    @NamedQuery(name = "EstacionTrabajo.findByUsuarioGra", query = "SELECT e FROM EstacionTrabajo e WHERE e.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "EstacionTrabajo.findByFechaGra", query = "SELECT e FROM EstacionTrabajo e WHERE e.fechaGra = :fechaGra"),
    @NamedQuery(name = "EstacionTrabajo.findByUsuarioMod", query = "SELECT e FROM EstacionTrabajo e WHERE e.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "EstacionTrabajo.findByFechaMod", query = "SELECT e FROM EstacionTrabajo e WHERE e.fechaMod = :fechaMod")})
public class EstacionTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estacion_trabajo")
    private Integer idEstacionTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(mappedBy = "idEstacionTrabajo")
    private List<PuntoControl> puntoControlList;
    @JoinColumn(name = "id_proceso_fabricacion", referencedColumnName = "id_proceso_fabricacion")
    @ManyToOne(optional = false)
    private ProcesoFabricacion idProcesoFabricacion;

    public EstacionTrabajo() {
    }

    public EstacionTrabajo(Integer idEstacionTrabajo) {
        this.idEstacionTrabajo = idEstacionTrabajo;
    }

    public EstacionTrabajo(Integer idEstacionTrabajo, String nombre, String banEstado, Date fechaGra, Date fechaMod) {
        this.idEstacionTrabajo = idEstacionTrabajo;
        this.nombre = nombre;
        this.banEstado = banEstado;
        this.fechaGra = fechaGra;
        this.fechaMod = fechaMod;
    }

    public Integer getIdEstacionTrabajo() {
        return idEstacionTrabajo;
    }

    public void setIdEstacionTrabajo(Integer idEstacionTrabajo) {
        this.idEstacionTrabajo = idEstacionTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public List<PuntoControl> getPuntoControlList() {
        return puntoControlList;
    }

    public void setPuntoControlList(List<PuntoControl> puntoControlList) {
        this.puntoControlList = puntoControlList;
    }

    public ProcesoFabricacion getIdProcesoFabricacion() {
        return idProcesoFabricacion;
    }

    public void setIdProcesoFabricacion(ProcesoFabricacion idProcesoFabricacion) {
        this.idProcesoFabricacion = idProcesoFabricacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstacionTrabajo != null ? idEstacionTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionTrabajo)) {
            return false;
        }
        EstacionTrabajo other = (EstacionTrabajo) object;
        if ((this.idEstacionTrabajo == null && other.idEstacionTrabajo != null) || (this.idEstacionTrabajo != null && !this.idEstacionTrabajo.equals(other.idEstacionTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.EstacionTrabajo[ idEstacionTrabajo=" + idEstacionTrabajo + " ]";
    }
    
}
