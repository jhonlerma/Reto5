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
public class VistaAgregarInventario extends JFrame {

    public Color colorFondo = Color.DARK_GRAY;
    public Color colorBoton = new Color(33, 150, 243);
    public Color colorTexto = Color.WHITE;
    public Color colorAceptar = new Color(0, 200, 83);
    public Color colorCancelar = new Color(229, 57, 53);

    public VistaPrincipal padre;
    public JLabel labelPrincipal;
    public JLabel labelNombre;
    public JTextField textoNombre;
    public JLabel labelCodigo;
    public JTextField textoCodigo;
    public JLabel labelValorCompra;
    public JTextField textoValorCompra;
    public JLabel labelValorVenta;
    public JTextField textoValorVenta;
    public JLabel labelCantidad;
    public JTextField textoCantidad;
    public JLabel labelCategoria;
    public JTextField textoCategoria;
    public JButton botonGuardar;
    public JButton botonVolver;

    public VistaAgregarInventario(VistaPrincipal pPadre) {

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
        panel.setBorder(new EmptyBorder(new Insets(24, 24, 24, 24)));
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.PAGE_START;
        bagConstraints.insets = new Insets(4, 8, 4, 8);
        bagConstraints.weighty = 1;
        bagConstraints.weightx = 1;

        labelPrincipal = new JLabel("<html><h3>Agregar producto a inventario</h3></html>");
        labelPrincipal.setIcon(new ImageIcon("src/imagenes/vagabundo_agregar_icono_128.png"));
        labelPrincipal.setBackground(colorFondo);
        labelPrincipal.setForeground(colorTexto);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelPrincipal, bagConstraints);

        labelCodigo = new JLabel("Código:");
        customLabel(labelCodigo);
        bagConstraints.ipady = 0;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelCodigo, bagConstraints);

        textoCodigo = new JTextField();
        bagConstraints.ipady = 12;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(textoCodigo, bagConstraints);

        labelNombre = new JLabel("Nombre:");
        customLabel(labelNombre);
        bagConstraints.ipady = 0;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelNombre, bagConstraints);

        textoNombre = new JTextField();
        bagConstraints.ipady = 12;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(textoNombre, bagConstraints);

        labelValorCompra = new JLabel("Valor de compra:");
        customLabel(labelValorCompra);
        bagConstraints.ipady = 0;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 5;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelValorCompra, bagConstraints);

        textoValorCompra = new JTextField();
        bagConstraints.ipady = 12;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 6;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(textoValorCompra, bagConstraints);

        labelValorVenta = new JLabel("Valor de venta:");
        customLabel(labelValorVenta);
        bagConstraints.ipady = 0;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 7;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelValorVenta, bagConstraints);

        textoValorVenta = new JTextField();
        bagConstraints.ipady = 12;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 8;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(textoValorVenta, bagConstraints);

        labelCategoria = new JLabel("Categoría:");
        customLabel(labelCategoria);
        bagConstraints.ipady = 0;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 9;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelCategoria, bagConstraints);

        textoCategoria = new JTextField();
        bagConstraints.ipady = 12;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 10;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(textoCategoria, bagConstraints);

        labelCantidad = new JLabel("Cant. de producto:");
        customLabel(labelCantidad);
        bagConstraints.ipady = 0;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 11;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(labelCantidad, bagConstraints);

        textoCantidad = new JTextField();
        bagConstraints.ipady = 12;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 12;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 2;
        panel.add(textoCantidad, bagConstraints);

        botonGuardar = new JButton("Guardar");
        botonGuardar.setBackground(colorAceptar);
        botonGuardar.setForeground(colorTexto);
        botonGuardar.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonGuardar.setIcon(new ImageIcon("src/imagenes/buscar_icono.png"));
        botonGuardar.setActionCommand("GUARDAR_PRODUCTO");
        bagConstraints.insets = new Insets(24, 8, 4, 8);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 13;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        panel.add(botonGuardar, bagConstraints);

        botonVolver = new JButton("Volver");
        botonVolver.setBackground(colorBoton);
        botonVolver.setForeground(colorTexto);
        botonVolver.setFont(new Font("Sanserif", Font.BOLD, 14));
        botonVolver.setActionCommand("VOLVER");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 13;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 1;
        botonVolver.setIcon(new ImageIcon("src/imagenes/buscar_icono.png"));
        panel.add(botonVolver, bagConstraints);

        this.add(panel);

    }

    public void customLabel(JLabel nombreLabel) {
        nombreLabel.setBackground(colorFondo);
        nombreLabel.setForeground(colorTexto);
        nombreLabel.setFont(new Font("Sanserif", Font.BOLD, 14));
    }

    public void iniciar() {
        pack();
        setVisible(true);
    }

    public void cerrar() {
        dispose();
    }

}
