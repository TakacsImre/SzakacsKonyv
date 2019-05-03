/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg43_01_nagy_feladat_recept_konyv;

import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author takac
 */
public class MenuDialog extends javax.swing.JDialog {
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private static SzakacsKonyvDAO adatbazisKezelo;
    private boolean oke;
    private String fajta;
    
    public MenuDialog(java.awt.Frame parent, boolean modal, SzakacsKonyvDAO adatbazisKezelo) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.adatbazisKezelo = adatbazisKezelo;
        etelekFajtai.setModel(listModel);
        try {
            beOlvas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hiba az ételek fajtája beolvasása közben!", "Hiba!", JOptionPane.ERROR_MESSAGE);
        } 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        etelekFajtai = new javax.swing.JList<>();
        btOke = new javax.swing.JButton();
        btMegsem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Az ételek fajtái:");

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        etelekFajtai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(etelekFajtai);

        btOke.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btOke.setText("Oké");
        btOke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkeActionPerformed(evt);
            }
        });

        btMegsem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btMegsem.setText("Mégsem");
        btMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegsemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 220, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btOke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMegsem, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btOke, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btMegsem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btMegsem, btOke});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkeActionPerformed
        kivalasztEllenor();
        if(this.oke == true) {
            this.fajta = etelekFajtai.getSelectedValue();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btOkeActionPerformed

    private void btMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMegsemActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btMegsemActionPerformed
    
    private void beOlvas() throws SQLException {
        List<String> lista = adatbazisKezelo.etelFajtak();
        if (lista.isEmpty()) {
            etelekFajtai.setForeground(new java.awt.Color(153, 153, 153));
            etelekFajtai.setEnabled(false);
            listModel.addElement("Egyenlőre nincs az adatbázisban recept, adjon hozzá új receptet!");
        } else {
            for (String etelFajta : lista) {
                listModel.addElement(etelFajta);
            }
        }
    }
    
    private void kivalasztEllenor() {
        String fajta = etelekFajtai.getSelectedValue();
        if (fajta == null) {
            JOptionPane.showMessageDialog(rootPane, "Kérem válassza ki a Menüben hogy milyen fajta ételeket szeretne megnézni vagy kattintson a 'Mégsem' gombra!", "Értesítés!", JOptionPane.INFORMATION_MESSAGE);
            this.oke = false;
        } else {
            this.oke = true;
        }
    }
    
    public String getFajta() {
        return this.fajta;
    }
    
    public boolean getOke() {
        return this.oke;
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMegsem;
    private javax.swing.JButton btOke;
    private javax.swing.JList<String> etelekFajtai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}