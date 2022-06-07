package reto5;


import controlador.ControladorAgregarInventario;
import controlador.ControladorBusquedaProducto;
import controlador.ControladorDialogo;
import vista.TablaProductos;
import controlador.ControladorPrincipal;
import controlador.ControladorTablaProductos;
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
        TablaProductos tabla = new TablaProductos();
        ControladorTablaProductos controlador  = new ControladorTablaProductos();

        VistaPrincipal principal = new VistaPrincipal();
        VistaAgregarInventario agregarInventario = new VistaAgregarInventario(principal);
        VistaBusquedaProducto busquedaProducto = new VistaBusquedaProducto(principal);
        VistaDialogo dialogo1 = new VistaDialogo(VistaDialogo.TIPO_ERROR, true);
        ControladorDialogo controladorDialogo =new ControladorDialogo(dialogo1);
        ControladorBusquedaProducto controladorBusquedaProducto = new ControladorBusquedaProducto(busquedaProducto,agregarInventario, dialogo1);
        ControladorAgregarInventario controladorAgregarInventario = new ControladorAgregarInventario(agregarInventario);
        ControladorPrincipal contrp = new ControladorPrincipal(principal, agregarInventario, busquedaProducto, tabla, dialogo1);
        
    }

}
