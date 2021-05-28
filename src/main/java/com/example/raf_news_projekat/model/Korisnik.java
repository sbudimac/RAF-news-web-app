package com.example.raf_news_projekat.model;

import org.apache.commons.codec.digest.DigestUtils;

public class Korisnik {
    private Integer korisnikId;
    private String email;
    private String ime;
    private String prezime;
    private TipKorisnika tip;
    private Status status;
    private String lozinka;

    public Korisnik() {

    }

    public Korisnik(Integer korisnikId, String email, String ime, String prezime, TipKorisnika tip, Status status, String lozinka) {
        this.korisnikId = korisnikId;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.tip = tip;
        this.status = status;
        this.lozinka = DigestUtils.sha256Hex(lozinka);
    }

    public Korisnik(String email, String ime, String prezime, TipKorisnika tip, Status status, String lozinka) {
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.tip = tip;
        this.status = status;
        this.lozinka = DigestUtils.sha256Hex(lozinka);
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public TipKorisnika getTip() {
        return tip;
    }

    public void setTip(TipKorisnika tip) {
        this.tip = tip;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = DigestUtils.sha256Hex(lozinka);
    }
}
