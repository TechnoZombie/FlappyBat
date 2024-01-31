package org.codeforall.flappybat.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Ghost extends Enemies {

    Picture picture;
    public int x = 1100;
    public int y = generator(150, 500);
    private int speed = 5;
    public boolean killedBat = false;

    public Enemies Ghost() {
        return new Ghost();
    }

    @Override
    public void tryMove() {
        try {
            move();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Picture getPicture() {
        return picture;
    }

    @Override
    public void move() throws InterruptedException {
        if (checkBounds()) {
            removePicture();
        }else if (checkIntersection()) {
            removePicture();
            killedBat = true;
        }
        if (generator(1, 2) == 2) {
            picture.translate(-speed, -speed);
        } else {
            picture.translate(-speed, speed);
        }
        Thread.sleep(50);
        this.x -= speed;
        speed += 2;
    }

    @Override
    public void removePicture() {
        picture = null;
    }

    @Override
    public void drawPicture() {
        picture = new Picture(x, y, "Resources/ghost.gif");
        picture.grow(30, 30);
        picture.draw();
    }

    @Override
    public java.awt.Rectangle hitBox() {
        return new Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());
    }

    @Override
    public boolean checkBounds() {
        return picture.getX() < -100;
    }

    @Override
    public boolean checkIntersection() {
        return Bat.batHitBox().intersects(hitBox());
    }

    @Override
    public boolean checkKilledBat() {
        return killedBat;
    }
}