package org.flappybat.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;


public class Enemies extends Picture {

    boolean collision;
    Death d;
    Ghost g;

    public void move() throws InterruptedException {
        translate(-20, 0);
    }

    public void removePicture() {

    }

    public Picture getPicture(){
        return null;
    }

    public void tryMove(){

    }

    public void drawPicture() {

    }

    public Rectangle hitBox() {
       return null;
    }

    public boolean checkKilledBat(){
        return false;
    }

    public boolean checkIntersection(){
        return false;
    }

    public boolean checkBounds() {
        return false;
    }

    public int generator(int min, int max) {
        return min + (int) Math.ceil(Math.random() * max);
    }
}
// return min + ((int)(Math.random()*(max-min))+min);


