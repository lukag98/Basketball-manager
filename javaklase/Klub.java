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
public class Klub {
    String naziv;
    String osnivanje;
    String trofeji;
    String isplata;
    String rank;

    public Klub() {
    }

    public Klub(String naziv, String osnivanje, String trofeji,String isplata,String rank) {
        this.naziv = naziv;
        this.osnivanje = osnivanje;
        this.trofeji = trofeji;
        this.isplata=isplata;
        this.rank=rank;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOsnivanje() {
        return osnivanje;
    }

    public String getTrofeji() {
        return trofeji;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOsnivanje(String osnivanje) {
        this.osnivanje = osnivanje;
    }

    public void setTrofeji(String trofeji) {
        this.trofeji = trofeji;
    }

    public String getIsplata() {
        return isplata;
    }

    public String getRank() {
        return rank;
    }

    public void setIsplata(String isplata) {
        this.isplata = isplata;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    
    
}
