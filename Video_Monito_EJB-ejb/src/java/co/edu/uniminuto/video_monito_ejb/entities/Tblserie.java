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
@Table(name = "tblserie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblserie.findAll", query = "SELECT t FROM Tblserie t"),
    @NamedQuery(name = "Tblserie.findByIdSerie", query = "SELECT t FROM Tblserie t WHERE t.idSerie = :idSerie"),
    @NamedQuery(name = "Tblserie.findByTemporada", query = "SELECT t FROM Tblserie t WHERE t.temporada = :temporada"),
    @NamedQuery(name = "Tblserie.findByNombre", query = "SELECT t FROM Tblserie t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblserie.findByEstado", query = "SELECT t FROM Tblserie t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tblserie.findByFechaInicio", query = "SELECT t FROM Tblserie t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Tblserie.findByFechaFinal", query = "SELECT t FROM Tblserie t WHERE t.fechaFinal = :fechaFinal")})
public class Tblserie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSerie")
    private Integer idSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "temporada")
    private String temporada;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "Fecha_Inicio")
    private String fechaInicio;
    @Size(max = 45)
    @Column(name = "Fecha_Final")
    private String fechaFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblserie")
    private Collection<Tblvideoserie> tblvideoserieCollection;

    public Tblserie() {
    }

    public Tblserie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Tblserie(Integer idSerie, String temporada) {
        this.idSerie = idSerie;
        this.temporada = temporada;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @XmlTransient
    public Collection<Tblvideoserie> getTblvideoserieCollection() {
        return tblvideoserieCollection;
    }

    public void setTblvideoserieCollection(Collection<Tblvideoserie> tblvideoserieCollection) {
        this.tblvideoserieCollection = tblvideoserieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerie != null ? idSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblserie)) {
            return false;
        }
        Tblserie other = (Tblserie) object;
        if ((this.idSerie == null && other.idSerie != null) || (this.idSerie != null && !this.idSerie.equals(other.idSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblserie[ idSerie=" + idSerie + " ]";
    }
    
}
