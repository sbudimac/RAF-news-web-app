package com.example.raf_news_projekat.resources.platforma;

import com.example.raf_news_projekat.model.Korisnik;
import com.example.raf_news_projekat.requests.LoginRequest;
import com.example.raf_news_projekat.services.KorisnikService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/platforma_korisnici")
public class PlatformaKorisnikResource {

    @Inject
    private KorisnikService korisnikService;

    @GET
    @Path("/{korisnik_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Korisnik getKorisnik(@PathParam("korisnik_id") Integer korisnikId) {
        return this.korisnikService.getKorisnik(korisnikId);
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid LoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();

        String jwt = this.korisnikService.login(loginRequest.getEmail(), loginRequest.getLozinka());
        if (jwt == null) {
            response.put("message", "No such email and password combination");
            return Response.status(422, "Unprocessable entity").entity(response).build();
        }
        response.put("jwt", jwt);

        return Response.ok(response).build();
    }
}
