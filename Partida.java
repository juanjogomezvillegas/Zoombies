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
 * @see acm.graphics
 * @see acm.program
 * @see java.awt.Color
 * @see java.util.ArrayList
 * **/
import acm.graphics.*;
import acm.program.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Create class "Partida", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Partida extends GraphicsProgram {
    /**Create Variables private, final and static**/
    private final ArrayList<Emoji> array_emojis = new ArrayList<>();
    private final String RUTA = "src/Zoombies/Imatges/";

    /**
     * Create method setter and static main
     * @param args array the Strings
     * **/
    public static void main(String[] args) {new Partida().start(args);}

    /**
     * Create method setter init
     * **/
    public void init() {
        /*
         * setSize set the size window in 900 the width and 900 the height
         * setBackground set the color window in DARK_GRAY
         * */
        setSize(900, 900);
        setBackground(Color.DARK_GRAY);

        /*
         * add to ArrayList "array_emojis" the images of the emojis, and write true if is zoombie and false if is not zoombie
         * */
        array_emojis.add(new Emoji("zoombie.png", true));
        array_emojis.add(new Emoji("emoji1.png", false));
        array_emojis.add(new Emoji("emoji2.png", false));
        array_emojis.add(new Emoji("emoji3.png", false));
        array_emojis.add(new Emoji("emoji4.png", false));
        array_emojis.add(new Emoji("emoji5.png", false));
        array_emojis.add(new Emoji("emoji6.png", false));
        array_emojis.add(new Emoji("emoji7.png", false));
        array_emojis.add(new Emoji("emoji8.png", false));
        array_emojis.add(new Emoji("emoji9.png", false));

        /*
         * add the images of the emojis in the window
         * */
        for (Emoji actual1 : array_emojis) {
            add(actual1.getImatge(), Aleatori.getNumeroAleatori(50, 650), Aleatori.getNumeroAleatori(50, 650));
        }
    }

    /**
     * Create method setter run
     * **/
    public void run() {
        waitForClick();/*wait until the user click on the window*/

        boolean sortir = false;
        /*Repeat the loop, while variable "sortir" be false*/
        while (!sortir) {
            /*All emojis advanced*/
            for (Emoji actual1 : array_emojis) {
                setAvancar(actual1);
            }

            /*check if an emoji is next to zoombie
            * if there is an emoji is next to an zoombie, the emoji convert in zoombie*/
            for (Emoji actual1 : array_emojis) {
                for (Emoji actual2 : array_emojis) {
                    if (actual1.isZoombie() && !actual2.isZoombie()) {
                        GImage img1 = actual1.getImatge();
                        GImage img2 = actual2.getImatge();
                        double x1 = img1.getX();
                        double y1 = img1.getY();
                        double x2 = img2.getX();
                        double y2 = img2.getY();

                        if (y1 < y2 + 35 && y1 > y2 - 35 && x1 < x2 + 35  && x1 > x2 - 35) {
                            actual2.getImatge().setImage(RUTA+"zoombie.png");
                            actual2.setZoombie(true);
                        }
                    }
                }
            }

            /*Check if all emojis have converted in zoombie
            * if all have convert in zoombie, the variable "sortir" is true*/
            for (Emoji actual1 : array_emojis) {
                if (!actual1.isZoombie()) {
                    sortir = false;
                    break;
                } else {
                    /*And the next loop, makes all the emojis disappear*/
                    for (Emoji actual2 : array_emojis) {
                        actual2.getImatge().setVisible(false);
                        pause(350);
                    }

                    /*And add a message "Game Over", with the font "Arial-50", and color "White", and located in the middle*/
                    GLabel gameover = new GLabel("Game Over!");
                    gameover.setFont("Arial-50");
                    gameover.setColor(Color.WHITE);
                    gameover.setLocation((getWidth() / 2.0) - gameover.getWidth() / 2, getHeight() / 2.0);
                    add(gameover);

                    sortir = true;
                }
            }

            /*establishes the pause time, in the value of the variable "1000"*/
            pause(1000);
            System.exit(0);
        }
    }

    /**
     * Create method setter "setAvancar"
     * @param emoji the emoji that needs to be moved
     * **/
    private void setAvancar(Emoji emoji) {
        /*Storage in the variables "locX" and "locY", the position X and Y to the emoji to param*/
        double locX = emoji.getImatge().getX();
        double locY = emoji.getImatge().getY();

        /*Check what "locX" be less that 0 or "locX" be greater that width to the window less 48
        * if is complies, will do the following*/
        if (locX < 0 || locX > getWidth() - 48) {
            emoji.setSpeedX(-emoji.getSpeedX());
        }
        /*Check what "locY" be less that 0 or "locY" be greater that height to the window less 48
        * if is complies, will do the following*/
        if (locY < 0 || locY > getHeight() - 48) {
            emoji.setSpeedY(-emoji.getSpeedY());
        }

        /*Move the emoji*/
        emoji.getImatge().move(emoji.getSpeedX(), emoji.getSpeedY());

        /*establishes the pause time, in the value of the variable "3"*/
        pause(3);
    }
}