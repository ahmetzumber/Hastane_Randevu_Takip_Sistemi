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
@Table(name = "POLIKLINIK_DETAY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoliklinikDetay.findAll", query = "SELECT p FROM PoliklinikDetay p")
    , @NamedQuery(name = "PoliklinikDetay.findById", query = "SELECT p FROM PoliklinikDetay p WHERE p.id = :id")
    , @NamedQuery(name = "PoliklinikDetay.findByPoliklinikId", query = "SELECT p FROM PoliklinikDetay p WHERE p.poliklinikId = :poliklinikId")
    , @NamedQuery(name = "PoliklinikDetay.findByDoktorAdi", query = "SELECT p FROM PoliklinikDetay p WHERE p.doktorAdi = :doktorAdi")})
public class PoliklinikDetay implements Serializable {

    @Column(name = "DOKTOR_ID")
    private Integer doktorId;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "POLIKLINIK_ID")
    private Integer poliklinikId;
    @Column(name = "DOKTOR_ADI")
    private String doktorAdi;

    public PoliklinikDetay() {
    }

    public PoliklinikDetay(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(Integer poliklinikId) {
        this.poliklinikId = poliklinikId;
    }

    public String getDoktorAdi() {
        return doktorAdi;
    }

    public void setDoktorAdi(String doktorAdi) {
        this.doktorAdi = doktorAdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoliklinikDetay)) {
            return false;
        }
        PoliklinikDetay other = (PoliklinikDetay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return doktorAdi;
    }

    public Integer getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(Integer doktorId) {
        this.doktorId = doktorId;
    }
    
}
