/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.ronpainter.behaviortracker;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paint
 */
@Entity
@Table(name = "vwpersonbehaviors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vwpersonbehaviors.findAll", query = "SELECT v FROM Vwpersonbehaviors v"),
    @NamedQuery(name = "Vwpersonbehaviors.findByPbid", query = "SELECT v FROM Vwpersonbehaviors v WHERE v.pbid = :pbid"),
    @NamedQuery(name = "Vwpersonbehaviors.findByPersonid", query = "SELECT v FROM Vwpersonbehaviors v WHERE v.personid = :personid"),
    @NamedQuery(name = "Vwpersonbehaviors.findByBehaviorid", query = "SELECT v FROM Vwpersonbehaviors v WHERE v.behaviorid = :behaviorid"),
    @NamedQuery(name = "Vwpersonbehaviors.findByName", query = "SELECT v FROM Vwpersonbehaviors v WHERE v.name = :name")})
public class Vwpersonbehaviors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "pbid")
    @Id
    private Integer pbid;
    @Column(name = "personid")
    private Integer personid;
    @Column(name = "behaviorid")
    private Integer behaviorid;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;

    public Vwpersonbehaviors() {
    }

    public Integer getPbid() {
        return pbid;
    }

    public void setPbid(Integer pbid) {
        this.pbid = pbid;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public Integer getBehaviorid() {
        return behaviorid;
    }

    public void setBehaviorid(Integer behaviorid) {
        this.behaviorid = behaviorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
