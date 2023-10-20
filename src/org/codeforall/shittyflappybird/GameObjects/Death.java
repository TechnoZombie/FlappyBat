package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Death extends Enemies implements Runnable{

    Enemies death;
    Picture picture;

    private int x = 1250;
    private int y = generator(-50, 800);

    private int speed = 40;

    public Enemies Death() {
        death = new Death();
        death.grow(30, 30);
        death.draw();
        return death;
    }

    @Override
    public void run(){
        try {
            move();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void move() throws InterruptedException {
        while(true) {
            if (generator(1, 2) == 2) {
                picture.translate(-speed, -15);
            } else {
                picture.translate(-speed, 15);
            }
            Thread.sleep(50);
            this.x -= speed;
        }
    }

    @Override
    public void removePicture() {
        picture.delete();
    }

    @Override
    public void drawPicture() {
        picture = new Picture(x, y, "Resources/Death.png");
        picture.grow(20, 20);
        picture.draw();
    }

    @Override
    public java.awt.Rectangle hitBox() {
        return new java.awt.Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());
    }

    @Override
    public boolean checkBounds() {
        if (picture.getX() > -100) {
            return true;
        }
        return false;
    }

    public Rectangle hitbox() {
        return new Rectangle();
    }

    @Override
    public void newSpawn() {
        picture.translate(x, y);
       // move();
    }

    @Override
    public boolean checkCollision(java.awt.Rectangle bat) {
        if (hitBox().intersects(bat)) {
            return true;
        }
        return false;
    }


}
