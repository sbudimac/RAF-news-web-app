package com.example.raf_news_projekat.repository;

import com.example.raf_news_projekat.model.Kategorija;

import java.util.List;

public interface IKategorijaRepository {

    public List<Kategorija> getKategorije();
    public Kategorija dodajKategoriju(Kategorija kategorija);
    public Kategorija izmeniKategoriju(Kategorija kategorija);
    public void obrisiKategoriju(Integer kategorijaId);
}
