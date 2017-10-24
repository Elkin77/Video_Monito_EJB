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
@Table(name = "tblmediopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblmediopago.findAll", query = "SELECT t FROM Tblmediopago t"),
    @NamedQuery(name = "Tblmediopago.findByIdMedioPago", query = "SELECT t FROM Tblmediopago t WHERE t.idMedioPago = :idMedioPago"),
    @NamedQuery(name = "Tblmediopago.findByNombre", query = "SELECT t FROM Tblmediopago t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblmediopago.findByTipo", query = "SELECT t FROM Tblmediopago t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tblmediopago.findByNumCuenta", query = "SELECT t FROM Tblmediopago t WHERE t.numCuenta = :numCuenta"),
    @NamedQuery(name = "Tblmediopago.findByPassword", query = "SELECT t FROM Tblmediopago t WHERE t.password = :password"),
    @NamedQuery(name = "Tblmediopago.findByCvr", query = "SELECT t FROM Tblmediopago t WHERE t.cvr = :cvr"),
    @NamedQuery(name = "Tblmediopago.findByYearVencimiento", query = "SELECT t FROM Tblmediopago t WHERE t.yearVencimiento = :yearVencimiento")})
public class Tblmediopago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedioPago")
    private Integer idMedioPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numCuenta")
    private int numCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CVR")
    private String cvr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "yearVencimiento")
    private String yearVencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblmediopago")
    private List<Tbltransaccion> tbltransaccionList;

    public Tblmediopago() {
    }

    public Tblmediopago(Integer idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public Tblmediopago(Integer idMedioPago, String nombre, String tipo, int numCuenta, String password, String cvr, String yearVencimiento) {
        this.idMedioPago = idMedioPago;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numCuenta = numCuenta;
        this.password = password;
        this.cvr = cvr;
        this.yearVencimiento = yearVencimiento;
    }

    public Integer getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(Integer idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getYearVencimiento() {
        return yearVencimiento;
    }

    public void setYearVencimiento(String yearVencimiento) {
        this.yearVencimiento = yearVencimiento;
    }

    @XmlTransient
    public List<Tbltransaccion> getTbltransaccionList() {
        return tbltransaccionList;
    }

    public void setTbltransaccionList(List<Tbltransaccion> tbltransaccionList) {
        this.tbltransaccionList = tbltransaccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedioPago != null ? idMedioPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblmediopago)) {
            return false;
        }
        Tblmediopago other = (Tblmediopago) object;
        if ((this.idMedioPago == null && other.idMedioPago != null) || (this.idMedioPago != null && !this.idMedioPago.equals(other.idMedioPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblmediopago[ idMedioPago=" + idMedioPago + " ]";
    }
    
}
