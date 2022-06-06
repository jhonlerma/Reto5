/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VistaBusquedaProducto;
import vista.VistaDialogo;
import vista.VistaPrincipal;

/**
 *
 * @author johne
 */
public class ControladorPrincipal implements ActionListener {

    VistaPrincipal vistaPrincipal;
    VistaBusquedaProducto vistaBusquedaProducto;
    VistaDialogo vistaDialogo;

    public ControladorPrincipal(VistaPrincipal pVistaPrincipal, VistaBusquedaProducto pVistaBusquedaProducto, VistaDialogo pVistaDialogo) {
        vistaPrincipal = pVistaPrincipal;
        vistaBusquedaProducto = pVistaBusquedaProducto;
        vistaDialogo = pVistaDialogo;
        agregarListeners();
        vistaPrincipal.iniciar();
    }

    private void agregarListeners() {
        vistaPrincipal.botonAgregarInventario.addActionListener(this);
        vistaPrincipal.botonBuscarProducto.addActionListener(this);
        vistaPrincipal.botonModificarInventario.addActionListener(this);
        vistaPrincipal.botonVerInventario.addActionListener(this);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ABRIR_AGREGAR_INVENTARIO")) {
            
            JOptionPane.showMessageDialog(null, e.getActionCommand());
            
        }else if (e.getActionCommand().equals("ABRIR_BUSQUEDA_PRODUCTO")){
            
            vistaBusquedaProducto.iniciar();
            
        }else if (e.getActionCommand().equals("ABRIR_MODIFICAR_INVENTARIO")){
            
            JOptionPane.showMessageDialog(null, e.getActionCommand());
            
        }else if (e.getActionCommand().equals("ABRIR_VER_INVENTARIO")){
            
            JOptionPane.showMessageDialog(null, e.getActionCommand());
            
        }
    }

}
