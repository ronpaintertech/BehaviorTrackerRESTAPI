/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.ronpainter.behaviortracker.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.ronpainter.behaviortracker.Trackbehavior;

/**
 *
 * @author paint
 */
@Stateless
@Path("tech.ronpainter.behaviortracker.trackbehavior")
public class TrackbehaviorFacadeREST extends AbstractFacade<Trackbehavior> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public TrackbehaviorFacadeREST() {
        super(Trackbehavior.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Trackbehavior entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Trackbehavior entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Trackbehavior find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Trackbehavior> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Trackbehavior> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("/trackdate/{trackdate}/person/{personid}/location/{locationid}/behavior/{behaviorid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trackbehavior> findByKeys(@PathParam("trackdate") String trackdate, @PathParam("personid") Integer personid, @PathParam("locationid") Integer locationid, @PathParam("behaviorid") Integer behaviorid) throws ParseException {
        javax.persistence.Query query = getEntityManager().createNamedQuery("Trackbehavior.findByKeys");
        query.setParameter("trackdate", new SimpleDateFormat("yyyyMMdd").parse(trackdate));
        query.setParameter("personid", personid);
        query.setParameter("locationid", locationid);
        query.setParameter("behaviorid", behaviorid);
        return query.getResultList();    
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
