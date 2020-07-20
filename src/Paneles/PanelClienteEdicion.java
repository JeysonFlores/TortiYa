package Paneles;
import Clases.Conexion;
import Clases.Usuario;
import Clases.Validaciones;
import Popups.Popup;
import java.sql.Connection;

public class PanelClienteEdicion extends javax.swing.JPanel {
    Conexion conexion = new Conexion();
    Connection con;
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Validaciones val = new Validaciones();
    String ID="";
    Usuario usu = new Usuario();
    
    public PanelClienteEdicion() {
        initComponents();
    }
    
    public PanelClienteEdicion(javax.swing.JFrame Frame,Connection con) {
        initComponents();
        this.con = con;
        this.SetComboEmpleado();
        this.Frame = Frame;
    }
    
    public PanelClienteEdicion(javax.swing.JFrame Frame,Connection con,String ID,String NombreE,String ContactoE,String TelefonoE,String DireccionE,Usuario usu) {
        initComponents();
        this.con = con;
        this.SetComboEmpleado();
        this.Frame = Frame;
        this.ID = ID;
        Nombre.setText(NombreE);
        Contact.setText(ContactoE);
        Tel.setText(TelefonoE);
        Dire.setText(DireccionE);
        this.usu = usu;
    }
    
    public void SetComboEmpleado(){
        Empl.setModel(conexion.ConsultaBoxEmpleado(con));
    }
    
    public boolean EvaluarContenido(){
        boolean error=false;
        if(Nombre.getText()==null||Nombre.getText()==""||val.ValidarContenido(Nombre.getText())==false||val.ValidarLongitud(Nombre.getText(), 45)==false){
            lblNombre.setForeground(new java.awt.Color(255,51,51));
            error=true;
        }
        else{
            lblNombre.setForeground(new java.awt.Color(51,51,51));
        }
        if(Contact.getText()==null||Contact.getText()==""||val.ValidarContenido(Contact.getText())==false||val.ValidarLongitud(Contact.getText(), 45)==false){
            lblContact.setForeground(new java.awt.Color(255,51,51));
            error=true;
        }
        else{
            lblContact.setForeground(new java.awt.Color(51,51,51));
        }
        if(Dire.getText()==null||Dire.getText()==""||val.ValidarContenido(Dire.getText())==false||val.ValidarLongitud(Dire.getText(), 45)==false){
            lblDire.setForeground(new java.awt.Color(255,51,51));
            error=true;
        }
        else{
            lblDire.setForeground(new java.awt.Color(51,51,51));
        }
        if(Tel.getText()==null||Tel.getText()==""||val.ValidarContenido(Tel.getText())==false||val.ValidarNums(Tel.getText())==false||val.ValidarLongitud(Tel.getText(), 11)==false||val.ValidarInt(Tel.getText())==false){
            lblTel.setForeground(new java.awt.Color(255,51,51));
            System.out.println("aber");
            error=true;
        }
        else{
            lblTel.setForeground(new java.awt.Color(51,51,51));
        }
        
        return error;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Nombre = new app.bolivia.swing.JCTextField();
        Dire = new app.bolivia.swing.JCTextField();
        Contact = new app.bolivia.swing.JCTextField();
        Tel = new app.bolivia.swing.JCTextField();
        BotonGuardar = new rojeru_san.complementos.RSButtonHover();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDire = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        BotonRegresar = new rojeru_san.complementos.RSButtonHover();
        Empl = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Barra.setBackground(new java.awt.Color(255, 199, 125));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Edit25.png"))); // NOI18N
        jLabel1.setText("Edición");

        javax.swing.GroupLayout BarraLayout = new javax.swing.GroupLayout(Barra);
        Barra.setLayout(BarraLayout);
        BarraLayout.setHorizontalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        BarraLayout.setVerticalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        add(Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 780, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre.setBackground(new java.awt.Color(255, 199, 125));
        Nombre.setBorder(null);
        Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nombre.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Nombre.setMargin(new java.awt.Insets(10, 10, 10, 10));
        Nombre.setName(""); // NOI18N
        Nombre.setPlaceholder("                      ej:Taquería Fernando");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 340, -1));

        Dire.setBackground(new java.awt.Color(255, 199, 125));
        Dire.setBorder(null);
        Dire.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Dire.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Dire.setMargin(new java.awt.Insets(3, 10, 3, 6));
        Dire.setPlaceholder("               ej: Calle Revolución No.619");
        jPanel1.add(Dire, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 340, -1));

        Contact.setBackground(new java.awt.Color(255, 199, 125));
        Contact.setBorder(null);
        Contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Contact.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Contact.setMargin(new java.awt.Insets(3, 10, 3, 6));
        Contact.setPlaceholder("                       ej: Jesús Hernández");
        jPanel1.add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 340, -1));

        Tel.setBackground(new java.awt.Color(255, 199, 125));
        Tel.setBorder(null);
        Tel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Tel.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Tel.setMargin(new java.awt.Insets(3, 10, 3, 6));
        Tel.setPlaceholder("          ej: 6945678912");
        jPanel1.add(Tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 210, -1));

        BotonGuardar.setBackground(new java.awt.Color(27, 34, 36));
        BotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar25.png"))); // NOI18N
        BotonGuardar.setText("  Guardar");
        BotonGuardar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 140, 40));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Asignar Empleado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        lblNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        lblDire.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblDire.setText("Dirección");
        jPanel1.add(lblDire, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        lblContact.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblContact.setText("Contacto");
        jPanel1.add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        lblTel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblTel.setText("Teléfono");
        jPanel1.add(lblTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));

        BotonRegresar.setBackground(new java.awt.Color(27, 34, 36));
        BotonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Regresar35.png"))); // NOI18N
        BotonRegresar.setText("Regresar");
        BotonRegresar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonRegresar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 140, -1));

        Empl.setBackground(new java.awt.Color(255, 199, 125));
        Empl.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Empl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(Empl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 190, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed

        if(EvaluarContenido()==false){
            if(PU.PopPreg(Frame, "¿Quieres Guardar el cliente?")==1){
                conexion.EditarCliente(con, ID,Nombre.getText(), Dire.getText(),Contact.getText(),Tel.getText(),(String)Empl.getSelectedItem());
                lblNombre.setForeground(new java.awt.Color(51,51,51));
                lblTel.setForeground(new java.awt.Color(51,51,51));
                lblDire.setForeground(new java.awt.Color(51,51,51));
                lblContact.setForeground(new java.awt.Color(51,51,51));
                PU.Exito(Frame, "Cliente Editado");
                PanelClienteConsulta PCC = new PanelClienteConsulta(Frame,con,usu);
                this.setLayout(new java.awt.BorderLayout());
                this.removeAll();
                this.add(PCC);
                this.revalidate();
            }
            else{

            }
        }
        else{
            PU.Error(Frame, "Caracteres no válidos");
        }

    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        if(PU.PopPreg(Frame, "¿Quiere regresar a consulta?")==1){
            PanelClienteConsulta PCC = new PanelClienteConsulta(Frame,con,usu);
            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(PCC);
            this.revalidate();
        }
    }//GEN-LAST:event_BotonRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private rojeru_san.complementos.RSButtonHover BotonGuardar;
    private rojeru_san.complementos.RSButtonHover BotonRegresar;
    private app.bolivia.swing.JCTextField Contact;
    private app.bolivia.swing.JCTextField Dire;
    private javax.swing.JComboBox<String> Empl;
    private app.bolivia.swing.JCTextField Nombre;
    private app.bolivia.swing.JCTextField Tel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblDire;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTel;
    // End of variables declaration//GEN-END:variables
}
