package com.example.raf_news_projekat.repository;

import com.example.raf_news_projekat.model.Komentar;

import java.util.List;

public interface IKomentarRepository {
    public List<Komentar> getVestKomentari(Integer vestId);
    public Komentar dodajKomentar(Komentar komentar, Integer vestId);
}
