/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author johne
 */
public class VistaDialogo {

    public static final int TIPO_ADVERTENCIA = 1;
    public static final int TIPO_ERROR = 2;

    public Color colorFondo = Color.DARK_GRAY;
    public Color colorBoton = new Color(33, 150, 243);
    public Color colorTexto = Color.WHITE;
    public Color colorAceptar = new Color(0, 200, 83);
    public Color colorCancelar = new Color(229, 57, 53);

    public JDialog alerta;
    public JLabel labelAlerta;
    public JButton botonAceptar = new JButton();
    public JButton botonCancelar = new JButton();
    

    // EL PADRE ES LA INSTNCIA QUE VA A ABRIR LA VENTANA DE DIALOGO, EJEMPLO UNA INSTANCIA DE BUSQUEDAPRODUCTO
    // EL TIPO 1 MUESTRA QUE ES UNA ADVERTENCIA, EL TIPO 2 MUESTRA QUE ES UN ERROR
    // EL PARAMETRO CANCELAR PERMITE QUE SE CARGUE EL BOTON CANCELAR SI ES VERDADERO
    public VistaDialogo(int tipo, boolean cancelar) {

        GridBagConstraints bagConstraints = new GridBagConstraints();

        alerta = new JDialog();
        alerta.setModal(true);
        alerta.setResizable(false);
        alerta.setTitle("");
        alerta.getContentPane().setLayout(new GridBagLayout());
        alerta.getContentPane().setBackground(colorFondo);

        labelAlerta = new JLabel("");
        labelAlerta.setForeground(colorTexto);

        if (tipo == TIPO_ADVERTENCIA) {
            labelAlerta.setIcon(new ImageIcon("src/imagenes/advertencia_icono.png"));
        } else if (tipo == TIPO_ERROR) {
            labelAlerta.setIcon(new ImageIcon("src/imagenes/error_icono.png"));
        }

        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.anchor = GridBagConstraints.CENTER;
        bagConstraints.weightx = 1;
        bagConstraints.ipady = 12;
        bagConstraints.insets = new Insets(24, 24, 24, 24);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridheight = 1;
        bagConstraints.gridwidth = 3;
        alerta.add(labelAlerta, bagConstraints);

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
        alerta.add(Box.createHorizontalStrut(100), bagConstraints);

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
        alerta.add(botonAceptar, bagConstraints);

        if (cancelar) {
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
            alerta.add(botonCancelar, bagConstraints);
        }

    }
    
    public void mostrar(String titulo, String mensaje){
        alerta.setTitle(titulo);
        labelAlerta.setText(mensaje);
        alerta.pack();
        alerta.setVisible(true);
    }

}
