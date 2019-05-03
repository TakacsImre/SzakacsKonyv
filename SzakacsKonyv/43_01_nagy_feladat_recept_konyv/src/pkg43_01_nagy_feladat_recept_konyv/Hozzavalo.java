/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg43_01_nagy_feladat_recept_konyv;

/**
 *
 * @author takac
 */
public class Hozzavalo {
    
    private int darab;
    private int sor;
    private Double mennyiseg;
    private String mertekegyseg;
    private String alapanyag;
    private int ar;

    public Hozzavalo() {
    }

    public Hozzavalo(double mennyiseg, String mertekegyseg, String alapanyag, int ar) {
        this.mennyiseg = mennyiseg;
        this.mertekegyseg = mertekegyseg;
        this.alapanyag = alapanyag;
        this.ar = ar;
       
    }

    public Double getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Double mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public String getMertekegyseg() {
        return mertekegyseg;
    }

    public void setMertekegyseg(String mertekegyseg) {
        this.mertekegyseg = mertekegyseg;
    }

    public String getAlapanyag() {
        return alapanyag;
    }

    public void setAlapanyag(String alapanyag) {
        this.alapanyag = alapanyag;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
    
    public int getSor() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }
    
    
    
    @Override
    public String toString() {
        String mennyiseg = "" + this.mennyiseg;
        if (mennyiseg.charAt(mennyiseg.indexOf(".") + 1) == '0') {
            mennyiseg = "" + this.mennyiseg.intValue();
        }
        
        return mennyiseg + " " + mertekegyseg + " " + alapanyag + " (" + ar + " Ft)";
    }
    
}
