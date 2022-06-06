/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Principal;
import vista.TablaProductos;
import vista.VistaPrincipal;

/**
 *
 * @author USURIO
 */
public class ControladorTablaProductos implements ActionListener {

    private TablaProductos vistaTablaProductos;
    private VistaPrincipal vistaPrincipal;

    public ControladorTablaProductos(TablaProductos pVistaProducto,VistaPrincipal pVistaPrincipal ) {
        vistaTablaProductos = pVistaProducto;
        vistaPrincipal = pVistaPrincipal;
        vistaTablaProductos.iniciar();
        agregarListeners();
    }

    public void agregarListeners() {
        vistaTablaProductos.botonvolver.addActionListener(this);
        vistaTablaProductos.botonEliminar.addActionListener(this);
        vistaTablaProductos.botonEditar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("VOLVER")) {
            System.out.println("Botón volver");
            vistaTablaProductos.cerrar();
            vistaPrincipal.iniciar();

        } else if (e.getActionCommand().equals("EDITAR")) {
            System.out.println("Botón Editar");

        } else if (e.getActionCommand().equals("ELIMINAR")) {
            System.out.println("Botón Eliminar");
        }
    }

}
