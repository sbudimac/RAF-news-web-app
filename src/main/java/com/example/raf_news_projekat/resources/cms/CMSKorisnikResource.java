package com.example.raf_news_projekat.resources.cms;

import com.example.raf_news_projekat.model.Korisnik;
import com.example.raf_news_projekat.services.KorisnikService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cms_korisnici")
public class CMSKorisnikResource {

    @Inject
    private KorisnikService korisnikService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Korisnik> getKorisnici() {
        return this.korisnikService.getKorisnici();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Korisnik dodajKorisnika(Korisnik korisnik) {
        return this.korisnikService.dodajKorisnika(korisnik);
    }

    @PUT
    @Path("/{korisnik_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Korisnik izmeniKorisnika(Korisnik korisnik) {
        return this.korisnikService.izmeniKorisnika(korisnik);
    }

    @PUT
    @Path("/aktivacija/{korisnik_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Korisnik aktivirajKorisnika(Korisnik korisnik) {
        return this.korisnikService.aktivirajKorisnika(korisnik);
    }

    @PUT
    @Path("/deaktivacija/{korisnik_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Korisnik deaktivirajKorisnika(Korisnik korisnik) {
        return this.korisnikService.deaktivirajKorisnika(korisnik);
    }
}
