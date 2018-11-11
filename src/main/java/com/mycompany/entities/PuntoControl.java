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
@Table(name = "punto_control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntoControl.findAll", query = "SELECT p FROM PuntoControl p"),
    @NamedQuery(name = "PuntoControl.findByIdPuntoControl", query = "SELECT p FROM PuntoControl p WHERE p.idPuntoControl = :idPuntoControl"),
    @NamedQuery(name = "PuntoControl.findByNombre", query = "SELECT p FROM PuntoControl p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PuntoControl.findByBanEstado", query = "SELECT p FROM PuntoControl p WHERE p.banEstado = :banEstado"),
    @NamedQuery(name = "PuntoControl.findByUsuarioGra", query = "SELECT p FROM PuntoControl p WHERE p.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "PuntoControl.findByFechaGra", query = "SELECT p FROM PuntoControl p WHERE p.fechaGra = :fechaGra"),
    @NamedQuery(name = "PuntoControl.findByUsuarioMod", query = "SELECT p FROM PuntoControl p WHERE p.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "PuntoControl.findByFechaMod", query = "SELECT p FROM PuntoControl p WHERE p.fechaMod = :fechaMod")})
public class PuntoControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_punto_control")
    private Integer idPuntoControl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
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
    @JoinColumn(name = "id_estacion_trabajo", referencedColumnName = "id_estacion_trabajo")
    @ManyToOne
    private EstacionTrabajo idEstacionTrabajo;

    public PuntoControl() {
    }

    public PuntoControl(Integer idPuntoControl) {
        this.idPuntoControl = idPuntoControl;
    }

    public PuntoControl(Integer idPuntoControl, String nombre, String banEstado, Date fechaGra, Date fechaMod) {
        this.idPuntoControl = idPuntoControl;
        this.nombre = nombre;
        this.banEstado = banEstado;
        this.fechaGra = fechaGra;
        this.fechaMod = fechaMod;
    }

    public Integer getIdPuntoControl() {
        return idPuntoControl;
    }

    public void setIdPuntoControl(Integer idPuntoControl) {
        this.idPuntoControl = idPuntoControl;
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

    public EstacionTrabajo getIdEstacionTrabajo() {
        return idEstacionTrabajo;
    }

    public void setIdEstacionTrabajo(EstacionTrabajo idEstacionTrabajo) {
        this.idEstacionTrabajo = idEstacionTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuntoControl != null ? idPuntoControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntoControl)) {
            return false;
        }
        PuntoControl other = (PuntoControl) object;
        if ((this.idPuntoControl == null && other.idPuntoControl != null) || (this.idPuntoControl != null && !this.idPuntoControl.equals(other.idPuntoControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.PuntoControl[ idPuntoControl=" + idPuntoControl + " ]";
    }
    
}
