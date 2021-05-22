package com.example.raf_news_projekat.model;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private List<String> reci;
    private List<Vest> vesti;

    public Tag() {
        reci = new ArrayList<>();
        vesti = new ArrayList<>();
    }

    public List<String> getReci() {
        return reci;
    }

    public void setReci(List<String> reci) {
        this.reci = reci;
    }

    public List<Vest> getVesti() {
        return vesti;
    }

    public void setVesti(List<Vest> vesti) {
        this.vesti = vesti;
    }
}
