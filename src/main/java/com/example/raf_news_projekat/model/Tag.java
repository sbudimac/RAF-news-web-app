package com.example.raf_news_projekat.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Tag {
    private Integer tagId;
    @NotNull(message = "reci ne smeju biti null")
    @NotEmpty(message = "reci ne smeju biti prazne")
    private String rec;

    public Tag(Integer tagId, String rec) {
        this.tagId = tagId;
        this.rec = rec;
    }

    public Tag(String rec) {
        this.rec = rec;
    }

    public Tag() {

    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getRec() {
        return rec;
    }

    public void setReci(String rec) {
        this.rec = rec;
    }
}
