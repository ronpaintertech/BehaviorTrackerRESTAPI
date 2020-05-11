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
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paint
 */
@Entity
@Table(name = "monthlyreport")
@XmlRootElement
@SqlResultSetMapping(
    name = "MonthlyReportNativeQuery",
    entities = {
        @EntityResult(
            fields = {
                @FieldResult( name = "behname", column="behname"),  
                @FieldResult( name = "sumbehcount", column="sumbehcount")
            },
            entityClass = Monthlyreport.class
        )
    }

)
public class Monthlyreport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Size(max = 50)
    @Column(name = "behname")
    @Id
    private String behname;
    
    @Column(name = "sumbehcount")
    private Long sumbehcount;

    public Monthlyreport() {
    }
    
    public Monthlyreport(String behname) {
        this.behname = behname;
    }
   
    public Monthlyreport(String behname, Long sumbehcount) {
        this.behname = behname;
        this.sumbehcount = sumbehcount;
    }

    public String getBehname() {
        return behname;
    }

    public void setBehname(String behname) {
        this.behname = behname;
    }

    public Long getSumbehcount() {
        return sumbehcount;
    }

    public void setSumbehcount(Long sumbehcount) {
        this.sumbehcount = sumbehcount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (behname != null ? behname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monthlyreport)) {
            return false;
        }
        Monthlyreport other = (Monthlyreport) object;
        if ((this.behname == null && other.behname != null) || (this.behname != null && !this.behname.equals(other.behname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tech.ronpainter.behaviortracker.Monthlyreport[ behname=" + behname + " ]";
    }
    
}
