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
@Table(name = "vwpersonlocations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vwpersonlocations.findAll", query = "SELECT v FROM Vwpersonlocations v"),
    @NamedQuery(name = "Vwpersonlocations.findByPlid", query = "SELECT v FROM Vwpersonlocations v WHERE v.plid = :plid"),
    @NamedQuery(name = "Vwpersonlocations.findByPersonid", query = "SELECT v FROM Vwpersonlocations v WHERE v.personid = :personid"),
    @NamedQuery(name = "Vwpersonlocations.findByLocationid", query = "SELECT v FROM Vwpersonlocations v WHERE v.locationid = :locationid"),
    @NamedQuery(name = "Vwpersonlocations.findByName", query = "SELECT v FROM Vwpersonlocations v WHERE v.name = :name")})
public class Vwpersonlocations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "plid")
    @Id
    private Integer plid;
    @Column(name = "personid")
    private Integer personid;
    @Column(name = "locationid")
    private Integer locationid;
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    public Vwpersonlocations() {
    }

    public Integer getPlid() {
        return plid;
    }

    public void setPlid(Integer plid) {
        this.plid = plid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
