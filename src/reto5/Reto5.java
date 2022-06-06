/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto5;

import controlador.ControladorPrincipal;
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
        // TODO code application logic here
        
        VistaPrincipal vent = new VistaPrincipal();
        VistaBusquedaProducto vent2 = new VistaBusquedaProducto();
        VistaDialogo vent3 = new VistaDialogo(VistaDialogo.TIPO_ERROR, true);
        ControladorPrincipal contrp = new ControladorPrincipal(vent, vent2, vent3);
       

        
        
    }
    
}
