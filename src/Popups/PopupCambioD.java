package Popups;
import Clases.Validaciones;

public class PopupCambioD extends javax.swing.JDialog {
    
    Validaciones val = new Validaciones();
    boolean flag = false;
    
    public PopupCambioD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public PopupCambioD(java.awt.Frame parent, boolean modal, String tot) {
        super(parent, modal);
        initComponents();
        Total.setText(tot);
        this.setLocationRelativeTo(null);
        this.setOpacity(0.85f);
    }
    
    private void Proceso() {
        String Pago = txt.getText().toString();
        if(val.ValidarFloat(Pago)==true && val.ValidarNums(Pago)==true){
            if (Float.parseFloat(Pago) >= Float.parseFloat(Total.getText())) {
                float camb = Float.parseFloat(Total.getText()) - Float.parseFloat(Pago);
                Cambio.setText((-1*camb) + "");
                Pagoa.setText(Pago);
                txt.setEnabled(false);
                flag = true;
                alerta.setText("");
            } 
            else {
                txt.setText("");
                alerta.setText("Pago insuficiente");
            }
        }
        else{
            txt.setText("");
            alerta.setText("Caracteres Inválidos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonAceptar = new rojeru_san.complementos.RSButtonHover();
        txt = new app.bolivia.swing.JCTextField();
        Total = new javax.swing.JTextField();
        Total1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Pagoa = new javax.swing.JTextField();
        Total3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Cambio = new javax.swing.JTextField();
        Total5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        alerta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

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
        jPanel1.add(BotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 100, -1));

        txt.setPlaceholder("                                 Ingrese pago");
        jPanel1.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 310, -1));

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 199, 125));
        Total.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Total.setText("0.0");
        Total.setBorder(null);
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 60, 40));

        Total1.setEditable(false);
        Total1.setBackground(new java.awt.Color(255, 199, 125));
        Total1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total1.setText("$");
        Total1.setBorder(null);
        jPanel1.add(Total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 30, 40));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 50, 40));

        Pagoa.setEditable(false);
        Pagoa.setBackground(new java.awt.Color(255, 199, 125));
        Pagoa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Pagoa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Pagoa.setText("0.0");
        Pagoa.setBorder(null);
        jPanel1.add(Pagoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 60, 40));

        Total3.setEditable(false);
        Total3.setBackground(new java.awt.Color(255, 199, 125));
        Total3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total3.setText("$");
        Total3.setBorder(null);
        jPanel1.add(Total3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 30, 40));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pago");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 50, 40));

        Cambio.setEditable(false);
        Cambio.setBackground(new java.awt.Color(255, 199, 125));
        Cambio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Cambio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Cambio.setText("0.0");
        Cambio.setBorder(null);
        jPanel1.add(Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 60, 40));

        Total5.setEditable(false);
        Total5.setBackground(new java.awt.Color(255, 199, 125));
        Total5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total5.setText("$");
        Total5.setBorder(null);
        jPanel1.add(Total5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 30, 40));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cambio");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 60, 40));

        alerta.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(alerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        if (flag == false) {
            Proceso();
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_BotonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(PopupCambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupCambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupCambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupCambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupCambioD dialog = new PopupCambioD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Cambio;
    private javax.swing.JTextField Pagoa;
    private javax.swing.JTextField Total;
    private javax.swing.JTextField Total1;
    private javax.swing.JTextField Total3;
    private javax.swing.JTextField Total5;
    private javax.swing.JLabel alerta;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private app.bolivia.swing.JCTextField txt;
    // End of variables declaration//GEN-END:variables
}
