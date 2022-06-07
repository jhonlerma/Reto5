/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaTablaProductos;
import vista.VistaAgregarInventario;
import vista.VistaDialogo;

/**
 *
 * @author johne
 */
public class ControladorAgregarInventario implements ActionListener{

    VistaAgregarInventario vistaAgregarInventario;
    VistaTablaProductos tablaProductos;
    VistaDialogo vistaDialogo;
    
    public ControladorAgregarInventario(
            VistaAgregarInventario pVistaAgregarInventario,
            VistaTablaProductos pTablaProductos,
            VistaDialogo pvVistaDialogo
    ) {
        
        vistaAgregarInventario = pVistaAgregarInventario;//para ver cambio XD
        tablaProductos = pTablaProductos;
        vistaDialogo = pvVistaDialogo;
        agregarListeners();
    }

    public void agregarListeners(){
        vistaAgregarInventario.botonGuardar.addActionListener(this);
        vistaAgregarInventario.botonVolver.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("GUARDAR_PRODUCTO")) {
            // si error porque ya existe
            if (true) {
                boolean resultado = vistaDialogo.mostrar("El codigo ya existe", "El codigo ya existe, desea editar el inventario?");
                
                if (resultado == true) {
                    
                   tablaProductos.iniciar();
                   vistaAgregarInventario.cerrar();
                }
                
            }
            
        } else if (e.getActionCommand().equals("VOLVER")){
            
            vistaAgregarInventario.padre.mostrar();
            vistaAgregarInventario.cerrar();
        }
    }
    
}
