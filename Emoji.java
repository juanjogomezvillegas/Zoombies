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

public class Emoji extends GraphicsProgram {
    private GImage IMAGE_EMOJI;
    private static final double BALL_RADIUS = 10;
    private double dx;
    private double dy;

    public Emoji(String rutaEmoji) {
        IMAGE_EMOJI = new GImage(rutaEmoji);
        dx = 2;
        dy = 1;
    }

    public GImage getRetornaImatge() {
        return IMAGE_EMOJI;
    }

    public void setAvancar(GImage emoji, double width, double height) {
        double bx = emoji.getX();
        double by = emoji.getY();
        if (bx < BALL_RADIUS || bx > width - BALL_RADIUS) dx = -dx;
        if (by < BALL_RADIUS || by > height - BALL_RADIUS) dy = -dy;
        emoji.move(dx, dy);
    }
}