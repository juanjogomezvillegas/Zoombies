package Zoombies;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * @author Edgar Peréz
 * @author Jordi Risco
 * @author Kirill Lupenkov
 * **/

/**Importa les següents classes:
 * @see acm.program
 * @see acm.graphics
 * @see java.awt
 * @see java.util.ArrayList
 * @see java.util.concurrent.ThreadLocalRandom
 * **/
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Crea la Classe "Zoombies", heretada de la classe "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Zoombies extends GraphicsProgram {
    /**Crea les variables de tipus protected**/
    protected String ruta = "src/Zoombies/";

    /**
     * Crea el metode main (Principal)
     * @param args
     */
    public static void main(String[] args) {new Zoombies().start(args);}

    /**
     * Crea el metode setter "init"
     * **/
    public void init() {
        /**
         * setSize: Estableix el tamany de la finestra en 975x750
         * setBackground: Estableix el color de fons de la finestra en el color especificat
         * **/
        setSize(900, 900);
        setBackground(Color.LIGHT_GRAY);
    }

    /**
     * Crea el metode setter "run"
     * **/
    public void run() {
        GImage zoombie = getRetornaZoombie();
        add(zoombie);

        ArrayList<GImage> arrayEmojis = getArrayEmojis();

        for (int i = 0; i <= 100; i++) {
            int emoji = Aleatori.getNumeroAleatori(0, arrayEmojis.size()-1);
            arrayEmojis.get(emoji).setLocation(Aleatori.getNumeroAleatori(1, 700), Aleatori.getNumeroAleatori(1, 700));
            add(arrayEmojis.get(emoji));
            arrayEmojis.get(emoji).pause(200);
        }
    }

    /**
     * Crea el metode getter "getRetornaZoombie"
     * @return zoombie (de tipus GImage)
     * **/
    public GImage getRetornaZoombie() {
        GImage zoombie = new GImage(ruta+"zoombie.png");
        zoombie.setSize(50, 50);
        zoombie.setLocation(Aleatori.getNumeroAleatori(1, 700), Aleatori.getNumeroAleatori(1, 700));
        return zoombie;
    }

    /**
     * Crea el metode getter "getArrayEmojis"
     * @return arrayEmojis (de tipus ArrayList<GImage>)
     * **/
    public ArrayList<GImage> getArrayEmojis() {
        ArrayList<GImage> arrayEmojis = new ArrayList<>();

        arrayEmojis.add(new GImage(ruta+"emoji1.png"));
        arrayEmojis.add(new GImage(ruta+"emoji2.png"));
        arrayEmojis.add(new GImage(ruta+"emoji3.png"));
        arrayEmojis.add(new GImage(ruta+"emoji4.png"));
        arrayEmojis.add(new GImage(ruta+"emoji5.png"));
        arrayEmojis.add(new GImage(ruta+"emoji6.png"));
        arrayEmojis.add(new GImage(ruta+"emoji7.png"));
        arrayEmojis.add(new GImage(ruta+"emoji8.png"));
        arrayEmojis.add(new GImage(ruta+"emoji9.png"));

        return arrayEmojis;
    }
}

/**
 * Crea la Classe "Aleatori"
 * @version 1
 * **/
class Aleatori {
    /**
     * Crea el metode getter "getNumeroAleatori", que retornara un numero aleatori entre el "min" i el "max" (parametres)
     * @param min
     * @param max
     * @return ThreadLocalRandom.current().nextInt(min, max)
     * **/
    public static int getNumeroAleatori(int min, int max) {return ThreadLocalRandom.current().nextInt(min, max);}
}