package projem2;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class BilgiSoyadDegistir extends javax.swing.JFrame {

    Hasta h;
    public BilgiSoyadDegistir(Hasta h) {
        initComponents();
        this.h = h;
    }

    public BilgiSoyadDegistir() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSoyad = new javax.swing.JTextField();
        degistir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Soyad Degistir");

        jLabel1.setText("Yeni bir soyad giriniz");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(degistir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(degistir)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public boolean regex(String desen, String kelime) {
        Pattern pattern = Pattern.compile(desen);
        Matcher matcher = pattern.matcher(kelime);
        return matcher.find();
    }

    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistirActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT h FROM Hasta h");
        List<Hasta> hastalar = q.getResultList();
        for (Hasta h : hastalar) {
            if (h.equals(this.h)) {
                h.setSoyadi(txtSoyad.getText());
                JOptionPane.showMessageDialog(this, "Randevunuz güncellenmiştir..");
                break;
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }//GEN-LAST:event_degistirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilgiSoyadDegistir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton degistir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtSoyad;
    // End of variables declaration//GEN-END:variables
}
