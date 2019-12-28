/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projem2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "RANDEVU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Randevu.findAll", query = "SELECT r FROM Randevu r")
    , @NamedQuery(name = "Randevu.findByRandevuId", query = "SELECT r FROM Randevu r WHERE r.randevuId = :randevuId")
    , @NamedQuery(name = "Randevu.findByHastaId", query = "SELECT r FROM Randevu r WHERE r.hastaId = :hastaId")
    , @NamedQuery(name = "Randevu.findByPoliklinikId", query = "SELECT r FROM Randevu r WHERE r.poliklinikId = :poliklinikId")
    , @NamedQuery(name = "Randevu.findByDoktorId", query = "SELECT r FROM Randevu r WHERE r.doktorId = :doktorId")})
public class Randevu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RANDEVU_ID")
    private Integer randevuId;
    @Column(name = "HASTA_ID")
    private Integer hastaId;
    @Column(name = "POLIKLINIK_ID")
    private Integer poliklinikId;
    @Column(name = "DOKTOR_ID")
    private Integer doktorId;

    public Randevu() {
    }

    public Randevu(Integer randevuId) {
        this.randevuId = randevuId;
    }

    public Integer getRandevuId() {
        return randevuId;
    }

    public void setRandevuId(Integer randevuId) {
        this.randevuId = randevuId;
    }

    public Integer getHastaId() {
        return hastaId;
    }

    public void setHastaId(Integer hastaId) {
        this.hastaId = hastaId;
    }

    public Integer getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(Integer poliklinikId) {
        this.poliklinikId = poliklinikId;
    }

    public Integer getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(Integer doktorId) {
        this.doktorId = doktorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (randevuId != null ? randevuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Randevu)) {
            return false;
        }
        Randevu other = (Randevu) object;
        if ((this.randevuId == null && other.randevuId != null) || (this.randevuId != null && !this.randevuId.equals(other.randevuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projem2.Randevu[ randevuId=" + randevuId + " ]";
    }
    
}
