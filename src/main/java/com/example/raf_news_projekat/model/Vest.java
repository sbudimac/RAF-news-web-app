package com.example.raf_news_projekat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vest {
    private Integer id;
    private String naslov;
    private String tekst;
    private Date vremeKreiranja;
    private Integer brojPoseta;
    private Korisnik autor;
    private List<Komentar> komentari;
    private List<Tag> tagovi;
    private Kategorija kategorija;

    public Vest(String naslov, String tekst, Date vremeKreiranja, Integer brojPoseta, Korisnik autor, Kategorija kategorija) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.vremeKreiranja = vremeKreiranja;
        this.brojPoseta = brojPoseta;
        this.autor = autor;
        this.kategorija = kategorija;
        komentari = new ArrayList<>();
        tagovi = new ArrayList<>();
    }

    public Vest() {
        komentari = new ArrayList<>();
        tagovi = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(Date vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }

    public Integer getBrojPoseta() {
        return brojPoseta;
    }

    public void setBrojPoseta(Integer brojPoseta) {
        this.brojPoseta = brojPoseta;
    }

    public Korisnik getAutor() {
        return autor;
    }

    public void setAutor(Korisnik autor) {
        this.autor = autor;
    }

    public List<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(List<Komentar> komentari) {
        this.komentari = komentari;
    }

    public List<Tag> getTagovi() {
        return tagovi;
    }

    public void setTagovi(List<Tag> tagovi) {
        this.tagovi = tagovi;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
}
