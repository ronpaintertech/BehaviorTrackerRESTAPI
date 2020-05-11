/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.ronpainter.behaviortracker;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paint
 */
@Embeddable
public class PersonLocationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "personid")
    private int personid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "locationid")
    private int locationid;

    public PersonLocationPK() {
    }

    public PersonLocationPK(int personid, int locationid) {
        this.personid = personid;
        this.locationid = locationid;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personid;
        hash += (int) locationid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonLocationPK)) {
            return false;
        }
        PersonLocationPK other = (PersonLocationPK) object;
        if (this.personid != other.personid) {
            return false;
        }
        if (this.locationid != other.locationid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tech.ronpainter.behaviortracker.PersonLocationPK[ personid=" + personid + ", locationid=" + locationid + " ]";
    }
    
}
