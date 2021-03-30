/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaoa.exerciciocompositearquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author joao
 */
public class Main {
    private static int QTD_FILES = 0;
    private static Random randomGenerator = new Random();
    private static ArrayList < String > Extensoes = new ArrayList < String > (Arrays.asList("webm", "mkv", "flv", "vob", "ogv", "ogg", "drc", "gif", "gifv", "mng", "avi", "mts", "m2ts", "ts", "mov", "qt", "wmv", "yuv", "rm", "rmvb", "viv", "asf", "amv", "mp4", "m4p",
        "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv", "m2v", "svi", "3gp", "3g2", "mxf", "roq", "nsv", "f4v", "f4p", "f4a", "f4b", "aa", "aac", "aax", "act", "aiff", "alac", "amr", "ape", "au", "awb", "dss", "dvf", "flac", "gsm",
     "iklax", "ivs", "m4a", "m4b", "mmf", "mp3", "mpc", "msv", "nmf", "oga", "mogg", "opus", "org", "ra", "raw", "rf64", "sln", "tta", "voc", "vox", "wav", "wma", "wv", "8svx", "cda", "doc", "dot", "wbk", "docx", "docm", "dotx",
        "dotm", "docb", "xls", "xlt", "xlm", "xlsx", "xlsm", "xltx", "xltm", "xlsb", "xla", "xlam", "xll", "xlw", "ppt", "pot", "pps", "pptx", "pptm", "potx", "potm", "ppam", "ppsx", "ppsm", "sldx", "sldm", "accdb", "accde", "accdt",
        "accdr", "one", "pub", "xps", "jpg", "jpeg", "jpe", "jif", "jfif", "jfi", "png", "webp", "tiff", "tif", "psd", "arw", "cr2", "nrw", "k25", "bmp", "dib", "heif", "heic", "ind", "indd", "indt", "jp2", "j2k", "jpf", "jpx", "jpm",
        "mj2", "svg", "svgz", "ai", "eps", "pdf"));
    //Parte de uma lista gigante de extensões obtida por um programa meu
    
    
    public static void main(String[] args) throws IOException {
        ComponenteBase pastaRoot = new ComponentePastaComposite("ArquivosPorExtensao");
        if(QTD_FILES == 0){
            QTD_FILES = Extensoes.size() * 10; //Para garantir repetição de extensões
        }
        System.out.println(QTD_FILES+ " arquivos serão criados");
        for (int i = 0; i < QTD_FILES; i++) {
            String ext = Extensoes.get(randomGenerator.nextInt(Extensoes.size()));
            String PastaExtensao = ext;
            String filename = String.format("arquivo%d.%s", i, ext);

            ComponenteBase Pasta = pastaRoot.getArquivo(PastaExtensao);
            ComponenteBase tempFile = new ComponenteArquivo(filename);

            if (Pasta == null) {
                ComponenteBase novaExtensao = new ComponentePastaComposite(PastaExtensao);
                novaExtensao.add(tempFile);
                pastaRoot.add(novaExtensao);
            } else {
                Pasta.add(tempFile);
            }
        }
        
        StringBuilder sb =  pastaRoot.ShowFileTree();
        File file = new File(".//src//main//java//com//joaoa//exerciciocompositearquivos//tree.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
        } finally {
            if (writer != null) writer.close();
        }
    }
}