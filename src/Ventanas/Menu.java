package Ventanas;
import Clases.Usuario;
import Clases.SimpleTimer;
import Clases.InactivityListener;
import java.sql.Connection;
import Popups.Popup;
import Paneles.PanelEmpleadoConsulta;
import Paneles.PanelClienteConsulta;
import Paneles.PanelPedidosConsulta;
import Paneles.PanelProductoConsulta;
import Paneles.PanelVentasConsulta;
import Paneles.PanelReporteDeCaja;
import java.awt.Color;
import javax.swing.ImageIcon;
import Paneles.PanelPuntoDeVenta;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.AbstractAction;


public class Menu extends javax.swing.JFrame {
    Usuario usu = new Usuario();
    Connection con;
    Popup PU = new Popup();
    SimpleTimer st = new SimpleTimer();

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setOpacity(0.92f);
    }
    
    public Menu(Usuario usu) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setOpacity(0.92f);
        this.usu = usu;
    }
    
    public Menu(Connection con, Usuario usu) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setOpacity(0.92f);
        this.setIconImage(new ImageIcon("src/Iconos/LogoApp.png").getImage());
        this.usu = usu;
        this.con = con;
        PU.Msg(this, "Bienvenido "+usu.getNombre()); 
        st.Start();
        InactivityListener listener = new InactivityListener(this, logout, 5);
        listener.start();
    }
    
    Action logout = new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                javax.swing.JFrame frame = (javax.swing.JFrame)e.getSource();
                frame.dispose();
                Login nf = new Login();
                nf.setVisible(true);
            }
        };
    
    private void SetColors(){
        BotonEmpleado.setForeground(new java.awt.Color(204,204,204));
        BotonCliente.setForeground(new java.awt.Color(204,204,204));
        BotonProductos.setForeground(new java.awt.Color(204,204,204));
        BotonPedidos.setForeground(new java.awt.Color(204,204,204));
        BotonVentas.setForeground(new java.awt.Color(204,204,204));
        BotonCorte.setForeground(new java.awt.Color(204,204,204));
        BotonPunto.setForeground(new java.awt.Color(204,204,204));
        BotonSalir.setForeground(new java.awt.Color(204,204,204));
        BotonUsuario.setForeground(new java.awt.Color(204,204,204));
        PanelIMGEmpleado.setBackground(new java.awt.Color(27,34,36));
        PanelIMGCliente.setBackground(new java.awt.Color(27,34,36));
        PanelIMGProductos.setBackground(new java.awt.Color(27,34,36));
        PanelIMGPedidos.setBackground(new java.awt.Color(27,34,36));
        PanelIMGVentas.setBackground(new java.awt.Color(27,34,36));
        PanelIMGCorte.setBackground(new java.awt.Color(27,34,36));
        PanelIMGPunto.setBackground(new java.awt.Color(27,34,36));
        PanelIMGSalir.setBackground(new java.awt.Color(27,34,36));
        PanelIMGUsuario.setBackground(new java.awt.Color(27,34,36));
        PanelEmpleado.setBackground(new java.awt.Color(27,34,36));
        PanelCliente.setBackground(new java.awt.Color(27,34,36));
        PanelVentas.setBackground(new java.awt.Color(27,34,36));
        PanelPunto.setBackground(new java.awt.Color(27,34,36));
        PanelCorte.setBackground(new java.awt.Color(27,34,36));
        PanelPedidos.setBackground(new java.awt.Color(27,34,36));
        PanelProductos.setBackground(new java.awt.Color(27,34,36));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTitulo = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        TortiyaLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelUsuario = new javax.swing.JPanel();
        BotonUsuario = new javax.swing.JButton();
        PanelEmpleado = new javax.swing.JPanel();
        BotonEmpleado = new javax.swing.JButton();
        PanelIMGEmpleado = new javax.swing.JPanel();
        BotonIconoEmpleados = new javax.swing.JButton();
        PanelIMGUsuario = new javax.swing.JPanel();
        UsuarioIcon = new javax.swing.JLabel();
        PanelCliente = new javax.swing.JPanel();
        BotonCliente = new javax.swing.JButton();
        PanelIMGCliente = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        PanelProductos = new javax.swing.JPanel();
        BotonProductos = new javax.swing.JButton();
        PanelIMGProductos = new javax.swing.JPanel();
        BotonIconProductos = new javax.swing.JButton();
        PanelPedidos = new javax.swing.JPanel();
        BotonPedidos = new javax.swing.JButton();
        PanelIMGPedidos = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        PanelVentas = new javax.swing.JPanel();
        BotonVentas = new javax.swing.JButton();
        PanelIMGVentas = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        PanelPunto = new javax.swing.JPanel();
        BotonPunto = new javax.swing.JButton();
        PanelCorte = new javax.swing.JPanel();
        BotonCorte = new javax.swing.JButton();
        PanelIMGPunto = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        PanelIMGCorte = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        PanelSalir = new javax.swing.JPanel();
        BotonSalir = new javax.swing.JButton();
        PanelIMGSalir = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(880, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTitulo.setBackground(new java.awt.Color(255, 199, 125));
        PanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("TortiYa");
        PanelTitulo.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 58));

        getContentPane().add(PanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 740, 60));

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TortiyaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logo4.png"))); // NOI18N
        Contenido.add(TortiyaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 260, 270));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido al Sistema TortiYa");
        Contenido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        getContentPane().add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 780, 480));

        PanelUsuario.setBackground(new java.awt.Color(27, 34, 36));

        BotonUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonUsuario.setForeground(new java.awt.Color(204, 204, 204));
        BotonUsuario.setText("Usuario");
        BotonUsuario.setBorder(null);
        BotonUsuario.setContentAreaFilled(false);
        BotonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelUsuarioLayout = new javax.swing.GroupLayout(PanelUsuario);
        PanelUsuario.setLayout(PanelUsuarioLayout);
        PanelUsuarioLayout.setHorizontalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotonUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        PanelUsuarioLayout.setVerticalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotonUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        getContentPane().add(PanelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 60));

        PanelEmpleado.setBackground(new java.awt.Color(27, 34, 36));

        BotonEmpleado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        BotonEmpleado.setText("Empleados");
        BotonEmpleado.setBorder(null);
        BotonEmpleado.setContentAreaFilled(false);
        BotonEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonEmpleadoMouseExited(evt);
            }
        });
        BotonEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEmpleadoLayout = new javax.swing.GroupLayout(PanelEmpleado);
        PanelEmpleado.setLayout(PanelEmpleadoLayout);
        PanelEmpleadoLayout.setHorizontalGroup(
            PanelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpleadoLayout.createSequentialGroup()
                .addComponent(BotonEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelEmpleadoLayout.setVerticalGroup(
            PanelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotonEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(PanelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 100, 60));

        PanelIMGEmpleado.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelIMGEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonIconoEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Clientes.png"))); // NOI18N
        BotonIconoEmpleados.setBorder(null);
        BotonIconoEmpleados.setBorderPainted(false);
        BotonIconoEmpleados.setContentAreaFilled(false);
        BotonIconoEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonIconoEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonIconoEmpleadosMouseExited(evt);
            }
        });
        BotonIconoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIconoEmpleadosActionPerformed(evt);
            }
        });
        PanelIMGEmpleado.add(BotonIconoEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(PanelIMGEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 60, 60));

        PanelIMGUsuario.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsuarioIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usu45.png"))); // NOI18N
        PanelIMGUsuario.add(UsuarioIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 60));

        getContentPane().add(PanelIMGUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        PanelCliente.setBackground(new java.awt.Color(27, 34, 36));

        BotonCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonCliente.setForeground(new java.awt.Color(204, 204, 204));
        BotonCliente.setText("Clientes");
        BotonCliente.setBorder(null);
        BotonCliente.setContentAreaFilled(false);
        BotonCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonClienteMouseExited(evt);
            }
        });
        BotonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelClienteLayout = new javax.swing.GroupLayout(PanelCliente);
        PanelCliente.setLayout(PanelClienteLayout);
        PanelClienteLayout.setHorizontalGroup(
            PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelClienteLayout.setVerticalGroup(
            PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(PanelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 100, 60));

        PanelIMGCliente.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Empleados45.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        PanelIMGCliente.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(PanelIMGCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 60, 60));

        PanelProductos.setBackground(new java.awt.Color(27, 34, 36));

        BotonProductos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonProductos.setForeground(new java.awt.Color(204, 204, 204));
        BotonProductos.setText("Productos");
        BotonProductos.setBorder(null);
        BotonProductos.setContentAreaFilled(false);
        BotonProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonProductosMouseExited(evt);
            }
        });
        BotonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelProductosLayout = new javax.swing.GroupLayout(PanelProductos);
        PanelProductos.setLayout(PanelProductosLayout);
        PanelProductosLayout.setHorizontalGroup(
            PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductosLayout.createSequentialGroup()
                .addComponent(BotonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        PanelProductosLayout.setVerticalGroup(
            PanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(PanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 60));

        PanelIMGProductos.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonIconProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Products45.png"))); // NOI18N
        BotonIconProductos.setBorder(null);
        BotonIconProductos.setBorderPainted(false);
        BotonIconProductos.setContentAreaFilled(false);
        BotonIconProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonIconProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonIconProductosMouseExited(evt);
            }
        });
        BotonIconProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIconProductosActionPerformed(evt);
            }
        });
        PanelIMGProductos.add(BotonIconProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(PanelIMGProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 60, 60));

        PanelPedidos.setBackground(new java.awt.Color(27, 34, 36));
        PanelPedidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonPedidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonPedidos.setForeground(new java.awt.Color(204, 204, 204));
        BotonPedidos.setText("Pedidos");
        BotonPedidos.setBorder(null);
        BotonPedidos.setContentAreaFilled(false);
        BotonPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonPedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonPedidosMouseExited(evt);
            }
        });
        BotonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPedidosActionPerformed(evt);
            }
        });
        PanelPedidos.add(BotonPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        getContentPane().add(PanelPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 100, 60));

        PanelIMGPedidos.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGPedidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pedidos45.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        PanelIMGPedidos.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(PanelIMGPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 60, 60));

        PanelVentas.setBackground(new java.awt.Color(27, 34, 36));

        BotonVentas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonVentas.setForeground(new java.awt.Color(204, 204, 204));
        BotonVentas.setText("Ventas");
        BotonVentas.setBorder(null);
        BotonVentas.setContentAreaFilled(false);
        BotonVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonVentasMouseExited(evt);
            }
        });
        BotonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelVentasLayout = new javax.swing.GroupLayout(PanelVentas);
        PanelVentas.setLayout(PanelVentasLayout);
        PanelVentasLayout.setHorizontalGroup(
            PanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVentasLayout.createSequentialGroup()
                .addComponent(BotonVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        PanelVentasLayout.setVerticalGroup(
            PanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelVentasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(PanelVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 100, -1));

        PanelIMGVentas.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Ventas45.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        PanelIMGVentas.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(PanelIMGVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 60, 60));

        PanelPunto.setBackground(new java.awt.Color(27, 34, 36));
        PanelPunto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonPunto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonPunto.setForeground(new java.awt.Color(204, 204, 204));
        BotonPunto.setText("Punto Venta");
        BotonPunto.setBorder(null);
        BotonPunto.setContentAreaFilled(false);
        BotonPunto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonPunto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonPuntoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonPuntoMouseExited(evt);
            }
        });
        BotonPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPuntoActionPerformed(evt);
            }
        });
        PanelPunto.add(BotonPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        getContentPane().add(PanelPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 100, 60));

        PanelCorte.setBackground(new java.awt.Color(27, 34, 36));

        BotonCorte.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonCorte.setForeground(new java.awt.Color(204, 204, 204));
        BotonCorte.setText("Reporte Caja");
        BotonCorte.setBorder(null);
        BotonCorte.setContentAreaFilled(false);
        BotonCorte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonCorte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonCorteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonCorteMouseExited(evt);
            }
        });
        BotonCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCorteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCorteLayout = new javax.swing.GroupLayout(PanelCorte);
        PanelCorte.setLayout(PanelCorteLayout);
        PanelCorteLayout.setHorizontalGroup(
            PanelCorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCorteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelCorteLayout.setVerticalGroup(
            PanelCorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCorteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(PanelCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 100, -1));

        PanelIMGPunto.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGPunto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PuntoVenta45.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        PanelIMGPunto.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(PanelIMGPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 60, 60));

        PanelIMGCorte.setBackground(new java.awt.Color(27, 34, 36));
        PanelIMGCorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/CorteCaja45.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        PanelIMGCorte.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(PanelIMGCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 60, 60));

        PanelSalir.setBackground(new java.awt.Color(27, 34, 36));

        BotonSalir.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(204, 204, 204));
        BotonSalir.setText("Salir");
        BotonSalir.setBorder(null);
        BotonSalir.setContentAreaFilled(false);
        BotonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonSalirMouseExited(evt);
            }
        });
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSalirLayout = new javax.swing.GroupLayout(PanelSalir);
        PanelSalir.setLayout(PanelSalirLayout);
        PanelSalirLayout.setHorizontalGroup(
            PanelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        PanelSalirLayout.setVerticalGroup(
            PanelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(PanelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 100, 60));

        PanelIMGSalir.setBackground(new java.awt.Color(27, 34, 36));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cerrar45.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelIMGSalirLayout = new javax.swing.GroupLayout(PanelIMGSalir);
        PanelIMGSalir.setLayout(PanelIMGSalirLayout);
        PanelIMGSalirLayout.setHorizontalGroup(
            PanelIMGSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIMGSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelIMGSalirLayout.setVerticalGroup(
            PanelIMGSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIMGSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(PanelIMGSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 60, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEmpleadoActionPerformed
        this.SetColors();
        PanelEmpleado.setBackground(new java.awt.Color(20, 26, 27));
        BotonEmpleado.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGEmpleado.setBackground(new java.awt.Color(255, 255, 153));
        PanelEmpleadoConsulta AD = new PanelEmpleadoConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(AD);
        Contenido.revalidate();
        LabelTitulo.setText("Empleados");
    }//GEN-LAST:event_BotonEmpleadoActionPerformed

    private void BotonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClienteActionPerformed
        this.SetColors();
        PanelCliente.setBackground(new java.awt.Color(20, 26, 27));
        BotonCliente.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGCliente.setBackground(new java.awt.Color(255, 255, 153));
        PanelClienteConsulta AD = new PanelClienteConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(AD);
        Contenido.revalidate();
        LabelTitulo.setText("Clientes");
    }//GEN-LAST:event_BotonClienteActionPerformed

    private void BotonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonProductosActionPerformed
        this.SetColors();
        PanelProductos.setBackground(new java.awt.Color(20, 26, 27));
        BotonProductos.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGProductos.setBackground(new java.awt.Color(255, 255, 153));
        PanelProductoConsulta AD = new PanelProductoConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(AD);
        Contenido.revalidate();
        LabelTitulo.setText("Productos");

    }//GEN-LAST:event_BotonProductosActionPerformed

    private void BotonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPedidosActionPerformed
        this.SetColors();
        PanelPedidos.setBackground(new java.awt.Color(20, 26, 27));
        BotonPedidos.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGPedidos.setBackground(new java.awt.Color(255, 255, 153));
        PanelPedidosConsulta PPC = new PanelPedidosConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PPC);
        Contenido.revalidate();
        LabelTitulo.setText("Pedidos");
    }//GEN-LAST:event_BotonPedidosActionPerformed

    private void BotonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentasActionPerformed
        this.SetColors();
        PanelVentas.setBackground(new java.awt.Color(20, 26, 27));
        BotonVentas.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGVentas.setBackground(new java.awt.Color(255, 255, 153));
        PanelVentasConsulta PVC = new PanelVentasConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PVC);
        Contenido.revalidate();
        LabelTitulo.setText("Ventas");
    }//GEN-LAST:event_BotonVentasActionPerformed

    private void BotonCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCorteActionPerformed
        this.SetColors();
        PanelCorte.setBackground(new java.awt.Color(20, 26, 27));
        BotonCorte.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGCorte.setBackground(new java.awt.Color(255, 255, 153));
        PanelReporteDeCaja PVC = new PanelReporteDeCaja(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PVC);
        Contenido.revalidate();
        LabelTitulo.setText("Reporte de Caja");
    }//GEN-LAST:event_BotonCorteActionPerformed

    private void BotonPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPuntoActionPerformed
        this.SetColors();
        PanelPunto.setBackground(new java.awt.Color(20, 26, 27));
        BotonPunto.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGPunto.setBackground(new java.awt.Color(255, 255, 153));
        PanelPuntoDeVenta PPC = new PanelPuntoDeVenta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PPC);
        Contenido.revalidate();
        LabelTitulo.setText("Punto de Venta");
    }//GEN-LAST:event_BotonPuntoActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        this.dispose();
        PU.MsgCerrar();
        Login LO = new Login();
        LO.setVisible(true);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuarioActionPerformed
        PU.Usuario(this, usu,st);
    }//GEN-LAST:event_BotonUsuarioActionPerformed

    private void BotonIconoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIconoEmpleadosActionPerformed
        this.SetColors();
        PanelEmpleado.setBackground(new java.awt.Color(20, 26, 27));
        BotonEmpleado.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGEmpleado.setBackground(new java.awt.Color(255, 255, 153));
        PanelEmpleadoConsulta AD = new PanelEmpleadoConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(AD);
        Contenido.revalidate();
        LabelTitulo.setText("Empleados");
    }//GEN-LAST:event_BotonIconoEmpleadosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.SetColors();
        PanelCliente.setBackground(new java.awt.Color(20, 26, 27));
        BotonCliente.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGCliente.setBackground(new java.awt.Color(255, 255, 153));
        PanelClienteConsulta AD = new PanelClienteConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(AD);
        Contenido.revalidate();
        LabelTitulo.setText("Clientes");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BotonIconProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIconProductosActionPerformed
        this.SetColors();
        PanelProductos.setBackground(new java.awt.Color(20, 26, 27));
        BotonProductos.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGProductos.setBackground(new java.awt.Color(255, 255, 153));
        PanelProductoConsulta AD = new PanelProductoConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(AD);
        Contenido.revalidate();
        LabelTitulo.setText("Productos");
    }//GEN-LAST:event_BotonIconProductosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.SetColors();
        PanelPedidos.setBackground(new java.awt.Color(20, 26, 27));
        BotonPedidos.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGPedidos.setBackground(new java.awt.Color(255, 255, 153));
        PanelPedidosConsulta PPC = new PanelPedidosConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PPC);
        Contenido.revalidate();
        LabelTitulo.setText("Pedidos");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.SetColors();
        PanelVentas.setBackground(new java.awt.Color(20, 26, 27));
        BotonVentas.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGVentas.setBackground(new java.awt.Color(255, 255, 153));
        PanelVentasConsulta PVC = new PanelVentasConsulta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PVC);
        Contenido.revalidate();
        LabelTitulo.setText("Ventas");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.SetColors();
        PanelCorte.setBackground(new java.awt.Color(20, 26, 27));
        BotonCorte.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGCorte.setBackground(new java.awt.Color(255, 255, 153));
        PanelReporteDeCaja PVC = new PanelReporteDeCaja(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PVC);
        Contenido.revalidate();
        LabelTitulo.setText("Reporte de Caja");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.SetColors();
        PanelPunto.setBackground(new java.awt.Color(20, 26, 27));
        BotonPunto.setForeground(new java.awt.Color(255, 255, 153));
        PanelIMGPunto.setBackground(new java.awt.Color(255, 255, 153));
        PanelPuntoDeVenta PPC = new PanelPuntoDeVenta(this,con,usu);
        Contenido.setLayout(new java.awt.BorderLayout());
        Contenido.removeAll();
        Contenido.add(PPC);
        Contenido.revalidate();
        LabelTitulo.setText("Punto de Venta");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void BotonEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEmpleadoMouseEntered
        if(PanelEmpleado.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelEmpleado.setBackground(new java.awt.Color(55,76,81));
        PanelIMGEmpleado.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonEmpleadoMouseEntered

    private void BotonEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEmpleadoMouseExited
        if(PanelEmpleado.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelEmpleado.setBackground(new java.awt.Color(27,34,36));
        PanelIMGEmpleado.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonEmpleadoMouseExited

    private void BotonIconoEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonIconoEmpleadosMouseEntered
        if(PanelEmpleado.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelEmpleado.setBackground(new java.awt.Color(55,76,81));
        PanelIMGEmpleado.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonIconoEmpleadosMouseEntered

    private void BotonIconoEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonIconoEmpleadosMouseExited
        if(PanelEmpleado.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelEmpleado.setBackground(new java.awt.Color(27,34,36));
        PanelIMGEmpleado.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonIconoEmpleadosMouseExited

    private void BotonClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonClienteMouseEntered
        if(PanelCliente.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelCliente.setBackground(new java.awt.Color(55,76,81));
        PanelIMGCliente.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonClienteMouseEntered

    private void BotonClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonClienteMouseExited
        if(PanelCliente.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelCliente.setBackground(new java.awt.Color(27,34,36));
        PanelIMGCliente.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonClienteMouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        if(PanelCliente.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelCliente.setBackground(new java.awt.Color(55,76,81));
        PanelIMGCliente.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        if(PanelCliente.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelCliente.setBackground(new java.awt.Color(27,34,36));
        PanelIMGCliente.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_jButton3MouseExited

    private void BotonProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProductosMouseEntered
        if(PanelProductos.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelProductos.setBackground(new java.awt.Color(55,76,81));
        PanelIMGProductos.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonProductosMouseEntered

    private void BotonProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProductosMouseExited
        if(PanelProductos.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelProductos.setBackground(new java.awt.Color(27,34,36));
        PanelIMGProductos.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonProductosMouseExited

    private void BotonIconProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonIconProductosMouseEntered
        if(PanelProductos.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelProductos.setBackground(new java.awt.Color(55,76,81));
        PanelIMGProductos.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonIconProductosMouseEntered

    private void BotonIconProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonIconProductosMouseExited
        if(PanelProductos.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelProductos.setBackground(new java.awt.Color(27,34,36));
        PanelIMGProductos.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonIconProductosMouseExited

    private void BotonPedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPedidosMouseEntered
        if(PanelPedidos.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelPedidos.setBackground(new java.awt.Color(55,76,81));
        PanelIMGPedidos.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonPedidosMouseEntered

    private void BotonPedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPedidosMouseExited
        if(PanelPedidos.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelPedidos.setBackground(new java.awt.Color(27,34,36));
        PanelIMGPedidos.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonPedidosMouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        if(PanelPedidos.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelPedidos.setBackground(new java.awt.Color(55,76,81));
        PanelIMGPedidos.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        if(PanelPedidos.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelPedidos.setBackground(new java.awt.Color(27,34,36));
        PanelIMGPedidos.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_jButton5MouseExited

    private void BotonVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVentasMouseEntered
        if(PanelVentas.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelVentas.setBackground(new java.awt.Color(55,76,81));
        PanelIMGVentas.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonVentasMouseEntered

    private void BotonVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVentasMouseExited
        if(PanelVentas.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelVentas.setBackground(new java.awt.Color(27,34,36));
        PanelIMGVentas.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonVentasMouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        if(PanelVentas.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelVentas.setBackground(new java.awt.Color(55,76,81));
        PanelIMGVentas.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        if(PanelVentas.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelVentas.setBackground(new java.awt.Color(27,34,36));
        PanelIMGVentas.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_jButton6MouseExited

    private void BotonCorteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCorteMouseEntered
        if(PanelCorte.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelCorte.setBackground(new java.awt.Color(55,76,81));
        PanelIMGCorte.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonCorteMouseEntered

    private void BotonCorteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCorteMouseExited
        if(PanelCorte.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelCorte.setBackground(new java.awt.Color(27,34,36));
        PanelIMGCorte.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonCorteMouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        if(PanelCorte.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelCorte.setBackground(new java.awt.Color(55,76,81));
        PanelIMGCorte.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        if(PanelCorte.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelCorte.setBackground(new java.awt.Color(27,34,36));
        PanelIMGCorte.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_jButton7MouseExited

    private void BotonPuntoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPuntoMouseEntered
        if(PanelPunto.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelPunto.setBackground(new java.awt.Color(55,76,81));
        PanelIMGPunto.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonPuntoMouseEntered

    private void BotonPuntoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPuntoMouseExited
        if(PanelPunto.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelPunto.setBackground(new java.awt.Color(27,34,36));
        PanelIMGPunto.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonPuntoMouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        if(PanelPunto.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelPunto.setBackground(new java.awt.Color(55,76,81));
        PanelIMGPunto.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        if(PanelPunto.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelPunto.setBackground(new java.awt.Color(27,34,36));
        PanelIMGPunto.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_jButton8MouseExited

    private void BotonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonSalirMouseEntered
        if(PanelSalir.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelSalir.setBackground(new java.awt.Color(55,76,81));
        PanelIMGSalir.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_BotonSalirMouseEntered

    private void BotonSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonSalirMouseExited
        if(PanelSalir.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelSalir.setBackground(new java.awt.Color(27,34,36));
        PanelIMGSalir.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_BotonSalirMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        if(PanelSalir.getBackground().equals(new java.awt.Color(27,34,36))){
        PanelSalir.setBackground(new java.awt.Color(55,76,81));
        PanelIMGSalir.setBackground(new java.awt.Color(55,76,81));
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        if(PanelSalir.getBackground().equals(new java.awt.Color(55,76,81))){
        PanelSalir.setBackground(new java.awt.Color(27,34,36));
        PanelIMGSalir.setBackground(new java.awt.Color(27,34,36));
        }
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        PU.MsgCerrar();
        Login LO = new Login();
        LO.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCliente;
    private javax.swing.JButton BotonCorte;
    private javax.swing.JButton BotonEmpleado;
    private javax.swing.JButton BotonIconProductos;
    private javax.swing.JButton BotonIconoEmpleados;
    private javax.swing.JButton BotonPedidos;
    private javax.swing.JButton BotonProductos;
    private javax.swing.JButton BotonPunto;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JButton BotonVentas;
    private javax.swing.JPanel Contenido;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PanelCliente;
    private javax.swing.JPanel PanelCorte;
    private javax.swing.JPanel PanelEmpleado;
    private javax.swing.JPanel PanelIMGCliente;
    private javax.swing.JPanel PanelIMGCorte;
    private javax.swing.JPanel PanelIMGEmpleado;
    private javax.swing.JPanel PanelIMGPedidos;
    private javax.swing.JPanel PanelIMGProductos;
    private javax.swing.JPanel PanelIMGPunto;
    private javax.swing.JPanel PanelIMGSalir;
    private javax.swing.JPanel PanelIMGUsuario;
    private javax.swing.JPanel PanelIMGVentas;
    private javax.swing.JPanel PanelPedidos;
    private javax.swing.JPanel PanelProductos;
    private javax.swing.JPanel PanelPunto;
    private javax.swing.JPanel PanelSalir;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JPanel PanelUsuario;
    private javax.swing.JPanel PanelVentas;
    private javax.swing.JLabel TortiyaLogo;
    private javax.swing.JLabel UsuarioIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
