/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author johne
 */
public class BusquedaProducto extends JFrame {

    Color colorFondo = Color.DARK_GRAY;
    Color colorTexto = Color.WHITE;
    JButton botonBuscar;
    JLabel labelBuscar;
    JTextField textoBuscar;
    JLabel labelProducto;

    public BusquedaProducto() {

        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(1000, 0);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(colorFondo);
        panel.setBorder(new EmptyBorder(new Insets(20, 0, 24, 0)));
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.ipady = 12;
        bagConstraints.insets = new Insets(0, 24, 8, 24);
        bagConstraints.gridx = 0;
        bagConstraints.gridheight = 12;

        labelBuscar = new JLabel("Codigo");
        labelBuscar.setBackground(colorFondo);
        labelBuscar.setForeground(colorTexto);
        labelBuscar.setFont(new Font("Sanserif", Font.BOLD, 14));
        labelBuscar.setFont(new Font("Sanserif", Font.BOLD, 14));

        panel.add(labelBuscar, bagConstraints);

        textoBuscar = new JTextField();
        textoBuscar.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(textoBuscar, bagConstraints);

        botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(colorFondo);
        botonBuscar.setForeground(colorTexto);
        botonBuscar.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonBuscar.setIcon(new ImageIcon("src/imagenes/buscar_icono.png"));
        panel.add(botonBuscar, bagConstraints);

        labelProducto = new JLabel("");
        labelProducto.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(labelProducto, bagConstraints);
        labelProducto.setPreferredSize(new Dimension(400, 200));
        labelProducto.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.add(panel);
    }

    public void iniciar() {
        pack();
        setVisible(true);

    }
}
