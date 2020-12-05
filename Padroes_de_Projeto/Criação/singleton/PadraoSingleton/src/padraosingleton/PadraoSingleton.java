/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraosingleton;
import java.io.*;

/**
 *
 * @author joaoa
 */
public class PadraoSingleton {

    /**
     * @param args the command line arguments
     */
    public static PadraoSingleton instance;
    
    
    public synchronized static PadraoSingleton getInstance()
    {
        if(instance == null)
        {
            instance = new PadraoSingleton();
        }
        return instance;
    }
    
    private long number = 0;
    
    public long getNumber() throws IOException{
        
        number = readLong("./src/padraosingleton/LastNumber.txt", 911111111);
        saveNextNumber();
        return number;
    
    }
    
    private void saveNextNumber() throws IOException{
        writeLong("./src/padraosingleton/LastNumber.txt", number+1);
    
    }
            
            
            
    public static void writeLong(String filename, long number) throws IOException {
    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
        dos.writeLong(number);
    }
}

    public static long readLong(String filename, long valueIfNotFound) {
        if (!new File(filename).canRead()) return valueIfNotFound;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            return dis.readLong();
        } catch (IOException ignored) {
            return valueIfNotFound;
        }
    }
    
   
}