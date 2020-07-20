package Popups;

public class PopupReporteCaja extends javax.swing.JDialog {

    public PopupReporteCaja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setOpacity(0.85f);
    }
    
    public PopupReporteCaja(java.awt.Frame parent, boolean modal,String dia,String cantprod,String cantven,String tot) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setOpacity(0.85f);
        Fec.setText(dia);
        Ventas.setText(cantven);
        Prods.setText(cantprod);
        Total.setText(tot);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonAceptar = new rojeru_san.complementos.RSButtonHover();
        ses = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Fec = new javax.swing.JTextField();
        Ventas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Prods = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        Total1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 278));

        jPanel1.setBackground(new java.awt.Color(27, 34, 36));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonAceptar.setBackground(new java.awt.Color(255, 199, 125));
        BotonAceptar.setBorder(null);
        BotonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        BotonAceptar.setText("Aceptar");
        BotonAceptar.setColorHover(new java.awt.Color(255, 187, 97));
        BotonAceptar.setColorText(new java.awt.Color(0, 0, 0));
        BotonAceptar.setColorTextHover(new java.awt.Color(0, 0, 0));
        BotonAceptar.setFont(new java.awt.Font("Andis", 0, 18)); // NOI18N
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 110, -1));

        ses.setFont(new java.awt.Font("Andis", 1, 14)); // NOI18N
        ses.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ses, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, 20));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 30));

        Fec.setEditable(false);
        Fec.setBackground(new java.awt.Color(255, 199, 125));
        Fec.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Fec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Fec.setBorder(null);
        Fec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecActionPerformed(evt);
            }
        });
        jPanel1.add(Fec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 30));

        Ventas.setEditable(false);
        Ventas.setBackground(new java.awt.Color(255, 199, 125));
        Ventas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Ventas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Ventas.setBorder(null);
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });
        jPanel1.add(Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Día");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 50, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ganancia Total");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ventas Realizadas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, 30));

        Prods.setEditable(false);
        Prods.setBackground(new java.awt.Color(255, 199, 125));
        Prods.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Prods.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Prods.setBorder(null);
        Prods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdsActionPerformed(evt);
            }
        });
        jPanel1.add(Prods, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 90, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Productos Vendidos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 30));

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 199, 125));
        Total.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Total.setText("0.0");
        Total.setBorder(null);
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 70, 30));

        Total1.setEditable(false);
        Total1.setBackground(new java.awt.Color(255, 199, 125));
        Total1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total1.setText("$");
        Total1.setBorder(null);
        jPanel1.add(Total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotonAceptarActionPerformed

    private void FecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FecActionPerformed

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VentasActionPerformed

    private void ProdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdsActionPerformed

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
            java.util.logging.Logger.getLogger(PopupReporteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupReporteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupReporteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupReporteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupReporteCaja dialog = new PopupReporteCaja(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover BotonAceptar;
    private javax.swing.JTextField Fec;
    private javax.swing.JTextField Prods;
    private javax.swing.JTextField Total;
    private javax.swing.JTextField Total1;
    private javax.swing.JTextField Ventas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ses;
    // End of variables declaration//GEN-END:variables
}
