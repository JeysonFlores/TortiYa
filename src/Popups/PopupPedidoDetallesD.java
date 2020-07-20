package Popups;
import Clases.Conexion;
import java.sql.Connection;

public class PopupPedidoDetallesD extends javax.swing.JDialog {

    public PopupPedidoDetallesD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public PopupPedidoDetallesD(java.awt.Frame parent, boolean modal,Conexion conexion,Connection con,String idped,String Fecha,String Clien,String Empl,String tot) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.setOpacity(0.96f);
        ID.setText(idped);
        Fec.setText(Fecha);
        Cliente.setText(Clien);
        Empleado.setText(Empl);
        Total.setText(tot);
        TablaD.setModel(conexion.getPedidoDetalles(con, idped));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaD = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Fec = new javax.swing.JTextField();
        Empleado = new javax.swing.JTextField();
        Cliente = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Total = new javax.swing.JTextField();
        Total1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BotonAceptar = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Precio(p/u)", "Precio(tot)"
            }
        ));
        TablaD.setAltoHead(20);
        TablaD.setColorBackgoundHead(new java.awt.Color(27, 34, 36));
        TablaD.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        TablaD.setColorBordeHead(new java.awt.Color(27, 34, 36));
        TablaD.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        TablaD.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        TablaD.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        TablaD.setColorSelBackgound(new java.awt.Color(255, 199, 125));
        TablaD.setColorSelForeground(new java.awt.Color(27, 34, 36));
        TablaD.setFuenteFilas(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TablaD.setFuenteFilasSelect(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TablaD.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        TablaD.setGridColor(new java.awt.Color(255, 255, 255));
        TablaD.setGrosorBordeFilas(0);
        TablaD.setGrosorBordeHead(0);
        TablaD.setMultipleSeleccion(false);
        TablaD.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TablaD);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 580, 270));

        jLabel1.setText("Empleado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel3.setText("Fecha de Entrega");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel4.setText("Cliente");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

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
        jPanel1.add(Fec, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 160, 30));

        Empleado.setEditable(false);
        Empleado.setBackground(new java.awt.Color(255, 199, 125));
        Empleado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Empleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Empleado.setBorder(null);
        jPanel1.add(Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 140, 30));

        Cliente.setEditable(false);
        Cliente.setBackground(new java.awt.Color(255, 199, 125));
        Cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cliente.setBorder(null);
        jPanel1.add(Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 140, 30));

        ID.setEditable(false);
        ID.setBackground(new java.awt.Color(255, 199, 125));
        ID.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.setBorder(null);
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 110, 30));

        jPanel2.setBackground(new java.awt.Color(255, 199, 125));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 20, 440));

        jPanel3.setBackground(new java.awt.Color(255, 199, 125));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 440));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 650, 10));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 199, 125));
        Total.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Total.setText("0.0");
        Total.setBorder(null);
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 60, 40));

        Total1.setEditable(false);
        Total1.setBackground(new java.awt.Color(255, 199, 125));
        Total1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total1.setText("$");
        Total1.setBorder(null);
        jPanel1.add(Total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 30, 40));

        jLabel5.setText("Total");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 50, 40));

        BotonAceptar.setBackground(new java.awt.Color(27, 34, 36));
        BotonAceptar.setText("Aceptar");
        BotonAceptar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonAceptar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 100, -1));

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

    private void FecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FecActionPerformed

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(PopupPedidoDetallesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupPedidoDetallesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupPedidoDetallesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupPedidoDetallesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupPedidoDetallesD dialog = new PopupPedidoDetallesD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Cliente;
    private javax.swing.JTextField Empleado;
    private javax.swing.JTextField Fec;
    private javax.swing.JTextField ID;
    private rojeru_san.complementos.RSTableMetro TablaD;
    private javax.swing.JTextField Total;
    private javax.swing.JTextField Total1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
