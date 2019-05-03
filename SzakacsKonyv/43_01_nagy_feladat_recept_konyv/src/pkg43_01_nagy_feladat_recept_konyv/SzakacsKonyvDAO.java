/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg43_01_nagy_feladat_recept_konyv;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author takac
 */
public interface SzakacsKonyvDAO {
    
    public List<Recept> beOlvas(String fajta) throws SQLException;
    
    public void kiir(Recept recept) throws SQLException;
    
    public List<Hozzavalo> hozzavaloBeolvasasa(Recept recept) throws SQLException;
    
    public void hozzavaloKiir(Hozzavalo hozzavalo, Recept recept) throws SQLException;
    
    public void receptModosit(Recept recept) throws SQLException;
    
    public void hozzavaloModositasa(Hozzavalo hozzavalo) throws SQLException;
    
    public void receptTorlese(Recept recept) throws SQLException;
    
    public void hozzavaloTorlese(Hozzavalo hozzavalo) throws SQLException;
    
    public List<Recept> kereses(String nev, String fajta) throws SQLException;
    
    public List<String> etelFajtak() throws SQLException;
    
    public void bezar() throws SQLException;
    
    
    
}
