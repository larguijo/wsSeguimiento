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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "seguimiento_empleado_of")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoEmpleadoOf.findAll", query = "SELECT s FROM SeguimientoEmpleadoOf s"),
    @NamedQuery(name = "SeguimientoEmpleadoOf.findTrabajoActual", query = "SELECT s FROM SeguimientoEmpleadoOf s WHERE s.idPuntoControl = :pc AND s.banEstado = 'P' ORDER BY s.idHojaRuta.idOrdenFabricacion.idOrdenFabricacion"),
    @NamedQuery(name = "SeguimientoEmpleadoOf.findByEmpleadoEstado", query = "SELECT s FROM SeguimientoEmpleadoOf s WHERE s.idEmpleado.idEmpleado = :idEmpleado AND s.banEstado = :banEstado"),
    @NamedQuery(name = "SeguimientoEmpleadoOf.findByIdSeguimiento", query = "SELECT s FROM SeguimientoEmpleadoOf s WHERE s.idSeguimiento = :idSeguimiento"),
    @NamedQuery(name = "SeguimientoEmpleadoOf.findByIdPuntoControl", query = "SELECT s FROM SeguimientoEmpleadoOf s WHERE s.idPuntoControl = :idPuntoControl"),
    @NamedQuery(name = "SeguimientoEmpleadoOf.findByFechaHoraInicio", query = "SELECT s FROM SeguimientoEmpleadoOf s WHERE s.fechaHoraInicio = :fechaHoraInicio"),
    @NamedQuery(name = "SeguimientoEmpleadoOf.findByFechaHoraFin", query = "SELECT s FROM SeguimientoEmpleadoOf s WHERE s.fechaHoraFin = :fechaHoraFin"),
    @NamedQuery(name = "SeguimientoEmpleadoOf.findByBanEstado", query = "SELECT s FROM SeguimientoEmpleadoOf s WHERE s.banEstado = :banEstado")})
public class SeguimientoEmpleadoOf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_seguimiento")
    private Integer idSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_punto_control")
    private int idPuntoControl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;
    @Column(name = "fecha_hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFin;
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
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_hoja_ruta", referencedColumnName = "id_hoja_ruta")
    @ManyToOne(optional = false)
    private HojaRutaOf idHojaRuta;

    public SeguimientoEmpleadoOf() {
    }

    public SeguimientoEmpleadoOf(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public SeguimientoEmpleadoOf(Integer idSeguimiento, int idPuntoControl, Date fechaHoraInicio, Date fechaHoraFin, String banEstado, String usuarioGra, Date fechaGra, String usuarioMod, Date fechaMod) {
        this.idSeguimiento = idSeguimiento;
        this.idPuntoControl = idPuntoControl;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.banEstado = banEstado;
        this.usuarioGra = usuarioGra;
        this.fechaGra = fechaGra;
        this.usuarioMod = usuarioMod;
        this.fechaMod = fechaMod;
    }

    public Integer getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public int getIdPuntoControl() {
        return idPuntoControl;
    }

    public void setIdPuntoControl(int idPuntoControl) {
        this.idPuntoControl = idPuntoControl;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
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

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public HojaRutaOf getIdHojaRuta() {
        return idHojaRuta;
    }

    public void setIdHojaRuta(HojaRutaOf idHojaRuta) {
        this.idHojaRuta = idHojaRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguimiento != null ? idSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoEmpleadoOf)) {
            return false;
        }
        SeguimientoEmpleadoOf other = (SeguimientoEmpleadoOf) object;
        if ((this.idSeguimiento == null && other.idSeguimiento != null) || (this.idSeguimiento != null && !this.idSeguimiento.equals(other.idSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.SeguimientoEmpleadoOf[ idSeguimiento=" + idSeguimiento + " ]";
    }
    
}
