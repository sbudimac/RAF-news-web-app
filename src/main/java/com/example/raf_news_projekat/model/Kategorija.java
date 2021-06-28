package com.example.raf_news_projekat.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Kategorija {
    private Integer kategorijaId;
    @NotNull(message = "ime kategorije ne sme biti null")
    @NotEmpty(message = "ime kategorije ne sme biti prazno")
    private String ime;
    @NotNull(message = "opis kategorije ne sme biti null")
    @NotEmpty(message = "opis kategorije ne sme biti prazno")
    private String opis;
    private List<Integer> vesti;

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

    public List<Integer> getVesti() {
        return vesti;
    }

    public void setVesti(List<Integer> vesti) {
        this.vesti = vesti;
    }
}
