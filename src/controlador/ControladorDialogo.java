/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaDialogo;

/**
 *
 * @author johne
 */
public class ControladorDialogo implements ActionListener{
    VistaDialogo vistaDialogo;

    public ControladorDialogo(VistaDialogo pVistaDialogo) {
        vistaDialogo = pVistaDialogo;
        agregarListeners();
    }
    
    public void agregarListeners(){
        vistaDialogo.botonAceptar.addActionListener(this);
        vistaDialogo.botonCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ACEPTAR_DIALOGO")) {
            vistaDialogo.cerrar();
        } else if (e.getActionCommand().equals("CANCELAR_DIALOGO")){
            vistaDialogo.cerrar();
        }
    }
}
