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
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
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

    public JButton botonBuscar;
    public JLabel labelBuscar;
    public JTextField textoBuscar;
    public JLabel labelProducto;

    public VistaBusquedaProducto() {

        setTitle("Inventario Ferreteria El Vagabundo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        bagConstraints.gridheight = 1;

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
        botonBuscar.setBackground(colorBoton);
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
        alertaNoEncuentra();
    }

    public void alertaNoEncuentra() {
        
        JDialog alerta;
        JLabel labelAlerta;
        JButton botonAceptar = new JButton();
        JButton botonCancelar = new JButton();
        
        GridBagConstraints bagConstraints = new GridBagConstraints();
        
        alerta = new JDialog();
        alerta.setModal(true);
        alerta.setTitle("No se encontro codigo");
        alerta.getContentPane().setLayout(new GridBagLayout());
        alerta.getContentPane().setBackground(colorFondo);
        
        labelAlerta = new JLabel();
        labelAlerta.setForeground(colorTexto);
        labelAlerta.setText("No se encontro el codigo, desea crear un nuevo producto?");
        labelAlerta.setIcon(new ImageIcon("src/imagenes/advertencia_icono.png"));
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.ipady = 12;
        bagConstraints.insets = new Insets(24, 24, 24, 24);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 3;
        alerta.add(labelAlerta,bagConstraints);
        
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.weighty = 1;
        bagConstraints.ipady = 0;
        bagConstraints.insets = new Insets(0, 0, 0, 0);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        alerta.add(Box.createHorizontalStrut(100),bagConstraints);
        
        botonAceptar = new JButton();
        botonAceptar.setForeground(colorTexto);
        botonAceptar.setBackground(colorAceptar);
        botonAceptar.setText("Aceptar");
        botonAceptar.setIcon(new ImageIcon("src/imagenes/aceptar_icono.png"));
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.ipady = 0;
        bagConstraints.insets = new Insets(0, 4, 24, 24);
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        alerta.add(botonAceptar,bagConstraints);

        botonCancelar = new JButton();
        botonCancelar.setForeground(colorTexto);
        botonCancelar.setBackground(colorCancelar);
        botonCancelar.setText("Cancelar");
        botonCancelar.setIcon(new ImageIcon("src/imagenes/cancelar_icono.png"));
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.weightx = 1;
        bagConstraints.weighty = 1;
        bagConstraints.ipady = 0;
        bagConstraints.insets = new Insets(0, 0, 24, 4);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        alerta.add(botonCancelar,bagConstraints);



        alerta.pack();
        alerta.setVisible(true);
    }
}
