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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jimmy
 */
public class ModificarInventario extends JFrame {

    Color colorFondo = Color.DARK_GRAY;
    Color colorTexto = Color.WHITE;
//        JTextField textoBuscar;
    JLabel labelInventario;
    JButton botonvolver;
    JButton botonEditar;
    JButton botonEliminar;

    public ModificarInventario() {
        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setResizable(false);
        setLocation(1000, 0);
        inicializarComponentes();
        pack();
        setVisible(true);
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

        labelInventario = new JLabel("Inventario");
        labelInventario.setBackground(colorFondo);
        labelInventario.setForeground(colorTexto);
        labelInventario.setFont(new Font("Sanserif",Font.BOLD, 14));
        panel.add(labelInventario, bagConstraints);

//        textoBuscar = new JTextField();
//        panel.add(textoBuscar, bagConstraints);
//        botonBuscar = new JButton("Buscar");
//        panel.add(botonBuscar, bagConstraints);

        labelInventario = new JLabel("");
        labelInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(labelInventario, bagConstraints);
        labelInventario.setPreferredSize(new Dimension(400, 200));
        labelInventario.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.add(panel);

        botonvolver = new JButton("Volver");
        botonvolver.setBackground(colorFondo);
        botonvolver.setForeground(colorTexto);
        botonvolver.setFont(new Font("Sanserif",Font.BOLD, 14));
        panel.add(botonvolver, bagConstraints);
        
        botonEditar = new JButton("Editar");
        botonEditar.setBackground(colorFondo);
        botonEditar.setForeground(colorTexto);
        botonEditar.setFont(new Font("Sanserif",Font.BOLD, 14));
        panel.add(botonEditar, bagConstraints);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBackground(colorFondo);
        botonEliminar.setForeground(colorTexto);
        botonEliminar.setFont(new Font("Sanserif",Font.BOLD, 14));
        panel.add(botonEliminar, bagConstraints);

    }

}
