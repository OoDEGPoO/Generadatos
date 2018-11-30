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
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Random;

/**
 *
 * @author Diego
 */
public class GeneraDatos {

    /**
     * @param args the command line arguments
     */
    //---------- Variables de uso común ----------
    private static Random rand;
    private static Calendar fecha;
    private static SimpleDateFormat ffecha;
    private static Genero genero;
    
    //------------ Ctes y Var comunes ------------
    private static final String[] tipos_disco = {"CD", "Vinilo", "Digital"};
    private static long cod_cancion = 0;
    private static final long max_discos = 1000000;//1.000.000 de discos en la base de datos
    private static long cod_disco = 0;
    private static final int max_canciones_disco = 24;//de media 12
    private static final int min_duracion_canciones = 2;//mínimo de duración de las canciones
    private static final int max_duracion_canciones = 7;//máximo de duración de las canciones
    private static final long num_entradas = 24000000;//24.000.000 de entradas en total
    private static long cod_entrada = 0;
    private static final long min_precio_entradas = 20;//mínimo precio posible de las entradas
    private static final long max_precio_entradas = 100;//máximo precio posible de las entradas
    private static final long num_conciertos = 100000;//100.000 numeros de conciertos
    private static long cod_concierto = 0;
    private static final long num_musicos = 1000000;//1.000.000 de musicos
    private static final long num_grupos = 200000;//200.000 de grupos
    private static long cod_grupo = 0;
    private static long num_discos = max_discos/num_grupos;
    
    private static final long num_registros = 1000;
    
    public static void main(String[] args) {
        //------------ Inicialización de variables comunes ---------------
        rand = new Random();
        fecha = Calendar.getInstance();
        ffecha = new SimpleDateFormat("yyyy-MM-dd");
        genero = new Genero();
        
        //----------------------------------------------------------------
        String texto = "";
        
        try {
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("datos_.csv")));
            
            for (int i = 1; i <= num_registros; i++){
                texto = i + "";
                
                salida.println(texto);
            }
            
            salida.close();
        } catch (IOException ex) {
            System.out.println("/!\\ - Fallo en la generación de datos de ");
        }
    }
    
    /*System.out.println("ñieje")*/
    
    //Genera Canciones de un disco concreto
    private static void generaCanciones(PrintWriter salida_canciones, String compositor, Calendar fecha_g, long c_disco){
        int max = rand.nextInt(max_canciones_disco)+1;//numero de canciones a generar
        String nombre = "Cancion";
        
        for (int i = 1; i <= max; i++){
            salida_canciones.println(cod_cancion+","+nombre+cod_cancion+","+compositor+","+ffecha.format(fecha_g.getTime())+","+
                (rand.nextInt(max_duracion_canciones-min_duracion_canciones) + min_duracion_canciones)+","+c_disco);
            cod_cancion++;
        }
    }
    
    //Genera Discos de un grupo en concreto
    private static void generaDiscos(PrintWriter salida_discos, PrintWriter salida_canciones, long c_grupo){
        String nombre = "Titulo";
        String compositor = "Compositor";
        
        for (long i = 1; i <= num_discos; i++){
            fecha.set(2017, ((int) (Math.random() * 12) + 1), ((int) (Math.random() * 30) + 1));
            generaCanciones(salida_canciones, compositor+c_grupo, fecha, cod_disco);
            salida_discos.println(cod_disco+","+nombre+cod_disco+","+ffecha.format(fecha.getTime())+","+genero.getGenero()+","+tipos_disco[rand.nextInt(tipos_disco.length)]+","+c_grupo);
            cod_disco++;
        }
    }
    
    //Genera Entradas de un concierto concreto
    private static void generaEntradas(PrintWriter salida_entradas, long max_localidades, double precio, long c_concierto){
        String localidad = "Localidad";
        String usuario = "Usuario";
        
        for (long i = 0; i < max_localidades; i++){
            salida_entradas.println(cod_entrada+","+localidad+i+","+precio+","
                    +usuario+cod_entrada+","+c_concierto);
            cod_entrada++;
        }
    }
}
