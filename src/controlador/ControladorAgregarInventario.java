/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BaseDatos;
import vista.VistaTablaProductos;
import vista.VistaAgregarInventario;
import vista.VistaDialogo;

/**
 *
 * @author johne
 */
public class ControladorAgregarInventario implements ActionListener{

    VistaAgregarInventario vistaAgregarInventario;
    VistaTablaProductos vistaTablaProductos;
    VistaDialogo vistaDialogo;
    BaseDatos bd = new BaseDatos();
    
    public ControladorAgregarInventario(
            VistaAgregarInventario pVistaAgregarInventario,
            VistaTablaProductos pTablaProductos,
            VistaDialogo pvVistaDialogo
    ) {
        
        vistaAgregarInventario = pVistaAgregarInventario;//para ver cambio XD
        vistaTablaProductos = pTablaProductos;
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
            
            int codigo = Integer.parseInt(vistaAgregarInventario.textoCodigo.getText());
            String nombre = vistaAgregarInventario.textoNombre.getText();
            double valorCompra = Double.parseDouble(vistaAgregarInventario.textoValorCompra.getText());
            double valorVenta = Double.parseDouble(vistaAgregarInventario.textoValorVenta.getText());
            String categoria = vistaAgregarInventario.textoCategoria.getText();
            int cantidad = Integer.parseInt(vistaAgregarInventario.textoCantidad.getText());
            
            bd.abrirConexion();
            bd.agregarProducto(codigo, nombre, valorCompra, valorVenta, categoria, cantidad);
            /*
            if (true) {
                boolean resultado = vistaDialogo.mostrar("El codigo ya existe", "El codigo ya existe, desea editar el inventario?");
                
                if (resultado == true) {
                    
                   vistaTablaProductos.iniciar();
                   vistaAgregarInventario.cerrar();
                }
                
            }
*/
            
        } else if (e.getActionCommand().equals("VOLVER")){
            
            vistaAgregarInventario.padre.mostrar();
            vistaAgregarInventario.cerrar();
        }
    }
    
}
