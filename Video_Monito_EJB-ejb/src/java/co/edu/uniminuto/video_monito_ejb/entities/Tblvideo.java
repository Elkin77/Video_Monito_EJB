/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ep77
 */
@Entity
@Table(name = "tblvideo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblvideo.findAll", query = "SELECT t FROM Tblvideo t"),
    @NamedQuery(name = "Tblvideo.findByIdVideo", query = "SELECT t FROM Tblvideo t WHERE t.idVideo = :idVideo"),
    @NamedQuery(name = "Tblvideo.findByYearProduccion", query = "SELECT t FROM Tblvideo t WHERE t.yearProduccion = :yearProduccion"),
    @NamedQuery(name = "Tblvideo.findByDuracion", query = "SELECT t FROM Tblvideo t WHERE t.duracion = :duracion"),
    @NamedQuery(name = "Tblvideo.findByTituloVideo", query = "SELECT t FROM Tblvideo t WHERE t.tituloVideo = :tituloVideo"),
    @NamedQuery(name = "Tblvideo.findByDescripcion", query = "SELECT t FROM Tblvideo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tblvideo.findByImagen", query = "SELECT t FROM Tblvideo t WHERE t.imagen = :imagen")})
public class Tblvideo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVideo")
    private Integer idVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yearProduccion")
    private short yearProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "TituloVideo")
    private String tituloVideo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "Imagen")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblvideo")
    private Collection<Tbltransaccion> tbltransaccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblvideo")
    private Collection<Tblvaloracion> tblvaloracionCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblvideo")
    private Tblvideopersona tblvideopersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblvideo")
    private Collection<Tblcoleccionvideo> tblcoleccionvideoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblvideo")
    private Collection<Tblvideoidioma> tblvideoidiomaCollection;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Tblcategoria idCategoria;
    @JoinColumn(name = "idClasificacion", referencedColumnName = "idClasificacion")
    @ManyToOne(optional = false)
    private Tblclasificacion idClasificacion;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    @ManyToOne(optional = false)
    private Tblproveedor idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblvideo")
    private Collection<Tblvideoserie> tblvideoserieCollection;

    public Tblvideo() {
    }

    public Tblvideo(Integer idVideo) {
        this.idVideo = idVideo;
    }

    public Tblvideo(Integer idVideo, short yearProduccion, Date duracion, String tituloVideo, String descripcion, String imagen) {
        this.idVideo = idVideo;
        this.yearProduccion = yearProduccion;
        this.duracion = duracion;
        this.tituloVideo = tituloVideo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Integer getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Integer idVideo) {
        this.idVideo = idVideo;
    }

    public short getYearProduccion() {
        return yearProduccion;
    }

    public void setYearProduccion(short yearProduccion) {
        this.yearProduccion = yearProduccion;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public String getTituloVideo() {
        return tituloVideo;
    }

    public void setTituloVideo(String tituloVideo) {
        this.tituloVideo = tituloVideo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<Tbltransaccion> getTbltransaccionCollection() {
        return tbltransaccionCollection;
    }

    public void setTbltransaccionCollection(Collection<Tbltransaccion> tbltransaccionCollection) {
        this.tbltransaccionCollection = tbltransaccionCollection;
    }

    @XmlTransient
    public Collection<Tblvaloracion> getTblvaloracionCollection() {
        return tblvaloracionCollection;
    }

    public void setTblvaloracionCollection(Collection<Tblvaloracion> tblvaloracionCollection) {
        this.tblvaloracionCollection = tblvaloracionCollection;
    }

    public Tblvideopersona getTblvideopersona() {
        return tblvideopersona;
    }

    public void setTblvideopersona(Tblvideopersona tblvideopersona) {
        this.tblvideopersona = tblvideopersona;
    }

    @XmlTransient
    public Collection<Tblcoleccionvideo> getTblcoleccionvideoCollection() {
        return tblcoleccionvideoCollection;
    }

    public void setTblcoleccionvideoCollection(Collection<Tblcoleccionvideo> tblcoleccionvideoCollection) {
        this.tblcoleccionvideoCollection = tblcoleccionvideoCollection;
    }

    @XmlTransient
    public Collection<Tblvideoidioma> getTblvideoidiomaCollection() {
        return tblvideoidiomaCollection;
    }

    public void setTblvideoidiomaCollection(Collection<Tblvideoidioma> tblvideoidiomaCollection) {
        this.tblvideoidiomaCollection = tblvideoidiomaCollection;
    }

    public Tblcategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Tblcategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Tblclasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Tblclasificacion idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Tblproveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Tblproveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @XmlTransient
    public Collection<Tblvideoserie> getTblvideoserieCollection() {
        return tblvideoserieCollection;
    }

    public void setTblvideoserieCollection(Collection<Tblvideoserie> tblvideoserieCollection) {
        this.tblvideoserieCollection = tblvideoserieCollection;
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
        if (!(object instanceof Tblvideo)) {
            return false;
        }
        Tblvideo other = (Tblvideo) object;
        if ((this.idVideo == null && other.idVideo != null) || (this.idVideo != null && !this.idVideo.equals(other.idVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.video_monito_ejb.entities.Tblvideo[ idVideo=" + idVideo + " ]";
    }
    
}
