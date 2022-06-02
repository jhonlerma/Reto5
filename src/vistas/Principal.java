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
public class Principal extends JFrame {

    public Principal() {

        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setResizable(false);
        setLocation(1000, 0);
        inicializarComponentes();
        pack();
        setVisible(true);

    }

    private void inicializarComponentes() {

        JLabel labelBienvenida;
        JButton botonAgregarInventario;
        JButton botonBuscarProducto;
        JButton botonModificarInventario;
        JButton botonVerInventario;

        JTextField textoBuscar;
        JLabel labelProducto;

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(new Insets(20, 0, 24, 0)));
        GridBagConstraints bagConstraints = new GridBagConstraints();

        labelBienvenida = new JLabel("Bienvenidos a Ferreteria El Vagabundo");
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.ipady = 12;
        bagConstraints.insets = new Insets(0, 24, 8, 24);
        bagConstraints.gridx = 0;
        bagConstraints.gridheight = 12;
        panel.add(labelBienvenida, bagConstraints);

        botonAgregarInventario = new JButton("Agregar productos a inventario");
        panel.add(botonAgregarInventario, bagConstraints);

        botonBuscarProducto = new JButton("Buscar producto por codigo");
        panel.add(botonBuscarProducto, bagConstraints);

        botonModificarInventario = new JButton("Modificar inventario");
        panel.add(botonModificarInventario, bagConstraints);

        botonVerInventario = new JButton("Ver inventario");
        panel.add(botonVerInventario, bagConstraints);
        
        this.add(panel);

    }

}
