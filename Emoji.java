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
 * @see java.awt
 * **/
import acm.graphics.*;
import acm.program.*;
import java.awt.*;

/**
 * Create class "Emoji", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Emoji extends GraphicsProgram {
    /**Create Variables private, final and static**/
    private static final double BALL_RADIUS = 10;
    private static final String RUTA = "src/Zoombies/Imatges/";
    /**Create Variables private**/
    private GImage IMAGE_EMOJI;
    private boolean zoombie;
    private double dx;
    private double dy;

    /**
     * Create method constructor the class "Emoji"
     * @param rutaEmoji path folder where are the images
     * @param zoombie variable boolean, what indicate if emoji is a zoombie or no
     * **/
    public Emoji(String rutaEmoji, boolean zoombie) {
        IMAGE_EMOJI = new GImage(RUTA+rutaEmoji);
        this.zoombie = zoombie;
        dx = 2;
        dy = 1;
    }

    /**
     * Create method setter "setAvancar"
     * @param width the width from the window
     * @param height the height from the window
     * **/
    public void setAvancar(double width, double height) {
        double bx = IMAGE_EMOJI.getX();
        double by = IMAGE_EMOJI.getY();
        if (bx < BALL_RADIUS || bx > width - 50) dx = -dx;
        if (by < BALL_RADIUS || by > height - 50) dy = -dy;
        IMAGE_EMOJI.move(dx, dy);
    }

    /**
     * Create method getter "getAfegirImatge"
     * @return IMAGE_EMOJI
     * **/
    public GImage getAfegirImatge() {return IMAGE_EMOJI;}

    /**
     * Create method setter "setCanviarImatge"
     * @param rutaImatge path folder where are the images
     * **/
    public void setCanviarImatge(String rutaImatge) {IMAGE_EMOJI.setImage(RUTA+rutaImatge);}

    /**
     * Create method getter "getRetornaImatge"
     * @return IMAGE_EMOJI.getImage()
     * **/
    public Image getRetornaImatge() {return IMAGE_EMOJI.getImage();}

    /**
     * Create method setter "setZoombie"
     * @param zoombie will be true, if is zoombie, and will be false, if is not zoombie
     * **/
    public void setZoombie(boolean zoombie) {this.zoombie = zoombie;}

    /**
     * Create method getter "isZoombie"
     * @return zoombie
     * **/
    public boolean isZoombie() {return zoombie;}
}