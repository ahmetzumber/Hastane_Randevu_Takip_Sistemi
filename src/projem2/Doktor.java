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
@Table(name = "DOKTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doktor.findAll", query = "SELECT d FROM Doktor d")
    , @NamedQuery(name = "Doktor.findByDoktorId", query = "SELECT d FROM Doktor d WHERE d.doktorId = :doktorId")
    , @NamedQuery(name = "Doktor.findByDoktorAdi", query = "SELECT d FROM Doktor d WHERE d.doktorAdi = :doktorAdi")})
public class Doktor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DOKTOR_ID")
    private Integer doktorId;
    @Column(name = "DOKTOR_ADI")
    private String doktorAdi;

    public Doktor() {
    }

    public Doktor(Integer doktorId) {
        this.doktorId = doktorId;
    }

    public Integer getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(Integer doktorId) {
        this.doktorId = doktorId;
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
        hash += (doktorId != null ? doktorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doktor)) {
            return false;
        }
        Doktor other = (Doktor) object;
        if ((this.doktorId == null && other.doktorId != null) || (this.doktorId != null && !this.doktorId.equals(other.doktorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projem2.Doktor[ doktorId=" + doktorId + " ]";
    }
    
}
