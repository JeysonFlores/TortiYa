package Paneles;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import Clases.Conexion;
import Clases.Usuario;
import Popups.Popup;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class PanelReporteDeCaja extends javax.swing.JPanel {
    Connection con;
    Conexion Conexion = new Conexion();
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Usuario usuario = new Usuario();
    
    public PanelReporteDeCaja() {
        initComponents();
    }
    
    public PanelReporteDeCaja(javax.swing.JFrame Frame,Connection con,Usuario usuario){
        initComponents();
        this.con = con;
        this.Frame = Frame;
        this.usuario = usuario;
        setTablaInit();
        Tabla.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int row = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
            PU.VentaDetalle(Frame, Conexion, con, Tabla.getValueAt(Tabla.getSelectedRow(),0).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),1).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),3).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),4).toString(), Tabla.getValueAt(Tabla.getSelectedRow(),2).toString());
                }
            }
        });
        
    }
    
    public void setTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model = Conexion.ConsultaVentasReporte(con,getDate());
        Tabla.setModel(model);
    }
    
    public void setTablaInit(){
        DefaultTableModel model = new DefaultTableModel();
        model = Conexion.ConsultaVentasReporte(con,getDateNowParsed());
        Tabla.setModel(model);
    }
    
    public Date setDateChooserInit(){
        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = formatter.parse(getDateNowParsed());
        } catch (ParseException ex) {
            Logger.getLogger(PanelReporteDeCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    private String getDateNowParsed(){
        String format = "dd/MM/yyyy";
        Date fec = new Date();
        SimpleDateFormat aa = new SimpleDateFormat(format);
        return aa.format(fec);
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
    
    public int ProductQuantity(){
        int flag = 0;
        
        return flag;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new rojeru_san.complementos.RSTableMetro();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        BotonBuscar = new rojeru_san.complementos.RSButtonHover();

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

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

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

        Contenido.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 620, 300));

        rSButtonHover1.setBackground(new java.awt.Color(27, 34, 36));
        rSButtonHover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Search22.png"))); // NOI18N
        rSButtonHover1.setText("  Reporte");
        rSButtonHover1.setColorHover(new java.awt.Color(20, 26, 27));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        Contenido.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 140, -1));

        Fecha.setColorBackground(new java.awt.Color(255, 199, 125));
        Fecha.setColorButtonHover(new java.awt.Color(255, 199, 125));
        Fecha.setColorDiaActual(new java.awt.Color(27, 34, 36));
        Fecha.setColorForeground(new java.awt.Color(27, 34, 36));
        Fecha.setDatoFecha(setDateChooserInit());
        Fecha.setFormatoFecha("dd/MM/yyyy");
        Fecha.setFuente(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Fecha.setPlaceholder("");
        Contenido.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 190, -1));

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

        add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        if(isDate()==true){
            setTabla();
        }
        else{
            if(Fecha.getDatoFecha()==null){
            }
            else{
                PU.Error(Frame, "Introduzca una fecha válida");
            }
        }
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        if(Tabla.getRowCount()== 0){
            PU.Error(Frame, "No hay ventas este día");
        }
        else{
            String fec = "";
            int prodstot = 0;
            float totot = 0;
            for(int i = 0;i<Tabla.getRowCount();i++){
                totot += Float.parseFloat(Tabla.getValueAt(i, 2).toString());
                prodstot += Conexion.CantidadProductoEnDetalle(con, Tabla.getValueAt(i, 0).toString());
            }
            PU.VentaReporte(Frame, getDate(), Tabla.getRowCount()+"", prodstot+"", totot+"");
        }
    }//GEN-LAST:event_rSButtonHover1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private rojeru_san.complementos.RSButtonHover BotonBuscar;
    private javax.swing.JPanel Contenido;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private rojeru_san.complementos.RSTableMetro Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    // End of variables declaration//GEN-END:variables
}
