package com.example.raf_news_projekat.services;

import com.example.raf_news_projekat.model.Korisnik;
import com.example.raf_news_projekat.model.Status;
import com.example.raf_news_projekat.model.TipKorisnika;
import com.example.raf_news_projekat.repository.IKorisnikRepository;

import javax.inject.Inject;
import java.util.List;

public class KorisnikService {

    @Inject
    private IKorisnikRepository korisnikRepository;

    public List<Korisnik> getKorisnici() {
        return this.korisnikRepository.getKorisnici();
    }

    public Korisnik dodajKorisnika(Korisnik korisnik) {
        return this.korisnikRepository.dodajKorisnika(korisnik);
    }

    public Korisnik izmeniKorisnika(Korisnik korisnik) {
        return this.korisnikRepository.izmeniKorisnika(korisnik);
    }

    public Korisnik aktivirajKorisnika(Korisnik korisnik) {
        if (!korisnik.getTip().equals(TipKorisnika.CONTENT_CREATOR)) {
            System.out.println("Korisnik nije content creator!");
            return null;
        }
        return this.korisnikRepository.aktivirajKorisnika(korisnik);
    }

    public Korisnik deaktivirajKorisnika(Korisnik korisnik) {
        return this.korisnikRepository.deaktivirajKorisnika(korisnik);
    }
}
