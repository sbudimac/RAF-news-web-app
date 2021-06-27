package com.example.raf_news_projekat.resources.platforma;

import com.example.raf_news_projekat.model.Vest;
import com.example.raf_news_projekat.services.VestService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/platforma_vesti")
public class PlatformaVestResource {

    @Inject
    private VestService vestService;

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

    @Path("/{vest_id}")
    public Vest getVest(@PathParam("vest_id") Integer id) {
        return this.vestService.findVest(id);
    }
}
