/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ep77
 */
@Entity
@Table(name = "tblvideopersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblvideopersona.findAll", query = "SELECT t FROM Tblvideopersona t"),
    @NamedQuery(name = "Tblvideopersona.findByIdVideo", query = "SELECT t FROM Tblvideopersona t WHERE t.idVideo = :idVideo")})
public class Tblvideopersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVideo")
    private Integer idVideo;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Tblpersona idPersona;
    @JoinColumn(name = "idVideo", referencedColumnName = "idVideo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tblvideo tblvideo;

    public Tblvideopersona() {
    }

    public Tblvideopersona(Integer idVideo, Tblpersona idPersona) {
        this.idVideo = idVideo;
        this.idPersona = idPersona;
    }
    

    public Tblvideopersona(Integer idVideo) {
        this.idVideo = idVideo;
    }

    public Integer getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Integer idVideo) {
        this.idVideo = idVideo;
    }

    public Tblpersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Tblpersona idPersona) {
        this.idPersona = idPersona;
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
        hash += (idVideo != null ? idVideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblvideopersona)) {
            return false;
        }
        Tblvideopersona other = (Tblvideopersona) object;
        if ((this.idVideo == null && other.idVideo != null) || (this.idVideo != null && !this.idVideo.equals(other.idVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblvideopersona[ idVideo=" + idVideo + " ]";
    }
    
}
