package projem2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class BilgiDoktorDegistir extends javax.swing.JFrame {

    DefaultComboBoxModel dcm = new DefaultComboBoxModel();
    Hasta h;
    BilgiPoliklinikDegistir bp;
    
    public BilgiDoktorDegistir(Hasta h, BilgiPoliklinikDegistir bp) {
        initComponents();
        this.h = h;
        this.bp = bp;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
       
        // Kalp Damar Doktorları
        Query q2 = em.createQuery("SELECT pd FROM PoliklinikDetay pd WHERE pd.poliklinikId=1");
        List<PoliklinikDetay> doktorİsimleri1 = q2.getResultList();

        // Fizik Tedavi Doktorları
        Query q3 = em.createQuery("SELECT pd FROM PoliklinikDetay pd WHERE pd.poliklinikId=2");
        List<PoliklinikDetay> doktorİsimleri2 = q3.getResultList();

        // Kas ve Sinir Doktorları
        Query q4 = em.createQuery("SELECT pd FROM PoliklinikDetay pd WHERE pd.poliklinikId=3");
        List<PoliklinikDetay> doktorİsimleri3 = q4.getResultList();

        if (h.equals(this.h) && h.getPoliklinikId() == 1) {
            for (PoliklinikDetay d1 : doktorİsimleri1) {
                dcm.addElement(d1);
            }
        } else if (h.equals(this.h) && h.getPoliklinikId().equals(2)) {
            for (PoliklinikDetay d2 : doktorİsimleri2) {
                dcm.addElement(d2);
            }
        } else if (h.equals(this.h) && h.getPoliklinikId().equals(3)) {
            for (PoliklinikDetay d3 : doktorİsimleri3) {
                dcm.addElement(d3);
            }

        }
        comboDoktor.setModel(dcm);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public BilgiDoktorDegistir() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboDoktor = new javax.swing.JComboBox<>();
        degistir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doktor Degistir");

        jLabel1.setText("Doktor seçiniz");

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
                        .addComponent(comboDoktor, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(comboDoktor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(degistir)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistirActionPerformed
       
            h.setDoktorId(((PoliklinikDetay) comboDoktor.getSelectedItem()).getDoktorId());           
            JOptionPane.showMessageDialog(this, "Randevunuz güncellenmiştir..");
        
    }//GEN-LAST:event_degistirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilgiDoktorDegistir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> comboDoktor;
    private javax.swing.JButton degistir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
