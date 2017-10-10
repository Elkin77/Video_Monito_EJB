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
public class TblvideoidiomaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idVideoIdioma")
    private int idVideoIdioma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVideo")
    private int idVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIdioma")
    private int idIdioma;

    public TblvideoidiomaPK() {
    }

    public TblvideoidiomaPK(int idVideoIdioma, int idVideo, int idIdioma) {
        this.idVideoIdioma = idVideoIdioma;
        this.idVideo = idVideo;
        this.idIdioma = idIdioma;
    }

    public int getIdVideoIdioma() {
        return idVideoIdioma;
    }

    public void setIdVideoIdioma(int idVideoIdioma) {
        this.idVideoIdioma = idVideoIdioma;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVideoIdioma;
        hash += (int) idVideo;
        hash += (int) idIdioma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblvideoidiomaPK)) {
            return false;
        }
        TblvideoidiomaPK other = (TblvideoidiomaPK) object;
        if (this.idVideoIdioma != other.idVideoIdioma) {
            return false;
        }
        if (this.idVideo != other.idVideo) {
            return false;
        }
        if (this.idIdioma != other.idIdioma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.TblvideoidiomaPK[ idVideoIdioma=" + idVideoIdioma + ", idVideo=" + idVideo + ", idIdioma=" + idIdioma + " ]";
    }
    
}
