/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg43_01_nagy_feladat_recept_konyv;

import java.awt.event.WindowEvent;
import javax.swing.DefaultListModel;

/**
 *
 * @author takac
 */
public class ElkeszetesDialog extends javax.swing.JDialog {

    private static Recept recept;
    private static int adag;
    private DefaultListModel<Hozzavalo> alapListModel = new DefaultListModel<>();
    private DefaultListModel<Hozzavalo> modositottListModel = new DefaultListModel<>();
    
    public ElkeszetesDialog(java.awt.Frame parent, boolean modal, Recept recept, int adag) {
        super(parent, modal);
        initComponents();
        alapHozzavalokLista.setModel(alapListModel);
        modositottHozzavalokLista.setModel(modositottListModel);
        setLocationRelativeTo(null);
        ElkeszetesDialog.recept = recept;
        ElkeszetesDialog.adag = adag;
        kinezetModosito();
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
        jLabel2 = new javax.swing.JLabel();
        lbReceptNeve = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfOsszesen = new javax.swing.JTextField();
        lbAdagElkeszetese = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfModositottOsszesen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        taElkeszitese = new java.awt.TextArea();
        btVissza = new javax.swing.JButton();
        btKilep = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alapHozzavalokLista = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        modositottHozzavalokLista = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recept elkészítése");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("elkészítéséhez szükséges:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Recept neve:");

        lbReceptNeve.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Összesen:");
        jLabel7.setVerifyInputWhenFocusTarget(false);

        tfOsszesen.setEditable(false);
        tfOsszesen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbAdagElkeszetese.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Hozzávalók:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Hozzávalók:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Összesen:");

        tfModositottOsszesen.setEditable(false);
        tfModositottOsszesen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Elkészítése:");

        taElkeszitese.setEditable(false);
        taElkeszitese.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btVissza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btVissza.setText("Vissza");
        btVissza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisszaActionPerformed(evt);
            }
        });

        btKilep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btKilep.setText("Kilép");
        btKilep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKilepActionPerformed(evt);
            }
        });

        alapHozzavalokLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        alapHozzavalokLista.setPreferredSize(new java.awt.Dimension(266, 100));
        jScrollPane1.setViewportView(alapHozzavalokLista);

        modositottHozzavalokLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modositottHozzavalokLista.setPreferredSize(new java.awt.Dimension(266, 100));
        jScrollPane2.setViewportView(modositottHozzavalokLista);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("1 adag");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("elkészítéséhez szükséges:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbReceptNeve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(taElkeszitese, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(22, 22, 22)
                            .addComponent(tfModositottOsszesen, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(22, 22, 22)
                            .addComponent(tfOsszesen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btVissza)
                            .addGap(18, 18, 18)
                            .addComponent(btKilep, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbAdagElkeszetese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)))
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btKilep, btVissza});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbReceptNeve)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfOsszesen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbAdagElkeszetese)
                    .addComponent(jLabel9))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfModositottOsszesen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taElkeszitese, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btKilep)
                    .addComponent(btVissza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, lbAdagElkeszetese, lbReceptNeve, tfModositottOsszesen, tfOsszesen});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btKilep, btVissza});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btKilepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKilepActionPerformed
      this.getParent().dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btKilepActionPerformed

    private void btVisszaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisszaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btVisszaActionPerformed

    private void kinezetModosito() {
       lbReceptNeve.setText(recept.getNev());
       int osszeg = 0;
        for (int i = 0; i < recept.getHozzavalok().size(); i++) {
            alapListModel.addElement(recept.getHozzavalok().get(i));
            osszeg += recept.getHozzavalok().get(i).getAr();
        }
        tfOsszesen.setText(osszeg + " Forint.");
        lbAdagElkeszetese.setText(adag + " adag");
        osszeg = 0;

        for (int i = 0; i < recept.getHozzavalok().size(); i++) {
            Hozzavalo hozzavalo = new Hozzavalo(recept.getHozzavalok().get(i).getMennyiseg(), recept.getHozzavalok().get(i).getMertekegyseg(), recept.getHozzavalok().get(i).getAlapanyag(), recept.getHozzavalok().get(i).getAr());
            hozzavalo.setMennyiseg(hozzavalo.getMennyiseg() * adag);
            hozzavalo.setAr(hozzavalo.getAr() * adag);
            modositottListModel.addElement(hozzavalo);
            osszeg += hozzavalo.getAr();
        }
        tfModositottOsszesen.setText(osszeg + " Forint lesz.");
        taElkeszitese.setText(recept.getElkeszitese());
        
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Hozzavalo> alapHozzavalokLista;
    private javax.swing.JButton btKilep;
    private javax.swing.JButton btVissza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAdagElkeszetese;
    private javax.swing.JLabel lbReceptNeve;
    private javax.swing.JList<Hozzavalo> modositottHozzavalokLista;
    private java.awt.TextArea taElkeszitese;
    private javax.swing.JTextField tfModositottOsszesen;
    private javax.swing.JTextField tfOsszesen;
    // End of variables declaration//GEN-END:variables
}
