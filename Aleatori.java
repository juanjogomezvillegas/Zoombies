package Zoombies;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * @author Kirill Lupenkov
 * @author Edgar Peréz
 * @author Jordi Risco
 * **/

/**
 * We import the following classes:
 * @see java.util.concurrent.ThreadLocalRandom
 * **/
import java.util.concurrent.ThreadLocalRandom;

/**
 * Create class "Aleatori"
 * @version 1
 * **/
public class Aleatori {
    /**
     * Create method getter "getNumeroAleatori", of type static
     * @param min minimum value
     * @param max maximum value
     * @return random number between param "min" and param "max"
     * **/
    public static int getNumeroAleatori(int min, int max) {return ThreadLocalRandom.current().nextInt(min, max);}
}