package projem2;

public class GirisEkranı extends javax.swing.JFrame {

    RandevuEkle randevuEkle = new RandevuEkle();
    RandevuGöster randevuGöster = new RandevuGöster();
    RandevuSil randevuSil = new RandevuSil();
    
    public GirisEkranı(RandevuEkle re,RandevuGöster rg, RandevuSil rs) {
        initComponents();
        randevuEkle = re;
        randevuGöster = rg;
        randevuSil = rs;
    }
    public GirisEkranı() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ekle = new javax.swing.JButton();
        göster = new javax.swing.JButton();
        silGüncelle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Randevu Giris Sistemi");

        ekle.setText("Randevu Ekle");
        ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleActionPerformed(evt);
            }
        });

        göster.setText("Randevu Göster ");
        göster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gösterActionPerformed(evt);
            }
        });

        silGüncelle.setText("Randevu Sil & Güncelle");
        silGüncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silGüncelleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(silGüncelle, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(göster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ekle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(ekle)
                .addGap(42, 42, 42)
                .addComponent(göster)
                .addGap(41, 41, 41)
                .addComponent(silGüncelle)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleActionPerformed
        randevuEkle.setVisible(true);
    }//GEN-LAST:event_ekleActionPerformed

    private void gösterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gösterActionPerformed
        randevuGöster.setVisible(true);
    }//GEN-LAST:event_gösterActionPerformed

    private void silGüncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silGüncelleActionPerformed
        randevuSil.setVisible(true);
    }//GEN-LAST:event_silGüncelleActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GirisEkranı().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekle;
    private javax.swing.JButton göster;
    private javax.swing.JButton silGüncelle;
    // End of variables declaration//GEN-END:variables
}
