package org.braulioecheverria.utils;

import java.util.Scanner;

/**
 *
 * @author jbmon
 */
public class ScannerSingleton {
    private static Scanner instancia;
    
    private ScannerSingleton(){
        
    }
    
    public static synchronized Scanner getInstancia(){
        if(instancia == null){
            instancia = new Scanner(System.in);
        }
        return instancia;
    }
}
