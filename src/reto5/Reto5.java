package reto5;


import javax.swing.JFrame;
import vista.VistaTablaProductos;
import controlador.ControladorPrincipal;
import controlador.ControladorTablaProductos;
import javax.swing.JComponent;
import controlador.ControladorAgregarInventario;
import controlador.ControladorBusquedaProducto;
import controlador.ControladorDialogo;
import vista.VistaAgregarInventario;
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

        VistaTablaProductos tabla = new VistaTablaProductos();
        VistaPrincipal principal = new VistaPrincipal();
        VistaAgregarInventario agregarInventario = new VistaAgregarInventario(principal);
        VistaBusquedaProducto busquedaProducto = new VistaBusquedaProducto(principal);
        VistaDialogo dialogo1 = new VistaDialogo(VistaDialogo.TIPO_ERROR, true);
        ControladorDialogo controladorDialogo =new ControladorDialogo(dialogo1);
        ControladorBusquedaProducto controladorBusquedaProducto = new ControladorBusquedaProducto(busquedaProducto,agregarInventario, dialogo1);
        ControladorAgregarInventario controladorAgregarInventario = new ControladorAgregarInventario(agregarInventario, tabla, dialogo1);
        ControladorPrincipal contrp = new ControladorPrincipal(principal, agregarInventario, busquedaProducto, tabla, dialogo1);
        ControladorTablaProductos controlador  = new ControladorTablaProductos(tabla, principal, dialogo1);
    }

}
