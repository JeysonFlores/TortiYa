package Paneles;
import Clases.Conexion;
import Clases.Usuario;
import java.sql.Connection;
import Popups.Popup;
import Clases.Validaciones;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelEmpleadoEdicion extends javax.swing.JPanel {
    Conexion conexion = new Conexion();
    Connection con;
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Validaciones val = new Validaciones();
    String ID;
    Usuario usu = new Usuario();
    
    public PanelEmpleadoEdicion() {
        initComponents();
    }
    
    public PanelEmpleadoEdicion(javax.swing.JFrame Frame,Connection con,String id,String nombres,String apellidos,String sexo,String tel,String dire,String fecha_nac,String curp,Usuario usu){
        initComponents();
        this.Frame = Frame;
        this.con = con;
        this.ID = id;
        Nombres.setText(nombres);
        Apellidos.setText(apellidos);
        CURP.setText(curp);
        Tel.setText(tel);
        Dire.setText(dire);
        this.usu = usu;
        Fecha.setDatoFecha(StringToDate(fecha_nac));
        if(sexo.equals("Masculino")==true){
            Masc.setSelected(true);
            Fem.setSelected(false);
        }
        else{
            Fem.setSelected(true);
            Masc.setSelected(false);
        }
        
    }
    
    private String getSexo(){
        if(Masc.isSelected()==true){
            return "Masculino";
        }
        else{
            return "Femenino";
        }
    }
    
    private String getDate(){
        String format = "dd/MM/yyyy";
        Date fec = Fecha.getDatoFecha();
        SimpleDateFormat aa = new SimpleDateFormat(format);
        return aa.format(fec);
    }
    
    private Date StringToDate(String date){
        String format = "dd/MM/yyyy";
        SimpleDateFormat aa = new SimpleDateFormat(format);
        Date newdate = null;
        try {
            newdate = aa.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(PanelEmpleadoEdicion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newdate;
    }
    
    public boolean isDate(){
        boolean flag = true;
        try{
        Date fec = Fecha.getDatoFecha();
        }
        catch(Exception e){
            flag = false;
        }
        System.out.println(""+flag);
        return flag;
    }
    
    public boolean EighteenYearsBeforeValidation(){
        Date fec = Fecha.getDatoFecha();
        Calendar cal = Calendar.getInstance();
        Date w = new Date();
        cal.add(cal.YEAR, -18);
        w= cal.getTime();
        if(fec.compareTo(w)==-1||fec.compareTo(w)==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean EvaluarContenido(){
        boolean error = false;
        if(Nombres.getText()==null||Nombres.getText()==""||val.ValidarContenido(Nombres.getText())==false||val.ValidarLongitud(Nombres.getText(), 45)==false){
            lblNombre.setForeground(Color.red);
            error = true;
        }
        else{
            lblNombre.setForeground(Color.black);
        }
        
        if(Apellidos.getText()==null||Apellidos.getText()==""||val.ValidarContenido(Apellidos.getText())==false||val.ValidarLongitud(Apellidos.getText(), 45)==false){
            lblApellidos.setForeground(Color.red);
            error = true;
        }
        else{
            lblApellidos.setForeground(Color.black);
        }
        
        if(Dire.getText()==null||Dire.getText()==""||val.ValidarContenido(Dire.getText())==false||val.ValidarLongitud(Dire.getText(), 45)==false){
            lblDire.setForeground(Color.red);
            error = true;
        }
        else{
            lblDire.setForeground(Color.black);
        }
        
        if(Tel.getText()==null||Tel.getText()==""||val.ValidarContenido(Tel.getText())==false||val.ValidarNums(Tel.getText())==false||val.ValidarLongitud(Tel.getText(), 11)==false||val.ValidarInt(Tel.getText())==false){
            lblTel.setForeground(Color.red);
            error = true;
        }
        else{
            lblTel.setForeground(Color.black);
        }
        
        if(CURP.getText()==null||CURP.getText()==""||val.ValidarContenido(CURP.getText())==false||val.ValidarLongitud(CURP.getText(), 22)==false){
            lblCURP.setForeground(Color.red);
            error = true;
        }
        else{
            lblCURP.setForeground(Color.black);
        }
        if(isDate()==false||Fecha.getDatoFecha()==null){
            lblFecha.setForeground(Color.red);
            error = true;
        }
        else{
            if(EighteenYearsBeforeValidation()==false){
                lblFecha.setForeground(Color.red);
                error = true;
            }
            else{
                lblFecha.setForeground(Color.black);
            }
        }
        return error;
    }
    
    private void ResetContenido(){
        Nombres.setText("");
        Apellidos.setText("");
        Tel.setText("");
        Dire.setText("");
        CURP.setText("");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BotonGuardar = new rojeru_san.complementos.RSButtonHover();
        lblNombre = new javax.swing.JLabel();
        lblDire = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        BotonRegresar = new rojeru_san.complementos.RSButtonHover();
        lblApellidos = new javax.swing.JLabel();
        lblCURP = new javax.swing.JLabel();
        Puesto = new javax.swing.JComboBox<>();
        Fem = new javax.swing.JRadioButton();
        Masc = new javax.swing.JRadioButton();
        lblFecha = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblPuesto = new javax.swing.JLabel();
        Nombres = new app.bolivia.swing.JCTextField();
        Apellidos = new app.bolivia.swing.JCTextField();
        Dire = new app.bolivia.swing.JCTextField();
        Tel = new app.bolivia.swing.JCTextField();
        CURP = new app.bolivia.swing.JCTextField();
        Fecha = new rojeru_san.componentes.RSDateChooser();

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

        lblNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblNombre.setText("Nombres");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        lblDire.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblDire.setText("Dirección");
        jPanel1.add(lblDire, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        lblTel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblTel.setText("Teléfono");
        jPanel1.add(lblTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, -1, 20));

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

        lblApellidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos");
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        lblCURP.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblCURP.setText("CURP");
        jPanel1.add(lblCURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        Puesto.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Puesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cajero", "Repartidor", "Gerente" }));
        Puesto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 150, 30));

        Fem.setText("Femenino");
        Fem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemActionPerformed(evt);
            }
        });
        jPanel1.add(Fem, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, -1));

        Masc.setSelected(true);
        Masc.setText("Masculino");
        Masc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MascActionPerformed(evt);
            }
        });
        jPanel1.add(Masc, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        lblFecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblFecha.setText("Fecha de Nacimiento");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        lblSexo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblSexo.setText("Sexo");
        jPanel1.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        lblPuesto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPuesto.setText("Puesto");
        jPanel1.add(lblPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        Nombres.setBackground(new java.awt.Color(255, 199, 125));
        Nombres.setBorder(null);
        Nombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nombres.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Nombres.setMargin(new java.awt.Insets(10, 10, 10, 10));
        Nombres.setName(""); // NOI18N
        Nombres.setPlaceholder("                               ej:Jesús Ángel");
        jPanel1.add(Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 300, -1));

        Apellidos.setBackground(new java.awt.Color(255, 199, 125));
        Apellidos.setBorder(null);
        Apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Apellidos.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Apellidos.setMargin(new java.awt.Insets(10, 10, 10, 10));
        Apellidos.setName(""); // NOI18N
        Apellidos.setPlaceholder("             ej:Hernández Salinas");
        jPanel1.add(Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 260, -1));

        Dire.setBackground(new java.awt.Color(255, 199, 125));
        Dire.setBorder(null);
        Dire.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Dire.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Dire.setMargin(new java.awt.Insets(3, 10, 3, 6));
        Dire.setPlaceholder("                     ej: Calle Revolución No.619");
        jPanel1.add(Dire, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 410, -1));

        Tel.setBackground(new java.awt.Color(255, 199, 125));
        Tel.setBorder(null);
        Tel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Tel.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Tel.setMargin(new java.awt.Insets(3, 10, 3, 6));
        Tel.setPlaceholder("       ej: 6945678912");
        jPanel1.add(Tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 180, -1));

        CURP.setBackground(new java.awt.Color(255, 199, 125));
        CURP.setBorder(null);
        CURP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CURP.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        CURP.setMargin(new java.awt.Insets(3, 10, 3, 6));
        CURP.setPlaceholder("  ej:BADD110313HCMLNS09");
        jPanel1.add(CURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 220, -1));

        Fecha.setColorBackground(new java.awt.Color(255, 199, 125));
        Fecha.setColorButtonHover(new java.awt.Color(255, 199, 125));
        Fecha.setColorDiaActual(new java.awt.Color(27, 34, 36));
        Fecha.setColorForeground(new java.awt.Color(27, 34, 36));
        Fecha.setEnabled(false);
        Fecha.setFuente(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Fecha.setPlaceholder("Día/Mes/Año");
        jPanel1.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 190, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        if(EvaluarContenido()==false){
            if(PU.PopPreg(Frame, "¿Quieres Guardar el empleado?")==1){
                conexion.EditarEmpleado(con,ID,Nombres.getText(),Apellidos.getText(),Dire.getText(),Tel.getText(),CURP.getText(),getSexo(),(String) Puesto.getSelectedItem(),getDate());
                ResetContenido();
                PU.Exito(Frame, "Empleado Guardado");
                PanelEmpleadoConsulta PEC = new PanelEmpleadoConsulta(Frame,con,usu);
                this.setLayout(new java.awt.BorderLayout());
                this.removeAll();
                this.add(PEC);
                this.revalidate();
            }
        }
        else{
            PU.Error(Frame, "Información no válida");
        }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        if(PU.PopPreg(Frame, "¿Quiere regresar a consulta?")==1){
            PanelEmpleadoConsulta PEC = new PanelEmpleadoConsulta(Frame,con,usu);
            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(PEC);
            this.revalidate();
        }
    }//GEN-LAST:event_BotonRegresarActionPerformed

    private void FemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemActionPerformed
        Masc.setSelected(false);
        Fem.setSelected(true);
    }//GEN-LAST:event_FemActionPerformed

    private void MascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MascActionPerformed
        Masc.setSelected(true);
        Fem.setSelected(false);
    }//GEN-LAST:event_MascActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField Apellidos;
    private javax.swing.JPanel Barra;
    private rojeru_san.complementos.RSButtonHover BotonGuardar;
    private rojeru_san.complementos.RSButtonHover BotonRegresar;
    private app.bolivia.swing.JCTextField CURP;
    private app.bolivia.swing.JCTextField Dire;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private javax.swing.JRadioButton Fem;
    private javax.swing.JRadioButton Masc;
    private app.bolivia.swing.JCTextField Nombres;
    private javax.swing.JComboBox<String> Puesto;
    private app.bolivia.swing.JCTextField Tel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCURP;
    private javax.swing.JLabel lblDire;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTel;
    // End of variables declaration//GEN-END:variables
}
