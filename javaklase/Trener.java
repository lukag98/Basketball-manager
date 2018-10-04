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
public class Trener {
    String ime;
    String prezime;
    String godine;

    public Trener() {
    }

    public Trener(String ime, String prezime, String godine) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
    }

    public String getGodine() {
        return godine;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setGodine(String godine) {
        this.godine = godine;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
 
    
}
