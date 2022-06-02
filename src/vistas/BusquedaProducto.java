/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

/**
 *
 * @author johne
 */
public class BusquedaProducto extends JFrame {

    public BusquedaProducto() {

        setTitle("VENTANA LAYOUTFLOW");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(true);
        setLocation(1000, 0);
        inicializarComponentes();
        setVisible(true);

    }

    public static void inicializarComponentes() {
        
        JButton button;
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        if (shouldFill) {
            //natural height, maximum width
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("Button 1");
        if (shouldWeightX) {
            gridBagConstraints.weightx = 0.5;
        }
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 2");
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 3");
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pane.add(button, c);

        button = new JButton("Long-Named Button 4");
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;      //make this component tall
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pane.add(button, c);

        button = new JButton("5");
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 0;       //reset to default
        gridBagConstraints.weighty = 1.0;   //request any extra vertical space
        gridBagConstraints.anchor = GridBagConstraints.PAGE_END; //bottom of space
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);  //top padding
        gridBagConstraints.gridx = 1;       //aligned with button 2
        gridBagConstraints.gridwidth = 2;   //2 columns wide
        gridBagConstraints.gridy = 2;       //third row
        pane.add(button, c);
    }
}
