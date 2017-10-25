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
@Table(name = "tblcoleccionvideo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcoleccionvideo.findAll", query = "SELECT t FROM Tblcoleccionvideo t"),
    @NamedQuery(name = "Tblcoleccionvideo.findByIdColeccionVideo", query = "SELECT t FROM Tblcoleccionvideo t WHERE t.tblcoleccionvideoPK.idColeccionVideo = :idColeccionVideo"),
    @NamedQuery(name = "Tblcoleccionvideo.findByIdVideo", query = "SELECT t FROM Tblcoleccionvideo t WHERE t.tblcoleccionvideoPK.idVideo = :idVideo"),
    @NamedQuery(name = "Tblcoleccionvideo.findByIdColeccion", query = "SELECT t FROM Tblcoleccionvideo t WHERE t.tblcoleccionvideoPK.idColeccion = :idColeccion")})
public class Tblcoleccionvideo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblcoleccionvideoPK tblcoleccionvideoPK;
    @JoinColumn(name = "idColeccion", referencedColumnName = "idColeccion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblcoleccion tblcoleccion;
    @JoinColumn(name = "idVideo", referencedColumnName = "idVideo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tblvideo tblvideo;

    public Tblcoleccionvideo() {
    }

    public Tblcoleccionvideo(Tblcoleccion tblcoleccion, Tblvideo tblvideo) {
        this.tblcoleccion = tblcoleccion;
        this.tblvideo = tblvideo;
    }

    
    

    public Tblcoleccionvideo(TblcoleccionvideoPK tblcoleccionvideoPK) {
        this.tblcoleccionvideoPK = tblcoleccionvideoPK;
    }

    public Tblcoleccionvideo(int idColeccionVideo, int idVideo, int idColeccion) {
        this.tblcoleccionvideoPK = new TblcoleccionvideoPK(idColeccionVideo, idVideo, idColeccion);
    }

    public TblcoleccionvideoPK getTblcoleccionvideoPK() {
        return tblcoleccionvideoPK;
    }

    public void setTblcoleccionvideoPK(TblcoleccionvideoPK tblcoleccionvideoPK) {
        this.tblcoleccionvideoPK = tblcoleccionvideoPK;
    }

    public Tblcoleccion getTblcoleccion() {
        return tblcoleccion;
    }

    public void setTblcoleccion(Tblcoleccion tblcoleccion) {
        this.tblcoleccion = tblcoleccion;
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
        hash += (tblcoleccionvideoPK != null ? tblcoleccionvideoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcoleccionvideo)) {
            return false;
        }
        Tblcoleccionvideo other = (Tblcoleccionvideo) object;
        if ((this.tblcoleccionvideoPK == null && other.tblcoleccionvideoPK != null) || (this.tblcoleccionvideoPK != null && !this.tblcoleccionvideoPK.equals(other.tblcoleccionvideoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblcoleccionvideo[ tblcoleccionvideoPK=" + tblcoleccionvideoPK + " ]";
    }
    
}
