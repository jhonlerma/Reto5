/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author johne
 */
public class VistaPrincipal extends JFrame {

    JLabel labelBienvenida;
    JButton botonAgregarInventario;
    JButton botonBuscarProducto;
    JButton botonModificarInventario;
    JButton botonVerInventario;
    Color colorFondo = Color.DARK_GRAY;
    Color colorTexto = Color.WHITE;

    public VistaPrincipal() {

        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(1000, 0);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(new Insets(20, 0, 24, 0)));
        panel.setBackground(colorFondo);
        
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.BOTH;
        bagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        bagConstraints.weightx = 1;
        bagConstraints.ipady = 12;
        bagConstraints.insets = new Insets(0, 24, 8, 24);
        bagConstraints.gridx = 0;
        bagConstraints.gridheight = 12;

        labelBienvenida = new JLabel("<html><h3>Bienvenidos a Ferreteria El Vagabundo</h3></html>");
        labelBienvenida.setIcon(new ImageIcon("src/imagenes/vagabundo_icono_128.png"));
        labelBienvenida.setBackground(colorFondo);
        labelBienvenida.setForeground(colorTexto);
        panel.add(labelBienvenida, bagConstraints);

        botonAgregarInventario = new JButton("Agregar productos a inventario");
        botonAgregarInventario.setBackground(colorFondo);
        botonAgregarInventario.setForeground(colorTexto);
        botonAgregarInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonAgregarInventario.setIcon(new ImageIcon("src/imagenes/agregar_icono.png"));
        panel.add(botonAgregarInventario, bagConstraints);

        botonBuscarProducto = new JButton("Buscar producto por codigo");
        botonBuscarProducto.setBackground(colorFondo);
        botonBuscarProducto.setForeground(colorTexto);
        botonBuscarProducto.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonBuscarProducto.setIcon(new ImageIcon("src/imagenes/buscar_icono.png"));
        panel.add(botonBuscarProducto, bagConstraints);

        botonModificarInventario = new JButton("Modificar inventario");
        botonModificarInventario.setBackground(colorFondo);
        botonModificarInventario.setForeground(colorTexto);
        botonModificarInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonModificarInventario.setIcon(new ImageIcon("src/imagenes/modificar_icono.png"));
        panel.add(botonModificarInventario, bagConstraints);

        botonVerInventario = new JButton("Ver inventario");
        botonVerInventario.setBackground(colorFondo);
        botonVerInventario.setForeground(colorTexto);
        botonVerInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonVerInventario.setIcon(new ImageIcon("src/imagenes/listar_icono.png"));
        panel.add(botonVerInventario, bagConstraints);

        this.add(panel);

    }

    public void iniciar() {
        
        pack();
        setVisible(true);

    }

}
