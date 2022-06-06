package reto5;

import controlador.ControladorTablaProductos;
import javax.swing.JFrame;
import vista.BusquedaProducto;
import vista.Principal;
import vista.TablaProductos;

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
        TablaProductos tabla = new TablaProductos();
        tabla.iniciar();
        ControladorTablaProductos controlador  = new ControladorTablaProductos();
//        BusquedaProducto vent = new BusquedaProducto();
//        Principal vent2 = new Principal();

    }

}
