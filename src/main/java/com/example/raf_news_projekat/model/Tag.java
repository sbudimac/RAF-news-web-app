package com.example.raf_news_projekat.model;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private Integer tagId;
    private String reci;
    private List<Vest> vesti;

    public Tag(Integer tagId, String reci) {
        this.tagId = tagId;
        this.reci = reci;
        vesti = new ArrayList<>();
    }

    public Tag() {
        vesti = new ArrayList<>();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getReci() {
        return reci;
    }

    public void setReci(String reci) {
        this.reci = reci;
    }

    public List<Vest> getVesti() {
        return vesti;
    }

    public void setVesti(List<Vest> vesti) {
        this.vesti = vesti;
    }
}
