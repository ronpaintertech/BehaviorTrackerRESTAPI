/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.ronpainter.behaviortracker;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paint
 */
@Entity
@Table(name = "trackbehavior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trackbehavior.findAll", query = "SELECT t FROM Trackbehavior t"),
    @NamedQuery(name = "Trackbehavior.findById", query = "SELECT t FROM Trackbehavior t WHERE t.id = :id"),
    @NamedQuery(name = "Trackbehavior.findByTrackdate", query = "SELECT t FROM Trackbehavior t WHERE t.trackdate = :trackdate"),
    @NamedQuery(name = "Trackbehavior.findByPersonid", query = "SELECT t FROM Trackbehavior t WHERE t.personid = :personid"),
    @NamedQuery(name = "Trackbehavior.findByLocationid", query = "SELECT t FROM Trackbehavior t WHERE t.locationid = :locationid"),
    @NamedQuery(name = "Trackbehavior.findByBehaviorid", query = "SELECT t FROM Trackbehavior t WHERE t.behaviorid = :behaviorid"),
    @NamedQuery(name = "Trackbehavior.findByBehcount", query = "SELECT t FROM Trackbehavior t WHERE t.behcount = :behcount"),
    @NamedQuery(name = "Trackbehavior.findByKeys", query = "SELECT t FROM Trackbehavior t WHERE t.trackdate = :trackdate AND t.personid = :personid AND t.locationid = :locationid AND t.behaviorid = :behaviorid")})

public class Trackbehavior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "trackdate")
    @Temporal(TemporalType.DATE)
    private Date trackdate;
    @Column(name = "personid")
    private Integer personid;
    @Column(name = "locationid")
    private Integer locationid;
    @Column(name = "behaviorid")
    private Integer behaviorid;
    @Column(name = "behcount")
    private Integer behcount;

    public Trackbehavior() {
    }

    public Trackbehavior(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTrackdate() {
        return trackdate;
    }

    public void setTrackdate(Date trackdate) {
        this.trackdate = trackdate;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public Integer getBehaviorid() {
        return behaviorid;
    }

    public void setBehaviorid(Integer behaviorid) {
        this.behaviorid = behaviorid;
    }

    public Integer getBehcount() {
        return behcount;
    }

    public void setBehcount(Integer behcount) {
        this.behcount = behcount;
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
        if (!(object instanceof Trackbehavior)) {
            return false;
        }
        Trackbehavior other = (Trackbehavior) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tech.ronpainter.behaviortracker.Trackbehavior[ id=" + id + " ]";
    }
    
}
