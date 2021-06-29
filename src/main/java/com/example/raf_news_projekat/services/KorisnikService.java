package com.example.raf_news_projekat.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.raf_news_projekat.model.Korisnik;
import com.example.raf_news_projekat.model.TipKorisnika;
import com.example.raf_news_projekat.repository.IKorisnikRepository;
import org.apache.commons.codec.digest.DigestUtils;
import com.auth0.jwt.algorithms.Algorithm;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public class KorisnikService {

    @Inject
    private IKorisnikRepository korisnikRepository;

    public List<Korisnik> getKorisnici() {
        return this.korisnikRepository.getKorisnici();
    }

    public Korisnik findKorisnik(String email) {
        return this.korisnikRepository.findKorisnik(email);
    }

    public Korisnik getKorisnik(Integer id) {
        return this.korisnikRepository.getKorisnik(id);
    }

    public Korisnik dodajKorisnika(Korisnik korisnik) {
        return this.korisnikRepository.dodajKorisnika(korisnik);
    }

    public Korisnik izmeniKorisnika(Integer id, Korisnik korisnik) {
        return this.korisnikRepository.izmeniKorisnika(id, korisnik);
    }

    public void aktivirajKorisnika(Integer id) {
        this.korisnikRepository.aktivirajKorisnika(id);
    }

    public void deaktivirajKorisnika(Integer id) {
        this.korisnikRepository.deaktivirajKorisnika(id);
    }

    public void obrisiKorisnika(Integer korisnikId) {
        this.korisnikRepository.obrisiKorisnika(korisnikId);
    }

    public String login(String email, String password) {
        String hashedPassword = DigestUtils.sha256Hex(password);

        Korisnik korisnik = this.korisnikRepository.findKorisnik(email);
        if(korisnik == null || !korisnik.getLozinkaHash().equals(hashedPassword)) {
            return null;
        }

        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + 24*60*60*1000);

        Algorithm algorithm = Algorithm.HMAC256("secret");

        return JWT.create()
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withSubject(email)
                .withClaim("korisnikId", korisnik.getKorisnikId())
                .withClaim("ime", korisnik.getIme())
                .withClaim("prezime", korisnik.getPrezime())
                .withClaim("tip", korisnik.getTip().toString())
                .withClaim("status", korisnik.getStatus().toString())
                .sign(algorithm);
    }

    public boolean isAuthorized(String token) {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String email = jwt.getSubject();

        Korisnik korisnik = this.korisnikRepository.findKorisnik(email);
        if (korisnik == null) {
            return false;
        }

        return true;
    }
}
