package com.example.raf_news_projekat.model;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private Integer tagId;
    private List<String> reci;
    private List<Vest> vesti;

    public Tag(Integer tagId) {
        this.tagId = tagId;
        reci = new ArrayList<>();
        vesti = new ArrayList<>();
    }

    public Tag() {
        reci = new ArrayList<>();
        vesti = new ArrayList<>();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
