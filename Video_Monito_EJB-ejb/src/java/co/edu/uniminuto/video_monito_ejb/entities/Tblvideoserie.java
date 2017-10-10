/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ep77
 */
@Entity
@Table(name = "tblvideoserie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblvideoserie.findAll", query = "SELECT t FROM Tblvideoserie t"),
    @NamedQuery(name = "Tblvideoserie.findByIdVideoSerie", query = "SELECT t FROM Tblvideoserie t WHERE t.tblvideoseriePK.idVideoSerie = :idVideoSerie"),
    @NamedQuery(name = "Tblvideoserie.findByIdVideo", query = "SELECT t FROM Tblvideoserie t WHERE t.tblvideoseriePK.idVideo = :idVideo"),
    @NamedQuery(name = "Tblvideoserie.findByIdSerie", query = "SELECT t FROM Tblvideoserie t WHERE t.tblvideoseriePK.idSerie = :idSerie")})
public class Tblvideoserie implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblvideoseriePK tblvideoseriePK;
    @JoinColumn(name = "idSerie", referencedColumnName = "idSerie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblserie tblserie;
    @JoinColumn(name = "idVideo", referencedColumnName = "idVideo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblvideo tblvideo;

    public Tblvideoserie() {
    }

    public Tblvideoserie(TblvideoseriePK tblvideoseriePK) {
        this.tblvideoseriePK = tblvideoseriePK;
    }

    public Tblvideoserie(int idVideoSerie, int idVideo, int idSerie) {
        this.tblvideoseriePK = new TblvideoseriePK(idVideoSerie, idVideo, idSerie);
    }

    public TblvideoseriePK getTblvideoseriePK() {
        return tblvideoseriePK;
    }

    public void setTblvideoseriePK(TblvideoseriePK tblvideoseriePK) {
        this.tblvideoseriePK = tblvideoseriePK;
    }

    public Tblserie getTblserie() {
        return tblserie;
    }

    public void setTblserie(Tblserie tblserie) {
        this.tblserie = tblserie;
    }

    public Tblvideo getTblvideo() {
        return tblvideo;
    }

    public void setTblvideo(Tblvideo tblvideo) {
        this.tblvideo = tblvideo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblvideoseriePK != null ? tblvideoseriePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblvideoserie)) {
            return false;
        }
        Tblvideoserie other = (Tblvideoserie) object;
        if ((this.tblvideoseriePK == null && other.tblvideoseriePK != null) || (this.tblvideoseriePK != null && !this.tblvideoseriePK.equals(other.tblvideoseriePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblvideoserie[ tblvideoseriePK=" + tblvideoseriePK + " ]";
    }
    
}
