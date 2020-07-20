package Paneles;
import Clases.Conexion;
import Clases.Usuario;
import java.sql.Connection;
import Popups.Popup;
import Clases.Validaciones;

public class PanelProductoEdicion extends javax.swing.JPanel {
    Conexion conexion = new Conexion();
    Connection con;
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Validaciones val = new Validaciones();
    String ID;
    Usuario usu = new Usuario();
    
    public PanelProductoEdicion() {
        initComponents();
    }
    
    public PanelProductoEdicion(javax.swing.JFrame Frame,Connection con,String ID,String nombre,String existencia,String descripcion,String precio,Usuario usu) {
        initComponents();
        this.con = con;
        this.Frame = Frame;
        this.ID = ID;
        this.usu = usu;
        Nombre.setText(nombre);
        Existencia.setText(existencia);
        Descripcion.setText(descripcion);
        Precio.setText(precio);
    }
    
    public void ResetConetenido(){
        Nombre.setText("");
        Existencia.setText("");
        Precio.setText("");
        Descripcion.setText("");
    }
    
    public boolean EvaluarContenido(){
        boolean error=false;
        if(Nombre.getText()==null||Nombre.getText()==""||val.ValidarContenido(Nombre.getText())==false||val.ValidarLongitud(Nombre.getText(), 30)==false){
            lblNombre.setForeground(new java.awt.Color(255,51,51));
            error=true;
        }
        else{
            lblNombre.setForeground(new java.awt.Color(51,51,51));
        }
        
        if(Existencia.getText()==null||Existencia.getText()==""||val.ValidarContenido(Existencia.getText())==false||val.ValidarNums(Existencia.getText())==false||val.ValidarLongitud(Existencia.getText(), 11)==false||val.ValidarInt(Existencia.getText())==false){
            lblExistencia.setForeground(new java.awt.Color(255,51,51));
            error=true;
        }
        else{
            lblExistencia.setForeground(new java.awt.Color(51,51,51));
        }
        
        if(Precio.getText()==null||Precio.getText()==""||val.ValidarContenido(Precio.getText())==false||val.ValidarLongitud(Precio.getText(), 11)==false||val.ValidarFloat(Precio.getText())==false){
            lblPrecio.setForeground(new java.awt.Color(255,51,51));
            error=true;
        }
        else{
            lblPrecio.setForeground(new java.awt.Color(51,51,51));
        }
        
        if(Descripcion.getText()==null||Descripcion.getText()==""||val.ValidarContenido(Descripcion.getText())==false||val.ValidarLongitud(Descripcion.getText(), 100)==false){
            lblDescripcion.setForeground(new java.awt.Color(255,51,51));
            error=true;
        }
        else{
            lblDescripcion.setForeground(new java.awt.Color(51,51,51));
        }
        
        return error;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BotonRegresar = new rojeru_san.complementos.RSButtonHover();
        BotonGuardar = new rojeru_san.complementos.RSButtonHover();
        lblPrecio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblExistencia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextPane();
        lblDescripcion = new javax.swing.JLabel();
        Nombre = new app.bolivia.swing.JCTextField();
        Existencia = new app.bolivia.swing.JCTextField();
        Precio = new app.bolivia.swing.JCTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Barra.setBackground(new java.awt.Color(255, 199, 125));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/EregistrarN25.png"))); // NOI18N
        jLabel1.setText("Registro");

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblPrecio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPrecio.setText("Precio");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        lblNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblNombre.setText("Nombres");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        lblExistencia.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblExistencia.setText("Existencia");
        jPanel1.add(lblExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        Descripcion.setBackground(new java.awt.Color(255, 199, 125));
        Descripcion.setBorder(null);
        jScrollPane1.setViewportView(Descripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 570, 110));

        lblDescripcion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblDescripcion.setText("Descripción");
        jPanel1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        Nombre.setBackground(new java.awt.Color(255, 199, 125));
        Nombre.setBorder(null);
        Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nombre.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Nombre.setMargin(new java.awt.Insets(10, 10, 10, 10));
        Nombre.setName(""); // NOI18N
        Nombre.setPlaceholder("         ej:Tortilla paq. 12pzs");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 220, -1));

        Existencia.setBackground(new java.awt.Color(255, 199, 125));
        Existencia.setBorder(null);
        Existencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Existencia.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Existencia.setMargin(new java.awt.Insets(10, 10, 10, 10));
        Existencia.setName(""); // NOI18N
        Existencia.setPlaceholder("      ej: 50");
        jPanel1.add(Existencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 110, -1));

        Precio.setBackground(new java.awt.Color(255, 199, 125));
        Precio.setBorder(null);
        Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Precio.setMargin(new java.awt.Insets(10, 10, 10, 10));
        Precio.setName(""); // NOI18N
        Precio.setPlaceholder("      ej:15.50");
        jPanel1.add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 130, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        if(PU.PopPreg(Frame, "¿Quiere regresar a consulta?")==1){
            PanelProductoConsulta PCC = new PanelProductoConsulta(Frame,con,usu);
            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(PCC);
            this.revalidate();
        }
    }//GEN-LAST:event_BotonRegresarActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed

        if(EvaluarContenido()==false){
            if(PU.PopPreg(Frame, "¿Quieres Guardar el producto?")==1){
                //conexion.AltaCliente(con,Nombre.getText(), Dire.getText(),Contact.getText(),Tel.getText(),(String)Empl.getSelectedItem());
                //conexion.AltaProducto(con, Nombre.getText(),Existencia.getText(),Precio.getText(),Descripcion.getText());
                conexion.EditarProducto(con, ID, Nombre.getText(), Existencia.getText(),Descripcion.getText(),Precio.getText());
                lblPrecio.setForeground(new java.awt.Color(51,51,51));
                lblNombre.setForeground(new java.awt.Color(51,51,51));
                lblExistencia.setForeground(new java.awt.Color(51,51,51));
                lblDescripcion.setForeground(new java.awt.Color(51,51,51));
                ResetConetenido();
                PU.Exito(Frame, "Producto Guardado");
                PanelProductoConsulta PCC = new PanelProductoConsulta(Frame,con,usu);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private rojeru_san.complementos.RSButtonHover BotonGuardar;
    private rojeru_san.complementos.RSButtonHover BotonRegresar;
    private javax.swing.JTextPane Descripcion;
    private app.bolivia.swing.JCTextField Existencia;
    private app.bolivia.swing.JCTextField Nombre;
    private app.bolivia.swing.JCTextField Precio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblExistencia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
