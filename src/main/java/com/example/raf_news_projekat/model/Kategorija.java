package com.example.raf_news_projekat.model;

import java.util.ArrayList;
import java.util.List;

public class Kategorija {
    private Integer kategorijaId;
    private String ime;
    private String opis;
    private List<Vest> vesti;

    public Kategorija(Integer kategorijaId, String ime, String opis) {
        this.kategorijaId = kategorijaId;
        this.ime = ime;
        this.opis = opis;
        vesti = new ArrayList<>();
    }

    public Kategorija(String ime, String opis) {
        this.ime = ime;
        this.opis = opis;
        vesti = new ArrayList<>();
    }

    public Kategorija() {

    }

    public Integer getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(Integer kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Vest> getVesti() {
        return vesti;
    }

    public void setVesti(List<Vest> vesti) {
        this.vesti = vesti;
    }
}
