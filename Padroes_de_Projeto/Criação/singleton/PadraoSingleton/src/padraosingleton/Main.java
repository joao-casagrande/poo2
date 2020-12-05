/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraosingleton;

import java.io.IOException;

/**
 *
 * @author joaoa
 */
public class Main {
    public static void main(String[] args) throws IOException{
        PadraoSingleton instance = new PadraoSingleton();
        long numero = 0;
        for(int i = 0; i<10; i++){
            chamaFunc(instance, numero);
        
        }
    
    }
    
    
    public static void chamaFunc(PadraoSingleton instancia, long variavel) throws IOException{
        variavel = instancia.getNumber();
        System.out.println(variavel);
    }
}
