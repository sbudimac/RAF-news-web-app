package com.example.raf_news_projekat.repository;

import com.example.raf_news_projekat.model.Korisnik;

import java.util.List;

public interface IKorisnikRepository {

    public List<Korisnik> getKorisnici();
    public Korisnik getKorisnik(Integer id);
    public Korisnik findKorisnik(String email);
    public Korisnik dodajKorisnika(Korisnik korisnik);
    public Korisnik izmeniKorisnika(Integer id, Korisnik korisnik);
    public Korisnik aktivirajKorisnika(Integer id, Korisnik korisnik);
    public Korisnik deaktivirajKorisnika(Integer id, Korisnik korisnik);
    public void obrisiKorisnika(Integer korisnikId);
}
