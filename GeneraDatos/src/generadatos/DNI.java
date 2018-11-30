/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadatos;

import java.util.Random;

/**
 *
 * @author diego
 */
public class DNI {
    private static Random rand;
    private static final String letra[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X",
        "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
    
    public static String generador(){
        int dni = rand.nextInt(100000000);
        
        return dni + letra[(dni % 23)];
    }
    
    public static String letra(int dni){
        return letra[(dni % 23)];
    }
    
    public static boolean checker(String dni){
        return ;
    }
}
