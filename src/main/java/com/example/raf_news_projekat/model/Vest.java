package com.example.raf_news_projekat.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Vest {
    private Integer vestId;
    @NotNull(message = "naslov ne sme biti null")
    @NotEmpty(message = "naslov ne sme biti prazan")
    private String naslov;
    @NotNull(message = "tekst ne sme biti null")
    @NotEmpty(message = "tekst ne sme biti prazan")
    private String tekst;
    @NotNull(message = "vreme kreiranja ne sme biti null")
    @NotEmpty(message = "vreme kreiranja ne sme biti prazno")
    private Date vremeKreiranja;
    @NotNull(message = "broj poseta ne sme biti null")
    @NotEmpty(message = "broj poseta ne sme biti prazan")
    private Integer brojPoseta;
    @NotNull(message = "autor ne sme biti null")
    @NotEmpty(message = "autor ne sme biti prazan")
    private Korisnik autor;
    @NotNull(message = "komentari ne smeju biti null")
    private List<Komentar> komentari;
    @NotNull(message = "tagovi ne smeju biti null")
    private List<Tag> tagovi;
    @NotNull(message = "kategorija ne sme biti null")
    @NotEmpty(message = "kategorija ne sme biti prazna")
    private Kategorija kategorija;

    public Vest(Integer vestId, String naslov, String tekst, Integer brojPoseta) {
        this.vestId = vestId;
        this.naslov = naslov;
        this.tekst = tekst;
        this.vremeKreiranja = new Date(System.currentTimeMillis());
        this.brojPoseta = brojPoseta;
        komentari = new ArrayList<>();
        tagovi = new ArrayList<>();
    }

    public Vest(String naslov, String tekst, Integer brojPoseta, Korisnik autor, Kategorija kategorija) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.vremeKreiranja = new Date(System.currentTimeMillis());
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

    public Integer getVestId() {
        return vestId;
    }

    public void setVestId(Integer vestId) {
        this.vestId = vestId;
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
