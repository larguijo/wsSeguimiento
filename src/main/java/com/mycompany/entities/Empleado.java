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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByBanEstado", query = "SELECT e FROM Empleado e WHERE e.banEstado = :banEstado"),
    @NamedQuery(name = "Empleado.findByUsuarioGra", query = "SELECT e FROM Empleado e WHERE e.usuarioGra = :usuarioGra"),
    @NamedQuery(name = "Empleado.findByFechaGra", query = "SELECT e FROM Empleado e WHERE e.fechaGra = :fechaGra"),
    @NamedQuery(name = "Empleado.findByUsuarioMod", query = "SELECT e FROM Empleado e WHERE e.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "Empleado.findByFechaMod", query = "SELECT e FROM Empleado e WHERE e.fechaMod = :fechaMod")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ban_estado")
    private String banEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<SeguimientoEmpleadoOf> seguimientoEmpleadoOfList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSupervisor")
    private List<OrdenFabricacion> ordenFabricacionList;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombre, String apellidos, String banEstado, String usuarioGra, Date fechaGra, String usuarioMod, Date fechaMod) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.banEstado = banEstado;
        this.usuarioGra = usuarioGra;
        this.fechaGra = fechaGra;
        this.usuarioMod = usuarioMod;
        this.fechaMod = fechaMod;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellidos;
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
    public List<SeguimientoEmpleadoOf> getSeguimientoEmpleadoOfList() {
        return seguimientoEmpleadoOfList;
    }

    public void setSeguimientoEmpleadoOfList(List<SeguimientoEmpleadoOf> seguimientoEmpleadoOfList) {
        this.seguimientoEmpleadoOfList = seguimientoEmpleadoOfList;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }

}
