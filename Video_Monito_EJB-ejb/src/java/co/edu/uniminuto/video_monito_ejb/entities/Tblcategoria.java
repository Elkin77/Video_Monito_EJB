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
@Table(name = "tblcategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcategoria.findAll", query = "SELECT t FROM Tblcategoria t"),
    @NamedQuery(name = "Tblcategoria.findByIdCategoria", query = "SELECT t FROM Tblcategoria t WHERE t.idCategoria = :idCategoria"),
    @NamedQuery(name = "Tblcategoria.findByCategoria", query = "SELECT t FROM Tblcategoria t WHERE t.categoria = :categoria"),
    @NamedQuery(name = "Tblcategoria.findByDescripcion", query = "SELECT t FROM Tblcategoria t WHERE t.descripcion = :descripcion")})
public class Tblcategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private List<Tblvideo> tblvideoList;

    public Tblcategoria() {
    }

    public Tblcategoria(String categoria, String descripcion) {
        this.categoria = categoria;
        this.descripcion = descripcion;
    }
    

    public Tblcategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Tblcategoria(Integer idCategoria, String categoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcategoria)) {
            return false;
        }
        Tblcategoria other = (Tblcategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblcategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
