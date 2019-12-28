package projem2;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class BilgiPoliklinikDegistir extends javax.swing.JFrame {

    DefaultComboBoxModel dcm = new DefaultComboBoxModel();
    List<Poliklinik> poliklinikler;
    List<PoliklinikDetay> doktorİsimleri1;
    List<PoliklinikDetay> doktorİsimleri2;
    List<PoliklinikDetay> doktorİsimleri3;
    Hasta h;

    public BilgiPoliklinikDegistir(Hasta h) {
        initComponents();
        this.h = h;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();

        // Poliklinikleri secme
        Query q1 = em.createQuery("SELECT p FROM Poliklinik p");
        poliklinikler = q1.getResultList();

        // Kalp Damar Doktorları
        Query q2 = em.createQuery("SELECT pd FROM PoliklinikDetay pd WHERE pd.poliklinikId=1");
        doktorİsimleri1 = q2.getResultList();

        // Fizik Tedavi Doktorları
        Query q3 = em.createQuery("SELECT pd FROM PoliklinikDetay pd WHERE pd.poliklinikId=2");
        doktorİsimleri2 = q3.getResultList();

        // Kas ve Sinir Doktorları
        Query q4 = em.createQuery("SELECT pd FROM PoliklinikDetay pd WHERE pd.poliklinikId=3");
        doktorİsimleri3 = q4.getResultList();

        for (Poliklinik p : poliklinikler) {
            dcm.addElement(p);
        }
        comboPolik.setModel(dcm);
        em.close();
        emf.close();
    }

    public BilgiPoliklinikDegistir() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboPolik = new javax.swing.JComboBox<>();
        degistir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Poliklinik Degistir");

        jLabel1.setText("Poliklinik seciniz");

        comboPolik.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPolikItemStateChanged(evt);
            }
        });

        degistir.setText("Degistir");
        degistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degistirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(comboPolik, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(degistir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboPolik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(degistir)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistirActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q = em.createQuery("SELECT h FROM Hasta h");
        List<Hasta> hastalar = q.getResultList();
        Query q1 = em.createQuery("SELECT r FROM Randevu r");
        List<Randevu> randevular = q1.getResultList();

        for (Hasta h : hastalar) {
            if (h.equals(this.h) ) {
                h.setPoliklinikId(((Poliklinik) comboPolik.getSelectedItem()).getPoliklinikId());
                JOptionPane.showMessageDialog(this, "Randevunuz güncellenmiştir..");
                break;
            }
        }
        for (Randevu r : randevular) {
            if (r.getHastaId().equals(h.getHastaId())) {
                r.setPoliklinikId(((Poliklinik)comboPolik.getSelectedItem()).getPoliklinikId());
                JOptionPane.showMessageDialog(this, "Randevunuz güncellenmistir...");
                break;
            }
        }
        h.setPoliklinikId(((Poliklinik)comboPolik.getSelectedItem()).getPoliklinikId());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }//GEN-LAST:event_degistirActionPerformed

    private void comboPolikItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPolikItemStateChanged
       
       
    }//GEN-LAST:event_comboPolikItemStateChanged

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilgiPoliklinikDegistir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> comboPolik;
    private javax.swing.JButton degistir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
