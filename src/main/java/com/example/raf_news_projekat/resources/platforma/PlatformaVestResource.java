package com.example.raf_news_projekat.resources.platforma;

import com.example.raf_news_projekat.model.Komentar;
import com.example.raf_news_projekat.model.Vest;
import com.example.raf_news_projekat.services.KomentarService;
import com.example.raf_news_projekat.services.VestService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/platforma_vesti")
public class PlatformaVestResource {

    @Inject
    private VestService vestService;
    @Inject
    private KomentarService komentarService;

    @Context
    private ResourceContext resourceContext;

    @GET
    @Path("/homepage")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> getHomePageVesti() {
        return this.vestService.getHomePageVesti();
    }

    @GET
    @Path("/najcitanije")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> getNajcitanijeVesti() {
        return this.vestService.getNajcitanijeVesti();
    }

    @GET
    @Path("/{kategorija_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> getKategorijaVesti(@PathParam("kategorija_id") Integer kategorijaId) {
        return this.vestService.getKategorijaVesti(kategorijaId);
    }

    @GET
    @Path("vesti/{vest_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vest getVest(@PathParam("vest_id") Integer id) {
        return this.vestService.findVest(id);
    }

    @GET
    @Path("/search/{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vest> searchVesti(@PathParam("search") String search) {
        return this.vestService.searchVesti(search);
    }

    @GET
    @Path("/{vest_id}/komentari")
    public List<Komentar> getVestKomentari(@PathParam("vest_id") Integer id) {
        return this.komentarService.getVestKomentari(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{vest_id}")
    public Komentar dodajKomentar(Komentar komentar, @PathParam("vest_id") Integer id) {
        return this.komentarService.dodajKomentar(komentar, id);
    }
}
