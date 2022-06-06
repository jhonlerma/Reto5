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

    public JPanel panel;
    public JLabel labelBienvenida;
    public JButton botonAgregarInventario;
    public JButton botonBuscarProducto;
    public JButton botonModificarInventario;
    public JButton botonVerInventario;
    public Color colorFondo = Color.DARK_GRAY;
    public Color colorBoton = new Color(33, 150, 243);
    public Color colorTexto = Color.WHITE;

    public VistaPrincipal() {

        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(500, 0);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        panel = new JPanel();
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
        botonAgregarInventario.setBackground(colorBoton);
        botonAgregarInventario.setForeground(colorTexto);
        botonAgregarInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonAgregarInventario.setIcon(new ImageIcon("src/imagenes/agregar_icono.png"));
        botonAgregarInventario.setActionCommand("ABRIR_AGREGAR_INVENTARIO");
        panel.add(botonAgregarInventario, bagConstraints);

        botonBuscarProducto = new JButton("Buscar producto por codigo");
        botonBuscarProducto.setBackground(colorBoton);
        botonBuscarProducto.setForeground(colorTexto);
        botonBuscarProducto.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonBuscarProducto.setIcon(new ImageIcon("src/imagenes/buscar_icono.png"));
        botonBuscarProducto.setActionCommand("ABRIR_BUSQUEDA_PRODUCTO");
        panel.add(botonBuscarProducto, bagConstraints);

        botonModificarInventario = new JButton("Modificar inventario");
        botonModificarInventario.setBackground(colorBoton);
        botonModificarInventario.setForeground(colorTexto);
        botonModificarInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonModificarInventario.setIcon(new ImageIcon("src/imagenes/modificar_icono.png"));
        botonModificarInventario.setActionCommand("ABRIR_MODIFICAR_INVENTARIO");
        panel.add(botonModificarInventario, bagConstraints);

        botonVerInventario = new JButton("Ver inventario");
        botonVerInventario.setBackground(colorBoton);
        botonVerInventario.setForeground(colorTexto);
        botonVerInventario.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonVerInventario.setIcon(new ImageIcon("src/imagenes/listar_icono.png"));
        botonVerInventario.setActionCommand("ABRIR_VER_INVENTARIO");
        panel.add(botonVerInventario, bagConstraints);

        this.add(panel);

    }

    public void iniciar() {
        
        pack();
        setVisible(true);

    }

}
