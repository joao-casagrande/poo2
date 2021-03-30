/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaoa.exerciciocompositearquivos;

import java.util.ArrayList;

/**
 *
 * @author AEVO
 */
public class ComponenteBase {
    String filename;
    boolean isPasta;

    public void printFilename() {
        System.out.println(this.filename);
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean add(ComponenteBase arquivo) {
        System.out.println("Erro: arquivo não é uma pasta");
        return false;
    }

    public boolean remove(String filename) {
        System.out.println("Erro: arquivo não é uma pasta");
        return false;
    }

    public ComponenteBase getArquivo(String filename) {
        System.out.println("Erro: arquivo não é uma pasta");
        return null;
    }

    public StringBuilder showFileTree() {
        System.out.println("Erro: arquivo não é uma pasta");
        return null;
    }
    
    public ArrayList<ComponenteBase> getLstArquivos() {
        System.out.println("Erro: arquivo não é uma pasta");
        return null;
    }
}