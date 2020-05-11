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
public class PersonBehaviorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "personid")
    private int personid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "behaviorid")
    private int behaviorid;

    public PersonBehaviorPK() {
    }

    public PersonBehaviorPK(int personid, int behaviorid) {
        this.personid = personid;
        this.behaviorid = behaviorid;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public int getBehaviorid() {
        return behaviorid;
    }

    public void setBehaviorid(int behaviorid) {
        this.behaviorid = behaviorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personid;
        hash += (int) behaviorid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonBehaviorPK)) {
            return false;
        }
        PersonBehaviorPK other = (PersonBehaviorPK) object;
        if (this.personid != other.personid) {
            return false;
        }
        if (this.behaviorid != other.behaviorid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tech.ronpainter.behaviortracker.PersonBehaviorPK[ personid=" + personid + ", behaviorid=" + behaviorid + " ]";
    }
    
}
