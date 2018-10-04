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
public class Hala {
    String naziv;
    String kapacitet;
    String adresa;

    public Hala() {
    }

    public Hala(String naziv, String kapacitet, String adresa) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getKapacitet() {
        return kapacitet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setKapacitet(String kapacitet) {
        this.kapacitet = kapacitet;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
