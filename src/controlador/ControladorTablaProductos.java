/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.TablaProductos;
import vista.VistaDialogo;
import vista.VistaPrincipal;

/**
 *
 * @author Jimmy
 */
public class ControladorTablaProductos implements ActionListener {

    private TablaProductos vistaTablaProductos;
    private VistaPrincipal vistaPrincipal;
    private VistaDialogo vistaDialogo;

    public ControladorTablaProductos(TablaProductos pVistaProducto, VistaPrincipal pVistaPrincipal,VistaDialogo PVistaDialogo) {
        vistaTablaProductos = pVistaProducto;
        vistaPrincipal = pVistaPrincipal;
        vistaDialogo = PVistaDialogo;
        vistaTablaProductos.iniciar();
        agregarListeners();
    }

    public void agregarListeners() {
        vistaTablaProductos.botonVolver.addActionListener(this);
        vistaTablaProductos.botonEliminar.addActionListener(this);
        vistaTablaProductos.botonEditar.addActionListener(this);
        vistaTablaProductos.botonGuardar.addActionListener(this);
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
            int opt = JOptionPane.showOptionDialog(vistaTablaProductos, "Desea modificar los productos ", "Mensaje",0,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
            if (opt == 0) {
                vistaTablaProductos.txtDatos1.setEnabled(true);
                vistaTablaProductos.txtDatos2.setEnabled(true);
                vistaTablaProductos.txtDatos3.setEnabled(true);
                vistaTablaProductos.txtDatos4.setEnabled(true);
                vistaTablaProductos.txtDatos5.setEnabled(true);
                vistaTablaProductos.txtDatos6.setEnabled(true);
                vistaTablaProductos.botonGuardar.setVisible(true);
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
                    System.out.println(vistaTablaProductos.tabla.getValueAt(fila, 0));
                    System.out.println(fila);
                }
            });

        } else if (e.getActionCommand().equals("ELIMINAR")) {
            System.out.println("Botón Eliminar");
            
            
            
        } else if (e.getActionCommand().equals("GUARDAR")) {
            System.out.println("Botón Guardar");
            int fila = vistaTablaProductos.tabla.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(vistaTablaProductos, "Debe Seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vistaTablaProductos, "Su información se ha modificado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println(vistaTablaProductos.tabla.getValueAt(fila, 0));

            System.out.println(fila);

        }
    }

}
