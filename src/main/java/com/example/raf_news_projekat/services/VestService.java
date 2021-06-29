package com.example.raf_news_projekat.services;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.model.Tag;
import com.example.raf_news_projekat.model.Vest;
import com.example.raf_news_projekat.repository.IVestRepository;

import javax.inject.Inject;
import java.util.List;

public class VestService {

    @Inject
    private IVestRepository vestRepository;

    public List<Vest> getVesti() {
        return this.vestRepository.getVesti();
    }

    public Vest findVest(Integer id) {
        return this.vestRepository.findVest(id);
    }

    public Vest dodajVest(Vest vest) {
        return this.vestRepository.dodajVest(vest);
    }

    public List<Tag> getVestTagovi(Integer vestId) {
        return this.vestRepository.getVestTagovi(vestId);
    }

    public List<Vest> getTagVesti(String rec) {
        return this.vestRepository.getTagVesti(rec);
    }

    public Tag dodajTag(Tag tag, Integer vestId) {
        return this.vestRepository.dodajTag(tag, vestId);
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

    public List<Vest> getKategorijaVesti(Integer kategorijaId) {
        return this.vestRepository.getKategorijaVesti(kategorijaId);
    }

    public List<Vest> searchVesti(String search) {
        return this.vestRepository.searchVesti(search);
    }
}
