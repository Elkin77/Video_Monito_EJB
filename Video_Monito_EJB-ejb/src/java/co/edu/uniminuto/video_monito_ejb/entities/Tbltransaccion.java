/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ep77
 */
@Entity
@Table(name = "tbltransaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbltransaccion.findAll", query = "SELECT t FROM Tbltransaccion t"),
    @NamedQuery(name = "Tbltransaccion.findByIdTransaccion", query = "SELECT t FROM Tbltransaccion t WHERE t.tbltransaccionPK.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "Tbltransaccion.findByFechaTransaccion", query = "SELECT t FROM Tbltransaccion t WHERE t.fechaTransaccion = :fechaTransaccion"),
    @NamedQuery(name = "Tbltransaccion.findByTipoTransaccion", query = "SELECT t FROM Tbltransaccion t WHERE t.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "Tbltransaccion.findByIdCliente", query = "SELECT t FROM Tbltransaccion t WHERE t.tbltransaccionPK.idCliente = :idCliente"),
    @NamedQuery(name = "Tbltransaccion.findByIdMedioPago", query = "SELECT t FROM Tbltransaccion t WHERE t.tbltransaccionPK.idMedioPago = :idMedioPago"),
    @NamedQuery(name = "Tbltransaccion.findByIdVideo", query = "SELECT t FROM Tbltransaccion t WHERE t.tbltransaccionPK.idVideo = :idVideo")})
public class Tbltransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbltransaccionPK tbltransaccionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaTransaccion")
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_Transaccion")
    private String tipoTransaccion;
    @JoinColumn(name = "idVideo", referencedColumnName = "idVideo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblvideo tblvideo;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblcliente tblcliente;
    @JoinColumn(name = "idMedioPago", referencedColumnName = "idMedioPago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblmediopago tblmediopago;

    public Tbltransaccion() {
    }

    public Tbltransaccion(TbltransaccionPK tbltransaccionPK) {
        this.tbltransaccionPK = tbltransaccionPK;
    }

    public Tbltransaccion(TbltransaccionPK tbltransaccionPK, Date fechaTransaccion, String tipoTransaccion) {
        this.tbltransaccionPK = tbltransaccionPK;
        this.fechaTransaccion = fechaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Tbltransaccion(int idTransaccion, int idCliente, int idMedioPago, int idVideo) {
        this.tbltransaccionPK = new TbltransaccionPK(idTransaccion, idCliente, idMedioPago, idVideo);
    }

    public TbltransaccionPK getTbltransaccionPK() {
        return tbltransaccionPK;
    }

    public void setTbltransaccionPK(TbltransaccionPK tbltransaccionPK) {
        this.tbltransaccionPK = tbltransaccionPK;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Tblvideo getTblvideo() {
        return tblvideo;
    }

    public void setTblvideo(Tblvideo tblvideo) {
        this.tblvideo = tblvideo;
    }

    public Tblcliente getTblcliente() {
        return tblcliente;
    }

    public void setTblcliente(Tblcliente tblcliente) {
        this.tblcliente = tblcliente;
    }

    public Tblmediopago getTblmediopago() {
        return tblmediopago;
    }

    public void setTblmediopago(Tblmediopago tblmediopago) {
        this.tblmediopago = tblmediopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbltransaccionPK != null ? tbltransaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbltransaccion)) {
            return false;
        }
        Tbltransaccion other = (Tbltransaccion) object;
        if ((this.tbltransaccionPK == null && other.tbltransaccionPK != null) || (this.tbltransaccionPK != null && !this.tbltransaccionPK.equals(other.tbltransaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tbltransaccion[ tbltransaccionPK=" + tbltransaccionPK + " ]";
    }
    
}
