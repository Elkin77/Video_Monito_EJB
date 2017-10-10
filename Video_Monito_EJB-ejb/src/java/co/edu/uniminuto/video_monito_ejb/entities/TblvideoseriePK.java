/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ep77
 */
@Embeddable
public class TblvideoseriePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idVideoSerie")
    private int idVideoSerie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVideo")
    private int idVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSerie")
    private int idSerie;

    public TblvideoseriePK() {
    }

    public TblvideoseriePK(int idVideoSerie, int idVideo, int idSerie) {
        this.idVideoSerie = idVideoSerie;
        this.idVideo = idVideo;
        this.idSerie = idSerie;
    }

    public int getIdVideoSerie() {
        return idVideoSerie;
    }

    public void setIdVideoSerie(int idVideoSerie) {
        this.idVideoSerie = idVideoSerie;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVideoSerie;
        hash += (int) idVideo;
        hash += (int) idSerie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblvideoseriePK)) {
            return false;
        }
        TblvideoseriePK other = (TblvideoseriePK) object;
        if (this.idVideoSerie != other.idVideoSerie) {
            return false;
        }
        if (this.idVideo != other.idVideo) {
            return false;
        }
        if (this.idSerie != other.idSerie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.TblvideoseriePK[ idVideoSerie=" + idVideoSerie + ", idVideo=" + idVideo + ", idSerie=" + idSerie + " ]";
    }
    
}
