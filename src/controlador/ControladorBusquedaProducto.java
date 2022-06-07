/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaBusquedaProducto;

/**
 *
 * @author johne
 */
public class ControladorBusquedaProducto implements ActionListener{
    
    VistaBusquedaProducto vistaBusquedaProducto;
    
    public ControladorBusquedaProducto(VistaBusquedaProducto pVistaBusquedaProducto){
        
        vistaBusquedaProducto = pVistaBusquedaProducto;
        agregarListeners();
    }
    
    public void agregarListeners(){

    vistaBusquedaProducto.botonBuscar.addActionListener(this);
    vistaBusquedaProducto.botonVolver.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("BUSCAR_PRODUCTO")) {
            
        }else if (e.getActionCommand().equals("VOLVER")) {
            vistaBusquedaProducto.padre.mostrar();
            vistaBusquedaProducto.cerrar();
        }
    }
}
