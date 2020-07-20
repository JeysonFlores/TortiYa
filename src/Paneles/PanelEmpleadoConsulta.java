package Paneles;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import Clases.Conexion;
import Clases.Usuario;
import Popups.Popup;
import java.awt.event.KeyEvent;

public class PanelEmpleadoConsulta extends javax.swing.JPanel {
    Connection con;
    Conexion Conexion = new Conexion();
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Usuario usu = new Usuario();
    
    public PanelEmpleadoConsulta() {
        initComponents();
    }
    
    public PanelEmpleadoConsulta(Connection con) {
        initComponents();
        this.con = con;
        setTabla();
    }
    
    public PanelEmpleadoConsulta(javax.swing.JFrame Frame,Connection con,Usuario usu) {
        initComponents();
        this.con = con;
        setTabla();
        this.Frame = Frame;
        this.usu = usu;
    }
    
    public void setTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model = Conexion.ActualizarEmpleados(con,TxtBusqueda.getText(), RadioElm.isSelected());
        Tabla.setModel(model);
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
        TxtBusqueda = new app.bolivia.swing.JCTextField();
        jSeparator1 = new javax.swing.JSeparator();
        BotonReactivar = new rojeru_san.complementos.RSButtonHover();

        setBackground(new java.awt.Color(255, 255, 255));
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
        BotonAgregar.setText("  Agregar");
        BotonAgregar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });
        Contenido.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 130, -1));

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
        Contenido.add(BotonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 130, -1));

        BotonEliminar.setBackground(new java.awt.Color(27, 34, 36));
        BotonEliminar.setBorder(null);
        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/DeleteSquare25_2.png"))); // NOI18N
        BotonEliminar.setText("  Eliminar");
        BotonEliminar.setBorderPainted(false);
        BotonEliminar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonEliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });
        Contenido.add(BotonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 130, -1));

        RadioElm.setBackground(new java.awt.Color(255, 255, 255));
        RadioElm.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        RadioElm.setText("Eliminados");
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
        jScrollPane2.setViewportView(Tabla);

        Contenido.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 570, 250));

        TxtBusqueda.setBorder(null);
        TxtBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        TxtBusqueda.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TxtBusqueda.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        TxtBusqueda.setPlaceholder("Ingrese nombre de empleado");
        TxtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBusquedaKeyReleased(evt);
            }
        });
        Contenido.add(TxtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 380, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        Contenido.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 380, 10));

        BotonReactivar.setBackground(new java.awt.Color(27, 34, 36));
        BotonReactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlusSquare25.png"))); // NOI18N
        BotonReactivar.setText("  Reactivar");
        BotonReactivar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonReactivar.setEnabled(false);
        BotonReactivar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        BotonReactivar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonReactivar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BotonReactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReactivarActionPerformed(evt);
            }
        });
        Contenido.add(BotonReactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 120, -1));

        add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        if(usu.getPuesto().equals("Gerente")){    
            if(Tabla.getSelectedRow()!=-1){
                if(PU.PopPreg(Frame, "¿Quieres eliminar el empleado "+Tabla.getValueAt(Tabla.getSelectedRow(),1)+"?")==1){
                    Conexion.BajaEmpleado(con, (String) Tabla.getValueAt(Tabla.getSelectedRow(), 0));
                    setTabla();
                    PU.Exito(Frame, "Eliminación Exitosa");
                } 
                else {
                    //PU.Error(Frame, "Eliminación Abortada");
                    }
            }
            else{
                PU.Error(Frame, "No hay registro seleccionado");
            }
        }
        else{
            PU.Error(Frame, "No tienes permiso");
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void RadioElmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioElmActionPerformed
        setTabla();
        if(RadioElm.isSelected()==true){
            BotonEliminar.setEnabled(false);
            BotonReactivar.setEnabled(true);
            BotonEditar.setEnabled(false);
        }
        else{
            BotonEliminar.setEnabled(true);
            BotonReactivar.setEnabled(false);
            BotonEditar.setEnabled(true);
        }
    }//GEN-LAST:event_RadioElmActionPerformed

    private void TxtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBusquedaKeyReleased
        setTabla();
    }//GEN-LAST:event_TxtBusquedaKeyReleased

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model = Conexion.BuscarEmpleados(con,TxtBusqueda.getText(), RadioElm.isSelected());
        Tabla.setModel(model);
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void BotonReactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReactivarActionPerformed
        if(usu.getPuesto().equals("Gerente")){
            if(Tabla.getSelectedRow()!=-1){
                if(PU.PopPreg(Frame, "¿Quieres reactivar el empleado "+Tabla.getValueAt(Tabla.getSelectedRow(),1)+"?")==1){
                    Conexion.ReactivarEmpleado(con, (String) Tabla.getValueAt(Tabla.getSelectedRow(), 0));
                    setTabla();
                    PU.Exito(Frame, "Reactivación Exitosa");
                } 
                else {
                    //PU.Error(Frame, "Eliminación Abortada");
                    }
            }
            else{
                PU.Error(Frame, "No hay registro seleccionado");
            }
        }
        else{
            PU.Error(Frame, "No tienes permiso");
        }
    }//GEN-LAST:event_BotonReactivarActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        if(usu.getPuesto().equals("Gerente")){    
            PanelEmpleadoRegistro PER = new PanelEmpleadoRegistro(Frame,con,usu);
            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(PER);
            this.revalidate();
        }
        else{
            PU.Error(Frame, "No tienes permiso");
        }
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarActionPerformed
        if(usu.getPuesto().equals("Gerente")){    
            if(Tabla.getSelectedRow()!=-1){
                if(PU.PopPreg(Frame, "¿Quieres editar el empleado "+Tabla.getValueAt(Tabla.getSelectedRow(),1)+"?")==1){
                    PanelEmpleadoEdicion PEE = new PanelEmpleadoEdicion(Frame,con,(String) Tabla.getValueAt(Tabla.getSelectedRow(),0),(String) Tabla.getValueAt(Tabla.getSelectedRow(),1),(String) Tabla.getValueAt(Tabla.getSelectedRow(),2),(String) Tabla.getValueAt(Tabla.getSelectedRow(),5),(String) Tabla.getValueAt(Tabla.getSelectedRow(),8),(String) Tabla.getValueAt(Tabla.getSelectedRow(),6),(String) Tabla.getValueAt(Tabla.getSelectedRow(), 4),(String) Tabla.getValueAt(Tabla.getSelectedRow(),7),usu);
                    this.setLayout(new java.awt.BorderLayout());
                    this.removeAll();
                    this.add(PEE);
                    this.revalidate();
                } 
                else {
                    //PU.Error(Frame, "Eliminación Abortada");
                    }
            }
            else{
                PU.Error(Frame, "No hay registro seleccionado");
            }
        }
        else{
            PU.Error(Frame, "No tienes permiso");
        }
    }//GEN-LAST:event_BotonEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private rojeru_san.complementos.RSButtonHover BotonAgregar;
    private rojeru_san.complementos.RSButtonHover BotonBuscar;
    private rojeru_san.complementos.RSButtonHover BotonEditar;
    private rojeru_san.complementos.RSButtonHover BotonEliminar;
    private rojeru_san.complementos.RSButtonHover BotonReactivar;
    private javax.swing.JPanel Contenido;
    private javax.swing.JRadioButton RadioElm;
    private rojeru_san.complementos.RSTableMetro Tabla;
    private app.bolivia.swing.JCTextField TxtBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
