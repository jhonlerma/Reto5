/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
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
public class VistaBusquedaProducto extends JFrame {

    public Color colorFondo = Color.DARK_GRAY;
    public Color colorBoton = new Color(33, 150, 243);
    public Color colorTexto = Color.WHITE;
    public Color colorAceptar = new Color(0, 200, 83);
    public Color colorCancelar = new Color(229, 57, 53);

    public VistaPrincipal padre;
    public JLabel labelPrincipal;
    public JButton botonBuscar;
    public JLabel labelBuscar;
    public JTextField textoBuscar;
    public JLabel labelProducto;
    public JButton botonVolver;

    public VistaBusquedaProducto(VistaPrincipal pPadre) {

        padre = pPadre;
        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
        bagConstraints.insets = new Insets(4, 8, 4, 8);
        bagConstraints.ipady = 12;
        bagConstraints.weighty = 1;
        bagConstraints.weightx = 1;

        labelPrincipal = new JLabel("<html><h3>Buscar producto por codigo</h3></html>");
        labelPrincipal.setIcon(new ImageIcon("src/imagenes/vagabundo_buscar_icono_128.png"));
        labelPrincipal.setBackground(colorFondo);
        labelPrincipal.setForeground(colorTexto);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelPrincipal, bagConstraints);

        labelBuscar = new JLabel("Codigo");
        labelBuscar.setBackground(colorFondo);
        labelBuscar.setForeground(colorTexto);
        labelBuscar.setFont(new Font("Sanserif", Font.BOLD, 14));
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelBuscar, bagConstraints);

        textoBuscar = new JTextField();
        textoBuscar.setFont(new Font("Sanserif", Font.BOLD, 14));
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(textoBuscar, bagConstraints);

        botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(colorBoton);
        botonBuscar.setForeground(colorTexto);
        botonBuscar.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonBuscar.setIcon(new ImageIcon("src/imagenes/buscar_icono.png"));
        botonBuscar.setActionCommand("BUSCAR_PRODUCTO");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(botonBuscar, bagConstraints);

        labelProducto = new JLabel("");
        labelProducto.setFont(new Font("Sanserif", Font.BOLD, 14));
        panel.add(labelProducto, bagConstraints);
        labelProducto.setPreferredSize(new Dimension(400, 200));
        labelProducto.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;

        botonVolver = new JButton("Volver");
        botonVolver.setBackground(colorBoton);
        botonVolver.setForeground(colorTexto);
        botonVolver.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonVolver.setActionCommand("VOLVER");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        botonVolver.setIcon(new ImageIcon("src/imagenes/buscar_icono.png"));
        panel.add(botonVolver, bagConstraints);

        this.add(panel);
    }

    public void iniciar() {
        pack();
        setVisible(true);
    }

    public void cerrar() {
        dispose();
    }

}
