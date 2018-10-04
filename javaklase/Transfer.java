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
public class Transfer {
    String ime;
    String prezime;
    String cena;
    
    

    public Transfer() {
    }

    public Transfer(String ime, String prezime, String cena) {
        this.cena = cena;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getCena() {
        return cena;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    
}
