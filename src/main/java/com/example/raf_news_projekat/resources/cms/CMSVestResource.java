package com.example.raf_news_projekat.resources.cms;

import com.example.raf_news_projekat.model.Tag;
import com.example.raf_news_projekat.model.Vest;
import com.example.raf_news_projekat.services.VestService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cms_vesti")
public class CMSVestResource {

    @Inject
    private VestService vestService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> getVesti() {
        return this.vestService.getVesti();
    }

    @GET
    @Path("/search/{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> searchVesti(@PathParam("search") String search) {
        return this.vestService.searchVesti(search);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vest dodajVest(Vest vest) {
        return this.vestService.dodajVest(vest);
    }

    @PUT
    @Path("/{vest_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vest izmeniVest(@PathParam("vest_id") Integer id, Vest vest) {
        vest.setVestId(id);
        return this.vestService.izmeniVest(vest);
    }

    @DELETE
    @Path("/{vest_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void obrisiVest(@PathParam("vest_id") Integer id) {
        this.vestService.obrisiVest(id);
    }

    @POST
    @Path("/{vest_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tag dodajTag(Tag tag, @PathParam("vest_id") Integer vestId) {
        return this.vestService.dodajTag(tag, vestId);
    }
}
