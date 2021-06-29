package com.example.raf_news_projekat.resources.platforma;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.services.KategorijaService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/platforma_kategorije")
public class PlatformaKategorijaResource {

    @Inject
    private KategorijaService kategorijaService;

    @Context
    private ResourceContext resourceContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kategorija> getKategorije() {
        return this.kategorijaService.getKategorije();
    }

    @GET
    @Path("/id/{kategorija_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kategorija getKategorija(@PathParam("kategorija_id") Integer kategorijaId) {
        return this.kategorijaService.findKategorija(kategorijaId);
    }

    @GET
    @Path("/{kategorija_ime}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kategorija getKategorija(@PathParam("kategorija_ime") String kategorijaIme) {
        return this.kategorijaService.findKategorija(kategorijaIme);
    }
}
