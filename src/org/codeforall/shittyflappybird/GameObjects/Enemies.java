package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;


public class Enemies extends Picture {

    boolean collision;
    Death d;
    Ghost g;

    public void move() throws InterruptedException {
        translate(-20, 0);
    }

    public boolean checkCollision(Rectangle rectangle) {
        return collision;
    }

    public void removePicture() {

    }

    public void newSpawn(){

    }

    public void drawPicture() {

    }

    public Rectangle hitBox() {
        return null;
    }

    public boolean checkBounds() {
        return false;
    }

    public int generator(int min, int max) {
        return min + (int) Math.ceil(Math.random() * max);
    }
}
// return min + ((int)(Math.random()*(max-min))+min);


