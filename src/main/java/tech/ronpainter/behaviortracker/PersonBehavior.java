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
@Table(name = "personbehavior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonBehavior.findAll", query = "SELECT p FROM PersonBehavior p"),
    @NamedQuery(name = "PersonBehavior.findByPersonid", query = "SELECT p FROM PersonBehavior p WHERE p.personBehaviorPK.personid = :personid"),
    @NamedQuery(name = "PersonBehavior.findByBehaviorid", query = "SELECT p FROM PersonBehavior p WHERE p.personBehaviorPK.behaviorid = :behaviorid")})
public class PersonBehavior implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonBehaviorPK personBehaviorPK;

    public PersonBehavior() {
    }

    public PersonBehavior(PersonBehaviorPK personBehaviorPK) {
        this.personBehaviorPK = personBehaviorPK;
    }

    public PersonBehavior(int personid, int behaviorid) {
        this.personBehaviorPK = new PersonBehaviorPK(personid, behaviorid);
    }

    public PersonBehaviorPK getPersonBehaviorPK() {
        return personBehaviorPK;
    }

    public void setPersonBehaviorPK(PersonBehaviorPK personBehaviorPK) {
        this.personBehaviorPK = personBehaviorPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personBehaviorPK != null ? personBehaviorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonBehavior)) {
            return false;
        }
        PersonBehavior other = (PersonBehavior) object;
        if ((this.personBehaviorPK == null && other.personBehaviorPK != null) || (this.personBehaviorPK != null && !this.personBehaviorPK.equals(other.personBehaviorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tech.ronpainter.behaviortracker.PersonBehavior[ personBehaviorPK=" + personBehaviorPK + " ]";
    }
    
}
