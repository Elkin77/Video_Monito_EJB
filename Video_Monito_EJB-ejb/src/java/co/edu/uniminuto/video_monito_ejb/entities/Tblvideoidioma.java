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
@Table(name = "tblvideoidioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblvideoidioma.findAll", query = "SELECT t FROM Tblvideoidioma t"),
    @NamedQuery(name = "Tblvideoidioma.findByIdVideoIdioma", query = "SELECT t FROM Tblvideoidioma t WHERE t.tblvideoidiomaPK.idVideoIdioma = :idVideoIdioma"),
    @NamedQuery(name = "Tblvideoidioma.findByIdVideo", query = "SELECT t FROM Tblvideoidioma t WHERE t.tblvideoidiomaPK.idVideo = :idVideo"),
    @NamedQuery(name = "Tblvideoidioma.findByIdIdioma", query = "SELECT t FROM Tblvideoidioma t WHERE t.tblvideoidiomaPK.idIdioma = :idIdioma")})
public class Tblvideoidioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblvideoidiomaPK tblvideoidiomaPK;
    @JoinColumn(name = "idIdioma", referencedColumnName = "idIdioma", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblidioma tblidioma;
    @JoinColumn(name = "idVideo", referencedColumnName = "idVideo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblvideo tblvideo;

    public Tblvideoidioma() {
    }

    public Tblvideoidioma(Tblidioma tblidioma, Tblvideo tblvideo) {
        this.tblidioma = tblidioma;
        this.tblvideo = tblvideo;
    }

    
    public Tblvideoidioma(TblvideoidiomaPK tblvideoidiomaPK) {
        this.tblvideoidiomaPK = tblvideoidiomaPK;
    }

    public Tblvideoidioma(int idVideoIdioma, int idVideo, int idIdioma) {
        this.tblvideoidiomaPK = new TblvideoidiomaPK(idVideoIdioma, idVideo, idIdioma);
    }

    public TblvideoidiomaPK getTblvideoidiomaPK() {
        return tblvideoidiomaPK;
    }

    public void setTblvideoidiomaPK(TblvideoidiomaPK tblvideoidiomaPK) {
        this.tblvideoidiomaPK = tblvideoidiomaPK;
    }

    public Tblidioma getTblidioma() {
        return tblidioma;
    }

    public void setTblidioma(Tblidioma tblidioma) {
        this.tblidioma = tblidioma;
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
        hash += (tblvideoidiomaPK != null ? tblvideoidiomaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblvideoidioma)) {
            return false;
        }
        Tblvideoidioma other = (Tblvideoidioma) object;
        if ((this.tblvideoidiomaPK == null && other.tblvideoidiomaPK != null) || (this.tblvideoidiomaPK != null && !this.tblvideoidiomaPK.equals(other.tblvideoidiomaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblvideoidioma[ tblvideoidiomaPK=" + tblvideoidiomaPK + " ]";
    }
    
}
