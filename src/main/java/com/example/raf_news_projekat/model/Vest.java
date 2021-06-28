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
    private Integer autorId;
    @NotNull(message = "komentari ne smeju biti null")
    private List<Integer> komentari;
    @NotNull(message = "tagovi ne smeju biti null")
    private List<String> tagovi;
    @NotNull(message = "kategorija ne sme biti null")
    @NotEmpty(message = "kategorija ne sme biti prazna")
    private Integer kategorijaId;

    public Vest(Integer vestId, String naslov, String tekst, Integer brojPoseta) {
        this.vestId = vestId;
        this.naslov = naslov;
        this.tekst = tekst;
        this.vremeKreiranja = new Date(System.currentTimeMillis());
        this.brojPoseta = brojPoseta;
        komentari = new ArrayList<>();
        tagovi = new ArrayList<>();
    }

    public Vest(String naslov, String tekst, Date vremeKreiranja, Integer brojPoseta, Integer autorId, Integer kategorijaId) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.vremeKreiranja = vremeKreiranja;
        this.brojPoseta = brojPoseta;
        this.autorId = autorId;
        this.kategorijaId = kategorijaId;
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

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public List<Integer> getKomentari() {
        return komentari;
    }

    public void setKomentari(List<Integer> komentari) {
        this.komentari = komentari;
    }

    public List<String> getTagovi() {
        return tagovi;
    }

    public void setTagovi(List<String> tagovi) {
        this.tagovi = tagovi;
    }

    public Integer getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(Integer kategorijaId) {
        this.kategorijaId = kategorijaId;
    }
}
