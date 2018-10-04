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
public class Pomocni {
    String ime;
    String prezime;
    String datumrodjenja;

    public Pomocni() {
    }

    public Pomocni(String ime, String prezime, String datumrodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumrodjenja = datumrodjenja;
    }

    public String getDatumrodjenja() {
        return datumrodjenja;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setDatumrodjenja(String datumrodjenja) {
        this.datumrodjenja = datumrodjenja;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    
}
