package com.example.raf_news_projekat.resources;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.model.Vest;
import com.example.raf_news_projekat.services.VestService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/vesti")
public class VestResource {

    @Inject
    private VestService vestService;

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
        vest.setId(id);
        return this.vestService.izmeniVest(vest);
    }

    @DELETE
    @Path("/{vest_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void obrisiVest(@PathParam("vest_id") Integer id) {
        this.vestService.obrisiVest(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> getHomePageVesti() {
        return this.vestService.getHomePageVesti();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> getNajcitanijeVesti() {
        return this.vestService.getNajcitanijeVesti();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> getKategorijaVesti(Kategorija kategorija) {
        return this.vestService.getKategorijaVesti(kategorija);
    }
}
