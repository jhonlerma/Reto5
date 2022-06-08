/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jimmy
 */
public class VistaTablaProductos extends JFrame {

    public Color colorFondo = Color.DARK_GRAY;
    public Color colorBoton = new Color(33, 150, 243);
    public Color colorTexto = Color.WHITE;
    public Color colorAceptar = new Color(0, 200, 83);
    public Color colorCancelar = new Color(229, 57, 53);

//    private JComboBox nombreTablas;
    private JLabel labelPrincipal;
    public JTable tabla;

    private JLabel labelDatos1;
    private JLabel labelDatos2;
    private JLabel labelDatos3;
    private JLabel labelDatos4;
    private JLabel labelDatos5;
    private JLabel labelDatos6;

    public JTextField txtDatos1;
    public JTextField txtDatos2;
    public JTextField txtDatos3;
    public JTextField txtDatos4;
    public JTextField txtDatos5;
    public JTextField txtDatos6;
    public JButton botonGuardar;
    public JButton botonVolverEditar;

    public JButton botonVolver;
    public JButton botonEditar;
    public JButton botonEliminar;

    private ResultSet rs;
    private modelo.BaseDatos db = new modelo.BaseDatos();
    private ResultSetModeloTable modelo;
    private JScrollPane scroll;

    public VistaTablaProductos() {
        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        panelContainer();
    }

    public void panelContainer() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(colorFondo);
        panel.setBorder(new EmptyBorder(new Insets(24, 24, 24, 24)));
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.weighty = 1;
        bagConstraints.ipady = 12;
        bagConstraints.insets = new Insets(4, 8, 4, 8);

        labelPrincipal = new JLabel("<html><h3>Consultar modificar eliminar inventario</h3></html>",SwingConstants.CENTER);
        labelPrincipal.setIcon(new ImageIcon("src/imagenes/vagabundo_editar_icono_128.png"));
        labelPrincipal.setBackground(colorFondo);
        labelPrincipal.setForeground(colorTexto);
        labelPrincipal.setFont(new Font("Sanserif", Font.BOLD, 14));
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 4;
        panel.add(labelPrincipal, bagConstraints);

        db.abrirConexion();
        rs = db.InventarioTotal();
        modelo = new ResultSetModeloTable(rs);
        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 7;
        bagConstraints.gridwidth = 2;
        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(640,360));
        panel.add(scroll, bagConstraints);
        validate();
        panelEditar(bagConstraints, panel);

        bagConstraints.gridx = 2;
        bagConstraints.gridy = 7;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(Box.createVerticalStrut(12), bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 8;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 4;
        panel.add(Box.createVerticalStrut(12), bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 9;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(Box.createVerticalStrut(12), bagConstraints);

        botonVolver = new JButton("Volver");
        customButton(botonVolver, colorBoton, "volver_icono.png");
        botonVolver.setActionCommand("VOLVER");
        bagConstraints.weightx = 0.25;
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 9;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(botonVolver, bagConstraints);

        botonEditar = new JButton("Edición");
        customButton(botonEditar, colorBoton, "modificar_icono.png");
        botonEditar.setActionCommand("EDITAR");
        bagConstraints.weightx = 1;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 9;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(botonEditar, bagConstraints);

        botonEliminar = new JButton("Eliminar");
        customButton(botonEliminar, colorCancelar, "eliminar_icono.png");
        botonEliminar.setActionCommand("ELIMINAR");
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 9;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(botonEliminar, bagConstraints);
        this.add(panel);

    }

    public void customLabel(JLabel nombreLabel) {
        nombreLabel.setBackground(colorFondo);
        nombreLabel.setForeground(colorTexto);
        nombreLabel.setFont(new Font("Sanserif", Font.BOLD, 14));
    }

    public void customButton(JButton nombreBoton, Color colorBoton, String nombreIcono) {
        nombreBoton.setBackground(colorBoton);
        nombreBoton.setForeground(colorTexto);
        nombreBoton.setFont(new Font("Sanserif", Font.BOLD, 14));
        nombreBoton.setIcon(new ImageIcon("src/imagenes/" + nombreIcono));
    }

    public void panelEditar(GridBagConstraints bagConstraints, JPanel panel) {
        labelDatos1 = new JLabel("Código:");
        customLabel(labelDatos1);
        
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(labelDatos1, bagConstraints);

        txtDatos1 = new JTextField(20);
        txtDatos1.setEnabled(false);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(txtDatos1, bagConstraints);

        labelDatos2 = new JLabel("Nombre:");
        customLabel(labelDatos2);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(labelDatos2, bagConstraints);

        txtDatos2 = new JTextField(20);
        txtDatos2.setEnabled(false);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(txtDatos2, bagConstraints);

        labelDatos3 = new JLabel("Valor de compra:");
        customLabel(labelDatos3);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(labelDatos3, bagConstraints);

        txtDatos3 = new JTextField(20);
        txtDatos3.setEnabled(false);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(txtDatos3, bagConstraints);

        labelDatos4 = new JLabel("Valor de venta:");
        customLabel(labelDatos4);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(labelDatos4, bagConstraints);

        txtDatos4 = new JTextField(20);
        txtDatos4.setEnabled(false);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(txtDatos4, bagConstraints);

        labelDatos5 = new JLabel("Cant. de producto:");
        customLabel(labelDatos5);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 5;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(labelDatos5, bagConstraints);

        txtDatos5 = new JTextField(20);
        txtDatos5.setEnabled(false);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 5;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(txtDatos5, bagConstraints);

        labelDatos6 = new JLabel("Categoría:");
        customLabel(labelDatos6);
        bagConstraints.weighty = 0.5;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 6;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(labelDatos6, bagConstraints);

        txtDatos6 = new JTextField(20);
        txtDatos6.setEnabled(false);
        bagConstraints.weighty = 1;
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 6;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(txtDatos6, bagConstraints);
        
        
        botonVolverEditar = new JButton("Fin Editar");
        customButton(botonVolverEditar, colorCancelar, "volver_icono.png");
        botonVolverEditar.setActionCommand("VOLVER_EDITAR");
        botonVolverEditar.setVisible(false);
        bagConstraints.weighty = 1;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 7;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(botonVolverEditar, bagConstraints);

        botonGuardar = new JButton("Guardar");
        customButton(botonGuardar, colorAceptar, "guardar_icono.png");
        botonGuardar.setActionCommand("GUARDAR");
        botonGuardar.setVisible(false);
        bagConstraints.weighty = 1;
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 7;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(botonGuardar, bagConstraints);

    }

    public void iniciar() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void cerrar() {
        dispose();
    }

}

class ResultSetModeloTable extends AbstractTableModel {

    private ResultSet rsRegistro;
    private ResultSetMetaData rsMetaData;

    public ResultSetModeloTable(ResultSet unResultset) {
        rsRegistro = unResultset;
        try {
            rsMetaData = (ResultSetMetaData) rsRegistro.getMetaData();
//            System.out.println("Result" + rsMetaData);

        } catch (SQLException e) {
            System.out.println("error" + e);
        }
    }

    @Override
    public int getColumnCount() {
        try {
//            System.out.println("Columnas: " + rsMetaData.getColumnCount());
            return rsMetaData.getColumnCount();
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }

    }

    @Override
    public int getRowCount() {
        try {

            rsRegistro.last();
//            System.out.println("Row: " + rsRegistro.last());
            return rsRegistro.getRow();
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rsRegistro.absolute(rowIndex + 1);
//            System.out.println("getValueAt" + rsRegistro.absolute(rowIndex + 1));
//            System.out.println("getValueAt" + rsRegistro.getObject(columnIndex + 1));
            return rsRegistro.getObject(columnIndex + 1);
        } catch (SQLException e) {
            System.out.println("error" + e);
            return null;
        }
    }

    @Override
    public String getColumnName(int c) {
        try {
//            System.out.println("Nombre Columnas: " + rsMetaData.getColumnName(c + 1));
            return rsMetaData.getColumnName(c + 1);
        } catch (SQLException ex) {
            System.out.println("error" + ex);
            return null;
        }
    }
}
