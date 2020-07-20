package Popups;
import Clases.SimpleTimer;
import Clases.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupUsuarioD extends javax.swing.JDialog {
    SimpleTimer st = new SimpleTimer();
    
    public PopupUsuarioD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public PopupUsuarioD(java.awt.Frame parent, boolean modal,Usuario usuario,SimpleTimer st) {
        super(parent, modal);
        initComponents();
        //this.setLocation(550,250);
        this.setLocationRelativeTo(null);
        this.setOpacity(0.85f);
        Nombre.setText(usuario.getNombre()+" ("+usuario.getPuesto()+")");
        Direccion.setText(usuario.getDireccion());
        CURP.setText(usuario.getCURP());
        Telefono.setText(usuario.getTelefono());
        Sexo.setText(usuario.getSexo());
        Fecha.setText(usuario.getFechaNac());
        this.st = st;
        ses.setText((st.ElapsedTimeLong()));
        t.start();
    }
    
    javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              ses.setText((st.ElapsedTimeLong()));
          }
            });
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Direccion = new javax.swing.JLabel();
        Telefono = new javax.swing.JLabel();
        CURP = new javax.swing.JLabel();
        Sexo = new javax.swing.JLabel();
        BotonAceptar = new rojeru_san.complementos.RSButtonHover();
        jLabel2 = new javax.swing.JLabel();
        ses = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(27, 34, 36));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usu45.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 53));

        Fecha.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        Fecha.setForeground(new java.awt.Color(255, 255, 255));
        Fecha.setText("EJEMPLO/EJEMPLO/EJEMPLO");
        jPanel1.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 150, -1));

        Nombre.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Ejemplo Ejemplo Ejemplo Ejemplo (Ejemplo)");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 370, -1));

        Direccion.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        Direccion.setForeground(new java.awt.Color(255, 255, 255));
        Direccion.setText("asdasdasasasdas");
        jPanel1.add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 250, 40));

        Telefono.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        Telefono.setForeground(new java.awt.Color(255, 255, 255));
        Telefono.setText("694694201");
        jPanel1.add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 90, -1));

        CURP.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        CURP.setForeground(new java.awt.Color(255, 255, 255));
        CURP.setText("EJEMPLO123EJEMPLO123EJMPLO");
        jPanel1.add(CURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 260, -1));

        Sexo.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        Sexo.setForeground(new java.awt.Color(255, 255, 255));
        Sexo.setText("EJEMPLO");
        jPanel1.add(Sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 90, -1));

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
        jPanel1.add(BotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 100, -1));

        jLabel2.setFont(new java.awt.Font("Andis", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tiempo de Sesión");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        ses.setFont(new java.awt.Font("Andis", 1, 14)); // NOI18N
        ses.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ses, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, 20));

        jLabel3.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sexo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 60, 20));

        jLabel4.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, 40));

        jLabel5.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 190, 20));

        jLabel6.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teléfono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 90, 40));

        jLabel7.setFont(new java.awt.Font("Andis", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CURP:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PopupUsuarioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupUsuarioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupUsuarioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupUsuarioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupUsuarioD dialog = new PopupUsuarioD(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel CURP;
    private javax.swing.JLabel Direccion;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Sexo;
    private javax.swing.JLabel Telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ses;
    // End of variables declaration//GEN-END:variables
}
