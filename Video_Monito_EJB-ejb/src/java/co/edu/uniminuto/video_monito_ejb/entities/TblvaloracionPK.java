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
public class TblvaloracionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idValoracion")
    private int idValoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVideo")
    private int idVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;

    public TblvaloracionPK() {
    }

    public TblvaloracionPK(int idValoracion, int idVideo, int idCliente) {
        this.idValoracion = idValoracion;
        this.idVideo = idVideo;
        this.idCliente = idCliente;
    }

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idValoracion;
        hash += (int) idVideo;
        hash += (int) idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblvaloracionPK)) {
            return false;
        }
        TblvaloracionPK other = (TblvaloracionPK) object;
        if (this.idValoracion != other.idValoracion) {
            return false;
        }
        if (this.idVideo != other.idVideo) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.TblvaloracionPK[ idValoracion=" + idValoracion + ", idVideo=" + idVideo + ", idCliente=" + idCliente + " ]";
    }
    
}
