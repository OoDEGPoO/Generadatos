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
public class Genero {
    private String[] generos = {"clásica", "blues", "jazz", "rock&roll",
        "góspel","soul", "rock", "metal", "funk", "disco", "techno",
        "pop", "reggae", "hiphop", "salsa"};
    
    private Random rand;
    
    public Genero(){//Constructor e inicializador del Random
        rand = new Random();
    }
    
    public String getGenero(){//generos de forma aleatoria
        return generos[(rand.nextInt(generos.length))];
    }
}
