/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ep77
 */
@Entity
@Table(name = "tblvaloracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblvaloracion.findAll", query = "SELECT t FROM Tblvaloracion t"),
    @NamedQuery(name = "Tblvaloracion.findByIdValoracion", query = "SELECT t FROM Tblvaloracion t WHERE t.tblvaloracionPK.idValoracion = :idValoracion"),
    @NamedQuery(name = "Tblvaloracion.findByIdVideo", query = "SELECT t FROM Tblvaloracion t WHERE t.tblvaloracionPK.idVideo = :idVideo"),
    @NamedQuery(name = "Tblvaloracion.findByIdCliente", query = "SELECT t FROM Tblvaloracion t WHERE t.tblvaloracionPK.idCliente = :idCliente"),
    @NamedQuery(name = "Tblvaloracion.findByValoracion", query = "SELECT t FROM Tblvaloracion t WHERE t.valoracion = :valoracion"),
    @NamedQuery(name = "Tblvaloracion.findByComentario", query = "SELECT t FROM Tblvaloracion t WHERE t.comentario = :comentario")})
public class Tblvaloracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblvaloracionPK tblvaloracionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Valoracion")
    private String valoracion;
    @Size(max = 512)
    @Column(name = "Comentario")
    private String comentario;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblcliente tblcliente;
    @JoinColumn(name = "idVideo", referencedColumnName = "idVideo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblvideo tblvideo;

    public Tblvaloracion() {
    }

    public Tblvaloracion(TblvaloracionPK tblvaloracionPK) {
        this.tblvaloracionPK = tblvaloracionPK;
    }

    public Tblvaloracion(TblvaloracionPK tblvaloracionPK, String valoracion) {
        this.tblvaloracionPK = tblvaloracionPK;
        this.valoracion = valoracion;
    }

    public Tblvaloracion(int idValoracion, int idVideo, int idCliente) {
        this.tblvaloracionPK = new TblvaloracionPK(idValoracion, idVideo, idCliente);
    }

    public TblvaloracionPK getTblvaloracionPK() {
        return tblvaloracionPK;
    }

    public void setTblvaloracionPK(TblvaloracionPK tblvaloracionPK) {
        this.tblvaloracionPK = tblvaloracionPK;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Tblcliente getTblcliente() {
        return tblcliente;
    }

    public void setTblcliente(Tblcliente tblcliente) {
        this.tblcliente = tblcliente;
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
        hash += (tblvaloracionPK != null ? tblvaloracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblvaloracion)) {
            return false;
        }
        Tblvaloracion other = (Tblvaloracion) object;
        if ((this.tblvaloracionPK == null && other.tblvaloracionPK != null) || (this.tblvaloracionPK != null && !this.tblvaloracionPK.equals(other.tblvaloracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblvaloracion[ tblvaloracionPK=" + tblvaloracionPK + " ]";
    }
    
}
