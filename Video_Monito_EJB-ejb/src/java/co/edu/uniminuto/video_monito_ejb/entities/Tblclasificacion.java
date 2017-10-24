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
@Table(name = "tblclasificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblclasificacion.findAll", query = "SELECT t FROM Tblclasificacion t"),
    @NamedQuery(name = "Tblclasificacion.findByIdClasificacion", query = "SELECT t FROM Tblclasificacion t WHERE t.idClasificacion = :idClasificacion"),
    @NamedQuery(name = "Tblclasificacion.findByClasificacion", query = "SELECT t FROM Tblclasificacion t WHERE t.clasificacion = :clasificacion"),
    @NamedQuery(name = "Tblclasificacion.findByDescripcion", query = "SELECT t FROM Tblclasificacion t WHERE t.descripcion = :descripcion")})
public class Tblclasificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClasificacion")
    private Integer idClasificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Clasificacion")
    private String clasificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasificacion")
    private List<Tblvideo> tblvideoList;

    public Tblclasificacion() {
    }

    public Tblclasificacion(String clasificacion, String descripcion) {
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
    }
    

    public Tblclasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Tblclasificacion(Integer idClasificacion, String clasificacion, String descripcion) {
        this.idClasificacion = idClasificacion;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Tblvideo> getTblvideoList() {
        return tblvideoList;
    }

    public void setTblvideoList(List<Tblvideo> tblvideoList) {
        this.tblvideoList = tblvideoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasificacion != null ? idClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblclasificacion)) {
            return false;
        }
        Tblclasificacion other = (Tblclasificacion) object;
        if ((this.idClasificacion == null && other.idClasificacion != null) || (this.idClasificacion != null && !this.idClasificacion.equals(other.idClasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblclasificacion[ idClasificacion=" + idClasificacion + " ]";
    }
    
}
