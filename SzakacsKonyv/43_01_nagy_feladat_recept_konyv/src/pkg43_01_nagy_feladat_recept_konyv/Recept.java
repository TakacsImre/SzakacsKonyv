/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg43_01_nagy_feladat_recept_konyv;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author takac
 */
public class Recept {
    
    private int id;
    private String nev;
    private String fajta;
    private List<Hozzavalo> hozzavalok;
    private String elkeszitese;
    private LocalDate felveteliDatum;

    public Recept() {}
    
    public Recept(String nev, String fajta, List<Hozzavalo> hozzavalok, String elkeszitese) {
        this.nev = nev;
        this.fajta = fajta;
        this.hozzavalok = hozzavalok;
        this.elkeszitese = elkeszitese;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }
    
    public String getElkeszitese() {
        return elkeszitese;
    }

    public void setElkeszitese(String elkeszitese) {
        this.elkeszitese = elkeszitese;
    }

    public LocalDate getFelveteliDatum() {
        return felveteliDatum;
    }

    public void setFelveteliDatum(LocalDate felveteliDatum) {
        this.felveteliDatum = felveteliDatum;
    }

    public List<Hozzavalo> getHozzavalok() {
        return hozzavalok;
    }

    public void setHozzavalok(List<Hozzavalo> hozzavalok) {
        this.hozzavalok = hozzavalok;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return nev + " (" + felveteliDatum + ")";
    }
    
}
