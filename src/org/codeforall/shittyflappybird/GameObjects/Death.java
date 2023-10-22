package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Death extends Enemies {

    Picture picture;
    private int x = 1100;
    private int y = generator(150, 500);
    private int speed = 5;
    public boolean killedBat = false;

    public Death Death() {
        return new Death();
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
            picture.delete();
            delete();
        }else if (checkIntersection()) {
            picture.delete();
            killedBat = true;
        }
        if (generator(1, 2) == 2) {
            picture.translate(-speed, -speed);
        } else {
            picture.translate(-speed, speed);
        }
        Thread.sleep(50);
        this.x -= speed;
        speed += 3;
    }

    @Override
    public void removePicture() {
        picture = null;
    }

    @Override
    public void drawPicture() {
        picture = new Picture(x, y, "Resources/Death.png");
        picture.grow(10, 10);
        picture.draw();
    }

    @Override
    public java.awt.Rectangle hitBox() {
        return new java.awt.Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());
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