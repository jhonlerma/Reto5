/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jimmy
 */
public final class TablaProductos extends JFrame {

    Color colorFondo = Color.DARK_GRAY;
    Color colorTexto = Color.WHITE;
    private JComboBox nombreTablas;
    private JLabel labelInventario;
    private JButton botonvolver;
    private JButton botonEditar;
    private JButton botonEliminar;
    
    private ResultSet rs;
    private modelo.BaseDatos db = new modelo.BaseDatos();
    private ResultSetModeloTable modelo;

    public TablaProductos() {
        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(1000, 0);
        panelContainer();
    }

    public void panelContainer() {

        JPanel panel = new JPanel();
        panel.setSize(680,420);
        panel.setLocation(0, 0);
        panel.setLayout(new GridBagLayout());
        panel.setBackground(colorFondo);
        panel.setBorder(new EmptyBorder(new Insets(20, 0, 24, 0)));
//        GridBagConstraints bagConstraints = new GridBagConstraints();
//        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
//        bagConstraints.anchor = GridBagConstraints.PAGE_START;
//        bagConstraints.weightx = 1;
//        bagConstraints.ipady = 12;
//        bagConstraints.insets = new Insets(0, 24, 8, 24);
//        bagConstraints.gridx = 0;
//        bagConstraints.gridheight = 1;

        labelInventario = new JLabel("Datos inventario");
        labelInventario.setBackground(colorFondo);
        labelInventario.setForeground(colorTexto);
        labelInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(labelInventario);

        nombreTablas = new JComboBox();

        try {
            db.abrirConexion();
            rs = db.InventarioTotal();
            modelo = new ResultSetModeloTable(rs);

            JTable tabla = new JTable(modelo);
            add(new JScrollPane(tabla), BorderLayout.CENTER);
            validate();
            while (rs.next()) {
                System.out.println(rs);
                nombreTablas.addItem(rs.getString("alias_cliente"));
            }
            panel.add(nombreTablas);
            panel.add(tabla);
            
        } catch (SQLException e) {
            System.out.println("error" + e);
        }
        
        botonvolver = new JButton("Volver");
        botonvolver.setBackground(colorFondo);
        botonvolver.setForeground(colorTexto);
        botonvolver.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(botonvolver);

        botonEditar = new JButton("Editar");
        botonEditar.setBackground(colorFondo);
        botonEditar.setForeground(colorTexto);
        botonEditar.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(botonEditar);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBackground(colorFondo);
        botonEliminar.setForeground(colorTexto);
        botonEliminar.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(botonEliminar);
        
        this.add(panel);

    }

    public void iniciar() {
        pack();
        setVisible(true);
    }

}

class ResultSetModeloTable extends AbstractTableModel {

    private ResultSet rsRegistro;
    private ResultSetMetaData rsMetaData;

    public ResultSetModeloTable(ResultSet unResultset) {
        rsRegistro = unResultset;
        try {
            rsMetaData = (ResultSetMetaData) rsRegistro.getMetaData();
            System.out.println("Result" + rsMetaData);

        } catch (SQLException e) {
            System.out.println("error" + e);
        }
    }

    @Override
    public int getColumnCount() {
        try {
            System.out.println("Columnas: " + rsMetaData.getColumnCount());
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
            System.out.println("Row: " + rsRegistro.last());
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
            System.out.println("getValueAt" + rsRegistro.absolute(rowIndex + 1));
            System.out.println("getValueAt" + rsRegistro.getObject(columnIndex + 1));
            return rsRegistro.getObject(columnIndex + 1);
        } catch (SQLException e) {
            System.out.println("error" + e);
            return null;
        }
    }

    @Override
    public String getColumnName(int c) {
        try {
            System.out.println("Nombre Columnas: " + rsMetaData.getColumnName(c + 1));
            return rsMetaData.getColumnName(c + 1);
        } catch (SQLException ex) {
            System.out.println("error" + ex);
            return null;
        }
    }

}
