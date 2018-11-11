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
@Table(name = "linea_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaProductiva.findAll", query = "SELECT l FROM LineaProductiva l"),
    @NamedQuery(name = "LineaProductiva.findByIdLineaProductiva", query = "SELECT l FROM LineaProductiva l WHERE l.idLineaProductiva = :idLineaProductiva"),
    @NamedQuery(name = "LineaProductiva.findByNombre", query = "SELECT l FROM LineaProductiva l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "LineaProductiva.findByBanEstado", query = "SELECT l FROM LineaProductiva l WHERE l.banEstado = :banEstado"),
    @NamedQuery(name = "LineaProductiva.findByUsuarioGra", query = "SELECT l FROM LineaProductiva l WHERE l.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "LineaProductiva.findByFechaGra", query = "SELECT l FROM LineaProductiva l WHERE l.fechaGra = :fechaGra"),
    @NamedQuery(name = "LineaProductiva.findByUsuarioMod", query = "SELECT l FROM LineaProductiva l WHERE l.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "LineaProductiva.findByFechaMod", query = "SELECT l FROM LineaProductiva l WHERE l.fechaMod = :fechaMod")})
public class LineaProductiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_linea_productiva")
    private Integer idLineaProductiva;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLineaProductiva")
    private List<ProcesoFabricacion> procesoFabricacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLineaProductiva")
    private List<OrdenFabricacion> ordenFabricacionList;

    public LineaProductiva() {
    }

    public LineaProductiva(Integer idLineaProductiva) {
        this.idLineaProductiva = idLineaProductiva;
    }

    public LineaProductiva(Integer idLineaProductiva, String nombre, String banEstado, Date fechaGra, Date fechaMod) {
        this.idLineaProductiva = idLineaProductiva;
        this.nombre = nombre;
        this.banEstado = banEstado;
        this.fechaGra = fechaGra;
        this.fechaMod = fechaMod;
    }

    public Integer getIdLineaProductiva() {
        return idLineaProductiva;
    }

    public void setIdLineaProductiva(Integer idLineaProductiva) {
        this.idLineaProductiva = idLineaProductiva;
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
    public List<ProcesoFabricacion> getProcesoFabricacionList() {
        return procesoFabricacionList;
    }

    public void setProcesoFabricacionList(List<ProcesoFabricacion> procesoFabricacionList) {
        this.procesoFabricacionList = procesoFabricacionList;
    }

    @XmlTransient
    public List<OrdenFabricacion> getOrdenFabricacionList() {
        return ordenFabricacionList;
    }

    public void setOrdenFabricacionList(List<OrdenFabricacion> ordenFabricacionList) {
        this.ordenFabricacionList = ordenFabricacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaProductiva != null ? idLineaProductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaProductiva)) {
            return false;
        }
        LineaProductiva other = (LineaProductiva) object;
        if ((this.idLineaProductiva == null && other.idLineaProductiva != null) || (this.idLineaProductiva != null && !this.idLineaProductiva.equals(other.idLineaProductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.LineaProductiva[ idLineaProductiva=" + idLineaProductiva + " ]";
    }
    
}
