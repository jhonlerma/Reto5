/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BaseDatos;
import vista.VistaAgregarInventario;
import vista.VistaBusquedaProducto;
import vista.VistaDialogo;

/**
 *
 * @author johne
 */
public class ControladorBusquedaProducto implements ActionListener{
    
    VistaBusquedaProducto vistaBusquedaProducto;
    VistaAgregarInventario vistaAgregarInventario;
    VistaDialogo vistaDialogo;
    BaseDatos baseDatos;
    
    public ControladorBusquedaProducto(
            VistaBusquedaProducto pVistaBusquedaProducto,
            VistaAgregarInventario pVistaAgregarInventario,
            VistaDialogo pVistaDialogo
    ){
        
        vistaBusquedaProducto = pVistaBusquedaProducto;
        vistaAgregarInventario = pVistaAgregarInventario;
        vistaDialogo = pVistaDialogo;
        baseDatos = new BaseDatos();
        agregarListeners();
    }
    
    public void agregarListeners(){

    vistaBusquedaProducto.botonBuscar.addActionListener(this);
    vistaBusquedaProducto.botonVolver.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("BUSCAR_PRODUCTO")) {
            if (true) {
                // si no existe el codigo mostrar dialogo
                boolean resultado = vistaDialogo.mostrar("No se encuentra el codigo", "No se encuentra el codigo, desea agregarlo al inventario?");
                
                if (resultado == true) {
                    
                   vistaAgregarInventario.iniciar();
                   vistaAgregarInventario.textoCodigo.setText(vistaBusquedaProducto.textoBuscar.getText());
                   vistaBusquedaProducto.cerrar();
                }
                System.out.println(resultado);
            }
        }else if (e.getActionCommand().equals("VOLVER")) {
            vistaBusquedaProducto.padre.mostrar();
            vistaBusquedaProducto.cerrar();
        }
    }
}
