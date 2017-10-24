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
@Table(name = "tblidioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblidioma.findAll", query = "SELECT t FROM Tblidioma t"),
    @NamedQuery(name = "Tblidioma.findByIdIdioma", query = "SELECT t FROM Tblidioma t WHERE t.idIdioma = :idIdioma"),
    @NamedQuery(name = "Tblidioma.findByLenguaje", query = "SELECT t FROM Tblidioma t WHERE t.lenguaje = :lenguaje"),
    @NamedQuery(name = "Tblidioma.findBySubtitulos", query = "SELECT t FROM Tblidioma t WHERE t.subtitulos = :subtitulos"),
    @NamedQuery(name = "Tblidioma.findByDoblaje", query = "SELECT t FROM Tblidioma t WHERE t.doblaje = :doblaje")})
public class Tblidioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIdioma")
    private Integer idIdioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lenguaje")
    private String lenguaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "subtitulos")
    private String subtitulos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "doblaje")
    private String doblaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblidioma")
    private List<Tblvideoidioma> tblvideoidiomaList;

    public Tblidioma() {
    }

    public Tblidioma(String lenguaje, String subtitulos, String doblaje) {
        this.lenguaje = lenguaje;
        this.subtitulos = subtitulos;
        this.doblaje = doblaje;
    }
    

    public Tblidioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Tblidioma(Integer idIdioma, String lenguaje, String subtitulos, String doblaje) {
        this.idIdioma = idIdioma;
        this.lenguaje = lenguaje;
        this.subtitulos = subtitulos;
        this.doblaje = doblaje;
    }

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }

    public String getDoblaje() {
        return doblaje;
    }

    public void setDoblaje(String doblaje) {
        this.doblaje = doblaje;
    }

    @XmlTransient
    public List<Tblvideoidioma> getTblvideoidiomaList() {
        return tblvideoidiomaList;
    }

    public void setTblvideoidiomaList(List<Tblvideoidioma> tblvideoidiomaList) {
        this.tblvideoidiomaList = tblvideoidiomaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdioma != null ? idIdioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblidioma)) {
            return false;
        }
        Tblidioma other = (Tblidioma) object;
        if ((this.idIdioma == null && other.idIdioma != null) || (this.idIdioma != null && !this.idIdioma.equals(other.idIdioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblidioma[ idIdioma=" + idIdioma + " ]";
    }
    
}
