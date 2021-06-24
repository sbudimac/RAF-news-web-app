package com.example.raf_news_projekat.model;

import org.apache.commons.codec.digest.DigestUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Korisnik {
    private Integer korisnikId;
    @NotNull(message = "email ne sme biti null")
    @NotEmpty(message = "email ne sme biti prazan")
    private String email;
    @NotNull(message = "ime ne sme biti null")
    @NotEmpty(message = "ime ne sme biti prazno")
    private String ime;
    @NotNull(message = "prezime ne sme biti null")
    @NotEmpty(message = "prezime ne sme biti prazno")
    private String prezime;
    @NotNull(message = "tip korisnika ne sme biti null")
    @NotEmpty(message = "tip korisnika ne sme biti prazan")
    private TipKorisnika tip;
    @NotNull(message = "status ne sme biti null")
    @NotEmpty(message = "status ne sme biti prazan")
    private Status status;
    @NotNull(message = "lozinka ne sme biti null")
    @NotEmpty(message = "lozinka ne sme biti prazna")
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
