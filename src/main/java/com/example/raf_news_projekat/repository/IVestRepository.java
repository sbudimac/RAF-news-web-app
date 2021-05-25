package com.example.raf_news_projekat.repository;

import com.example.raf_news_projekat.model.Vest;

import java.util.List;

public interface IVestRepository {
    public Vest dodajVest(Vest vest);
    public Vest izmeniVest(Vest vest);
    public void obrisiVest(Integer id);
    public List<Vest> getHomePageVesti();
    public List<Vest> getNajcitanijeVesti();
    public List<Vest> getKategorijaVesti();
}
