/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ep77
 */
@Entity
@Table(name = "tblcoleccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcoleccion.findAll", query = "SELECT t FROM Tblcoleccion t"),
    @NamedQuery(name = "Tblcoleccion.findByIdColeccion", query = "SELECT t FROM Tblcoleccion t WHERE t.idColeccion = :idColeccion"),
    @NamedQuery(name = "Tblcoleccion.findByColeccion", query = "SELECT t FROM Tblcoleccion t WHERE t.coleccion = :coleccion"),
    @NamedQuery(name = "Tblcoleccion.findByVersion", query = "SELECT t FROM Tblcoleccion t WHERE t.version = :version"),
    @NamedQuery(name = "Tblcoleccion.findByFechacreacion", query = "SELECT t FROM Tblcoleccion t WHERE t.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Tblcoleccion.findByEstado", query = "SELECT t FROM Tblcoleccion t WHERE t.estado = :estado")})
public class Tblcoleccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idColeccion")
    private Integer idColeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Coleccion")
    private String coleccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Version")
    private String version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Fecha_creacion")
    private String fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblcoleccion")
    private List<Tblcoleccionvideo> tblcoleccionvideoList;

    public Tblcoleccion() {
    }

    public Tblcoleccion(String coleccion, String version, String fechacreacion, String estado) {
        this.coleccion = coleccion;
        this.version = version;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }
    
    

    public Tblcoleccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public Tblcoleccion(Integer idColeccion, String coleccion, String version, String fechacreacion, String estado) {
        this.idColeccion = idColeccion;
        this.coleccion = coleccion;
        this.version = version;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getColeccion() {
        return coleccion;
    }

    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Tblcoleccionvideo> getTblcoleccionvideoList() {
        return tblcoleccionvideoList;
    }

    public void setTblcoleccionvideoList(List<Tblcoleccionvideo> tblcoleccionvideoList) {
        this.tblcoleccionvideoList = tblcoleccionvideoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColeccion != null ? idColeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcoleccion)) {
            return false;
        }
        Tblcoleccion other = (Tblcoleccion) object;
        if ((this.idColeccion == null && other.idColeccion != null) || (this.idColeccion != null && !this.idColeccion.equals(other.idColeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblcoleccion[ idColeccion=" + idColeccion + " ]";
    }
    
}
