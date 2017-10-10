/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Ep77
 */
@Entity
@Table(name = "tblcliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcliente.findAll", query = "SELECT t FROM Tblcliente t"),
    @NamedQuery(name = "Tblcliente.findByIdCliente", query = "SELECT t FROM Tblcliente t WHERE t.idCliente = :idCliente"),
    @NamedQuery(name = "Tblcliente.findByNombre", query = "SELECT t FROM Tblcliente t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblcliente.findByApellido", query = "SELECT t FROM Tblcliente t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "Tblcliente.findByPassword", query = "SELECT t FROM Tblcliente t WHERE t.password = :password"),
    @NamedQuery(name = "Tblcliente.findByDocumento", query = "SELECT t FROM Tblcliente t WHERE t.documento = :documento"),
    @NamedQuery(name = "Tblcliente.findByFechaIngreso", query = "SELECT t FROM Tblcliente t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Tblcliente.findByCorreo", query = "SELECT t FROM Tblcliente t WHERE t.correo = :correo"),
    @NamedQuery(name = "Tblcliente.findByReferido", query = "SELECT t FROM Tblcliente t WHERE t.referido = :referido"),
    @NamedQuery(name = "Tblcliente.findByPuntos", query = "SELECT t FROM Tblcliente t WHERE t.puntos = :puntos")})
public class Tblcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_Ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "referido")
    private String referido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblcliente")
    private Collection<Tbltransaccion> tbltransaccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblcliente")
    private Collection<Tblvaloracion> tblvaloracionCollection;

    public Tblcliente() {
    }

    public Tblcliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Tblcliente(Integer idCliente, String nombre, String apellido, String password, String documento, Date fechaIngreso, String correo, String referido, int puntos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.documento = documento;
        this.fechaIngreso = fechaIngreso;
        this.correo = correo;
        this.referido = referido;
        this.puntos = puntos;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getReferido() {
        return referido;
    }

    public void setReferido(String referido) {
        this.referido = referido;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @XmlTransient
    public Collection<Tbltransaccion> getTbltransaccionCollection() {
        return tbltransaccionCollection;
    }

    public void setTbltransaccionCollection(Collection<Tbltransaccion> tbltransaccionCollection) {
        this.tbltransaccionCollection = tbltransaccionCollection;
    }

    @XmlTransient
    public Collection<Tblvaloracion> getTblvaloracionCollection() {
        return tblvaloracionCollection;
    }

    public void setTblvaloracionCollection(Collection<Tblvaloracion> tblvaloracionCollection) {
        this.tblvaloracionCollection = tblvaloracionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcliente)) {
            return false;
        }
        Tblcliente other = (Tblcliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblcliente[ idCliente=" + idCliente + " ]";
    }
    
}
