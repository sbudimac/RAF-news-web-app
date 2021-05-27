package com.example.raf_news_projekat.resources.platforma;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.services.KategorijaService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class PlatformaKategorijaResource {

    @Inject
    private KategorijaService kategorijaService;

    @Context
    private ResourceContext resourceContext;

    @GET
    @Path("/kategorije")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kategorija> getKategorije() {
        return this.kategorijaService.getKategorije();
    }

    @Path("kategorije/{kategorija_id}/kategorija_vesti")
    public PlatformaVestResource getKategorijaVesti() {
        return resourceContext.getResource(PlatformaVestResource.class);
    }
}
