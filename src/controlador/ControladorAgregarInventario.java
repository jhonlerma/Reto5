/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import modelo.BaseDatos;
import vista.VistaTablaProductos;
import vista.VistaAgregarInventario;
import vista.VistaDialogo;

/**
 *
 * @author johne
 */
public class ControladorAgregarInventario implements ActionListener {

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

    public void agregarListeners() {
        vistaAgregarInventario.botonGuardar.addActionListener(this);
        vistaAgregarInventario.botonVolver.addActionListener(this);
        aceptarSoloNumeros(vistaAgregarInventario.textoCodigo);
        aceptarSoloNumeros(vistaAgregarInventario.textoValorCompra);
        aceptarSoloNumeros(vistaAgregarInventario.textoValorVenta);
        aceptarSoloNumeros(vistaAgregarInventario.textoCantidad);

    }

    public void aceptarSoloNumeros(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String value = textField.getText();
                int l = value.length();
                if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    textField.setEditable(true);
                } else {
                    textField.setEditable(false);
                }
            }
        });
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

            if (bd.verificarExistencia(codigo) > 0) {
                boolean resultado = vistaDialogo.mostrar("El codigo ya existe", "El codigo ya existe, desea editar el inventario?");
                if (resultado == true) {

                    vistaTablaProductos.iniciar();
                    vistaAgregarInventario.cerrar();
                }

            } else {
                bd.abrirConexion();
                bd.agregarProducto(codigo, nombre, valorCompra, valorVenta, categoria, cantidad);
            }

        } else if (e.getActionCommand().equals("VOLVER")) {

            vistaAgregarInventario.padre.mostrar();
            vistaAgregarInventario.cerrar();
        }
    }

}
