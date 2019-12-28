/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projem2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mac
 */
public class RandevuGöster extends javax.swing.JFrame {

    DefaultListModel dlm = new DefaultListModel();
    RandevuEkle randevu = new RandevuEkle();

    public RandevuGöster() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDoktorAra = new javax.swing.JTextField();
        ara = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listHasta = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        randevuGöster = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Randevu Göster");

        jLabel1.setText("Doktor İsmi Giriniz :  ");

        ara.setText("Ara");
        ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                araActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listHasta);

        jLabel2.setText("Hasta Randevu Listesi");

        randevuGöster.setText("Randevuyu Göster");
        randevuGöster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randevuGösterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDoktorAra, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ara, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(randevuGöster, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDoktorAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ara))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(randevuGöster)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randevuGösterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randevuGösterActionPerformed
        if (listHasta.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Randevu görüntülemek için lütfen arama yapınız...");
        }else{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT p FROM Poliklinik p");
        List<Poliklinik> poliklinikler = q.getResultList();
        
        Query q1 = em.createQuery("SELECT d FROM Doktor d");
        List<Doktor> doktorlar = q1.getResultList();

        HastaBilgileri hb = new HastaBilgileri();
        hb.setVisible(true);

        hb.jLabel9.setText(((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getAdi());
        hb.jLabel10.setText(((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getSoyadi());
        hb.jLabel11.setText(((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getCinsiyet());
        hb.jLabel12.setText(((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getTcKimlikno().toString());
        for (int i = 0; i < poliklinikler.size(); i++) {
            if (((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getPoliklinikId().equals(poliklinikler.get(i).getPoliklinikId())) {
                hb.jLabel13.setText(poliklinikler.get(i).getPoliklinikAdi());
            }
        }
        for (int i = 0; i < doktorlar.size(); i++) {
            if (((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getDoktorId().equals(doktorlar.get(i).getDoktorId())) {
                hb.jLabel14.setText(doktorlar.get(i).getDoktorAdi());
            }
        }
        hb.jLabel15.setText(((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getTarih());
        hb.jLabel16.setText(((Hasta) dlm.getElementAt(listHasta.getSelectedIndex())).getSaat());
        em.close();
        emf.close();
        }
    }//GEN-LAST:event_randevuGösterActionPerformed

    private void araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_araActionPerformed
        if (txtDoktorAra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Randevu aramak içi lütfen doktor adı giriniz !");
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT d FROM Doktor d");
        List<Doktor> doktorlar = q.getResultList();

        Query q1 = em.createQuery("SELECT h FROM Hasta h");
        List<Hasta> hastalar = q1.getResultList();

        for (int i = 0; i < doktorlar.size(); i++) {
            for (int j = 0; j < hastalar.size(); j++) {
                if (doktorlar.get(i).getDoktorId().equals(hastalar.get(j).getDoktorId()) && doktorlar.get(i).getDoktorAdi().equals(txtDoktorAra.getText())) {
                    dlm.addElement(hastalar.get(j));
                }
            }
        }
        listHasta.setModel(dlm);
        em.close();
        emf.close();
        
    }//GEN-LAST:event_araActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RandevuGöster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RandevuGöster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RandevuGöster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RandevuGöster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RandevuGöster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listHasta;
    private javax.swing.JButton randevuGöster;
    private javax.swing.JTextField txtDoktorAra;
    // End of variables declaration//GEN-END:variables
}
