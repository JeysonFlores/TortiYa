package Paneles;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import Clases.Conexion;
import Clases.Usuario;
import Popups.Popup;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;

public class PanelPedidosConsulta extends javax.swing.JPanel {
    Connection con;
    Conexion Conexion = new Conexion();
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Usuario usuario = new Usuario();
    boolean iscomplete = true;
    
    public PanelPedidosConsulta() {
        initComponents();
    }
    
    public PanelPedidosConsulta(javax.swing.JFrame Frame,Connection con,Usuario usuario) {
        initComponents();
        this.con = con;
        setTablaVoid();
        this.Frame = Frame;
        this.usuario = usuario;
        Tabla.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int row = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
            PU.PedidoDetalle(Frame, Conexion, con, Tabla.getValueAt(Tabla.getSelectedRow(),0).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),1).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),3).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),4).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),2).toString());
                }
            }
        });
    }
    
    public void setTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model = Conexion.ActualizarPedido(con,getDate(), RadioElm.isSelected());
        Tabla.setModel(model);
    }
    
    public void setTablaVoid(){
        DefaultTableModel model = new DefaultTableModel();
        model = Conexion.ActualizarPedido(con,null, RadioElm.isSelected());
        Tabla.setModel(model);
    }
    
    private String getDate(){
        String format = "dd/MM/yyyy";
        Date fec = Fecha.getDatoFecha();
        SimpleDateFormat aa = new SimpleDateFormat(format);
        return aa.format(fec);
    }
    
    public boolean isDate(){
        boolean flag = true;
        try{
        String format = "dd/MM/yyyy";
        Date fec = Fecha.getDatoFecha();
        SimpleDateFormat aa = new SimpleDateFormat(format);
        aa.format(fec);
        }
        catch(Exception e){
            flag = false;
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        BotonBuscar = new rojeru_san.complementos.RSButtonHover();
        BotonAgregar = new rojeru_san.complementos.RSButtonHover();
        BotonEditar = new rojeru_san.complementos.RSButtonHover();
        BotonEliminar = new rojeru_san.complementos.RSButtonHover();
        RadioElm = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new rojeru_san.complementos.RSTableMetro();
        BotonConfirmar = new rojeru_san.complementos.RSButtonHover();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Barra.setBackground(new java.awt.Color(255, 199, 125));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/datagrid25.png"))); // NOI18N
        jLabel1.setText("Consulta");

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

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonBuscar.setBackground(new java.awt.Color(27, 34, 36));
        BotonBuscar.setBorder(null);
        BotonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Search22.png"))); // NOI18N
        BotonBuscar.setText(" Buscar");
        BotonBuscar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });
        Contenido.add(BotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 90, 30));

        BotonAgregar.setBackground(new java.awt.Color(27, 34, 36));
        BotonAgregar.setBorder(null);
        BotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlusSquare25.png"))); // NOI18N
        BotonAgregar.setText("  Realizar Nuevo");
        BotonAgregar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });
        Contenido.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 160, -1));

        BotonEditar.setBackground(new java.awt.Color(27, 34, 36));
        BotonEditar.setBorder(null);
        BotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Edit25.png"))); // NOI18N
        BotonEditar.setText("  Editar");
        BotonEditar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonEditar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEditarActionPerformed(evt);
            }
        });
        Contenido.add(BotonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 130, -1));

        BotonEliminar.setBackground(new java.awt.Color(27, 34, 36));
        BotonEliminar.setBorder(null);
        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/DeleteSquare25_2.png"))); // NOI18N
        BotonEliminar.setText(" Cancelar");
        BotonEliminar.setBorderPainted(false);
        BotonEliminar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonEliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });
        Contenido.add(BotonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 100, -1));

        RadioElm.setBackground(new java.awt.Color(255, 255, 255));
        RadioElm.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        RadioElm.setText("Cancelados");
        RadioElm.setBorder(null);
        RadioElm.setContentAreaFilled(false);
        RadioElm.setIconTextGap(1);
        RadioElm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioElmActionPerformed(evt);
            }
        });
        Contenido.add(RadioElm, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 90, 30));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla.setAltoHead(20);
        Tabla.setColorBackgoundHead(new java.awt.Color(27, 34, 36));
        Tabla.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        Tabla.setColorBordeHead(new java.awt.Color(27, 34, 36));
        Tabla.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Tabla.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Tabla.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Tabla.setColorSelBackgound(new java.awt.Color(255, 199, 125));
        Tabla.setColorSelForeground(new java.awt.Color(27, 34, 36));
        Tabla.setFuenteFilas(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Tabla.setFuenteFilasSelect(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Tabla.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        Tabla.setGridColor(new java.awt.Color(255, 255, 255));
        Tabla.setGrosorBordeFilas(0);
        Tabla.setGrosorBordeHead(0);
        Tabla.setMultipleSeleccion(false);
        Tabla.getTableHeader().setReorderingAllowed(false);
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla);

        Contenido.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 570, 250));

        BotonConfirmar.setBackground(new java.awt.Color(27, 34, 36));
        BotonConfirmar.setBorder(null);
        BotonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Registrar25.png"))); // NOI18N
        BotonConfirmar.setText(" Confirmar");
        BotonConfirmar.setBorderPainted(false);
        BotonConfirmar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonConfirmar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarActionPerformed(evt);
            }
        });
        Contenido.add(BotonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 100, -1));

        Fecha.setColorBackground(new java.awt.Color(255, 199, 125));
        Fecha.setColorButtonHover(new java.awt.Color(255, 199, 125));
        Fecha.setColorDiaActual(new java.awt.Color(27, 34, 36));
        Fecha.setColorForeground(new java.awt.Color(27, 34, 36));
        Fecha.setFuente(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Fecha.setPlaceholder("Ingrese Fecha");
        Contenido.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 190, -1));

        rSButtonHover1.setBackground(new java.awt.Color(27, 34, 36));
        rSButtonHover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reload25.png"))); // NOI18N
        rSButtonHover1.setColorHover(new java.awt.Color(20, 26, 27));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        Contenido.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 60, -1));

        add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        if(isDate()==true){
            setTabla();
            iscomplete = false;
        }
        else{
            if(Fecha.getDatoFecha()==null){
                setTablaVoid();
            }
            else{
            PU.Error(Frame, "Introduzca una fecha válida");
            }
        }
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        PanelPedidoRegistro PER = new PanelPedidoRegistro(Frame,con,usuario);
        this.setLayout(new java.awt.BorderLayout());
        this.removeAll();
        this.add(PER);
        this.revalidate();
    }//GEN-LAST:event_BotonAgregarActionPerformed
    
    
    
    private void BotonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarActionPerformed
        if(Tabla.getSelectedRow()!=-1){
            if(usuario.getClave().equals(Conexion.getEmpleadoIdFromPedidos(con, Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString()))||usuario.getPuesto().equals("Gerente")){
                if(PU.PopPreg(Frame, "¿Quieres editar el pedido "+Tabla.getValueAt(Tabla.getSelectedRow(),0)+"?")==1){
                    PanelPedidosEdicion PPE = new PanelPedidosEdicion(Frame,con,usuario,Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString(),Tabla.getValueAt(Tabla.getSelectedRow(), 1).toString(),Tabla.getValueAt(Tabla.getSelectedRow(), 2).toString());
                    this.setLayout(new java.awt.BorderLayout());
                    this.removeAll();
                    this.add(PPE);
                    this.revalidate();
                }
            else {
                //PU.Error(Frame, "Eliminación Abortada");
            }
        }
            else{
                PU.Error(Frame, "No tienes permiso");
            }
        }
        else{
            PU.Error(Frame, "No hay registro seleccionado");
        }
        
    }//GEN-LAST:event_BotonEditarActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        if(Tabla.getSelectedRow()!=-1){
            if(usuario.getClave().equals(Conexion.getEmpleadoIdFromPedidos(con, Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString()))||usuario.getPuesto().equals("Gerente")){
                if(PU.PopPreg(Frame, "¿Quieres cancelar el pedido "+Tabla.getValueAt(Tabla.getSelectedRow(),0)+"?")==1){
                    Conexion.CancelarPedido(con, (String) Tabla.getValueAt(Tabla.getSelectedRow(), 0));
                    setTablaVoid();
                    PU.Exito(Frame, "Cancelación Exitosa");
                }
            else {
                //PU.Error(Frame, "Eliminación Abortada");
            }
        }
            else{
                PU.Error(Frame, "No tienes permiso");
            }
        }
        else{
            PU.Error(Frame, "No hay registro seleccionado");
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void RadioElmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioElmActionPerformed
        if(iscomplete==false){
        setTabla();
        }
        else{
            setTablaVoid();
        }
        if(RadioElm.isSelected()==true){
            BotonEliminar.setEnabled(false);
            BotonEditar.setEnabled(false);
            BotonConfirmar.setEnabled(false);
        }
        else{
            BotonEliminar.setEnabled(true);
            BotonEditar.setEnabled(true);
            BotonConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_RadioElmActionPerformed

    private void BotonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmarActionPerformed
        if(Tabla.getSelectedRow()!=-1){
            if(usuario.getClave().equals(Conexion.getEmpleadoIdFromPedidos(con, Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString()))||usuario.getPuesto().equals("Gerente")){
                if(PU.PopPreg(Frame, "¿Quieres confirmar el pedido "+Tabla.getValueAt(Tabla.getSelectedRow(),0)+"?")==1){
                    JTable x = new JTable();
                    x.setModel(Conexion.getPedidoDetalles(con,Tabla.getValueAt(Tabla.getSelectedRow(),0).toString()));
                    Conexion.ConfirmarPedido(con,x,Tabla.getValueAt(Tabla.getSelectedRow(),0).toString(),usuario.getClave(),Tabla.getValueAt(Tabla.getSelectedRow(),3).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),1).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),2).toString());
                    setTablaVoid();
                    PU.Exito(Frame, "Confirmación Exitosa");
                }
            else {
                //PU.Error(Frame, "Eliminación Abortada");
            }
        }
            else{
                PU.Error(Frame, "No tienes permiso");
            }
        }
        else{
            PU.Error(Frame, "No hay registro seleccionado");
        }
    }//GEN-LAST:event_BotonConfirmarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
       
    }//GEN-LAST:event_TablaMouseClicked

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        setTablaVoid();
        iscomplete = true;
    }//GEN-LAST:event_rSButtonHover1ActionPerformed
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private rojeru_san.complementos.RSButtonHover BotonAgregar;
    private rojeru_san.complementos.RSButtonHover BotonBuscar;
    private rojeru_san.complementos.RSButtonHover BotonConfirmar;
    private rojeru_san.complementos.RSButtonHover BotonEditar;
    private rojeru_san.complementos.RSButtonHover BotonEliminar;
    private javax.swing.JPanel Contenido;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private javax.swing.JRadioButton RadioElm;
    private rojeru_san.complementos.RSTableMetro Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    // End of variables declaration//GEN-END:variables
}
