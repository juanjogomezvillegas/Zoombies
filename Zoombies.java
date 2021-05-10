package Zoombies;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * @author Edgar Peréz
 * @author Jordi Risco
 * @author Kirill Lupenkov
 * **/

public class Zoombies extends GraphicsProgram {
    protected String ruta = "src/Zoombies/";

    public static void main(String[] args) {new Zoombies().start(args);}

    public void init() {
        setSize(900, 900);
        setBackground(Color.PINK);
    }

    public void run() {
        GImage zoombie = new GImage(ruta+"zoombie.png");
        zoombie.setSize(50, 50);
        add(zoombie);
    }

    /*Crea el metode getter "getNumeroAleatori"*/
    public int getNumeroAleatori(int min, int max) {
        /*Retorna un numero aleatori entre el "min" i el "max" (parametres) i el retorna*/
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}