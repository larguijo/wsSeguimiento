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
@Table(name = "hoja_ruta_of")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HojaRutaOf.findAll", query = "SELECT h FROM HojaRutaOf h"),
    @NamedQuery(name = "HojaRutaOf.findByIdHojaRuta", query = "SELECT h FROM HojaRutaOf h WHERE h.idHojaRuta = :idHojaRuta"),
    @NamedQuery(name = "HojaRutaOf.findByFechaHoraIni", query = "SELECT h FROM HojaRutaOf h WHERE h.fechaHoraIni = :fechaHoraIni"),
    @NamedQuery(name = "HojaRutaOf.findByFechaHoraFin", query = "SELECT h FROM HojaRutaOf h WHERE h.fechaHoraFin = :fechaHoraFin"),
    @NamedQuery(name = "HojaRutaOf.findByBanEstado", query = "SELECT h FROM HojaRutaOf h WHERE h.banEstado = :banEstado"),
    @NamedQuery(name = "HojaRutaOf.findByBanOfNotificada", query = "SELECT h FROM HojaRutaOf h WHERE h.banOfNotificada = :banOfNotificada"),
    @NamedQuery(name = "HojaRutaOf.findByUsuarioGra", query = "SELECT h FROM HojaRutaOf h WHERE h.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "HojaRutaOf.findByFechaGra", query = "SELECT h FROM HojaRutaOf h WHERE h.fechaGra = :fechaGra"),
    @NamedQuery(name = "HojaRutaOf.findByUsuarioMod", query = "SELECT h FROM HojaRutaOf h WHERE h.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "HojaRutaOf.findByFechaMod", query = "SELECT h FROM HojaRutaOf h WHERE h.fechaMod = :fechaMod")})
public class HojaRutaOf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hoja_ruta")
    private Integer idHojaRuta;
    @Column(name = "fecha_hora_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraIni;
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
    @Size(min = 1, max = 1)
    @Column(name = "ban_of_notificada")
    private String banOfNotificada;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHojaRuta")
    private List<SeguimientoEmpleadoOf> seguimientoEmpleadoOfList;
    @JoinColumn(name = "id_orden_fabricacion", referencedColumnName = "id_orden_fabricacion")
    @ManyToOne(optional = false)
    private OrdenFabricacion idOrdenFabricacion;
    @JoinColumn(name = "id_proceso_fabricacion", referencedColumnName = "id_proceso_fabricacion")
    @ManyToOne(optional = false)
    private ProcesoFabricacion idProcesoFabricacion;

    public HojaRutaOf() {
    }

    public HojaRutaOf(Integer idHojaRuta) {
        this.idHojaRuta = idHojaRuta;
    }

    public HojaRutaOf(Integer idHojaRuta, Date fechaHoraIni, Date fechaHoraFin, String banEstado, String banOfNotificada, String usuarioGra, Date fechaGra, String usuarioMod, Date fechaMod) {
        this.idHojaRuta = idHojaRuta;
        this.fechaHoraIni = fechaHoraIni;
        this.fechaHoraFin = fechaHoraFin;
        this.banEstado = banEstado;
        this.banOfNotificada = banOfNotificada;
        this.usuarioGra = usuarioGra;
        this.fechaGra = fechaGra;
        this.usuarioMod = usuarioMod;
        this.fechaMod = fechaMod;
    }

    public Integer getIdHojaRuta() {
        return idHojaRuta;
    }

    public void setIdHojaRuta(Integer idHojaRuta) {
        this.idHojaRuta = idHojaRuta;
    }

    public Date getFechaHoraIni() {
        return fechaHoraIni;
    }

    public void setFechaHoraIni(Date fechaHoraIni) {
        this.fechaHoraIni = fechaHoraIni;
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

    public String getBanOfNotificada() {
        return banOfNotificada;
    }

    public void setBanOfNotificada(String banOfNotificada) {
        this.banOfNotificada = banOfNotificada;
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
    public List<SeguimientoEmpleadoOf> getSeguimientoEmpleadoOfList() {
        return seguimientoEmpleadoOfList;
    }

    public void setSeguimientoEmpleadoOfList(List<SeguimientoEmpleadoOf> seguimientoEmpleadoOfList) {
        this.seguimientoEmpleadoOfList = seguimientoEmpleadoOfList;
    }

    public OrdenFabricacion getIdOrdenFabricacion() {
        return idOrdenFabricacion;
    }

    public void setIdOrdenFabricacion(OrdenFabricacion idOrdenFabricacion) {
        this.idOrdenFabricacion = idOrdenFabricacion;
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
        hash += (idHojaRuta != null ? idHojaRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojaRutaOf)) {
            return false;
        }
        HojaRutaOf other = (HojaRutaOf) object;
        if ((this.idHojaRuta == null && other.idHojaRuta != null) || (this.idHojaRuta != null && !this.idHojaRuta.equals(other.idHojaRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.HojaRutaOf[ idHojaRuta=" + idHojaRuta + " ]";
    }
    
}
