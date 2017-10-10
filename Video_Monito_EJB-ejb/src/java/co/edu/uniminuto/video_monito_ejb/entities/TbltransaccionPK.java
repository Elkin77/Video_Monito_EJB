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
public class TbltransaccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private int idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedioPago")
    private int idMedioPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVideo")
    private int idVideo;

    public TbltransaccionPK() {
    }

    public TbltransaccionPK(int idTransaccion, int idCliente, int idMedioPago, int idVideo) {
        this.idTransaccion = idTransaccion;
        this.idCliente = idCliente;
        this.idMedioPago = idMedioPago;
        this.idVideo = idVideo;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTransaccion;
        hash += (int) idCliente;
        hash += (int) idMedioPago;
        hash += (int) idVideo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbltransaccionPK)) {
            return false;
        }
        TbltransaccionPK other = (TbltransaccionPK) object;
        if (this.idTransaccion != other.idTransaccion) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idMedioPago != other.idMedioPago) {
            return false;
        }
        if (this.idVideo != other.idVideo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.TbltransaccionPK[ idTransaccion=" + idTransaccion + ", idCliente=" + idCliente + ", idMedioPago=" + idMedioPago + ", idVideo=" + idVideo + " ]";
    }
    
}
