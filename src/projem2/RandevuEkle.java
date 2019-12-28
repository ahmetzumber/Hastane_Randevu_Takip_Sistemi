/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projem2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RandevuEkle extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultComboBoxModel dcmPol = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmDok = new DefaultComboBoxModel();
    List<Poliklinik> poliklinikler;
    List<PoliklinikDetay> doktorİsimleri1;
    List<PoliklinikDetay> doktorİsimleri2;
    List<PoliklinikDetay> doktorİsimleri3;

    public RandevuEkle() {
        initComponents();
        dtm.setColumnIdentifiers(new String[]{"HASTA_ID", "AD", "SOYAD", "CİNSİYET", "T.C. KIMLIK NO", "POLIKLINIK", "DOKTOR", "TARIH", "SAAT"});

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
            dcmPol.addElement(p);
        }
        comboPolik.setModel(dcmPol);

        em.close();
        emf.close();

        tableHasta.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHasta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAD = new javax.swing.JTextField();
        txtSOYAD = new javax.swing.JTextField();
        txtTC = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        comboDoktor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTarih = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSaat = new javax.swing.JTextField();
        kayitOlustur = new javax.swing.JButton();
        comboPolik = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Randevu Ekle");

        tableHasta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableHasta);

        jLabel1.setText("Ad :");

        jLabel2.setText("Soyad :");

        jLabel3.setText("Cinsiyet :");

        jLabel4.setText("T.C. Kimlik No");

        jLabel5.setText("Poliklinik :");

        txtAD.setText("Ahmet");

        txtSOYAD.setText("Zumber");

        txtTC.setText("12341234123");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Erkek");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Kadın");

        jLabel6.setText("Doktor :");

        jLabel7.setText("Tarih :");

        txtTarih.setText("12.02.2019");

        jLabel8.setText("Saat :");

        txtSaat.setText("12.30");

        kayitOlustur.setText("Kayıt Olustur");
        kayitOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kayitOlusturActionPerformed(evt);
            }
        });

        comboPolik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kalp ve Damar Hastalıkları", "Fizik Tedavi ve Rehabilitasyon", "Kas ve Sinir Hastalıkları" }));
        comboPolik.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPolikItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSOYAD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(txtAD, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboPolik, 0, 240, Short.MAX_VALUE)
                                .addComponent(comboDoktor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTarih, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(txtSaat, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(kayitOlustur, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSOYAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboPolik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDoktor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSaat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kayitOlustur)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String cinsiyet() {
        if (jRadioButton1.isSelected()) {
            return "Erkek";
        } else if (jRadioButton3.isSelected()) {
            return "Kadın";
        }
        return " ";
    }

    public boolean regex(String desen, String kelime) {
        Pattern pattern = Pattern.compile(desen);
        Matcher matcher = pattern.matcher(kelime);
        return matcher.find();
    }

    public final String saatRegex = "1[012]|[1-9].[0-5][0-9]$";

    public boolean saatRegex(String saat) {
        Pattern pattern = Pattern.compile(saatRegex);
        Matcher matcher = pattern.matcher(saat);
        return matcher.find();
    }

    private void kayitOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayitOlusturActionPerformed
        if (txtAD.getText().isEmpty() || txtSOYAD.getText().isEmpty() || cinsiyet().isEmpty() || txtTC.getText().isEmpty() || comboPolik.getSelectedIndex() == -1 || comboDoktor.getSelectedIndex() == -1 || txtTarih.getText().isEmpty() || txtSaat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Randevunuzda eksik bilginiz var !!");
        } else {
            int seçim = JOptionPane.showConfirmDialog(this, "Bunu eklemek istiyor musunuz ?", "UYARI !", JOptionPane.YES_OPTION);

            if (seçim == JOptionPane.YES_OPTION) {

                Hasta h = new Hasta();
                Randevu r = new Randevu();

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJEM2PU");
                EntityManager em = emf.createEntityManager();
                EntityManager em1 = emf.createEntityManager();

                em.getTransaction().begin();

                Query q = em.createQuery("SELECT h FROM Hasta h");
                List<Hasta> hastalar = q.getResultList();

                Query q1 = em.createQuery("SELECT h.hastaId FROM Hasta h");
                List<Integer> hastaIDleri = q1.getResultList();

                Query q2 = em1.createQuery("SELECT r.randevuId FROM Randevu r");
                List<Integer> randevuIdleri = q2.getResultList();

                //--------------------------HASTA ID VE RANDEVU ID KONTROLLERİ---------------------------------//
                int max = 1;
                for (Integer hastaID : hastaIDleri) {
                    if (hastaID > max) {
                        max = hastaID;
                    }
                }
                max++;
                h.setHastaId(max);
                r.setHastaId(h.getHastaId());

                int maxRandevuID = 1;
                for (Integer randevuID : randevuIdleri) {
                    if (randevuID > maxRandevuID) {
                        maxRandevuID = randevuID;
                    }
                }
                maxRandevuID++;
                r.setRandevuId(maxRandevuID);

                for (Hasta hasta : hastalar) {
                    if (hasta.getTcKimlikno().equals(BigInteger.valueOf(Long.valueOf(txtTC.getText())))) {
                        JOptionPane.showMessageDialog(this, "Aynı T.C. Kimlik numarasına sahip iki kişi olamaz ya da aynı ID de iki hasta olamaz ! ");
                        return;
                    }
                }

                //--------------------------------------------------------------------------------------------------// 
                if (!regex("([1-9]{1}[0-9]{10})$", txtTC.getText()) && ((Hasta) q.getSingleResult()).getTcKimlikno().equals(txtTC.getText())) {
                    JOptionPane.showMessageDialog(this, "Aynı numaraya sahip iki kişi olamaz ya da yanlış bir T.C. kimlik no girdiniz !");
                    return;
                } else {
                    h.setTcKimlikno(BigInteger.valueOf(Long.valueOf(txtTC.getText())));
                }
                //--------------------------------------------------------------------------------------------------//
                if (!regex("[A-Za-z$]", txtAD.getText())) {
                    JOptionPane.showMessageDialog(this, "Bu alan boş bırakılamaz ya da yanlış bir isim girdiniz !");
                    return;
                } else {
                    h.setAdi(txtAD.getText());
                }
                //--------------------------------------------------------------------------------------------------//
                if (!regex("[A-Za-z$]", txtSOYAD.getText())) {
                    JOptionPane.showMessageDialog(this, "Bu alan boş bırakılamaz ya da yanlış bir soyad girdiniz !");
                    return;
                } else {
                    h.setSoyadi(txtSOYAD.getText());
                }
                //--------------------------------------------------------------------------------------------------//
                h.setCinsiyet(cinsiyet());
                //--------------------------------------------------------------------------------------------------//  
                h.setPoliklinikId(((Poliklinik) comboPolik.getSelectedItem()).getPoliklinikId());
                r.setPoliklinikId(((Poliklinik) comboPolik.getSelectedItem()).getPoliklinikId());
                //--------------------------------------------------------------------------------------------------// 
                h.setDoktorId(((PoliklinikDetay) comboDoktor.getSelectedItem()).getDoktorId());
                r.setDoktorId(((PoliklinikDetay) comboDoktor.getSelectedItem()).getDoktorId());
                //--------------------------------------------------------------------------------------------------//
                if (!regex("\\d{2}.\\d{2}.\\d{4}$", txtTarih.getText())) {
                    JOptionPane.showMessageDialog(this, "Bu alan boş bırakılamaz ya da yanlış bir tarih girdiniz !");
                    return;
                } else {
                    h.setTarih(txtTarih.getText());
                }
                //--------------------------------------------------------------------------------------------------//
                if (!saatRegex(txtSaat.getText())) {
                    JOptionPane.showMessageDialog(this, "Bu alan boş bırakılamaz ya da yanlış bir saat girdiniz !");
                    return;
                } else {
                    h.setSaat(txtSaat.getText());
                }

                //--------------------------------------------------------------------------------------------------//
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("/Users/mac/NetBeansProjects/PROJEM2/Hastalar/Hastalar.txt/")));
                    ObjectOutputStream oos1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("/Users/mac/NetBeansProjects/PROJEM2/Hastalar/Randevular.txt/")));
                    oos.writeObject(h);
                    oos1.writeObject(r);
                    oos.close();
                    oos1.close();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RandevuEkle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RandevuEkle.class.getName()).log(Level.SEVERE, null, ex);
                }
                //--------------------------------------------------------------------------------------------------//      

                em.persist(h);

                em1.getTransaction().begin();
                em1.persist(r);

                em.getTransaction().commit();
                em1.getTransaction().commit();

                em.close();
                em1.close();
                emf.close();

                dtm.addRow(new String[]{String.valueOf(h.getHastaId()), h.getAdi(), h.getSoyadi(), h.getCinsiyet(), String.valueOf(h.getTcKimlikno()), String.valueOf(((Poliklinik) comboPolik.getSelectedItem()).getPoliklinikId()), String.valueOf(((PoliklinikDetay) comboDoktor.getSelectedItem()).getDoktorId()), h.getTarih(), h.getSaat()});
                tableHasta.setModel(dtm);
            }
        }
    }//GEN-LAST:event_kayitOlusturActionPerformed

    private void comboPolikItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPolikItemStateChanged
        dcmDok.removeAllElements();
        if (((Poliklinik) comboPolik.getSelectedItem()).getPoliklinikAdi().equals("Kalp ve Damar Hastalıkları")) {
            for (PoliklinikDetay d1 : doktorİsimleri1) {
                dcmDok.addElement(d1);
            }
        }

        if (((Poliklinik) comboPolik.getSelectedItem()).getPoliklinikAdi().equals("Fizik Tedavi ve Rehabilitasyon")) {
            for (PoliklinikDetay d2 : doktorİsimleri2) {
                dcmDok.addElement(d2);
            }
        }

        if (((Poliklinik) comboPolik.getSelectedItem()).getPoliklinikAdi().equals("Kas ve Sinir Hastalıkları")) {
            for (PoliklinikDetay d3 : doktorİsimleri3) {
                dcmDok.addElement(d3);

            }
        }
        comboDoktor.setModel(dcmDok);
    }//GEN-LAST:event_comboPolikItemStateChanged

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
            java.util.logging.Logger.getLogger(RandevuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RandevuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RandevuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RandevuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RandevuEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> comboDoktor;
    private javax.swing.JComboBox<String> comboPolik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kayitOlustur;
    private javax.swing.JTable tableHasta;
    private javax.swing.JTextField txtAD;
    private javax.swing.JTextField txtSOYAD;
    private javax.swing.JTextField txtSaat;
    private javax.swing.JTextField txtTC;
    private javax.swing.JTextField txtTarih;
    // End of variables declaration//GEN-END:variables
}
