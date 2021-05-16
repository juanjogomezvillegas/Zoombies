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
    private double speedX;
    private double speedY;

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

        switch (Aleatori.getNumeroAleatori(0, 8)) {
            case 0:
                this.speedX = 4;
                this.speedY = 2;
                break;
            case 1:
                this.speedX = 4;
                this.speedY = -2;
                break;
            case 2:
                this.speedX = -4;
                this.speedY = 2;
                break;
            case 3:
                this.speedX = -4;
                this.speedY = -2;
                break;
            case 4:
                this.speedX = 2;
                this.speedY = 4;
                break;
            case 5:
                this.speedX = 2;
                this.speedY = -4;
                break;
            case 6:
                this.speedX = -2;
                this.speedY = 4;
                break;
            default:
                this.speedX = -2;
                this.speedY = -4;
                break;
        }
    }

    /**
     * Create method getter "getImatge"
     * @return IMAGE_EMOJI
     * **/
    public GImage getImatge() {return IMAGE_EMOJI;}

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

    /**
     * Create method setter "setSpeedX"
     * @param speedX speed X the emoji
     * **/
    public void setSpeedX(double speedX) {this.speedX = speedX;}

    /**
     * Create method setter "setSpeedY"
     * @param speedY speed Y the emoji
     * **/
    public void setSpeedY(double speedY) {this.speedY = speedY;}

    /**
     * Create method getter "getSpeedX"
     * @return speedX
     * **/
    public double getSpeedX() {return speedX;}

    /**
     * Create method getter "getSpeedY"
     * @return speedY
     * **/
    public double getSpeedY() {return speedY;}
}