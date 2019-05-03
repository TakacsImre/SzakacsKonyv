/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg43_01_nagy_feladat_recept_konyv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author takac
 */
public class SzakacsKonyvDAOJDBCImpl implements SzakacsKonyvDAO {
    
    private Connection conn;
    private PreparedStatement receptBeolvas;
    private PreparedStatement receptKiir;
    private PreparedStatement recepTorlese;
    private PreparedStatement receptModosit;
    
    private PreparedStatement hozzavalokBeolvas;
    private PreparedStatement hozzavalokKiir;
    private PreparedStatement hozzavaloTorlese;
    private PreparedStatement hozzavaloModositas;
    
    private PreparedStatement getID;
    
    public SzakacsKonyvDAOJDBCImpl() {
    }
  
    public SzakacsKonyvDAOJDBCImpl(Connection conn) throws SQLException{
        this.conn = conn;
        this.receptBeolvas = conn.prepareStatement("SELECT * FROM recept WHERE recept.Fajta = ?");
        this.receptKiir = conn.prepareStatement("INSERT INTO recept(Nev, Fajta, Elkeszetese, Datum) VALUES(?, ?, ?, ?)");
        this.receptModosit = conn.prepareStatement("UPDATE recept SET Nev = ?, Elkeszetese = ?, Fajta = ? WHERE ID = ?");
        this.recepTorlese = conn.prepareStatement("DELETE FROM recept WHERE ID = ?");

        this.hozzavalokBeolvas = conn.prepareStatement("SELECT * FROM recept INNER JOIN hozzavalok ON ID = ReceptID WHERE recept.Fajta = ? AND ReceptID = ?");
        this.hozzavalokKiir = conn.prepareStatement("INSERT INTO hozzavalok(Darab, ReceptID, ReceptNev, Mennyiseg, Mertekegyseg, Alapanyag, Ara) VALUES(?, ?, ?, ?, ?, ?, ?)");
        this.hozzavaloTorlese = conn.prepareStatement("DELETE FROM hozzavalok WHERE Sor = ?");
        this.hozzavaloModositas = conn.prepareStatement("UPDATE hozzavalok SET Mennyiseg = ?, Mertekegyseg = ?, Alapanyag = ?, Ara = ? WHERE Sor = ?");
        
        this.getID = conn.prepareStatement("SELECT recept.ID FROM recept WHERE Nev = ? AND Fajta = ?");
    }
    
    @Override
    public List<Recept> beOlvas(String fajta) throws SQLException {
        
        List<Recept> receptLista = new ArrayList<>();
        
        int id = 0;
        this.receptBeolvas.setString(1, fajta);
        ResultSet receptBeolvasasa = receptBeolvas.executeQuery();
        while (receptBeolvasasa.next()) {
            Recept recept = new Recept();
            recept.setId(receptBeolvasasa.getInt("ID"));
            recept.setNev(receptBeolvasasa.getString("Nev"));
            recept.setFajta(receptBeolvasasa.getString("Fajta"));
            recept.setElkeszitese(receptBeolvasasa.getString("Elkeszetese"));
            recept.setFelveteliDatum(receptBeolvasasa.getDate("Datum").toLocalDate());
            
            List<Hozzavalo> hozzavalok = hozzavaloBeolvasasa(recept);
            recept.setHozzavalok(hozzavalok);
            receptLista.add(recept);
        }
        return receptLista;
        
    }
    
    @Override
    public void kiir(Recept recept) throws SQLException {
        int id = 0;
        this.receptKiir.setString(1, recept.getNev());
        this.receptKiir.setString(2, recept.getFajta());
        this.receptKiir.setString(3, recept.getElkeszitese());
        this.receptKiir.setDate(4, Date.valueOf(recept.getFelveteliDatum()));
        this.receptKiir.executeUpdate();
        
        this.getID.setString(1, recept.getNev());
        this.getID.setString(2, recept.getFajta());
        ResultSet rs = this.getID.executeQuery();
        while(rs.next()) {
            id = rs.getInt("ID");
        }
        recept.setId(id);
        for (int i = 0; i < recept.getHozzavalok().size(); i++) {
            
            hozzavaloKiir(recept.getHozzavalok().get(i), recept);
            
        }
        
    }
    
    @Override
    public List<Hozzavalo> hozzavaloBeolvasasa(Recept recept) throws SQLException {
            this.hozzavalokBeolvas.setString(1, recept.getFajta());
            this.hozzavalokBeolvas.setInt(2, recept.getId());
            ResultSet hozzavalokBeolvasasa = hozzavalokBeolvas.executeQuery();
            List<Hozzavalo> hozzavalok = new ArrayList<>();
            while(hozzavalokBeolvasasa.next()) {
                Hozzavalo hozzavalo = new Hozzavalo(hozzavalokBeolvasasa.getDouble("Mennyiseg"), hozzavalokBeolvasasa.getString("Mertekegyseg"), hozzavalokBeolvasasa.getString("Alapanyag"), hozzavalokBeolvasasa.getInt("Ara"));
                hozzavalo.setDarab(hozzavalokBeolvasasa.getInt("Darab"));
                hozzavalo.setSor(hozzavalokBeolvasasa.getInt("Sor"));
                hozzavalok.add(hozzavalo);
            }
            return hozzavalok;
    }
    
    @Override
    public void hozzavaloKiir(Hozzavalo hozzavalo, Recept recept) throws SQLException {

        this.hozzavalokKiir.setInt(1, hozzavalo.getDarab());
        this.hozzavalokKiir.setInt(2, recept.getId());
        this.hozzavalokKiir.setString(3, recept.getNev());
        this.hozzavalokKiir.setDouble(4, hozzavalo.getMennyiseg());
        this.hozzavalokKiir.setString(5, hozzavalo.getMertekegyseg());
        this.hozzavalokKiir.setString(6, hozzavalo.getAlapanyag());
        this.hozzavalokKiir.setInt(7, hozzavalo.getAr());
        this.hozzavalokKiir.executeUpdate();

    }
    
    @Override
    public void receptModosit(Recept recept) throws SQLException {
        
        this.receptModosit.setString(1, recept.getNev());
        this.receptModosit.setString(2, recept.getElkeszitese());
        this.receptModosit.setString(3, recept.getFajta());
        this.receptModosit.setInt(4, recept.getId());
        this.receptModosit.executeUpdate();
  
    }
    
    @Override
    public void hozzavaloModositasa(Hozzavalo hozzavalo) throws SQLException {

        this.hozzavaloModositas.setDouble(1, hozzavalo.getMennyiseg());
        this.hozzavaloModositas.setString(2, hozzavalo.getMertekegyseg());
        this.hozzavaloModositas.setString(3, hozzavalo.getAlapanyag());
        this.hozzavaloModositas.setInt(4, hozzavalo.getAr());
        this.hozzavaloModositas.setInt(5, hozzavalo.getSor());
        this.hozzavaloModositas.executeUpdate();
        
    }
    
    @Override
    public void receptTorlese(Recept recept) throws SQLException {
        
        this.recepTorlese.setInt(1, recept.getId());
        this.recepTorlese.executeUpdate();
        for (int i = 0; i < recept.getHozzavalok().size(); i++) {
            hozzavaloTorlese(recept.getHozzavalok().get(i));
        }
        
    }
    
    @Override
    public void hozzavaloTorlese(Hozzavalo hozzavalo) throws SQLException {
        this.hozzavaloTorlese.setInt(1, hozzavalo.getSor());
        this.hozzavaloTorlese.executeUpdate();
    }
    
    @Override
    public List<Recept> kereses(String nev, String fajta) throws SQLException {
        List<Recept> receptek = new ArrayList<>();
        Statement kereses = conn.createStatement();
        ResultSet rs = kereses.executeQuery("SELECT * FROM recept WHERE Nev LIKE '%" + nev + "%' AND Fajta = '" + fajta + "'");
        
        while(rs.next()) {
            Recept recept = new Recept();
            recept.setId(rs.getInt("ID"));
            recept.setNev(rs.getString("Nev"));
            recept.setFajta(rs.getString("Fajta"));
            recept.setElkeszitese(rs.getString("Elkeszetese"));
            recept.setFelveteliDatum(rs.getDate("Datum").toLocalDate());
            
            List<Hozzavalo> hozzavalok = hozzavaloBeolvasasa(recept);
            recept.setHozzavalok(hozzavalok);
            receptek.add(recept);
        }
        rs.close();
        kereses.close();
        return receptek;
    }
    
    @Override
    public List<String> etelFajtak() throws SQLException {
        List<String> lista = new ArrayList<>();
        
        Statement etelFajtak = conn.createStatement();
        ResultSet rs = etelFajtak.executeQuery("SELECT recept.Fajta FROM recept GROUP BY recept.Fajta");
        while(rs.next()) {
            lista.add(rs.getString("Fajta"));
        }
        rs.close();
        etelFajtak.close();
        return lista;
    }
    
    @Override
    public void bezar() throws SQLException {
        this.receptBeolvas.close();
        this.receptKiir.close();
        this.recepTorlese.close();
        this.receptModosit.close();

        this.hozzavalokBeolvas.close();
        this.hozzavalokKiir.close();
        this.hozzavaloTorlese.close();
        this.hozzavaloModositas.close();
        
        this.getID.close();
        this.conn.close();
    }
    
}
