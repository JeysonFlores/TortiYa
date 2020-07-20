package Paneles;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import Clases.Conexion;
import Clases.Usuario;
import Popups.Popup;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class PanelVentasConsulta extends javax.swing.JPanel {
    Connection con;
    Conexion Conexion = new Conexion();
    Popup PU = new Popup();
    javax.swing.JFrame Frame = new javax.swing.JFrame();
    Usuario usuario = new Usuario();
    
    public PanelVentasConsulta() {
        initComponents();
    }
    
    public PanelVentasConsulta(javax.swing.JFrame Frame,Connection con,Usuario usuario){
        initComponents();
        this.con = con;
        setTabla();
        this.Frame = Frame;
        this.usuario = usuario;
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
        model = Conexion.ConsultaVentas(con);
        Tabla.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new rojeru_san.complementos.RSTableMetro();

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

        Contenido.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 630, 310));

        add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private javax.swing.JPanel Contenido;
    private rojeru_san.complementos.RSTableMetro Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
