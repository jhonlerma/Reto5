
package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jimmy
 */
public class BaseDatos {
    
    private Connection conexion;
    private Properties mispropiedades;
    
    public BaseDatos(){
        
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
    
    public void closeConexion(){
        
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Problema al cerrar conexión base de datos" + e );
        }
    }
    
    public ResultSet InventarioTotal(){
        PreparedStatement ps;
        ResultSet rs = null;
        //modificar consulta ejemplo
        String sql = "SELECT * FROM Clientes";
        try {
            //Ejecución de la consulta
            ps = conexion.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Problema consulta en la base de datos");
        }
        return rs;
    }
}
