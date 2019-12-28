package projem2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class BilgiCinsiyetDegistir extends javax.swing.JFrame {

    Hasta h;

    public BilgiCinsiyetDegistir(Hasta h) {
        initComponents();
        this.h = h;
    }

    public BilgiCinsiyetDegistir() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        erkek = new javax.swing.JRadioButton();
        kadın = new javax.swing.JRadioButton();
        degistir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cinsiyet Degistir");

        jLabel1.setText("Cinsiyet seciniz ");

        buttonGroup1.add(erkek);
        erkek.setText("Erkek");

        buttonGroup1.add(kadın);
        kadın.setText("Kadın");

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
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(degistir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(erkek, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kadın, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(erkek)
                    .addComponent(kadın))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(degistir)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    public String cinsiyet() {
        if (erkek.isSelected()) {
            return "Erkek";
        } else if (kadın.isSelected()) {
            return "Kadın";
        }
        return " ";
    }

    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistirActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT h FROM Hasta h");
        List<Hasta> hastalar = q.getResultList();
        for (Hasta h : hastalar) {
            if (h.equals(this.h)) {
                h.setCinsiyet(cinsiyet());
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
                new BilgiCinsiyetDegistir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton degistir;
    private javax.swing.JRadioButton erkek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton kadın;
    // End of variables declaration//GEN-END:variables
}
