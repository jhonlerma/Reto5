/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaPrincipal;

/**
 *
 * @author johne
 */
public class ControladorPrincipal implements ActionListener {

    VistaPrincipal vistaPrincipal;

    public ControladorPrincipal(VistaPrincipal pVistaPrincipal) {
        vistaPrincipal = pVistaPrincipal;
    }

    private void agregarListeners() {
        vistaPrincipal.botonAgregarInventario.addActionListener(this);
        vistaPrincipal.botonBuscarProducto.addActionListener(this);
        vistaPrincipal.botonModificarInventario.addActionListener(this);
        vistaPrincipal.botonVerInventario.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
