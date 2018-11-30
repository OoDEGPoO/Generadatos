/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadatos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class GeneraDatosConsultas {//Genera tambien Operaciones y Pruebas

    /**
     * @param args the command line arguments
     */
    private static final long num_registros = 24000000;
    private static final long num_operaciones = (long) (num_registros * 0.4);
    private static final long num_pruebas = (long) (num_registros * 0.6);
    public static void main(String[] args) {
        
        String textoConsulta = "";
        String textoOperacion = "";
        String textoPrueba = "";
        String hora = "";
        int i = 1;
        int j = 1;
        int colegiado;
        int area;
        int sala;
        Calendar fecha = Calendar.getInstance();
        SimpleDateFormat ffecha = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            PrintWriter salidaConsultas = new PrintWriter(new BufferedWriter(new FileWriter("datos_consultas.csv")));
            PrintWriter salidaOperaciones = new PrintWriter(new BufferedWriter(new FileWriter("datos_operaciones.csv")));
            PrintWriter salidaPruebas = new PrintWriter(new BufferedWriter(new FileWriter("datos_pruebas.csv")));
            
            while (i <= num_operaciones){
                fecha.set(2016, ((int) (Math.random() * 12) + 1), ((int) (Math.random() * 30) + 1));
                hora = ((int) (Math.random() * 24)) + ":" + ((int) (Math.random() * 60));
                colegiado = ((int) (Math.random() * 500000) + 1);
                area = ((int) (Math.random() * 100) + 1);
                
                textoConsulta = i + ", " + ((int) (Math.random() * 8000000) + 1) + ", " + colegiado + ", " + ffecha.format(fecha.getTime()) + ", " + hora + ", AREA" + area + ", " + ((int) (Math.random() * 3) + 1);
                textoOperacion = j + ", " + ffecha.format(fecha.getTime()) + ", " + hora + ", " + i + ", " + colegiado + ", AREA" + area + ", " + ((int) (Math.random() * 5) + 1) + ", ninguna";
                
                
                salidaConsultas.println(textoConsulta);
                salidaOperaciones.println(textoOperacion);
                i++;
                j++;
            }
            
            j = 1;
            
            while (i <= num_registros){
                fecha.set(2016, ((int) (Math.random() * 12) + 1), ((int) (Math.random() * 30) + 1));
                hora = ((int) (Math.random() * 24)) + ":" + ((int) (Math.random() * 60));
                colegiado = ((int) (Math.random() * 500000) + 1);
                area = ((int) (Math.random() * 100) + 1);
                sala = ((int) (Math.random() * 3) + 1);
                
                textoConsulta = i + ", " + ((int) (Math.random() * 8000000) + 1) + ", " + colegiado + ", " + ffecha.format(fecha.getTime()) + ", " + hora + ", AREA" + area + ", " + sala;
                textoPrueba = j + ", " + ffecha.format(fecha.getTime()) + ", " + hora + ", " + i + ", AREA" + area + ", " + sala + ", ninguna, " + colegiado;
                
                
                salidaConsultas.println(textoConsulta);
                salidaPruebas.println(textoPrueba);
                i++;
                j++;
            }
            
            salidaConsultas.close();
            salidaOperaciones.close();
            salidaPruebas.close();
        } catch (IOException ex) {
            System.out.println("/!\\ - Fallo en la generación de datos de consultas / operaciones / pruebas");
        }
    }
     
}
