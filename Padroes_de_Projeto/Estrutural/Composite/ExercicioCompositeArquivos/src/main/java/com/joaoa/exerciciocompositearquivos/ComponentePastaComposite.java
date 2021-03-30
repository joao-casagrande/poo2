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
public class ComponentePastaComposite extends ComponenteBase {
    ArrayList <ComponenteBase> arquivos = new ArrayList < ComponenteBase > ();

    public ComponentePastaComposite(String nomeDoArquivo) {
        this.filename = nomeDoArquivo;
        this.isPasta = true;
    }

    @Override
    public void printFilename() {
        System.out.println(this.filename);
        for (ComponenteBase arquivo: arquivos) {
            arquivo.printFilename();
        }
    }

    @Override
    public boolean add(ComponenteBase novoArquivo) {
        try {
            this.arquivos.add(novoArquivo);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean remove(String nomeDoArquivo) {
        for (ComponenteBase arquivo: arquivos) {
            if (arquivo.getFilename() == nomeDoArquivo) {
                this.arquivos.remove(arquivo);
                return true;
            }
        }
        return false;
    }

    @Override
    public ComponenteBase getArquivo(String nomeDoArquivo) {
        for (ComponenteBase arquivo: arquivos) {
            if (arquivo.getFilename() == nomeDoArquivo) {
                return arquivo;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<ComponenteBase> getLstArquivos() {
        if(this.isPasta){
            return arquivos;
        }
        return null;
    }
    
    @Override
    public StringBuilder showFileTree() {
        
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printTree(this, indent, sb);
        //1System.out.print(sb);
       return sb;
    }
    
    
     private static void printTree(ComponenteBase file, int indent,StringBuilder sb) {
        sb.append(getIndentString(indent));
        file.getClass();
        sb.append("+--");
        sb.append(file.filename+"/");
        sb.append("/");
        sb.append("\n");        
        for (ComponenteBase arquivo : file.getLstArquivos()) {
            if(arquivo.isPasta)
            {
                printTree(arquivo, indent + 1, sb);
            }
            else
            {
                printFile(arquivo.filename, indent + 1, sb);
            }
            
            
        }

    }
    
    private static void printFile(String filename, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(filename);
        sb.append("\n");
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }
}