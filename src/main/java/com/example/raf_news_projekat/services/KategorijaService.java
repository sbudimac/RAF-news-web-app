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
}
