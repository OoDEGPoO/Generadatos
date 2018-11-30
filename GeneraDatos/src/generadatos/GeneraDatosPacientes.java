/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadatos;

import java.io.*;
import java.util.*;

/**
 *
 * @author Diego
 */
public class GeneraDatosPacientes {

    /**
     * @param args the command line arguments
     */
    
    private static final String[] ciudades = {"ciudad_1", "ciudad_2", "ciudad_3", "ciudad_4", "ciudad_5"};
    private static final long num_registros = 8000000;
    
    public static void main(String[] args) {
        String texto = "";
        int cp;
        
        try {
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("datos_pacientes.csv")));
            
            
            
            for (int i = 1; i <= num_registros; i++){
                cp = ((int) (Math.random()* 52));
                
                texto = i + ", " + i + ", " + i + ", nombre" + i + ", apellido" + i + ", direccion" + i + ", " + (cp+1) + "" + ((int) (Math.random()* 1000)) + ", " + ciudades[(int) (Math.random() * 5)] + ", " + Provincias.getProvincia(cp) + ", 900000000, " + i;
                
                salida.println(texto);
            }
            
            salida.close();
        } catch (IOException ex) {
            System.out.println("/!\\ - Fallo en la generación de datos de pacientes");
        }
    }
    
}
