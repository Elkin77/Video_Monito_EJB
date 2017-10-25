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
public class TblcoleccionvideoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idColeccionVideo")
    private int idColeccionVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVideo")
    private int idVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idColeccion")
    private int idColeccion;

    public TblcoleccionvideoPK() {
    }

    public TblcoleccionvideoPK(int idVideo, int idColeccion) {
        this.idVideo = idVideo;
        this.idColeccion = idColeccion;
    }
    

    public TblcoleccionvideoPK(int idColeccionVideo, int idVideo, int idColeccion) {
        this.idColeccionVideo = idColeccionVideo;
        this.idVideo = idVideo;
        this.idColeccion = idColeccion;
    }

    public int getIdColeccionVideo() {
        return idColeccionVideo;
    }

    public void setIdColeccionVideo(int idColeccionVideo) {
        this.idColeccionVideo = idColeccionVideo;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public int getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(int idColeccion) {
        this.idColeccion = idColeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idColeccionVideo;
        hash += (int) idVideo;
        hash += (int) idColeccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblcoleccionvideoPK)) {
            return false;
        }
        TblcoleccionvideoPK other = (TblcoleccionvideoPK) object;
        if (this.idColeccionVideo != other.idColeccionVideo) {
            return false;
        }
        if (this.idVideo != other.idVideo) {
            return false;
        }
        if (this.idColeccion != other.idColeccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.TblcoleccionvideoPK[ idColeccionVideo=" + idColeccionVideo + ", idVideo=" + idVideo + ", idColeccion=" + idColeccion + " ]";
    }
    
}
