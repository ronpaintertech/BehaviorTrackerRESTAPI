/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.ronpainter.behaviortracker.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EntityManager;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.PersistenceContext;
import javax.persistence.SqlResultSetMapping;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.ronpainter.behaviortracker.Monthlyreport;

/**
 *
 * @author paint
 */
@Stateless
@Path("tech.ronpainter.behaviortracker.monthlyreport")

public class MonthlyreportFacadeREST extends AbstractFacade<Monthlyreport> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public MonthlyreportFacadeREST() {
        super(Monthlyreport.class);
    }
    
    @GET
    @Path("/personid/{personid}/startdate/{startdate}/enddate/{enddate}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Monthlyreport> getMonthlyReport(@PathParam("personid") Integer personid,
                                                @PathParam("startdate") String startdate,
                                                @PathParam("enddate") String enddate)  throws ParseException {
        javax.persistence.Query spquery = getEntityManager().createNativeQuery("SELECT behname, sumbehcount FROM monthlyreport("+personid+",'"+startdate+"','"+enddate+"')", "MonthlyReportNativeQuery");
        return spquery.getResultList();    
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
