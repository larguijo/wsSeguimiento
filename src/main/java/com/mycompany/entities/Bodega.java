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
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByIdBodega", query = "SELECT b FROM Bodega b WHERE b.idBodega = :idBodega"),
    @NamedQuery(name = "Bodega.findByNombre", query = "SELECT b FROM Bodega b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Bodega.findByBanEstado", query = "SELECT b FROM Bodega b WHERE b.banEstado = :banEstado"),
    @NamedQuery(name = "Bodega.findByUsuarioGra", query = "SELECT b FROM Bodega b WHERE b.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "Bodega.findByFechaGra", query = "SELECT b FROM Bodega b WHERE b.fechaGra = :fechaGra"),
    @NamedQuery(name = "Bodega.findByUsuarioMod", query = "SELECT b FROM Bodega b WHERE b.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "Bodega.findByFechaMod", query = "SELECT b FROM Bodega b WHERE b.fechaMod = :fechaMod")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_bodega")
    private Integer idBodega;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBodega")
    private List<Inventario> inventarioList;

    public Bodega() {
    }

    public Bodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Bodega(Integer idBodega, String nombre, String banEstado, Date fechaGra, Date fechaMod) {
        this.idBodega = idBodega;
        this.nombre = nombre;
        this.banEstado = banEstado;
        this.fechaGra = fechaGra;
        this.fechaMod = fechaMod;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
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
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Bodega[ idBodega=" + idBodega + " ]";
    }
    
}
