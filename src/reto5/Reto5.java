package reto5;


import javax.swing.JFrame;
import vista.TablaProductos;
import controlador.ControladorPrincipal;
import controlador.ControladorTablaProductos;
import javax.swing.JComponent;
import vista.VistaBusquedaProducto;
import vista.VistaDialogo;
import vista.VistaPrincipal;


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
        VistaPrincipal vent = new VistaPrincipal();
        VistaBusquedaProducto vent2 = new VistaBusquedaProducto();
        VistaDialogo vent3 = new VistaDialogo(VistaDialogo.TIPO_ERROR, true);
//        ControladorPrincipal contrp = new ControladorPrincipal(vent, vent2, vent3);
        ControladorTablaProductos controlador  = new ControladorTablaProductos(tabla, vent,vent3);
    }

}
