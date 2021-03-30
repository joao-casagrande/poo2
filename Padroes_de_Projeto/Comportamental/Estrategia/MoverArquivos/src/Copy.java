import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AEVO
 */
public class Copy extends Thread{
    
    private File listaFiles[] = null;
    public String threadName = "";
    public long elapsedTimeMillis = 0;
    
    public Copy(File[] lst, String threadName){
        this.listaFiles = lst;
        this.threadName = threadName;
    }
     
    @Override
    public void run(){
        synchronized(this){
            try{
                
                final long startTime = System.currentTimeMillis();// tempo incial
                System.out.println("Iniciando copiar de arquivos na thread "+ threadName);
                for(int i = 0; i < listaFiles.length; i++) {
                    File origem = new File(listaFiles[i].getAbsolutePath());
                    String destinationFile = listaFiles[i].getAbsolutePath();
                    destinationFile = destinationFile.replace("origem", "destino");
                    copyFile(origem, new File(destinationFile));
                } 
                elapsedTimeMillis = System.currentTimeMillis() - startTime; //tempo total de execução do programa
                System.out.println("Time "+threadName +":" + elapsedTimeMillis+ " ms");
            } catch (Exception e){notify();}
            
        }
    }
    
    private void copyFile(File sourceFile, File destFile) throws IOException {

        if (!sourceFile.exists()) {
            return;
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }
    }
}
