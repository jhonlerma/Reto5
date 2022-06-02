/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
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

    public BusquedaProducto() {

        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setResizable(false);
        setLocation(1000, 0);
        inicializarComponentes();
        pack();
        setVisible(true);

    }

    public void inicializarComponentes() {

        JButton botonBuscar;
        JLabel labelBuscar;
        JTextField textoBuscar;
        JLabel labelProducto;

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(new Insets(20, 0, 24, 0)));
        GridBagConstraints bagConstraints = new GridBagConstraints();

        labelBuscar = new JLabel("Codigo");
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.ipady = 12;
        bagConstraints.insets = new Insets(0, 24, 8, 24);
        bagConstraints.gridx = 0;
        bagConstraints.gridheight = 12;
        panel.add(labelBuscar, bagConstraints);

        textoBuscar = new JTextField();
        panel.add(textoBuscar, bagConstraints);

        botonBuscar = new JButton("Buscar");
        panel.add(botonBuscar, bagConstraints);

        labelProducto = new JLabel("");

        panel.add(labelProducto, bagConstraints);
        labelProducto.setPreferredSize(new Dimension(400, 200));
        labelProducto.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.add(panel);
    }
}
