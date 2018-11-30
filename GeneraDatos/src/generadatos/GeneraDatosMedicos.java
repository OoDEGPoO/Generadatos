/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadatos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Diego
 */
public class GeneraDatosMedicos {

    /**
     * @param args the command line arguments
     */
    
    private static final String[] ciudades = {"ciudad_1", "ciudad_2", "ciudad_3", "ciudad_4", "ciudad_5"};
    private static final long num_registros = 500000;
    
    public static void main(String[] args) {
        String texto = "";
        int cp;
        int esp;
        
        try {
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("datos_medicos.csv")));
            
            for (int i = 1; i <= num_registros; i++){
                cp = ((int) (Math.random() * 52));
                esp = ((int) (Math.random() * 100) + 1);
                texto = i + ", " + i + ", " + i + ", antoni@" + i + ", apellido" + i + ", direccion" + i + ", " + cp + ((int) (Math.random()* 1000)) + ", " + ciudades[(int) (Math.random() * 5)] + ", " + Provincias.getProvincia(cp) + ", 900000000, AREA" + ((int) (Math.random() * 100) + 1) + ", Especialidad" + esp + ", " + ((int) (Math.random() * 25) + 1);
                
                salida.println(texto);
            }
            
            salida.close();
        } catch (IOException ex) {
            System.out.println("/!\\ - Fallo en la generación de datos de medicos");
        }
    }
    
}
