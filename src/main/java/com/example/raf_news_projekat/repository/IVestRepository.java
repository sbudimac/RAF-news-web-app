package com.example.raf_news_projekat.repository;
import com.example.raf_news_projekat.model.Tag;
import com.example.raf_news_projekat.model.Vest;

import java.util.List;

public interface IVestRepository {
    public List<Vest> getVesti();
    public Vest findVest(Integer vestId);
    public Vest dodajVest(Vest vest);
    public List<Tag> getVestTagovi(Integer vestId);
    public List<Vest> getTagVesti(String rec);
    public Tag dodajTag(Tag tag, Integer vestId);
    public Vest izmeniVest(Vest vest);
    public void obrisiVest(Integer vestId);
    public List<Vest> getHomePageVesti();
    public List<Vest> getNajcitanijeVesti();
    public List<Vest> getKategorijaVesti(Integer kategorijaId);
    public List<Vest> searchVesti(String search);
    public void posetaVesti(Integer vestId, Integer brojPoseta);
}
