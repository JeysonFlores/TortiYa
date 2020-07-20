package Clases;
import Popups.Popup;
import com.itextpdf.text.DocumentException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Conexion {
    
    File configFile = new File("src/Clases/Config.properties");
    Popup PU = new Popup();
    PDF pdf = new PDF();
    private static Connection con;
    private static String USER;
    private static String PASS;
    private static String URL;
    private static String HOST;
    private static String DB;
    private static String LOCK;
    private static ResultSet rs;
    private Statement s;
    
    public Conexion(){
        GetValues();
    }
    
    public void GetValues(){
        FileReader reader = null;
        try {
            reader = new FileReader(configFile);
            Properties prop = new Properties();
            try {
                prop.load(reader);
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            setUSER(prop.getProperty("mysql.user"));
            setPASS(prop.getProperty("mysql.password"));
            setHOST(prop.getProperty("mysql.host"));
            setDB(prop.getProperty("mysql.db"));
            setURL("jdbc:mysql://"+getHOST()+":3306/"+getDB()+"?useSSL=false");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getLockingDate(){
        FileReader reader = null;
        String res = "";
        try {
            reader = new FileReader(configFile);
            Properties prop = new Properties();
            try {
                prop.load(reader);
                res = prop.getProperty("app.lock.date");
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void setLockingDate(String date){
        String host = "",bd = "",user = "",pass = "";
        FileReader reader = null;
        Properties properties = new Properties();
        try {
            reader = new FileReader(configFile);
            Properties prop = new Properties();
            try {
                prop.load(reader);
                host = prop.getProperty("mysql.host");
                bd = prop.getProperty("mysql.db");
                user = prop.getProperty("mysql.user");
                pass = prop.getProperty("mysql.password");
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try(OutputStream outputStream = new FileOutputStream("src/Clases/Config.properties")){ 
            properties.setProperty("mysql.host", host);
            properties.setProperty("mysql.db", bd);
            properties.setProperty("mysql.user", user);
            properties.setProperty("mysql.password", pass);
            properties.setProperty("app.lock.date", date);
            properties.store(outputStream, null);
        }
        catch (IOException e) {
         }
    }
    
    public void setValues(javax.swing.JFrame main, String host,String bd,String user,String pass){
        String DateLock="";
        Properties properties = new Properties();
        Properties prop = new Properties();
        FileReader reader = null;
        
        try {
            reader = new FileReader(configFile);
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            prop.load(reader);
        }
        catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DateLock = prop.getProperty("app.lock.date");
        
        try(OutputStream outputStream = new FileOutputStream("src/Clases/Config.properties")){ 
            properties.setProperty("mysql.host", host);
            properties.setProperty("mysql.db", bd);
            properties.setProperty("mysql.user", user);
            properties.setProperty("mysql.password", pass);
            properties.setProperty("app.lock.date", DateLock);
            properties.store(outputStream, null);
        }
        catch (IOException e) {
         }
        //JOptionPane.showMessageDialog(null,"ok");
        PU.Exito(main,"Conexión Guardada");
        
    }
    
    public Connection Conectar(){
        con = null;
        try{
             con = DriverManager.getConnection("jdbc:mysql://"+getHOST()+":3306/"+getDB()+"?user="+getUSER()+"&password="+getPASS()+"");
             s=con.createStatement();
             if(con!=null){
                 JOptionPane.showMessageDialog(null, "Base de datos conectada");
                return con;
             }
         }
         catch(SQLException e){
             System.out.println(e);
         }
       return con;
    }
    
    public Connection Conectar(javax.swing.JFrame main){
        con = null;
        try{
             con = DriverManager.getConnection("jdbc:mysql://"+getHOST()+":3306/"+getDB()+"?user="+getUSER()+"&password="+getPASS()+"");
             s=con.createStatement();
             if(con!=null){
                 PU.Exito(main, "Conexión Exitosa");
                return con;
             }
         }
         catch(SQLException e){
                System.out.println(e);
                PU.Error(main,"Conexión Fallida");
         }
       return con;
    }
    
    public Connection ConectarLogin(javax.swing.JFrame main){
        con = null;
        try{
             con = DriverManager.getConnection("jdbc:mysql://"+getHOST()+":3306/"+getDB()+"?user="+getUSER()+"&password="+getPASS()+"");
             s=con.createStatement();
             if(con!=null){  
                return con;
             }
         }
         catch(SQLException e){
             System.out.println(e);
             PU.Error(main,"Conexión Fallida");
         }
       return con;
    }
    
    
    public boolean ConsultaLogin(Connection Cone,String Cadena){
        String cont = "SELECT count(*) FROM `empleados` WHERE status='A' AND idempleado = "+Cadena+";";
        int contr = -1;
        try {           
            s = Cone.prepareStatement(cont);
            rs = s.executeQuery(cont);
            if(rs.next())
                if(rs.getInt(1) == 1)
                    contr = 1;
                else
                    contr = 0;
        } catch (SQLException ex) {
            //Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contr == 1;
    }
    
    
    public Usuario PostConsultaLogin(Usuario usu,Connection Cone,String Cadena){
        String cons = "SELECT * FROM `empleados` WHERE status='A' AND idempleado = "+Cadena+"";
        try {
            s = Cone.prepareStatement(cons);
            rs = s.executeQuery(cons);
            if(rs.next()){
                usu.setClave(rs.getString("idempleado"));
                usu.setNombre(rs.getString("nombres")+" "+rs.getString("apellidos"));
                usu.setPuesto(rs.getString("puesto"));
                usu.setFechaNac(rs.getString("fecha_nac"));
                usu.setSexo(rs.getString("sexo"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setCURP(rs.getString("curp"));
                usu.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException ex) {
            //PU.ErrorSimple("Error Inesperado");
        }
        return usu;
    }
    
    public DefaultTableModel ActualizarEmpleados(Connection cone,String busqueda,boolean eliminado){
        String datos[];
        String query;
        PreparedStatement consul = null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Puesto");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Sexo");
        model.addColumn("Direccion");
        model.addColumn("CURP");
        model.addColumn("Telefono");
        if(eliminado==false){
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM empleados WHERE status = 'A'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM empleados WHERE status = 'A' AND nombres LIKE ?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda+"%");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        else{
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM empleados WHERE status = 'B'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM empleados WHERE status = 'B'AND nombres LIKE ?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda+"%");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        
        try{
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[9];
                datos[0] = rs.getString("idempleado");
                datos[1] = rs.getString("nombres");
                datos[2] = rs.getString("apellidos");
                datos[3] = rs.getString("puesto");
                datos[4] = rs.getString("fecha_nac");
                datos[5] = rs.getString("sexo");
                datos[6] = rs.getString("direccion");
                datos[7] = rs.getString("curp");
                datos[8] = rs.getString("telefono");
                model.addRow(datos);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel BuscarEmpleados(Connection cone,String busqueda,boolean eliminado){
        String datos[];
        String query;
        PreparedStatement consul = null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Puesto");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Sexo");
        model.addColumn("Direccion");
        model.addColumn("CURP");
        model.addColumn("Telefono");
        if(eliminado==false){
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM empleados WHERE status = 'A'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM empleados WHERE status = 'A' AND nombres=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        else{
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM empleados WHERE status = 'B'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM empleados WHERE status = 'B'AND nombres=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        
        try{
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[9];
                datos[0] = rs.getString("idempleado");
                datos[1] = rs.getString("nombres");
                datos[2] = rs.getString("apellidos");
                datos[3] = rs.getString("puesto");
                datos[4] = rs.getString("fecha_nac");
                datos[5] = rs.getString("sexo");
                datos[6] = rs.getString("direccion");
                datos[7] = rs.getString("curp");
                datos[8] = rs.getString("telefono");
                model.addRow(datos);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    
    public DefaultTableModel ActualizarClientes(Connection cone,String busqueda,boolean eliminado){
        String datos[];
        String query;
        PreparedStatement consul = null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Contacto");
        model.addColumn("Telefono");
        model.addColumn("Direccion");
        model.addColumn("Empleado Asignado");
        if(eliminado==false){
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='A'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='A' AND clientes.nombre LIKE ?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda+"%");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        else{
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='B'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='B' AND clientes.nombre LIKE ?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda+"%");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        
        try{
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[6];
                datos[0] = rs.getString("idcliente");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("contacto");
                datos[3] = rs.getString("telefono");
                datos[4] = rs.getString("direccion");
                datos[5] = rs.getString("empleado_asignado");
                model.addRow(datos);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel BuscarClientes(Connection cone,String busqueda,boolean eliminado){
        String datos[];
        String query;
        PreparedStatement consul = null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Contacto");
        model.addColumn("Telefono");
        model.addColumn("Direccion");
        model.addColumn("Empleado Asignado");
        if(eliminado==false){
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='A'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='A' AND clientes.nombre=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        else{
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='B'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT clientes.idcliente,nombre,clientes.direccion,clientes.telefono,clientes.contacto,CONCAT(empleados.nombres,' ',empleados.apellidos) as empleado_asignado FROM clientes INNER JOIN empleados WHERE clientes.fk_idempleado = empleados.idempleado AND clientes.status='B' AND clientes.nombre=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        
        try{
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[6];
                datos[0] = rs.getString("idcliente");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("contacto");
                datos[3] = rs.getString("telefono");
                datos[4] = rs.getString("direccion");
                datos[5] = rs.getString("empleado_asignado");
                model.addRow(datos);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel ActualizarProductos(Connection cone,String busqueda,boolean eliminado){
        String datos[];
        String query;
        PreparedStatement consul = null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Existencia");
        model.addColumn("Descripcion");
        model.addColumn("Precio($)");
        if(eliminado==false){
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM productos WHERE status = 'A'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM productos WHERE status = 'A' AND nombre LIKE ?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda+"%");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        else{
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM productos WHERE status = 'B'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM productos WHERE status = 'B'AND nombre LIKE ?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda+"%");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        
        try{
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[5];
                datos[0] = rs.getString("idproducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("existencia");
                datos[3] = rs.getString("descripcion");
                datos[4] = rs.getString("precio");
                model.addRow(datos);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel BuscarProductos(Connection cone,String busqueda,boolean eliminado){
        String datos[];
        String query;
        PreparedStatement consul = null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Existencia");
        model.addColumn("Descripcion");
        model.addColumn("Precio($)");
        if(eliminado==false){
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM productos WHERE status = 'A'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM productos WHERE status = 'A' AND nombre=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        else{
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM productos WHERE status = 'B'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM productos WHERE status = 'B'AND nombre=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        
        try{
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[5];
                datos[0] = rs.getString("idproducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("existencia");
                datos[3] = rs.getString("descripcion");
                datos[4] = rs.getString("precio");
                model.addRow(datos);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public void BajaEmpleado(Connection cone,String id){
        String down = "UPDATE empleados SET status = 'B' where idempleado=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(down);
            consulta.setString(1, id);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReactivarEmpleado(Connection cone,String id){
        String down = "UPDATE empleados SET status = 'A' where idempleado=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(down);
            consulta.setString(1, id);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BajaCliente(Connection cone,String id){
        String down = "UPDATE clientes SET status = 'B' where idcliente=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(down);
            consulta.setString(1, id);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReactivarCliente(Connection cone,String id){
        String down = "UPDATE clientes SET status = 'A' where idcliente=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(down);
            consulta.setString(1, id);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BajaProducto(Connection cone,String id){
        String down = "UPDATE productos SET status = 'B' where idproducto=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(down);
            consulta.setString(1, id);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int ProductoOcupado(Connection cone,String id){
        int cant = -1;
        String query="SELECT COUNT(*) FROM detalle_pedidos \n" +
"	INNER JOIN pedidos ON detalle_pedidos.fk_idpedido = pedidos.idpedido\n" +
"		WHERE detalle_pedidos.fk_idproducto=? AND pedidos.status = 'P'";
        try {
            PreparedStatement consulta = cone.prepareStatement(query);
            consulta.setString(1, id);
            rs = consulta.executeQuery();
            while(rs.next()){
                cant = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
    }
    
    public void ReactivarProducto(Connection cone,String id){
            String down = "UPDATE productos SET status = 'A' where idproducto=?";
            try {
                PreparedStatement consulta = cone.prepareStatement(down);
                consulta.setString(1, id);
                consulta.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public DefaultComboBoxModel ConsultaBoxEmpleado(Connection cone){
        String query = "select CONCAT(nombres,' ',apellidos) as nom_comp FROM empleados WHERE status='A'";
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try{
            PreparedStatement consulta = cone.prepareStatement(query);
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
                model.addElement(rs.getString(1));
            }
        }
        catch(SQLException ex){
         Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
        return model;
    }
    
    public void AltaCliente(Connection cone,String nombre,String dire,String contacto,String telefono,String empleado){
        String queryid = "SELECT idempleado FROM empleados WHERE CONCAT(nombres,' ',apellidos)=?";
        String idauto = "SELECT idcliente FROM clientes ORDER BY idcliente";
        String query = "INSERT INTO clientes(idcliente,nombre,contacto,telefono,direccion,status,fk_idempleado) VALUES(?,?,?,?,?,'A',?)";
        String idempleado="";
        int idcliente=0;
        try {
            PreparedStatement consulta = cone.prepareStatement(idauto);
            ResultSet rs = consulta.executeQuery();
            rs.last();
            idcliente = rs.getInt("idcliente")+1;
            consulta = cone.prepareStatement(queryid);
            consulta.setString(1, empleado);
            rs = consulta.executeQuery();
            while(rs.next()){
                idempleado = rs.getString(1);
            }
            consulta = cone.prepareStatement(query);
            consulta.setString(1, idcliente+"");
            consulta.setString(2, nombre);
            consulta.setString(3, contacto);
            consulta.setString(4, telefono);
            consulta.setString(5, dire);
            consulta.setString(6, idempleado);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void EditarCliente(Connection cone,String ID,String nombre,String dire,String contacto,String telefono,String empleado){
        String queryid = "SELECT idempleado FROM empleados WHERE CONCAT(nombres,' ',apellidos)=?";
        String update = "UPDATE clientes SET nombre=?,direccion=?,contacto=?,telefono=?,fk_idempleado=? WHERE idcliente=?";
        String idempleado="";
        try {
            PreparedStatement consulta = cone.prepareStatement(queryid);
            consulta.setString(1, empleado);
            ResultSet rss = consulta.executeQuery();
            while(rss.next()){
                idempleado=rss.getString(1);
            }
            consulta = cone.prepareStatement(update);
            consulta.setString(1, nombre);
            consulta.setString(2, dire);
            consulta.setString(3, contacto);
            consulta.setString(4, telefono);
            consulta.setString(5, idempleado);
            consulta.setString(6, ID);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AltaEmpleado(Connection cone,String nombres,String apellidos,String dire,String telefono,String puesto,String curp,String sexo,String fecha_nac){
        String query = "INSERT INTO empleados(idempleado,nombres,apellidos,direccion,telefono,puesto,curp,sexo,fecha_nac,status) VALUES(?,?,?,?,?,?,?,?,?,'A')";
        String idauto = "SELECT idempleado FROM empleados ORDER BY idempleado";
        int idempleado=0;
        try {
            PreparedStatement consulta = cone.prepareStatement(idauto);
            ResultSet rs = consulta.executeQuery();
            rs.last();
            idempleado = rs.getInt("idempleado")+1;
            consulta = cone.prepareStatement(query);
            consulta.setString(1, idempleado+"");
            consulta.setString(2, nombres);
            consulta.setString(3, apellidos);
            consulta.setString(4, dire);
            consulta.setString(5, telefono);
            consulta.setString(6, puesto);
            consulta.setString(7, curp);
            consulta.setString(8, sexo);
            consulta.setString(9, fecha_nac);
            consulta.execute();
        }
        catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void EditarEmpleado(Connection cone,String id,String nombres,String apellidos,String dire,String tele,String curp,String sexo,String puesto,String fecha_nac){
        String update = "UPDATE empleados SET nombres=?,apellidos=?,direccion=?,telefono=?,curp=?,puesto=?,fecha_nac=?,sexo=? WHERE idempleado=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(update);
            consulta.setString(1, nombres);
            consulta.setString(2, apellidos);
            consulta.setString(3, dire);
            consulta.setString(4, tele);
            consulta.setString(5, curp);
            consulta.setString(6, puesto);
            consulta.setString(7, fecha_nac);
            consulta.setString(8, sexo);
            consulta.setString(9, id);
            consulta.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void AltaProducto(Connection cone,String nombre,String existencia,String precio,String desc){
        String idauto = "SELECT idproducto FROM productos ORDER BY idproducto";
        String query = "INSERT INTO productos(idproducto,nombre,existencia,descripcion,precio,status) VALUES(?,?,?,?,?,'A')";
        int idproducto=0;
        try {
            PreparedStatement consulta = cone.prepareStatement(idauto);
            ResultSet rs = consulta.executeQuery();
            rs.last();
            idproducto = rs.getInt("idproducto")+1;
            consulta = cone.prepareStatement(query);
            consulta.setString(1, idproducto+"");
            consulta.setString(2, nombre);
            consulta.setString(3, existencia);
            consulta.setString(4, desc);
            consulta.setString(5, precio);
            consulta.execute();
        }
        catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void EditarProducto(Connection cone,String id,String nombre,String existencia,String desc,String precio){
        String update="UPDATE productos SET nombre=?,existencia=?,descripcion=?,precio=? WHERE idproducto=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(update);
            consulta.setString(1, nombre);
            consulta.setString(2, existencia);
            consulta.setString(3, desc);
            consulta.setString(4, precio);
            consulta.setString(5, id);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel ActualizarPedido(Connection cone,String busqueda,boolean cancelado){
        String datos[] = null;
        String query,ide = null,idc = null;
        String idempl="",idclient="";
        String Cliente="SELECT nombre FROM clientes WHERE idcliente=?";
        String Empleado="SELECT CONCAT(nombres,' ',apellidos) as nombre_c FROM empleados WHERE idempleado=?";
        PreparedStatement consul = null;
        ResultSet rs = null,rss=null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Fecha de Entrega");
        model.addColumn("Valor($)");
        model.addColumn("Cliente");
        model.addColumn("Empleado");
        if(cancelado==false){
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM pedidos WHERE status='P'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM pedidos WHERE status='P' AND fecha=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        else{
            if(busqueda == null || busqueda.isEmpty()){
                query = "SELECT * FROM pedidos WHERE status='C'";
                try {
                    consul = cone.prepareStatement(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                query = "SELECT * FROM pedidos WHERE status='C' AND fecha=?";
                try {
                    consul = cone.prepareStatement(query);
                    consul.setString(1,busqueda);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
        try{
            rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[5];
                datos[0] = rs.getString("idpedido");
                datos[1] = rs.getString("fecha");
                datos[2] = rs.getString("valor");
                idclient = rs.getString("fk_idcliente");
                idempl = rs.getString("fk_idempleado");
                consul = cone.prepareStatement(Cliente);
                consul.setString(1, idclient);
                rss = consul.executeQuery();
                while(rss.next()){
                    idc = rss.getString("nombre");
                }
                consul = cone.prepareStatement(Empleado);
                consul.setString(1, idempl);
                rss = consul.executeQuery();
                while(rss.next()){
                ide = rss.getString("nombre_c");
                }
                datos[3] = idc;
                datos[4] = ide;
                model.addRow(datos);
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public void CancelarPedido(Connection cone,String id){
        String canc = "UPDATE pedidos SET status='C' WHERE idpedido=?";
        try {
            PreparedStatement consulta = cone.prepareStatement(canc);
            consulta.setString(1, id);
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public DefaultTableModel getPŕoductos(Connection cone){
        String datos[];
        String query="SELECT idproducto,nombre,existencia,precio FROM productos WHERE status='A'";
        PreparedStatement consul = null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Existencia");
        model.addColumn("Precio($)(p/u)");
        try{
            consul = cone.prepareStatement(query);
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[4];
                datos[0] = rs.getString("idproducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("existencia");
                datos[3] = rs.getString("precio");
                model.addRow(datos);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultComboBoxModel getClientesGerente(Connection cone){
        String query="SELECT CONCAT(nombre,'(',idcliente,')') AS rar FROM clientes WHERE status='A'";
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        PreparedStatement consul = null;
        try {
            consul = cone.prepareStatement(query);
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    public DefaultComboBoxModel getClientesCajRep(Connection cone,String id){
        String query="SELECT CONCAT(nombre,'(',idcliente,')') AS rar FROM clientes WHERE status='A' AND fk_idempleado=?";
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        PreparedStatement consul = null;
        try {
            consul = cone.prepareStatement(query);
            consul.setString(1,id);
            ResultSet rs = consul.executeQuery();
            while(rs.next()){
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public void ActualizarExistencia(Connection cone,String idprod,String cantped){
        String getcantoriginal = "SELECT existencia FROM productos WHERE idproducto=?";
        String update = "UPDATE productos SET existencia=? WHERE idproducto=?";
        int cantorg=0;
        PreparedStatement consul = null;
        ResultSet rs = null;
        try {
            consul = cone.prepareStatement(getcantoriginal);
            consul.setString(1, idprod);
            rs = consul.executeQuery();
            while(rs.next()){
                cantorg = rs.getInt(1);
            }
            int cantnuev = cantorg - Integer.parseInt(cantped);
            consul = cone.prepareStatement(update);
            consul.setString(1, cantnuev+"");
            consul.setString(2, idprod);
            consul.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void SetDetalleP(Connection cone,String idped,String idprod,String cant,String precp){
        String setdet = "INSERT INTO detalle_pedidos(fk_idpedido,fk_idproducto,cantidad,precio_parcial) VALUES(?,?,?,?)";
        PreparedStatement consul = null;
        ResultSet rs = null;
        try {
            consul = cone.prepareStatement(setdet);
            consul.setString(1, idped);
            consul.setString(2, idprod);
            consul.setString(3, cant);
            consul.setString(4, precp);
            consul.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void RealizarPedido(Connection cone,JTable table,String idempl,String fecha,String cliente,String valor){
        //------------------ Parte 1 ----------------------------------
        String queryid = "SELECT idpedido FROM pedidos ORDER BY idpedido";
        String queryidcliente = "SELECT idcliente FROM clientes WHERE CONCAT(nombre,'(',idcliente,')')=?";
        String npedido = "INSERT INTO pedidos(idpedido,fecha,valor,fk_idempleado,fk_idcliente,status) VALUES(?,?,?,?,?,'P')";
        String ndetalle = "";
        int idpedn = -1;
        int idclient = -1;
        PreparedStatement consul = null;
        ResultSet rs = null;
        try {
            consul = cone.prepareStatement(queryid);
            rs = consul.executeQuery();
            rs.last();
            idpedn = rs.getInt(1)+1;
            consul = cone.prepareStatement(queryidcliente);
            consul.setString(1, cliente);
            rs = consul.executeQuery();
            while(rs.next()){
                idclient = rs.getInt(1);
            }
            consul = cone.prepareStatement(npedido);
            consul.setString(1, idpedn+"");
            consul.setString(2, fecha);
            consul.setString(3, valor);
            consul.setString(4, idempl);
            consul.setString(5, idclient+"");
            consul.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //------------------------- Parte 2 -----------------------------------
            pdf.GenerarPDFPedido(table, idpedn+"", valor, cliente, npedido, fecha);
            
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<table.getRowCount();i++){
            ActualizarExistencia(cone, table.getValueAt(i, 0).toString(),table.getValueAt(i, 2).toString());
            SetDetalleP(cone,idpedn+"",table.getValueAt(i, 0).toString(),table.getValueAt(i, 2).toString(), table.getValueAt(i, 4).toString());
        }
        
    }
    
    public DefaultTableModel getPedidoDetalles(Connection cone,String ID){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        PreparedStatement consul = null;
        ResultSet rs = null;
        String[] s;
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio($)(u)");
        model.addColumn("Precio($)(tot)");
        String query = "SELECT productos.idproducto, productos.nombre, productos.precio, detalle_pedidos.cantidad \n" +
        "FROM bdtortiya.pedidos\n" +
        "JOIN bdtortiya.detalle_pedidos ON pedidos.idpedido = detalle_pedidos.fk_idpedido\n" +
        "JOIN bdtortiya.productos ON detalle_pedidos.fk_idproducto = productos.idproducto WHERE detalle_pedidos.fk_idpedido=?";
        try {
            consul = cone.prepareStatement(query);
            consul.setString(1, ID);
            rs = consul.executeQuery();
            while(rs.next()){
                s = new String[5];
                s[0] = rs.getString("idproducto");
                s[1] = rs.getString("nombre");
                int can = Integer.parseInt(rs.getString("cantidad"));
                s[2] = can+"";
                float fla = Float.parseFloat(rs.getString("precio"));
                s[3] = fla+"";
                float res = fla * can;
                s[4] = res+"";
                model.addRow(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    private void ReestablecerExistencia(Connection cone,String ID,String cant){
        String query = "SELECT existencia FROM productos WHERE idproducto=?";
        String update = "UPDATE productos SET existencia=? WHERE idproducto=?";
        PreparedStatement consul = null;
        ResultSet rs = null;
        int cants = Integer.parseInt(cant);
        int existo=-1;
        int res = -1;
        try {
            consul = cone.prepareStatement(query);
            consul.setString(1, ID);
            rs = consul.executeQuery();
            while(rs.next()){
                existo = rs.getInt(1);
            }
            res = existo + cants;
            consul = cone.prepareStatement(update);
            consul.setString(1,res+"");
            consul.setString(2, ID);
            consul.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
    public void DepurarDetalles(Connection cone,String ID){
        String drop = "DELETE FROM detalle_pedidos WHERE fk_idpedido=?";
        PreparedStatement consul = null;
        try {
            consul = cone.prepareStatement(drop);
            consul.setString(1, ID);
            consul.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EditarPedido(Connection cone,String id,String fecha,String valor,String idcliente,String idemp){
        String update = "UPDATE pedidos SET fecha=?,valor=?,fk_idcliente=?,fk_idempleado=? WHERE idpedido=?";
        PreparedStatement consul = null;
        try {
            consul = cone.prepareStatement(update);
            consul.setString(1, fecha);
            consul.setString(2, valor);
            consul.setString(3, idcliente);
            consul.setString(4, idemp);
            consul.setString(5, id);
            consul.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EditarPedidoTotal(Connection cone,JTable tablan,JTable tablao,String idped,String idempl,String fecha,String cliente,String valor){
        String queryidcliente = "SELECT idcliente FROM clientes WHERE CONCAT(nombre,'(',idcliente,')')=?";
        int idclient = -1;
        PreparedStatement consul = null;
        ResultSet rs = null;
        for(int i = 0;i<tablao.getRowCount();i++){
            ReestablecerExistencia(cone,tablao.getValueAt(i, 0).toString(),tablao.getValueAt(i, 2).toString());
        }
        DepurarDetalles(cone,idped);
        try{
        consul = cone.prepareStatement(queryidcliente);
        consul.setString(1, cliente);
        rs = consul.executeQuery();
        while(rs.next()){
            idclient = rs.getInt(1);
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        EditarPedido(cone,idped,fecha,valor,idclient+"",idempl);
        for(int i = 0;i<tablan.getRowCount();i++){
            ActualizarExistencia(cone, tablan.getValueAt(i, 0).toString(),tablan.getValueAt(i, 2).toString());
            SetDetalleP(cone,idped,tablan.getValueAt(i, 0).toString(),tablan.getValueAt(i, 2).toString() ,tablan.getValueAt(i, 4).toString());
        }
        
        try {
            pdf.GenerarPDFPedido(tablan, idped, valor, cliente, idped, fecha);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getEmpleadoIdFromPedidos(Connection cone,String idped){
        String query = "SELECT fk_idempleado FROM pedidos WHERE idpedido=?";
        PreparedStatement consul = null;
        ResultSet rs = null;
        String res="";
        try {
            consul = cone.prepareStatement(query);
            consul.setString(1, idped);
            rs = consul.executeQuery();
            while(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void SetDetalleV(Connection cone,String idven,String idprod,String cant,String precp){
        String setdet = "INSERT INTO detalle_ventas(fk_idventa,fk_idproducto,cantidad,precio_parcial) VALUES(?,?,?,?)";
        PreparedStatement consul = null;
        ResultSet rs = null;
        try {
            consul = cone.prepareStatement(setdet);
            consul.setString(1, idven);
            consul.setString(2, idprod);
            consul.setString(3, cant);
            consul.setString(4, precp);
            consul.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void RealizarVenta(Connection cone,JTable table,String idempl,String fecha,String valor){
        //------------------ Parte 1 ----------------------------------
        String queryid = "SELECT idventa FROM ventas ORDER BY idventa";
        String npedido = "INSERT INTO ventas(idventa,fecha,valor,fk_idempleado,fk_idcliente) VALUES(?,?,?,?,?)";
        int idven = -1;
        int idclient = 0;
        PreparedStatement consul = null;
        ResultSet rs = null;
        try {
            consul = cone.prepareStatement(queryid);
            rs = consul.executeQuery();
            rs.last();
            idven = rs.getInt(1)+1;
            consul = cone.prepareStatement(npedido);
            consul.setString(1, idven+"");
            consul.setString(2, fecha);
            consul.setString(3, valor);
            consul.setString(4, idempl);
            consul.setString(5, idclient+"");
            consul.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //------------------------- Parte 2 -----------------------------------
        for(int i=0;i<table.getRowCount();i++){
            ActualizarExistencia(cone, table.getValueAt(i, 0).toString(),table.getValueAt(i, 2).toString());
            SetDetalleV(cone,idven+"",table.getValueAt(i, 0).toString(),table.getValueAt(i, 2).toString(), table.getValueAt(i, 4).toString());
        }
        
        try {
            pdf.GenerarPDFVenta(table, idven+"", valor, "", "", fecha);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public DefaultTableModel ConsultaVentas(Connection cone){
        String datos[] = null;
        String query,ide = null,idc = null;
        String idempl="",idclient="";
        String Cliente="SELECT nombre FROM clientes WHERE idcliente=?";
        String Empleado="SELECT CONCAT(nombres,' ',apellidos) as nombre_c FROM empleados WHERE idempleado=?";
        query = "SELECT * FROM ventas";
        PreparedStatement consul = null;
        ResultSet rs = null,rss=null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Fecha de Entrega");
        model.addColumn("Valor($)");
        model.addColumn("Cliente");
        model.addColumn("Empleado");
        try{
            consul = cone.prepareStatement(query);
            rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[5];
                datos[0] = rs.getString("idventa");
                datos[1] = rs.getString("fecha");
                datos[2] = rs.getString("valor");
                idclient = rs.getString("fk_idcliente");
                idempl = rs.getString("fk_idempleado");
                consul = cone.prepareStatement(Cliente);
                consul.setString(1, idclient);
                rss = consul.executeQuery();
                while(rss.next()){
                    idc = rss.getString("nombre");
                }
                consul = cone.prepareStatement(Empleado);
                consul.setString(1, idempl);
                rss = consul.executeQuery();
                while(rss.next()){
                ide = rss.getString("nombre_c");
                }
                datos[3] = idc;
                datos[4] = ide;
                model.addRow(datos);
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public void ConfirmarPedido(Connection cone,JTable table,String idped,String empl,String client,String fecha,String valor){
        String canc = "UPDATE pedidos SET status='E' WHERE idpedido=?";
        String queryid = "SELECT idventa FROM ventas ORDER BY idventa";
        String queryidcli = "SELECT idcliente FROM clientes WHERE nombre=?";
        String npedido = "INSERT INTO ventas(idventa,fecha,valor,fk_idempleado,fk_idcliente) VALUES(?,?,?,?,?)";
        int idven = -1;
        int idclient = 0;
        try {
            PreparedStatement consulta = cone.prepareStatement(canc);
            consulta.setString(1, idped);
            consulta.execute();
            consulta = cone.prepareStatement(queryid);
            rs = consulta.executeQuery();
            rs.last();
            idven = rs.getInt(1)+1;
            consulta = cone.prepareStatement(queryidcli);
            consulta.setString(1, client);
            rs = consulta.executeQuery();
            rs.first();
            idclient = rs.getInt(1);
            consulta = cone.prepareStatement(npedido);
            consulta.setString(1, idven+"");
            consulta.setString(2, fecha);
            consulta.setString(3, valor);
            consulta.setString(4, empl);
            consulta.setString(5, idclient+"");
            consulta.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<table.getRowCount();i++){
            //ActualizarExistencia(cone, table.getValueAt(i, 0).toString(),table.getValueAt(i, 2).toString());
            SetDetalleV(cone,idven+"",table.getValueAt(i, 0).toString(),table.getValueAt(i, 2).toString(), table.getValueAt(i, 4).toString());
        }
        
        try {
            pdf.GenerarPDFVenta(table, idven+"", valor, "", "", fecha);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    public DefaultTableModel getVentaDetalles(Connection cone,String ID){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        PreparedStatement consul = null;
        ResultSet rs = null;
        String[] s;
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio($)(u)");
        model.addColumn("Precio($)(tot)");
        String query = "SELECT productos.idproducto, productos.nombre, productos.precio, detalle_ventas.cantidad \n" +
"        FROM bdtortiya.ventas\n" +
"        JOIN bdtortiya.detalle_ventas ON ventas.idventa = detalle_ventas.fk_idventa \n" +
"        JOIN bdtortiya.productos ON detalle_ventas.fk_idproducto = productos.idproducto WHERE detalle_ventas.fk_idventa=?";
        try {
            consul = cone.prepareStatement(query);
            consul.setString(1, ID);
            rs = consul.executeQuery();
            while(rs.next()){
                s = new String[5];
                s[0] = rs.getString("idproducto");
                s[1] = rs.getString("nombre");
                int can = Integer.parseInt(rs.getString("cantidad"));
                s[2] = can+"";
                float fla = Float.parseFloat(rs.getString("precio"));
                s[3] = fla+"";
                float res = fla * can;
                s[4] = res+"";
                model.addRow(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel ConsultaVentasReporte(Connection cone,String date){
        String datos[] = null;
        String query,ide = null,idc = null;
        String idempl="",idclient="";
        String Cliente="SELECT nombre FROM clientes WHERE idcliente=?";
        String Empleado="SELECT CONCAT(nombres,' ',apellidos) as nombre_c FROM empleados WHERE idempleado=?";
        query = "SELECT * FROM ventas WHERE fecha=?";
        PreparedStatement consul = null;
        ResultSet rs = null,rss=null;
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
    }
        };
        model.addColumn("ID");
        model.addColumn("Fecha de Entrega");
        model.addColumn("Valor($)");
        model.addColumn("Cliente");
        model.addColumn("Empleado");
        try{
            consul = cone.prepareStatement(query);
            consul.setString(1, date);
            rs = consul.executeQuery();
            while(rs.next()){
                datos = new String[5];
                datos[0] = rs.getString("idventa");
                datos[1] = rs.getString("fecha");
                datos[2] = rs.getString("valor");
                idclient = rs.getString("fk_idcliente");
                idempl = rs.getString("fk_idempleado");
                consul = cone.prepareStatement(Cliente);
                consul.setString(1, idclient);
                rss = consul.executeQuery();
                while(rss.next()){
                    idc = rss.getString("nombre");
                }
                consul = cone.prepareStatement(Empleado);
                consul.setString(1, idempl);
                rss = consul.executeQuery();
                while(rss.next()){
                ide = rss.getString("nombre_c");
                }
                datos[3] = idc;
                datos[4] = ide;
                model.addRow(datos);
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    public int CantidadProductoEnDetalle(Connection cone,String id){
        int flag = 0;
        String query = "SELECT cantidad FROM detalle_ventas WHERE fk_idventa=?";
        PreparedStatement consul = null;
        ResultSet rs = null;
        try {
            consul = cone.prepareStatement(query);
            consul.setString(1, id);
            rs = consul.executeQuery();
            while(rs.next()){
                flag += rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Conexion.USER = USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static void setPASS(String PASS) {
        Conexion.PASS = PASS;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        Conexion.URL = URL;
    }

    public static String getHOST() {
        return HOST;
    }

    public static void setHOST(String HOST) {
        Conexion.HOST = HOST;
    }

    public static String getDB() {
        return DB;
    }

    public static void setDB(String DB) {
        Conexion.DB = DB;
    }
    
    public static void setURL(){
        Conexion.URL = "jdbc:mysql://"+Conexion.HOST+":3306/"+Conexion.DB+"?useSSL=false";
    }
    
}
