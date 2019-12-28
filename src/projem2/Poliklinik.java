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
@Table(name = "POLIKLINIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poliklinik.findAll", query = "SELECT p FROM Poliklinik p")
    , @NamedQuery(name = "Poliklinik.findByPoliklinikId", query = "SELECT p FROM Poliklinik p WHERE p.poliklinikId = :poliklinikId")
    , @NamedQuery(name = "Poliklinik.findByPoliklinikAdi", query = "SELECT p FROM Poliklinik p WHERE p.poliklinikAdi = :poliklinikAdi")})
public class Poliklinik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "POLIKLINIK_ID")
    private Integer poliklinikId;
    @Column(name = "POLIKLINIK_ADI")
    private String poliklinikAdi;

    public Poliklinik() {
    }

    public Poliklinik(Integer poliklinikId) {
        this.poliklinikId = poliklinikId;
    }

    public Integer getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(Integer poliklinikId) {
        this.poliklinikId = poliklinikId;
    }

    public String getPoliklinikAdi() {
        return poliklinikAdi;
    }

    public void setPoliklinikAdi(String poliklinikAdi) {
        this.poliklinikAdi = poliklinikAdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poliklinikId != null ? poliklinikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poliklinik)) {
            return false;
        }
        Poliklinik other = (Poliklinik) object;
        if ((this.poliklinikId == null && other.poliklinikId != null) || (this.poliklinikId != null && !this.poliklinikId.equals(other.poliklinikId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return poliklinikAdi;
    }
    
}
