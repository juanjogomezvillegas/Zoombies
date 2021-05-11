package Zoombies;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * @author Edgar Peréz
 * @author Jordi Risco
 * @author Kirill Lupenkov
 * **/

/**
 * Importa les següents classes:
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
    /**Crea les variables de tipus private i constants**/
    private final int max_move = 700;
    private final int min_move = 1;

    /**
     * Crea el metode main (Principal)
     * @param args Array de String amb el nom de "args"
     */
    public static void main(String[] args) {new Zoombies().start(args);}

    /**
     * Crea el metode setter "init"
     * **/
    public void init() {
        /*
        * setSize: Estableix el tamany de la finestra en 975x750
        * setBackground: Estableix el color de fons de la finestra en el color especificat
        * */
        setSize(900, 900);
        setBackground(Color.LIGHT_GRAY);
    }

    /**
     * Crea el metode setter "run"
     * **/
    public void run() {
        Emoji emoji = new Emoji();

        GImage zoombie = getRetornaZoombie();
        add(zoombie);

        ArrayList<GImage> arrayEmojis = emoji.getRetornaArrayEmoji();

        int posicio;
        for (int i = 1; i <= 300; i++) {
            zoombie.setLocation(Aleatori.getNumeroAleatori(min_move, max_move), Aleatori.getNumeroAleatori(min_move, max_move));

            posicio = emoji.getRetornaPosicioAleatoria();
            arrayEmojis.get(posicio).setLocation(Aleatori.getNumeroAleatori(min_move, max_move), Aleatori.getNumeroAleatori(min_move, max_move));
            add(arrayEmojis.get(posicio));

            zoombie.pause(50);
            arrayEmojis.get(posicio).pause(50);
        }
    }

    /**
     * Crea el metode getter "getRetornaZoombie"
     * @return zoombie (de tipus GImage)
     * **/
    public GImage getRetornaZoombie() {
        GImage zoombie = new GImage(ruta+"zoombie.png");
        zoombie.setSize(50, 50);
        zoombie.setLocation(Aleatori.getNumeroAleatori(min_move, max_move), Aleatori.getNumeroAleatori(min_move, max_move));
        return zoombie;
    }
}

/**
 * Crea la Classe "Aleatori"
 * @version 1
 * **/
class Aleatori {
    /**
     * Crea el metode getter "getNumeroAleatori", que retornara un numero aleatori entre el "min" i el "max" (parametres)
     * @param min valor minim
     * @param max valor maxim
     * @return un numero aleatori entre els parametres "min" i "max"
     * **/
    public static int getNumeroAleatori(int min, int max) {return ThreadLocalRandom.current().nextInt(min, max);}
}

/**
 * Crea la Classe "Emoji", que esta heretant de la classe "Zoombies"
 * @see Zoombies
 * @version 1
 * **/
class Emoji extends Zoombies {
    /**Crea les variables de tipus private**/
    private ArrayList<GImage> arrayEmojis;

    /**
     * Crea el metode getter "getRetornaEmoji"
     * @return l'ArrayList "arrayEmojis"
     * **/
    public ArrayList<GImage> getRetornaArrayEmoji() {
        arrayEmojis = new ArrayList<>();

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

    /**
     * Crea el metode getter "getRetornaEmoji"
     * @return numero aleatori entre 0 i la longitud de l'ArrayList "arrayEmojis"
     * **/
    public int getRetornaPosicioAleatoria() {return Aleatori.getNumeroAleatori(0, arrayEmojis.size()-1);}
}