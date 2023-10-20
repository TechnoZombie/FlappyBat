package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

public class Ghost extends Enemies implements Runnable {

    public Enemies ghost;

    public int x = 1250;
    public int y = generator(-50, 800);

    private int speed = 30;
    Picture picture;

    public Enemies Ghost() {
        ghost = new Ghost();
        ghost.grow(30, 30);
        ghost.draw();
        return ghost;
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
                Thread.sleep(50);
            } else {
                picture.translate(-speed, 15);
                Thread.sleep(50);
            }
            this.x -= speed;
        }
    }

    @Override
    public void removePicture() {
        picture.delete();
    }

    @Override
    public void drawPicture() {
        picture = new Picture(x, y, "Resources/ghost.gif");
        picture.grow(40, 40);
        picture.draw();

    }

    @Override
    public void newSpawn(){
        picture.translate(x,y);
        //move();
    }

    @Override
    public boolean checkBounds() {
        if (picture.getX() > -100) {
            return true;
        }
        return false;
    }

    @Override
    public java.awt.Rectangle hitBox() {
        return new java.awt.Rectangle(picture.getX(),picture.getY(), picture.getWidth(), picture.getHeight());
    }

    @Override
    public boolean checkCollision(Rectangle bat) {
        if (hitBox().intersects(bat)) {
            return true;
        }
        return false;
    }


}
