package com.example.raf_news_projekat.services;

import com.example.raf_news_projekat.model.Komentar;
import com.example.raf_news_projekat.repository.IKomentarRepository;

import javax.inject.Inject;
import java.util.List;

public class KomentarService {

    @Inject
    private IKomentarRepository komentarRepository;

    public List<Komentar> getVestKomentari(Integer vestId) {
        return this.komentarRepository.getVestKomentari(vestId);
    }

    public Komentar dodajKomentar(Komentar komentar, Integer vestId) {
        return this.komentarRepository.dodajKomentar(komentar, vestId);
    }
}
