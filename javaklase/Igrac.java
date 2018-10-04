/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Luka
 */
public class Igrac {
    String ime;
    String prezime;
    String pozicija;
    String datumRodjenja;
    String plata;

    public Igrac() {
    }

    public Igrac(String ime, String prezime, String pozicija, String datumRodjenja,String plata) {
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.datumRodjenja = datumRodjenja;
        this.plata = plata;
    }

    public String getIme() {
        return ime;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getPozicija() {
        return pozicija;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getPlata() {
        return plata;
    }

    public void setPlata(String plata) {
        this.plata = plata;
    }
    
    
    
}
