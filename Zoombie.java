package Zoombies;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * @author Edgar Peréz
 * @author Jordi Risco
 * @author Kirill Lupenkov
 * **/

import acm.graphics.*;
import acm.program.*;

public class Zoombie extends GraphicsProgram {
    private GImage IMAGE_ZOOMBIE;
    private static final double BALL_RADIUS = 10;
    private double dx;
    private double dy;

    public Zoombie(String rutaEmoji) {
        IMAGE_ZOOMBIE = new GImage(rutaEmoji);
        dx = 2;
        dy = 1;
    }

    public GImage getRetornaImatge() {
        return IMAGE_ZOOMBIE;
    }

    public void setAvancar(GImage zoombie, double width, double height) {
        double bx = zoombie.getX();
        double by = zoombie.getY();
        if (bx < BALL_RADIUS || bx > width - BALL_RADIUS) dx = -dx;
        if (by < BALL_RADIUS || by > height - BALL_RADIUS) dy = -dy;
        zoombie.move(dx, dy);
    }
}