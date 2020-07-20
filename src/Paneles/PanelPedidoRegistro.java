package Paneles;
import Clases.Conexion;
import Clases.Usuario;
import Clases.Validaciones;
import Popups.Popup;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class PanelPedidoRegistro extends javax.swing.JPanel {
    Conexion conexion = new Conexion();
    Connection con;
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Validaciones val = new Validaciones();
    Usuario usuario = new Usuario();
    
    public PanelPedidoRegistro() {
        initComponents();
    }
    
    public PanelPedidoRegistro(javax.swing.JFrame Frame,Connection con,Usuario usuario) {
        initComponents();
        this.con = con;
        this.Frame = Frame;
        TablaP.setModel(conexion.getPŕoductos(con));
        setTableVoid();
        this.usuario = usuario;
        if(usuario.getPuesto().equals("Gerente")){
            setComboModel(conexion.getClientesGerente(con));
        }
        else{
            setComboModel(conexion.getClientesCajRep(con, usuario.getClave()));
        }
    }
    
    private void setComboModel(DefaultComboBoxModel model){
        Cliente.setModel(model);
    }
    private void setTableVoid(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
        }
        };
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio(u)");
        model.addColumn("Precio(tot)");
        TablaD.setModel(model);
    }
    
    private void setTotal(){
        float tot = 0;
        for(int i = 0;i<TablaD.getRowCount();i++){
            tot += Float.parseFloat(TablaD.getValueAt(i, 4).toString());
        }
        Total.setText(tot+"");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaP = new rojeru_san.complementos.RSTableMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaD = new rojeru_san.complementos.RSTableMetro();
        Unidad = new app.bolivia.swing.JCTextField();
        BotonGuardar = new rojeru_san.complementos.RSButtonHover();
        BotonAgregar = new rojeru_san.complementos.RSButtonHover();
        BotonRegresar = new rojeru_san.complementos.RSButtonHover();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        Cliente = new javax.swing.JComboBox<>();
        BotonQuitar = new rojeru_san.complementos.RSButtonHover();
        Total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Total1 = new javax.swing.JTextField();

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

        TablaP.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaP.setAltoHead(20);
        TablaP.setColorBackgoundHead(new java.awt.Color(27, 34, 36));
        TablaP.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        TablaP.setColorBordeHead(new java.awt.Color(27, 34, 36));
        TablaP.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        TablaP.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        TablaP.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        TablaP.setColorSelBackgound(new java.awt.Color(255, 199, 125));
        TablaP.setColorSelForeground(new java.awt.Color(27, 34, 36));
        TablaP.setFuenteFilas(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TablaP.setFuenteFilasSelect(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TablaP.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        TablaP.setGridColor(new java.awt.Color(255, 255, 255));
        TablaP.setGrosorBordeFilas(0);
        TablaP.setGrosorBordeHead(0);
        TablaP.setMultipleSeleccion(false);
        TablaP.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TablaP);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 280));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 320, 280));
        jPanel1.add(Unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 60, 40));

        BotonGuardar.setBackground(new java.awt.Color(27, 34, 36));
        BotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar25.png"))); // NOI18N
        BotonGuardar.setText("Guardar");
        BotonGuardar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 150, 40));

        BotonAgregar.setBackground(new java.awt.Color(27, 34, 36));
        BotonAgregar.setText("+");
        BotonAgregar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 60, -1));

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

        Fecha.setColorBackground(new java.awt.Color(255, 199, 125));
        Fecha.setColorButtonHover(new java.awt.Color(255, 199, 125));
        Fecha.setColorDiaActual(new java.awt.Color(27, 34, 36));
        Fecha.setColorForeground(new java.awt.Color(27, 34, 36));
        Fecha.setEnabled(false);
        Fecha.setFuente(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Fecha.setPlaceholder("Día/Mes/Año");
        jPanel1.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 190, -1));

        Cliente.setBackground(new java.awt.Color(255, 199, 125));
        Cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 180, 40));

        BotonQuitar.setBackground(new java.awt.Color(27, 34, 36));
        BotonQuitar.setText("-");
        BotonQuitar.setColorHover(new java.awt.Color(20, 26, 27));
        BotonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 60, -1));

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 199, 125));
        Total.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Total.setText("0.0");
        Total.setBorder(null);
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 60, 40));

        jLabel3.setText("Total");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 50, 40));

        Total1.setEditable(false);
        Total1.setBackground(new java.awt.Color(255, 199, 125));
        Total1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Total1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total1.setText("$");
        Total1.setBorder(null);
        jPanel1.add(Total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 30, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        if(PU.PopPreg(Frame, "¿Quiere regresar a consulta?")==1){
            PanelPedidosConsulta PPC = new PanelPedidosConsulta(Frame,con,usuario);
            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(PPC);
            this.revalidate();
        }
    }//GEN-LAST:event_BotonRegresarActionPerformed
    
    private boolean IfIsInTable(){
        boolean flag=false;
        int i = 0;
        String aux = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 0);
        while(i<TablaD.getRowCount()){
            if(aux.equals((String) TablaD.getValueAt(i, 0))){
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
    
    private String getDate(){
        String format = "dd/MM/yyyy";
        Date fec = Fecha.getDatoFecha();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat aa = new SimpleDateFormat(format);
        return aa.format(fec);
    }
    
    public boolean isDate(){
        boolean flag = true;
        try{
        Date fec = Fecha.getDatoFecha();
        }
        catch(Exception e){
            flag = false;
        }
        return flag;
    }
    
    public boolean FutureDateValidation(){
        String format = "dd/MM/yyyy";
        Date fec = Fecha.getDatoFecha();
        Date w = new Date();
        if(fec.compareTo(w)==1||fec.compareTo(w)==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean EvaluarContenido(){
        boolean error = false;
        if(TablaD.getRowCount()<=0){
            error = true;
        }
        if(Cliente.getSelectedItem().toString()==null||Cliente.getSelectedItem().toString()==""){
            error = true;
        }
        if(isDate()==false||Fecha.getDatoFecha()==null){
            error = true;
        }
        return error;
    }
    
    private int WhereIsItThen(){
        int i = 0;
        int pos=-1;
        String aux = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 0);
        while(i<TablaD.getRowCount()){
            if(aux.equals((String) TablaD.getValueAt(i, 0))){
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }
    
    private int WhereIsTheProduct(){
        int i = 0;
        int pos=-1;
        String aux = TablaD.getValueAt(TablaD.getSelectedRow(), 0).toString();
        while(i<TablaP.getRowCount()){
            if(aux.equals(TablaP.getValueAt(i, 0))){
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }
    
    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        if(TablaP.getSelectedRow()==-1){
            PU.Error(Frame, "No hay producto seleccionado");
        }
        else{
            if(val.ValidarInt(Unidad.getText())==false){
                PU.Error(Frame, "Introduzca un número válido");
            }
            else{
                if(Integer.parseInt(Unidad.getText())<=0){
                    PU.Error(Frame, "Introduzca un valor positivo");
                }
                else{
                    if(TablaD.getRowCount()==0){
                        if(Integer.parseInt((String)TablaP.getValueAt(TablaP.getSelectedRow(), 2).toString())>=Integer.parseInt(Unidad.getText())){
                        DefaultTableModel model = (DefaultTableModel) TablaD.getModel();
                        DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
                        String[] aux = new String[5];
                        aux[0] = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 0).toString();
                        aux[1] = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 1).toString();
                        aux[2] = Unidad.getText();
                        aux[3] = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 3).toString();
                        float aux2 = (Integer.parseInt(Unidad.getText())*Float.parseFloat(aux[3]));
                        aux[4] = aux2+"";
                        model.addRow(aux);
                        TablaD.setModel(model);
                        int aux3 = Integer.parseInt((String) TablaP.getValueAt(TablaP.getSelectedRow(), 2).toString());
                        int aux4 = aux3 - Integer.parseInt(Unidad.getText());
                        modelo.setValueAt(aux4+"", TablaP.getSelectedRow(), 2);
                        TablaP.setModel(modelo);
                        setTotal();
                        }
                        else{
                            PU.Error(Frame, "No hay tanta cantidad");
                        }
                    }
                    else{
                        if(IfIsInTable()==false){
                            if(Integer.parseInt((String)TablaP.getValueAt(TablaP.getSelectedRow(), 2).toString())>=Integer.parseInt(Unidad.getText())){
                            DefaultTableModel model = (DefaultTableModel) TablaD.getModel();
                            DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
                            String[] aux = new String[5];
                            aux[0] = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 0).toString();
                            aux[1] = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 1).toString();
                            aux[2] = Unidad.getText();
                            aux[3] = (String) TablaP.getValueAt(TablaP.getSelectedRow(), 3).toString();
                            float aux2 = (Integer.parseInt(Unidad.getText())*Float.parseFloat(aux[3]));
                            aux[4] = aux2+"";
                            model.addRow(aux);
                            TablaD.setModel(model);
                            int aux3 = Integer.parseInt((String) TablaP.getValueAt(TablaP.getSelectedRow(), 2).toString());
                            int aux4 = aux3 - Integer.parseInt(Unidad.getText());
                            modelo.setValueAt(aux4+"", TablaP.getSelectedRow(), 2);
                            TablaP.setModel(modelo);
                            setTotal();
                            }
                            else{
                                PU.Error(Frame, "No hay tanta cantidad");
                            }
                        }
                        else{
                            if(Integer.parseInt((String)TablaP.getValueAt(TablaP.getSelectedRow(), 2).toString())>=Integer.parseInt(Unidad.getText())){
                            int auxd = WhereIsItThen();
                            DefaultTableModel model = (DefaultTableModel) TablaD.getModel();
                            DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
                            int exist1 =Integer.parseInt((String) TablaP.getValueAt(TablaP.getSelectedRow(), 2).toString());
                            String cant2s = TablaD.getValueAt(auxd, 2).toString();
                            int cant2 = Integer.parseInt(cant2s);
                            exist1 = exist1 - Integer.parseInt(Unidad.getText());
                            cant2 = cant2 + Integer.parseInt(Unidad.getText());
                            float auxf = cant2 * Float.parseFloat((String) TablaD.getValueAt(auxd, 3).toString());
                            modelo.setValueAt(exist1+"", TablaP.getSelectedRow(), 2);
                            model.setValueAt(cant2, auxd, 2);
                            model.setValueAt(auxf+"", auxd, 4);
                            TablaP.setModel(modelo);
                            TablaD.setModel(model);
                            setTotal();
                            }
                            else{
                                PU.Error(Frame, "No hay tanta cantidad");
                            }
                        }
                    }      
                }
            }
        }
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
       if(EvaluarContenido()==false){
           if(PU.PopPreg(Frame, "¿Quiere guardar el pedido?")==1){
            conexion.RealizarPedido(con, TablaD, usuario.getClave(), getDate(), Cliente.getSelectedItem().toString(),Total.getText());
            setTableVoid();
            Total.setText("0.0");
           }
           else{
               
           }
       }
       else{
           PU.Error(Frame, "Pedido Incorrecto. Verifíquelo");
       }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonQuitarActionPerformed
        if(TablaD.getSelectedRow()==-1){
            PU.Error(Frame, "No hay producto seleccionado");
        }
        else{
            if(val.ValidarInt(Unidad.getText())==false){
                PU.Error(Frame, "Introduzca un número válido");
            }
            else{
                if(Integer.parseInt(Unidad.getText())<=0){
                    PU.Error(Frame, "Introduzca un valor positivo");
                }
                else{
                    if(Integer.parseInt(Unidad.getText())>Integer.parseInt(TablaD.getValueAt(TablaD.getSelectedRow(), 2).toString())){
                        PU.Error(Frame, "No hay dicha cantidad en el pedido");
                    }
                    else{
                        if(Integer.parseInt(Unidad.getText())==Integer.parseInt(TablaD.getValueAt(TablaD.getSelectedRow(), 2).toString())){
                            int pos = WhereIsTheProduct();
                            DefaultTableModel model = (DefaultTableModel) TablaD.getModel();
                            DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
                            int oldcantd = Integer.parseInt(TablaD.getValueAt(TablaD.getSelectedRow(),2).toString());
                            int oldcantp = Integer.parseInt(TablaP.getValueAt(pos,2).toString());
                            int ncant = oldcantd + oldcantp;
                            modelo.setValueAt(ncant, pos, 2);
                            model.removeRow(TablaD.getSelectedRow());
                            TablaD.setModel(model);
                            TablaP.setModel(modelo);
                            setTotal();
                        }
                        else{
                            int pos = WhereIsTheProduct();
                            DefaultTableModel model = (DefaultTableModel) TablaD.getModel();
                            DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
                            int cantdres = Integer.parseInt(Unidad.getText());
                            int oldcantd = Integer.parseInt(TablaD.getValueAt(TablaD.getSelectedRow(),2).toString());
                            int oldcantp = Integer.parseInt(TablaP.getValueAt(pos,2).toString());
                            int ncantp = oldcantp + cantdres;
                            int ncantd = oldcantd - cantdres;
                            modelo.setValueAt(ncantp, pos, 2);
                            model.setValueAt(ncantd, TablaD.getSelectedRow(), 2);
                            float nprectot = ncantd * Float.parseFloat(model.getValueAt(TablaD.getSelectedRow(), 3).toString());
                            model.setValueAt(nprectot, TablaD.getSelectedRow(), 4);
                            TablaD.setModel(model);
                            TablaP.setModel(modelo);
                            setTotal();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_BotonQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private rojeru_san.complementos.RSButtonHover BotonAgregar;
    private rojeru_san.complementos.RSButtonHover BotonGuardar;
    private rojeru_san.complementos.RSButtonHover BotonQuitar;
    private rojeru_san.complementos.RSButtonHover BotonRegresar;
    private javax.swing.JComboBox<String> Cliente;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private rojeru_san.complementos.RSTableMetro TablaD;
    private rojeru_san.complementos.RSTableMetro TablaP;
    private javax.swing.JTextField Total;
    private javax.swing.JTextField Total1;
    private app.bolivia.swing.JCTextField Unidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
