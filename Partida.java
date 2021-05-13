package Zoombies;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * @author Edgar Peréz
 * @author Jordi Risco
 * @author Kirill Lupenkov
 * **/

/**
 * We import the following classes:
 * @see acm.graphics
 * @see acm.program
 * @see java.awt
 * @see java.util.ArrayList
 * **/
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Create class "Partida", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Partida extends GraphicsProgram {
    /**Create Variables private, final and static**/
    private static final String RUTA = "src/Zoombies/";
    private static final int PAUSE_TIME = 1;
    /**Create Variables private and final**/
    private final ArrayList<Emoji> array_emojis = new ArrayList<>();
    private final ArrayList<GImage> array_images_emojis = new ArrayList<>();
    /**Create Variables private**/
    private Zoombie ZOOMBIE;
    private GImage IMAGE_ZOOMBIE;

    /**
     * Create method setter and static main
     * @param args array the Strings
     * **/
    public static void main(String[] args) {new Partida().start(args);}

    /**
     * Create method setter init
     * **/
    public void init() {
        setSize(900, 900);
        setBackground(Color.LIGHT_GRAY);

        ZOOMBIE = new Zoombie(RUTA+"zoombie.png");

        IMAGE_ZOOMBIE = ZOOMBIE.getRetornaImatge();

        add(IMAGE_ZOOMBIE, Aleatori.getNumeroAleatori(1, getWidth()), Aleatori.getNumeroAleatori(1, getWidth()));

        array_emojis.add(new Emoji(RUTA+"emoji1.png"));
        array_emojis.add(new Emoji(RUTA+"emoji2.png"));
        array_emojis.add(new Emoji(RUTA+"emoji3.png"));
        array_emojis.add(new Emoji(RUTA+"emoji4.png"));
        array_emojis.add(new Emoji(RUTA+"emoji5.png"));
        array_emojis.add(new Emoji(RUTA+"emoji6.png"));
        array_emojis.add(new Emoji(RUTA+"emoji7.png"));
        array_emojis.add(new Emoji(RUTA+"emoji8.png"));
        array_emojis.add(new Emoji(RUTA+"emoji9.png"));

        for (Emoji actual : array_emojis) {
            array_images_emojis.add(actual.getRetornaImatge());
        }

        for (GImage actual : array_images_emojis) {
            add(actual, Aleatori.getNumeroAleatori(1, 700), Aleatori.getNumeroAleatori(1, 700));
        }
    }

    /**
     * Create method setter run
     * **/
    public void run() {
        waitForClick();

        while (true) {
            ZOOMBIE.setAvancar(IMAGE_ZOOMBIE, getWidth(), getHeight());

            for (int i = 0; i < array_emojis.size() && i < array_images_emojis.size(); i++) {
                array_emojis.get(i).setAvancar(array_images_emojis.get(i), getWidth(), getHeight());

                array_images_emojis.get(i).pause(PAUSE_TIME);
            }
        }
    }
}