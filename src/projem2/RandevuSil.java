package projem2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class RandevuSil extends javax.swing.JFrame {

    DefaultListModel dlm = new DefaultListModel();

    public RandevuSil() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTC = new javax.swing.JTextField();
        ara = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listRandevu = new javax.swing.JList<>();
        randevuSil = new javax.swing.JButton();
        randevuGüncelle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Randevu Sil & Güncelle");

        jLabel1.setText("T.C. Kimlik NO : ");

        ara.setText("Ara");
        ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                araActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listRandevu);

        randevuSil.setText("Randevuyu Sil");
        randevuSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randevuSilActionPerformed(evt);
            }
        });

        randevuGüncelle.setText("Randevuyu Güncelle");
        randevuGüncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randevuGüncelleActionPerformed(evt);
            }
        });

        jLabel2.setText("Randevular");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(randevuSil, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(randevuGüncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ara))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randevuSil)
                    .addComponent(randevuGüncelle))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_araActionPerformed
        if (txtTC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Randevu görüntülemek için T.C. Kimlik No giriniz ! ");
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Hasta h");
        List<Hasta> hastalar = q.getResultList();

        for (int i = 0; i < hastalar.size(); i++) {
            if (hastalar.get(i).getTcKimlikno().toString().equals(txtTC.getText())) {
                dlm.addElement(hastalar.get(i));
            }
        }
        listRandevu.setModel(dlm);
        em.close();
        emf.close();
    }//GEN-LAST:event_araActionPerformed

    private void randevuSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randevuSilActionPerformed
        if (listRandevu.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Randevu silmek için listeden seçim yapınız !");
        }else{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT r FROM Randevu r");
        List<Randevu> randevular = q.getResultList();
     
        DefaultListModel dlm1 =(DefaultListModel) listRandevu.getModel();
        int id = ((Hasta)dlm1.getElementAt(0)).getHastaId();
              
        for (Randevu r : randevular) {
            if (r.getHastaId().equals(id)) {
                em.remove(r);
                JOptionPane.showMessageDialog(this, "Randevunuz silinmistir. ");
                dlm1.removeAllElements();
            }          
        }
        listRandevu.setModel(dlm1);
        em.getTransaction().commit();       
        em.close();
        emf.close();
        }
    }//GEN-LAST:event_randevuSilActionPerformed

    private void randevuGüncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randevuGüncelleActionPerformed
       if (listRandevu.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Randevu güncellemek için listeden seçim yapınız !");
        }else{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT p FROM Poliklinik p");
        List<Poliklinik> poliklinikler = q.getResultList();

        Query q1 = em.createQuery("SELECT d FROM Doktor d");
        List<Doktor> doktorlar = q1.getResultList();

        DefaultListModel dlm = (DefaultListModel) listRandevu.getModel();
        RandevuGüncelle rg = new RandevuGüncelle((Hasta)dlm.getElementAt(0));
        rg.setVisible(true);

        rg.jLabel9.setText(((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getAdi());
        rg.jLabel10.setText(((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getSoyadi());
        rg.jLabel11.setText(((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getCinsiyet());
        rg.jLabel12.setText(((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getTcKimlikno().toString());
        for (int i = 0; i < poliklinikler.size(); i++) {
            if (((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getPoliklinikId().equals(poliklinikler.get(i).getPoliklinikId())) {
                rg.jLabel13.setText(poliklinikler.get(i).getPoliklinikAdi());
            }
        }
        for (int i = 0; i < doktorlar.size(); i++) {
            if (((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getDoktorId().equals(doktorlar.get(i).getDoktorId())) {
                rg.jLabel14.setText(doktorlar.get(i).getDoktorAdi());
            }
        }
        rg.jLabel15.setText(((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getTarih());
        rg.jLabel16.setText(((Hasta) dlm.getElementAt(listRandevu.getSelectedIndex())).getSaat());

        em.close();
        emf.close();
        dlm.removeAllElements();
       }
    }//GEN-LAST:event_randevuGüncelleActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RandevuSil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JList<String> listRandevu;
    private javax.swing.JButton randevuGüncelle;
    private javax.swing.JButton randevuSil;
    public javax.swing.JTextField txtTC;
    // End of variables declaration//GEN-END:variables

    
}
