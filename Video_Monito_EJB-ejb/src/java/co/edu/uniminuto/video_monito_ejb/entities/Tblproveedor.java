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
@Table(name = "tblproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblproveedor.findAll", query = "SELECT t FROM Tblproveedor t"),
    @NamedQuery(name = "Tblproveedor.findByIdProveedor", query = "SELECT t FROM Tblproveedor t WHERE t.idProveedor = :idProveedor"),
    @NamedQuery(name = "Tblproveedor.findByNit", query = "SELECT t FROM Tblproveedor t WHERE t.nit = :nit"),
    @NamedQuery(name = "Tblproveedor.findByNombres", query = "SELECT t FROM Tblproveedor t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "Tblproveedor.findBySede", query = "SELECT t FROM Tblproveedor t WHERE t.sede = :sede"),
    @NamedQuery(name = "Tblproveedor.findByPassword", query = "SELECT t FROM Tblproveedor t WHERE t.password = :password")})
public class Tblproveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProveedor")
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "Nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sede")
    private String sede;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private Collection<Tblvideo> tblvideoCollection;

    public Tblproveedor() {
    }

    public Tblproveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Tblproveedor(Integer idProveedor, String nit, String nombres, String sede, String password) {
        this.idProveedor = idProveedor;
        this.nit = nit;
        this.nombres = nombres;
        this.sede = sede;
        this.password = password;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Tblvideo> getTblvideoCollection() {
        return tblvideoCollection;
    }

    public void setTblvideoCollection(Collection<Tblvideo> tblvideoCollection) {
        this.tblvideoCollection = tblvideoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblproveedor)) {
            return false;
        }
        Tblproveedor other = (Tblproveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblproveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
