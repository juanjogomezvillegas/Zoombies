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
 * **/
import acm.graphics.*;
import acm.program.*;

/**
 * Create class "Emoji", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Emoji extends GraphicsProgram {
    /**Create Variables private, final and static**/
    private static final double BALL_RADIUS = 55;
    /**Create Variables private**/
    private static final String RUTA = "src/Zoombies/";
    private GImage IMAGE_EMOJI;
    private double dx;
    private double dy;

    public Emoji(String rutaEmoji) {
        IMAGE_EMOJI = new GImage(rutaEmoji);
        dx = 2;
        dy = 1;
    }

    public GImage getRetornaImatge() {return IMAGE_EMOJI;}

    public void setAvancar(GImage emoji, double width, double height) {
        double bx = emoji.getX();
        double by = emoji.getY();
        if (bx < BALL_RADIUS || bx > width - BALL_RADIUS) dx = -dx;
        if (by < BALL_RADIUS || by > height - BALL_RADIUS) dy = -dy;
        emoji.move(dx, dy);
    }
}