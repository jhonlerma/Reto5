package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jimmy
 */
public class BaseDatos {

    private Connection conexion;
    private Properties mispropiedades;

    public BaseDatos() {

        mispropiedades = new Properties();
        conexion = null;
        try {
            mispropiedades.load(new FileReader("data/config.properties"));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public Connection abrirConexion() {
        String db = mispropiedades.getProperty("database");
        String ipLocal = mispropiedades.getProperty("IPLocal");
        String username = mispropiedades.getProperty("usuario");
        String password = mispropiedades.getProperty("pass");
        String dbURL = "jdbc:mysql://" + ipLocal + ":3306/" + db + "";
        Connection conn = null;
        try {
            conexion = DriverManager.getConnection(dbURL, username, password);
            if (conexion != null) {
                System.out.println("Conectado");
                return conexion;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    public void closeConexion() {

        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Problema al cerrar conexión base de datos" + e);
        }
    }

    public ResultSet InventarioTotal() {
        PreparedStatement ps;
        ResultSet rs = null;

        String sql = "Select codigo_productos as Código ,nomb_productos as Nombre_Producto,valor_und_productos as Valor_Unidad,valor_venta_productos as Valor_Venta, cantidad_productos as Cantidad_Producto, nomb_categoriaProducto as Categoria from Productos, categoriaproducto  where id_categoriaProductoFK = id_categoriaProducto";

        try {
            //Ejecución de la consulta
            ps = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Problema consulta en la base de datos");
        }
        return rs;
    }

    public void ActualizarInventario(String nombreProducto, double valorUnidad, double valorVenta, int cantidad, int categoria, int idcodigo) {
        PreparedStatement ps;
        String sql = "UPDATE Productos SET nomb_productos = ?, valor_und_productos = ?, valor_venta_productos = ?, cantidad_productos = ?, id_categoriaProductoFK = ? WHERE codigo_productos = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            ps.setDouble(2, valorUnidad);
            ps.setDouble(3, valorVenta);
            ps.setInt(4, cantidad);
            ps.setInt(5, categoria);
            ps.setInt(6, idcodigo);
            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Problema consulta Actualizar en la base de datos" + ex);
        }
    }
    
    public void EliminarProducto(int codigoProducto){
        PreparedStatement ps;
        String sql = "DELETE FROM Productos WHERE codigo_productos = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, codigoProducto);
            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
            
    
    }
    
    public void agregarProducto(int codigo, String nombre, double valorCompra, double valorVenta, int categoria, int cantidad){
        
        PreparedStatement ps;
        String sql = "INSERT FROM Productos WHERE codigo_productos = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

