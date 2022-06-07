/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaAgregarInventario;

/**
 *
 * @author johne
 */
public class ControladorAgregarInventario implements ActionListener{

    VistaAgregarInventario vistaAgregarInventario;
    
    public ControladorAgregarInventario(VistaAgregarInventario pVistaAgregarInventario) {
        
        vistaAgregarInventario = pVistaAgregarInventario;
        agregarListeners();
    }

    public void agregarListeners(){
        vistaAgregarInventario.botonGuardar.addActionListener(this);
        vistaAgregarInventario.botonVolver.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("GUARDAR_PRODUCTO")) {
            
        } else if (e.getActionCommand().equals("VOLVER")){
            
            vistaAgregarInventario.padre.mostrar();
            vistaAgregarInventario.cerrar();
        }
    }
    
}
