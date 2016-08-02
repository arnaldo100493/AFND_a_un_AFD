/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afndaunafd.utilidades;

import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author FABAME
 */
public class LimpiarComponentes {

    public LimpiarComponentes() {

    }

    public static void limpiarComponentes(JPanel panelDatos) {

        Component[] listadoComponentes = panelDatos.getComponents();

        for (Component item : listadoComponentes) {

            if (item.getClass().getName().equals("javax.swing.JCheckBox")) {
                ((javax.swing.JCheckBox) item).setSelected(false);
            }

            if (item.getClass().getName().equals("javax.swing.JComboBox")) {
                ((javax.swing.JComboBox) item).setSelectedIndex(0);
            }

            if (item.getClass().getName().equals("javax.swing.JPasswordField")) {
                ((javax.swing.JPasswordField) item).setText("");
            }

            if (item.getClass().getName().equals("javax.swing.JTextArea")) {
                ((javax.swing.JTextArea) item).setText("");
            }

            if (item.getClass().getName().equals("javax.swing.JTextField")) {
                ((javax.swing.JTextField) item).setText("");
            }

            if (item.getClass().getName().equals("javax.swing.JTextPane")) {
                ((javax.swing.JTextPane) item).setText("");
            }
        }
    }
}
