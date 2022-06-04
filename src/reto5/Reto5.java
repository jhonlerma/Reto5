package reto5;

import vista.BusquedaProducto;
import vista.ModificarInventario;
import vista.Principal;

/**
 *
 * @author johne
 */
public class Reto5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        modelo.BaseDatos conn = new modelo.BaseDatos();
        conn.abrirConexion();
                
        // TODO code application logic here
        ModificarInventario ventena = new ModificarInventario();
        BusquedaProducto vent = new BusquedaProducto();
        Principal vent2 = new Principal();
        
    }
    
}
