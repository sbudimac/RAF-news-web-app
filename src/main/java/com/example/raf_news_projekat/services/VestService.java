package com.example.raf_news_projekat.services;

import com.example.raf_news_projekat.model.Vest;
import com.example.raf_news_projekat.repository.IVestRepository;

import javax.inject.Inject;
import java.util.List;

public class VestService {

    @Inject
    private IVestRepository vestRepository;

    public Vest dodajVest(Vest vest) {
        return this.vestRepository.dodajVest(vest);
    }

    public Vest izmeniVest(Vest vest) {
        return this.vestRepository.izmeniVest(vest);
    }

    public void obrisiVest(Integer id) {
        this.vestRepository.obrisiVest(id);
    }

    public List<Vest> getHomePageVesti() {
        return this.vestRepository.getHomePageVesti();
    }

    public List<Vest> getNajcitanijeVesti() {
        return this.vestRepository.getNajcitanijeVesti();
    }

    public List<Vest> getKategorijaVesti() {
        return this.vestRepository.getKategorijaVesti();
    }
}
