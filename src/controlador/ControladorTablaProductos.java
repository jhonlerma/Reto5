/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Principal;
import vista.TablaProductos;

/**
 *
 * @author USURIO
 */
public class ControladorTablaProductos implements ActionListener {

    private TablaProductos vistaTablaProductos;
    private Principal vistaprincipal;

    public ControladorTablaProductos() {
        vistaTablaProductos = new TablaProductos();
        vistaprincipal = new Principal();
        agregarListeners();
    }

    public void agregarListeners() {
        vistaTablaProductos.botonvolver.addActionListener(oyenteDeAccion);
        vistaTablaProductos.botonEliminar.addActionListener(oyenteDeAccion);
        vistaTablaProductos.botonEditar.addActionListener(oyenteDeAccion);
    }

    ActionListener oyenteDeAccion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Volver")) {
            System.out.println("Botón volver");

        } else {
            if (e.getActionCommand().equals("Editar")) {
                System.out.println("Botón Editar");

            } else {
                if (e.getActionCommand().equals("Eliminar")) {
                    System.out.println("Botón Eliminar");
                }

            }

        }
    }

}
