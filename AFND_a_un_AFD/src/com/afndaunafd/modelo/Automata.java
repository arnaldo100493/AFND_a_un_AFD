/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afndaunafd.modelo;

import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author FABAME
 */
public class Automata {

    private String nombre;
    private int numeroEstados;
    private int estadoInicial;
    private int estadoActual;
    private TreeSet<String> alfabeto;
    private TreeSet<Integer> estadoFinal;
    private TreeSet<Integer>[][] tablaTransiciones;

    public Automata() {
        super();
        alfabeto = new TreeSet<String>();
        estadoFinal = new TreeSet<Integer>();
    }

    public Automata(String nombre, int nEstados, TreeSet<String> alfabeto, int q0, TreeSet<Integer> qend, TreeSet<Integer>[][] tablaTransiciones) {
        super();
        this.nombre = nombre;
        this.numeroEstados = nEstados;
        this.alfabeto = alfabeto;
        this.estadoInicial = q0;
        estadoFinal = qend;
        this.tablaTransiciones = tablaTransiciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEstados() {
        return numeroEstados;
    }

    public void setNumeroEstados(int nEstados) {
        this.numeroEstados = nEstados;
    }

    public TreeSet<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(TreeSet<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public int getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(int q0) {
        this.estadoInicial = q0;
    }

    public TreeSet<Integer> getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(TreeSet<Integer> qend) {
        this.estadoFinal = qend;
    }

    public TreeSet<Integer>[][] getTablaTransiciones() {
        return tablaTransiciones;
    }

    public void setTablaTransiciones(TreeSet<Integer>[][] tablaTransiciones) {
        this.tablaTransiciones = tablaTransiciones;
    }

    public void addEstadoFinal(int q) {
        this.estadoFinal.add(q);
    }

    public int getEstadoActual() {
        return estadoActual;
    }

    @SuppressWarnings("unchecked")
    public void addLetraAlfabeto(String letra) {
        this.alfabeto.add(letra);
        this.tablaTransiciones = new TreeSet[this.numeroEstados][this.alfabeto.size()];
        iniciarTablaTransiciones();
    }

    private void iniciarTablaTransiciones() {
        for (int x = 0; x < this.numeroEstados; x++) {
            for (int y = 0; y < this.alfabeto.size(); y++) {
                this.tablaTransiciones[x][y] = new TreeSet<Integer>();
            }
        }
    }

    public void addTransicion(int q0, String e, int q1) {
        Vector<String> a = new Vector<String>();
        a.addAll(this.alfabeto);
        this.tablaTransiciones[q0][a.indexOf(e)].add(q1);
    }

    public boolean analizarPalabra(String palabra) {

        this.estadoActual = this.estadoInicial;
        String[] letras = palabra.split("");

        for (String l : letras) {
            if (!l.equals("")) {
                this.estadoActual = funcion(this.estadoActual, l);
                if (this.estadoActual == -1) {
                    return false;
                }
            }
        }
        if (this.estadoFinal.contains(this.estadoActual)) {
            return true;
        }

        return false;
    }

    private int funcion(int estadoActual, String e) {
        Vector<String> a = new Vector<String>();
        a.addAll(this.alfabeto);
        if (this.tablaTransiciones[estadoActual][a.indexOf(e)].isEmpty()) {
            return -1;
        } else {
            return this.tablaTransiciones[estadoActual][a.indexOf(e)].first();
        }
    }
}
