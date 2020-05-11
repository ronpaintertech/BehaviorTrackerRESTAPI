/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.ronpainter.behaviortracker.service;

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
import javax.ws.rs.core.PathSegment;
import tech.ronpainter.behaviortracker.PersonBehavior;
import tech.ronpainter.behaviortracker.PersonBehaviorPK;

/**
 *
 * @author paint
 */
@Stateless
@Path("tech.ronpainter.behaviortracker.personbehavior")
public class PersonBehaviorFacadeREST extends AbstractFacade<PersonBehavior> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private PersonBehaviorPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;personid=personidValue;behaviorid=behavioridValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        tech.ronpainter.behaviortracker.PersonBehaviorPK key = new tech.ronpainter.behaviortracker.PersonBehaviorPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> personid = map.get("personid");
        if (personid != null && !personid.isEmpty()) {
            key.setPersonid(new java.lang.Integer(personid.get(0)));
        }
        java.util.List<String> behaviorid = map.get("behaviorid");
        if (behaviorid != null && !behaviorid.isEmpty()) {
            key.setBehaviorid(new java.lang.Integer(behaviorid.get(0)));
        }
        return key;
    }

    public PersonBehaviorFacadeREST() {
        super(PersonBehavior.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PersonBehavior entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, PersonBehavior entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        tech.ronpainter.behaviortracker.PersonBehaviorPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PersonBehavior find(@PathParam("id") PathSegment id) {
        tech.ronpainter.behaviortracker.PersonBehaviorPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PersonBehavior> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PersonBehavior> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
