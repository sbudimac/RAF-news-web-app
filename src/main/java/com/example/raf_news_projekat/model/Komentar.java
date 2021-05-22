package com.example.raf_news_projekat.model;

import java.util.Date;

public class Komentar {
    private String imeAutora;
    private String komentar;
    private Date datumKreiranja;
    private Vest vest;

    public Komentar(String imeAutora, String komentar, Date datumKreiranja, Vest vest) {
        this.imeAutora = imeAutora;
        this.komentar = komentar;
        this.datumKreiranja = datumKreiranja;
        this.vest = vest;
    }

    public Komentar() {

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
