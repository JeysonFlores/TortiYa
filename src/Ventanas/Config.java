package Ventanas;
import Clases.Conexion;
import javax.swing.JOptionPane;
import Paneles.AcercaDe;
import Paneles.BDConfig;
import javax.swing.ImageIcon;

public class Config extends javax.swing.JFrame {
    
    Conexion con = new Conexion();
    
    public Config() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("src/Iconos/LogoApp.png").getImage());
        BDConfig BDC2 = new BDConfig(this);
        PanelPrincipal.setLayout(new java.awt.BorderLayout());
        PanelPrincipal.removeAll();
        PanelPrincipal.add(BDC2);
        PanelPrincipal.revalidate();
        this.setOpacity(0.97f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        PanelBotonBDC = new javax.swing.JPanel();
        BotonBDC = new javax.swing.JButton();
        PanelBotonAD = new javax.swing.JPanel();
        BotonAD = new javax.swing.JButton();
        PanelBotonTL = new javax.swing.JPanel();
        BotonTL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setBackground(new java.awt.Color(27, 34, 36));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 470));

        jPanel1.setBackground(new java.awt.Color(20, 26, 27));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBotonBDC.setBackground(new java.awt.Color(255, 199, 125));
        PanelBotonBDC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonBDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/BD45.png"))); // NOI18N
        BotonBDC.setBorderPainted(false);
        BotonBDC.setContentAreaFilled(false);
        BotonBDC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonBDCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonBDCMouseExited(evt);
            }
        });
        BotonBDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBDCActionPerformed(evt);
            }
        });
        PanelBotonBDC.add(BotonBDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        jPanel1.add(PanelBotonBDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        PanelBotonAD.setBackground(new java.awt.Color(20, 26, 27));
        PanelBotonAD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/about45.png"))); // NOI18N
        BotonAD.setText("   ");
        BotonAD.setBorderPainted(false);
        BotonAD.setContentAreaFilled(false);
        BotonAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonADMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonADMouseExited(evt);
            }
        });
        BotonAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonADActionPerformed(evt);
            }
        });
        PanelBotonAD.add(BotonAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        jPanel1.add(PanelBotonAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, 70));

        PanelBotonTL.setBackground(new java.awt.Color(21, 28, 30));
        PanelBotonTL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ToLOGIN45.png"))); // NOI18N
        BotonTL.setText("   ");
        BotonTL.setBorderPainted(false);
        BotonTL.setContentAreaFilled(false);
        BotonTL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonTLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonTLMouseExited(evt);
            }
        });
        BotonTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTLActionPerformed(evt);
            }
        });
        PanelBotonTL.add(BotonTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        jPanel1.add(PanelBotonTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 60, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 60, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonADActionPerformed
        PanelBotonBDC.setBackground(new java.awt.Color(20,26,27));
        PanelBotonAD.setBackground(new java.awt.Color(255,199,125));
        AcercaDe AD = new AcercaDe();
        PanelPrincipal.setLayout(new java.awt.BorderLayout());
        PanelPrincipal.removeAll();
        PanelPrincipal.add(AD);
        PanelPrincipal.revalidate();
    }//GEN-LAST:event_BotonADActionPerformed

    private void BotonBDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBDCActionPerformed
        PanelBotonBDC.setBackground(new java.awt.Color(255,199,125));
        PanelBotonAD.setBackground(new java.awt.Color(20,26,27));
        BDConfig BDC = new BDConfig(this);
        PanelPrincipal.setLayout(new java.awt.BorderLayout());
        PanelPrincipal.removeAll();
        PanelPrincipal.add(BDC);
        PanelPrincipal.revalidate();
    }//GEN-LAST:event_BotonBDCActionPerformed

    private void BotonTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTLActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);        
    }//GEN-LAST:event_BotonTLActionPerformed

    private void BotonADMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonADMouseEntered
        if(PanelBotonAD.getBackground().equals(new java.awt.Color(255,199,125))){
            //gg
        }
        else{
        PanelBotonAD.setBackground(new java.awt.Color(14,19,19));
        }
    }//GEN-LAST:event_BotonADMouseEntered

    private void BotonADMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonADMouseExited
        if(PanelBotonAD.getBackground().equals(new java.awt.Color(255,199,125))){
            //gg
        }
        else{
            PanelBotonAD.setBackground(new java.awt.Color(20,26,27));
        }
    }//GEN-LAST:event_BotonADMouseExited

    private void BotonBDCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBDCMouseEntered
        if(PanelBotonBDC.getBackground().equals(new java.awt.Color(255,199,125))){
            //gg
        }
        else{
        PanelBotonBDC.setBackground(new java.awt.Color(14,19,19));
        }
    }//GEN-LAST:event_BotonBDCMouseEntered

    private void BotonBDCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBDCMouseExited
        if(PanelBotonBDC.getBackground().equals(new java.awt.Color(255,199,125))){
            //gg
        }
        else{
            PanelBotonBDC.setBackground(new java.awt.Color(20,26,27));
        }
    }//GEN-LAST:event_BotonBDCMouseExited

    private void BotonTLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonTLMouseEntered
            PanelBotonTL.setBackground(new java.awt.Color(14,19,19));
        
    }//GEN-LAST:event_BotonTLMouseEntered

    private void BotonTLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonTLMouseExited
        PanelBotonTL.setBackground(new java.awt.Color(21,28,30));
    }//GEN-LAST:event_BotonTLMouseExited


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
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Config().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAD;
    private javax.swing.JButton BotonBDC;
    private javax.swing.JButton BotonTL;
    private javax.swing.JPanel PanelBotonAD;
    private javax.swing.JPanel PanelBotonBDC;
    private javax.swing.JPanel PanelBotonTL;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
