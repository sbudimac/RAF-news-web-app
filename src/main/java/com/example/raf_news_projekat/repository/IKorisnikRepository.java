package com.example.raf_news_projekat.repository;

import com.example.raf_news_projekat.model.Korisnik;

import java.util.List;

public interface IKorisnikRepository {

    public List<Korisnik> getKorisnici();
    public Korisnik dodajKorisnika(Korisnik korisnik);
    public Korisnik izmeniKorisnika(Korisnik korisnik);
    public Korisnik aktivirajKorisnika(Korisnik korisnik);
    public Korisnik deaktivirajKorisnika(Korisnik korisnik);
}
