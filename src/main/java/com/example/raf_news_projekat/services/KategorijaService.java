package com.example.raf_news_projekat.services;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.repository.IKategorijaRepository;

import javax.inject.Inject;
import java.util.List;

public class KategorijaService {

    @Inject
    private IKategorijaRepository kategorijaRepository;

    public List<Kategorija> getKategorije() {
        return this.kategorijaRepository.getKategorije();
    }

    public Kategorija dodajKategoriju(Kategorija kategorija) {
        if (this.kategorijaRepository.findKategorija(kategorija.getIme()) != null) {
            System.out.println("Ova kategorija vec postoji!");
            return null;
        }
        return this.kategorijaRepository.dodajKategoriju(kategorija);
    }

    public Kategorija izmeniKategoriju(Kategorija kategorija) {
        return this.kategorijaRepository.izmeniKategoriju(kategorija);
    }

    public void obrisiKategoriju(Integer kategorijaId) {
        if (this.kategorijaRepository.findKategorija(kategorijaId).getVesti().size() != 0) {
            System.out.println("Ova kategorija ima vesti!");
            return;
        }
        this.kategorijaRepository.obrisiKategoriju(kategorijaId);
    }
}
