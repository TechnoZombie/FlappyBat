package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemies extends Picture {

    private Obstacles obstacles;
    public static Picture bat;
    public static Picture ghost;
    private Rectangle rectangle;

    public Enemies() {
        bat = new Picture(270, 100, "Resources/morcego.gif");
        ghost = new Picture(300, 400, "Resources/ghost.gif");
        bat.grow(10, 10);
        ghost.grow(30, 30);
        bat.draw();
        ghost.draw();

    }

    public void keepUp(Picture pic) throws InterruptedException {
        double i = Math.random();
        if (i > 0.50) {
            pic.translate(-3, 0);
            ghostHitBox();
            batHitBox();
        } else
            pic.translate(-3, 0);
        batHitBox();
        ghostHitBox();
    }

    public void checkInterseption(){

    }

    public void batHitBox() throws InterruptedException {
        rectangle = new Rectangle(bat.getX() + 35, bat.getY() + 100, bat.getWidth() - 100, bat.getHeight() - 150);
        rectangle.fill();
        Thread.sleep(10);
        rectangle.delete();
    }

    public void ghostHitBox() throws InterruptedException {
        rectangle = new Rectangle(ghost.getX(), ghost.getY(), ghost.getWidth(), ghost.getHeight());
        rectangle.fill();
        Thread.sleep(10);
        rectangle.delete();
    }
}


