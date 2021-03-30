import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class MoveFileAsync extends MoveFile{
    
    private static File listaFiles[] = null;
    
    private static File listaFilesT1[] = null;
    private static File listaFilesT2[] = null;
    
    private static final long elapsedTimeMillis = 0;
    
    public static void main(String[] args) throws IOException, InterruptedException {

       final long startTime = System.currentTimeMillis();// tempo incial
       listaFiles = MoveFile.getSingleTonListaFiles(); //le arquivos do diretorio e coloca na listaFiles                
       System.out.println("Iniciando copiar de arquivos Async");
       int Len = listaFiles.length;
       int metadeLen = listaFiles.length/2;
       listaFilesT1 = Arrays.copyOfRange(listaFiles, 0, metadeLen);
       listaFilesT2 = Arrays.copyOfRange(listaFiles, metadeLen, Len);

        Copy t1 = new Copy(listaFilesT1, "Thread 1");
        Copy t2 = new Copy(listaFilesT2, "Thread 2");
        t1.start();
        t2.start();
        
        while (t1.isAlive() || t2.isAlive()) {   }
       
       
       long elapsedTimeMillis = System.currentTimeMillis() - startTime; //tempo total de execução do programa
       System.out.println("Time Thread 1 + Thread 2:" + (t1.elapsedTimeMillis + t2.elapsedTimeMillis));
       System.out.println("Time Async:" + elapsedTimeMillis);
       
       
       System.out.println("##### OBS #####");
       System.out.println("Em algumas ocasiões o tempo pode dar 0, não entendi muito bem o porquê");
       System.out.println("Do mesmo jeito, as vezes o tempo das threads é muito menor que a do programa todo, também achei estranho isso.");
       System.out.println("###############");
       
       System.out.println("##### RESULTADO #####");
       System.out.println("Em geral, o método assíncrono se demonstrou bem mais rápido que o síncrono, visto que a carga de processamento é dividida em duas partes processadas simultaneamente.");
       System.out.println("#####################");



   }
}





