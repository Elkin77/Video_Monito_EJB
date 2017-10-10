/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ep77
 */
@Entity
@Table(name = "tblpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblpersona.findAll", query = "SELECT t FROM Tblpersona t"),
    @NamedQuery(name = "Tblpersona.findByIdPersona", query = "SELECT t FROM Tblpersona t WHERE t.idPersona = :idPersona"),
    @NamedQuery(name = "Tblpersona.findByNombre", query = "SELECT t FROM Tblpersona t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblpersona.findByApellido", query = "SELECT t FROM Tblpersona t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "Tblpersona.findByPapelVideo", query = "SELECT t FROM Tblpersona t WHERE t.papelVideo = :papelVideo"),
    @NamedQuery(name = "Tblpersona.findByDescripcion", query = "SELECT t FROM Tblpersona t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tblpersona.findByEdad", query = "SELECT t FROM Tblpersona t WHERE t.edad = :edad"),
    @NamedQuery(name = "Tblpersona.findByPais", query = "SELECT t FROM Tblpersona t WHERE t.pais = :pais"),
    @NamedQuery(name = "Tblpersona.findByPremios", query = "SELECT t FROM Tblpersona t WHERE t.premios = :premios")})
public class Tblpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersona")
    private Integer idPersona;
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
    @Column(name = "papelVideo")
    private String papelVideo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "premios")
    private String premios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<Tblvideopersona> tblvideopersonaCollection;

    public Tblpersona() {
    }

    public Tblpersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Tblpersona(Integer idPersona, String nombre, String apellido, String papelVideo, String descripcion, int edad, String pais, String premios) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.papelVideo = papelVideo;
        this.descripcion = descripcion;
        this.edad = edad;
        this.pais = pais;
        this.premios = premios;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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

    public String getPapelVideo() {
        return papelVideo;
    }

    public void setPapelVideo(String papelVideo) {
        this.papelVideo = papelVideo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    @XmlTransient
    public Collection<Tblvideopersona> getTblvideopersonaCollection() {
        return tblvideopersonaCollection;
    }

    public void setTblvideopersonaCollection(Collection<Tblvideopersona> tblvideopersonaCollection) {
        this.tblvideopersonaCollection = tblvideopersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblpersona)) {
            return false;
        }
        Tblpersona other = (Tblpersona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblpersona[ idPersona=" + idPersona + " ]";
    }
    
}
