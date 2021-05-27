package com.example.raf_news_projekat.model;

import java.util.Date;

public class Komentar {
    private Integer komentarId;
    private String imeAutora;
    private String komentar;
    private Date datumKreiranja;
    private Vest vest;

    public Komentar(Integer komentarId, String imeAutora, String komentar, Date datumKreiranja, Vest vest) {
        this.komentarId = komentarId;
        this.imeAutora = imeAutora;
        this.komentar = komentar;
        this.datumKreiranja = datumKreiranja;
        this.vest = vest;
    }

    public Komentar(String imeAutora, String komentar, Date datumKreiranja, Vest vest) {
        this.imeAutora = imeAutora;
        this.komentar = komentar;
        this.datumKreiranja = datumKreiranja;
        this.vest = vest;
    }

    public Komentar() {

    }

    public Integer getKomentarId() {
        return komentarId;
    }

    public void setKomentarId(Integer komentarId) {
        this.komentarId = komentarId;
    }

    public String getImeAutora() {
        return imeAutora;
    }

    public void setImeAutora(String imeAutora) {
        this.imeAutora = imeAutora;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Vest getVest() {
        return vest;
    }

    public void setVest(Vest vest) {
        this.vest = vest;
    }
}
