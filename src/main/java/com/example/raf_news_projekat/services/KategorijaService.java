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
        return this.kategorijaRepository.dodajKategoriju(kategorija);
    }

    public Kategorija izmeniKategoriju(Kategorija kategorija) {
        return this.kategorijaRepository.izmeniKategoriju(kategorija);
    }

    public void obrisiKategoriju(Integer kategorijaId) {
        this.kategorijaRepository.obrisiKategoriju(kategorijaId);
    }

    public Kategorija findKategorija(String imeKategorije) {
        return this.kategorijaRepository.findKategorija(imeKategorije);
    }

    public Kategorija findKategorija(Integer kategorijaId) {
        return this.kategorijaRepository.findKategorija(kategorijaId);
    }
}
