package Paneles;
import Clases.Conexion;

public class BDConfig extends javax.swing.JPanel {
    
    Conexion con = new Conexion();
    javax.swing.JFrame main = new javax.swing.JFrame();

    public BDConfig() {
        initComponents();
        txthost.setText(con.getHOST());
        //System.out.println(con.getUSER());
        txtbd.setText(con.getDB());
        txtuser.setText(con.getUSER());
        txtpass.setText(con.getPASS());
    }
    
    public BDConfig(javax.swing.JFrame main) {
        initComponents();
        txthost.setText(con.getHOST());
        //System.out.println(con.getUSER());
        txtbd.setText(con.getDB());
        txtuser.setText(con.getUSER());
        txtpass.setText(con.getPASS());
        this.main = main;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        SeparadorPass = new javax.swing.JSeparator();
        SeparadorHost = new javax.swing.JSeparator();
        SeparadorBD = new javax.swing.JSeparator();
        SeparadorUser = new javax.swing.JSeparator();
        LabelPass = new javax.swing.JLabel();
        LabelHost = new javax.swing.JLabel();
        LabelBD = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        txthost = new javax.swing.JTextField();
        txtbd = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        BotonGuardar = new rojeru_san.complementos.RSButtonHover();
        BotonProbar = new rojeru_san.complementos.RSButtonHover();

        PanelPrincipal.setBackground(new java.awt.Color(27, 34, 36));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelPrincipal.add(SeparadorPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 290, 30));
        PanelPrincipal.add(SeparadorHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 290, 30));
        PanelPrincipal.add(SeparadorBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 290, 30));
        PanelPrincipal.add(SeparadorUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 290, 30));

        LabelPass.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        LabelPass.setForeground(new java.awt.Color(255, 255, 255));
        LabelPass.setText("Contraseña");
        PanelPrincipal.add(LabelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        LabelHost.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        LabelHost.setForeground(new java.awt.Color(255, 255, 255));
        LabelHost.setText("Host");
        PanelPrincipal.add(LabelHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        LabelBD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        LabelBD.setForeground(new java.awt.Color(255, 255, 255));
        LabelBD.setText("Base de datos");
        PanelPrincipal.add(LabelBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        LabelUser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelUser.setText("Usuario");
        PanelPrincipal.add(LabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 60, -1));

        txtpass.setBackground(new java.awt.Color(27, 34, 36));
        txtpass.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setBorder(null);
        PanelPrincipal.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 290, 30));

        txthost.setBackground(new java.awt.Color(27, 34, 36));
        txthost.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txthost.setForeground(new java.awt.Color(255, 255, 255));
        txthost.setBorder(null);
        PanelPrincipal.add(txthost, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 59, 290, 30));

        txtbd.setBackground(new java.awt.Color(27, 34, 36));
        txtbd.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtbd.setForeground(new java.awt.Color(255, 255, 255));
        txtbd.setBorder(null);
        PanelPrincipal.add(txtbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 290, 30));

        txtuser.setBackground(new java.awt.Color(27, 34, 36));
        txtuser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtuser.setForeground(new java.awt.Color(255, 255, 255));
        txtuser.setBorder(null);
        PanelPrincipal.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 290, 30));

        BotonGuardar.setBackground(new java.awt.Color(20, 26, 27));
        BotonGuardar.setBorder(null);
        BotonGuardar.setText("Guardar Conexión");
        BotonGuardar.setColorHover(new java.awt.Color(14, 19, 19));
        BotonGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(BotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 149, 50));

        BotonProbar.setBackground(new java.awt.Color(20, 26, 27));
        BotonProbar.setBorder(null);
        BotonProbar.setText("Probar Conexión");
        BotonProbar.setColorHover(new java.awt.Color(14, 19, 19));
        BotonProbar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonProbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonProbarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(BotonProbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 149, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        con.setValues(main,txthost.getText(),txtbd.getText(), txtuser.getText(), txtpass.getText());
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonProbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonProbarActionPerformed
        con.setHOST(txthost.getText());
        con.setDB(txtbd.getText());
        con.setUSER(txtuser.getText());
        con.setPASS(txtpass.getText());
        con.setURL();
        con.Conectar(main);
    }//GEN-LAST:event_BotonProbarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover BotonGuardar;
    private rojeru_san.complementos.RSButtonHover BotonProbar;
    private javax.swing.JLabel LabelBD;
    private javax.swing.JLabel LabelHost;
    private javax.swing.JLabel LabelPass;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JSeparator SeparadorBD;
    private javax.swing.JSeparator SeparadorHost;
    private javax.swing.JSeparator SeparadorPass;
    private javax.swing.JSeparator SeparadorUser;
    private javax.swing.JTextField txtbd;
    private javax.swing.JTextField txthost;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
