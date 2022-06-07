/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VistaTablaProductos;
import vista.VistaAgregarInventario;
import vista.VistaPrincipal;
import vista.VistaBusquedaProducto;
import vista.VistaDialogo;

/**
 *
 * @author johne
 */
public class ControladorPrincipal implements ActionListener {

    VistaPrincipal vistaPrincipal;
    VistaBusquedaProducto vistaBusquedaProducto;
    VistaTablaProductos vistaTablaProductos;
    VistaAgregarInventario vistaAgregarInventario;
    VistaDialogo vistaDialogo;

    public ControladorPrincipal(
            VistaPrincipal pVistaPrincipal,
            VistaAgregarInventario pVistaAgregarInventario,
            VistaBusquedaProducto pVistaBusquedaProducto,
            VistaTablaProductos pVistaTablaProductos,
            VistaDialogo pVistaDialogo
    ) {
        vistaPrincipal = pVistaPrincipal;
        vistaAgregarInventario = pVistaAgregarInventario;
        vistaBusquedaProducto = pVistaBusquedaProducto;
        vistaTablaProductos = pVistaTablaProductos;
        vistaDialogo = pVistaDialogo;
        agregarListeners();
        vistaPrincipal.iniciar();
    }

    private void agregarListeners() {
        vistaPrincipal.botonAgregarInventario.addActionListener(this);
        vistaPrincipal.botonBuscarProducto.addActionListener(this);
        vistaPrincipal.botonModificarInventario.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ABRIR_AGREGAR_INVENTARIO")) {

            vistaAgregarInventario.iniciar();
            vistaPrincipal.ocultar();

        } else if (e.getActionCommand().equals("ABRIR_BUSQUEDA_PRODUCTO")) {

            vistaBusquedaProducto.iniciar();
            vistaPrincipal.ocultar();

        } else if (e.getActionCommand().equals("ABRIR_MODIFICAR_INVENTARIO")) {

            vistaTablaProductos.iniciar();
            vistaPrincipal.ocultar();

        } 
        
    }

}
