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
public class Predsednik {
    String ime;
    String prezime;
    

    public Predsednik() {
    }

    public Predsednik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
        
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

   
    
    
}
