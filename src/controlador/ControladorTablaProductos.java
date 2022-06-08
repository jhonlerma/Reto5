/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import vista.VistaTablaProductos;
import vista.VistaDialogo;
import vista.VistaPrincipal;

/**
 *
 * @author Jimmy
 */
public class ControladorTablaProductos implements ActionListener {

    private VistaTablaProductos vistaTablaProductos;
    private VistaPrincipal vistaPrincipal;
    private VistaDialogo vistaDialogo;
    private ResultSet rs;
    private modelo.BaseDatos db = new modelo.BaseDatos();

    public ControladorTablaProductos(VistaTablaProductos pVistaProducto, VistaPrincipal pVistaPrincipal, VistaDialogo PVistaDialogo) {
        vistaTablaProductos = pVistaProducto;
        vistaPrincipal = pVistaPrincipal;
        vistaDialogo = PVistaDialogo;

        agregarListeners();
    }

    public void agregarListeners() {
        vistaTablaProductos.botonVolver.addActionListener(this);
        vistaTablaProductos.botonEliminar.addActionListener(this);
        vistaTablaProductos.botonEditar.addActionListener(this);
        vistaTablaProductos.botonGuardar.addActionListener(this);
        vistaTablaProductos.botonVolverEditar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("VOLVER")) {
            System.out.println("Botón volver");
            vistaTablaProductos.cerrar();
            vistaPrincipal.iniciar();
        } else if (e.getActionCommand().equals("EDITAR")) {
            System.out.println("Botón Editar");
            Object[] opciones = {"Aceptar", "Cancelar"};
            int opt = JOptionPane.showOptionDialog(vistaTablaProductos, "Desea modificar los productos ", "Mensaje", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (opt == 0) {
                vistaTablaProductos.botonEliminar.setEnabled(false);
                vistaTablaProductos.txtDatos1.setEnabled(true);
                vistaTablaProductos.txtDatos2.setEnabled(true);
                vistaTablaProductos.txtDatos3.setEnabled(true);
                vistaTablaProductos.txtDatos4.setEnabled(true);
                vistaTablaProductos.txtDatos5.setEnabled(true);
                vistaTablaProductos.txtDatos6.setEnabled(true);
                vistaTablaProductos.botonGuardar.setVisible(true);
                vistaTablaProductos.botonVolverEditar.setVisible(true);
            }
            vistaTablaProductos.tabla.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int fila = vistaTablaProductos.tabla.getSelectedRow();
                    vistaTablaProductos.txtDatos1.setText(vistaTablaProductos.tabla.getValueAt(fila, 0).toString());
                    vistaTablaProductos.txtDatos2.setText(vistaTablaProductos.tabla.getValueAt(fila, 1).toString());
                    vistaTablaProductos.txtDatos3.setText(vistaTablaProductos.tabla.getValueAt(fila, 2).toString());
                    vistaTablaProductos.txtDatos4.setText(vistaTablaProductos.tabla.getValueAt(fila, 3).toString());
                    vistaTablaProductos.txtDatos5.setText(vistaTablaProductos.tabla.getValueAt(fila, 4).toString());
                    vistaTablaProductos.txtDatos6.setText(vistaTablaProductos.tabla.getValueAt(fila, 5).toString());
                }
            });

        } else if (e.getActionCommand().equals("ELIMINAR")) {
            System.out.println("Botón Eliminar");
            int fila = vistaTablaProductos.tabla.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(vistaTablaProductos, "Debe Seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                db.abrirConexion();
                int codigoProducto = Integer.parseInt(vistaTablaProductos.tabla.getValueAt(fila, 0).toString());
                db.EliminarProducto(codigoProducto);
//                vistaTablaProductos.tablaProductos();
                JOptionPane.showMessageDialog(vistaTablaProductos, "El producto se ha eliminado del inventario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getActionCommand().equals("GUARDAR")) {
            System.out.println("Botón Guardar");
            String nombreProducto = "";
            double valorUnidad = 0.0;
            double valorVenta = 0.0;
            int cantidad = 0;
            String categoria = "";
            int idcodigo = 0;
            int idcategoria = 0;
            int fila = vistaTablaProductos.tabla.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(vistaTablaProductos, "Debe Seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                db.abrirConexion();
                nombreProducto = vistaTablaProductos.txtDatos2.getText();
                valorUnidad = Double.parseDouble(vistaTablaProductos.txtDatos3.getText());
                valorVenta = Double.parseDouble(vistaTablaProductos.txtDatos4.getText());
                cantidad = Integer.parseInt(vistaTablaProductos.txtDatos5.getText());
                categoria = vistaTablaProductos.txtDatos6.getText();
                idcodigo = Integer.parseInt(vistaTablaProductos.tabla.getValueAt(fila, 0).toString());

                if (categoria == "Materiales") {
                    idcategoria = 1;
                    System.out.println(idcategoria);
                } else if (categoria == "Maquinaria") {
                    idcategoria = 2;
                    System.out.println(idcategoria);
                } else if (categoria == "Servicios") {
                    idcategoria = 3;
                    System.out.println(idcategoria);
                } else {
                    vistaTablaProductos.txtDatos6.setText(vistaTablaProductos.tabla.getValueAt(fila, 5).toString());
                }
                db.ActualizarInventario(nombreProducto, valorUnidad, valorVenta, cantidad, idcategoria, idcodigo);
                
                vistaTablaProductos.txtDatos1.setText("");
                vistaTablaProductos.txtDatos2.setText("");
                vistaTablaProductos.txtDatos3.setText("");
                vistaTablaProductos.txtDatos4.setText("");
                vistaTablaProductos.txtDatos5.setText("");
                vistaTablaProductos.txtDatos6.setText("");
                vistaTablaProductos.panelContainer();
                JOptionPane.showMessageDialog(vistaTablaProductos, "Su información se ha modificado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getActionCommand().equals("VOLVER_EDITAR")) {
            vistaTablaProductos.txtDatos1.setText("");
            vistaTablaProductos.txtDatos2.setText("");
            vistaTablaProductos.txtDatos3.setText("");
            vistaTablaProductos.txtDatos4.setText("");
            vistaTablaProductos.txtDatos5.setText("");
            vistaTablaProductos.txtDatos6.setText("");
            vistaTablaProductos.botonEliminar.setEnabled(true);
            vistaTablaProductos.botonGuardar.setVisible(false);
            vistaTablaProductos.botonVolverEditar.setVisible(false);
            vistaTablaProductos.txtDatos1.setEnabled(false);
            vistaTablaProductos.txtDatos2.setEnabled(false);
            vistaTablaProductos.txtDatos3.setEnabled(false);
            vistaTablaProductos.txtDatos4.setEnabled(false);
            vistaTablaProductos.txtDatos5.setEnabled(false);
            vistaTablaProductos.txtDatos6.setEnabled(false);
            System.out.println("Botón volver editar");

        }
    }

}
