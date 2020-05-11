/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.ronpainter.behaviortracker;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paint
 */
@Entity
@Table(name = "personlocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonLocation.findAll", query = "SELECT p FROM PersonLocation p"),
    @NamedQuery(name = "PersonLocation.findByPersonid", query = "SELECT p FROM PersonLocation p WHERE p.personLocationPK.personid = :personid"),
    @NamedQuery(name = "PersonLocation.findByLocationid", query = "SELECT p FROM PersonLocation p WHERE p.personLocationPK.locationid = :locationid")})
public class PersonLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonLocationPK personLocationPK;

    public PersonLocation() {
    }

    public PersonLocation(PersonLocationPK personLocationPK) {
        this.personLocationPK = personLocationPK;
    }

    public PersonLocation(int personid, int locationid) {
        this.personLocationPK = new PersonLocationPK(personid, locationid);
    }

    public PersonLocationPK getPersonLocationPK() {
        return personLocationPK;
    }

    public void setPersonLocationPK(PersonLocationPK personLocationPK) {
        this.personLocationPK = personLocationPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personLocationPK != null ? personLocationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonLocation)) {
            return false;
        }
        PersonLocation other = (PersonLocation) object;
        if ((this.personLocationPK == null && other.personLocationPK != null) || (this.personLocationPK != null && !this.personLocationPK.equals(other.personLocationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tech.ronpainter.behaviortracker.PersonLocation[ personLocationPK=" + personLocationPK + " ]";
    }
    
}
