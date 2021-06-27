package com.example.raf_news_projekat.resources.cms;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.services.KategorijaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cms_kategorije")
public class CMSKategorijaResource {

    @Inject
    private KategorijaService kategorijaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Kategorija dodajKategoriju(Kategorija kategorija) {
        return this.kategorijaService.dodajKategoriju(kategorija);
    }

    @PUT
    @Path("/{kategorija_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Kategorija izmeniKategoriju(@PathParam("kategorija_id") Integer id, Kategorija kategorija) {
        kategorija.setKategorijaId(id);
        return this.kategorijaService.izmeniKategoriju(kategorija);
    }

    @DELETE
    @Path("/{kategorija_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void obrisiKategoriju(@PathParam("kategorija_id") Integer id) {
        this.kategorijaService.obrisiKategoriju(id);
    }
}
