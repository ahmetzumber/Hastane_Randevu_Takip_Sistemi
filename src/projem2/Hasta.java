/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projem2;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "HASTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hasta.findAll", query = "SELECT h FROM Hasta h")
    , @NamedQuery(name = "Hasta.findByHastaId", query = "SELECT h FROM Hasta h WHERE h.hastaId = :hastaId")
    , @NamedQuery(name = "Hasta.findByAdi", query = "SELECT h FROM Hasta h WHERE h.adi = :adi")
    , @NamedQuery(name = "Hasta.findBySoyadi", query = "SELECT h FROM Hasta h WHERE h.soyadi = :soyadi")
    , @NamedQuery(name = "Hasta.findByCinsiyet", query = "SELECT h FROM Hasta h WHERE h.cinsiyet = :cinsiyet")
    , @NamedQuery(name = "Hasta.findByTcKimlikno", query = "SELECT h FROM Hasta h WHERE h.tcKimlikno = :tcKimlikno")
    , @NamedQuery(name = "Hasta.findByPoliklinikId", query = "SELECT h FROM Hasta h WHERE h.poliklinikId = :poliklinikId")
    , @NamedQuery(name = "Hasta.findByDoktorId", query = "SELECT h FROM Hasta h WHERE h.doktorId = :doktorId")
    , @NamedQuery(name = "Hasta.findByTarih", query = "SELECT h FROM Hasta h WHERE h.tarih = :tarih")
    , @NamedQuery(name = "Hasta.findBySaat", query = "SELECT h FROM Hasta h WHERE h.saat = :saat")})
public class Hasta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HASTA_ID")
    private Integer hastaId;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name = "CINSIYET")
    private String cinsiyet;
    @Column(name = "TC_KIMLIKNO")
    private BigInteger tcKimlikno;
    @Column(name = "POLIKLINIK_ID")
    private Integer poliklinikId;
    @Column(name = "DOKTOR_ID")
    private Integer doktorId;
    @Column(name = "TARIH")
    private String tarih;
    @Column(name = "SAAT")
    private String saat;

    public Hasta() {
    }

    public Hasta(Integer hastaId) {
        this.hastaId = hastaId;
    }

    public Integer getHastaId() {
        return hastaId;
    }

    public void setHastaId(Integer hastaId) {
        this.hastaId = hastaId;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public BigInteger getTcKimlikno() {
        return tcKimlikno;
    }

    public void setTcKimlikno(BigInteger tcKimlikno) {
        this.tcKimlikno = tcKimlikno;
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

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hastaId != null ? hastaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hasta)) {
            return false;
        }
        Hasta other = (Hasta) object;
        if ((this.hastaId == null && other.hastaId != null) || (this.hastaId != null && !this.hastaId.equals(other.hastaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return adi+" "+soyadi;
    }
    
}
