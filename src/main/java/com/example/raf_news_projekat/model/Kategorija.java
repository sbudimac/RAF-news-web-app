package com.example.raf_news_projekat.model;

public class Kategorija {
    private String ime;
    private String opis;

    public Kategorija(String ime, String opis) {
        this.ime = ime;
        this.opis = opis;
    }

    public Kategorija() {

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
}
