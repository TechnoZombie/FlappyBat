package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Enemies extends Picture implements Runnable  {

    public static Picture bat;
    public static Picture ghost;
    public static Picture bat1;
    public static Picture ghost1;
    private java.awt.Rectangle rectangle;

    public Enemies() {

    }

    public void spawnEnemiesRound2(){
        bat1 = new Picture(600, 100, "Resources/morcego.gif");
        ghost1 =new Picture(650, 400, "Resources/ghost.gif");
        bat1.grow(10,10);
        ghost1.grow(30,30);
        bat1.draw();
        ghost1.draw();
        System.out.println("wtf");
        move2();
    }

    public void spawnEnemiesRound1(){
        bat = new Picture(600, 100, "Resources/morcego.gif");
        ghost = new Picture(650, 400, "Resources/ghost.gif");
        bat.grow(10, 10);
        ghost.grow(30, 30);
        bat.draw();
        ghost.draw();
        move();
    }

    private void move2(){
        try{
           keepUp2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void move(){
        try{
            keepUp();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void keepUp2() throws InterruptedException {
        while (bat1.getX() > -100 && ghost1.getX() > -70) {
            Thread.sleep(40);
            moveAndIntersection(bat1,ghost1);
        }
        restart(bat1,ghost1);
        spawnEnemiesRound2();
        move();
    }

    public void keepUp() throws InterruptedException {
        while (bat.getX() > -100 && ghost.getX() > -70) {
            Thread.sleep(40);
                moveAndIntersection(bat,ghost);
        }
        restart(bat,ghost);
        spawnEnemiesRound1();
        move();
    }

    private void restart(Picture bat, Picture ghost){
        ghost.delete();
        bat.delete();
    }

    private void moveAndIntersection(Picture bat,Picture ghost){
        batMove(bat);
        ghostMove(ghost);
        checkInterseption(bat,ghost);
    }

    private void batMove(Picture bat){
        double i = Math.random();
        if (i > 0.50) {
            bat.translate(-3, -5);
            batHitBox(bat);
        }else
            bat.translate(-3, 5);
    }

    private void ghostMove(Picture ghost){
        double i = Math.random();
        if (i > 0.50) {
            ghost.translate(-3, -5);
            ghostHitBox(ghost);
        }else
            ghost.translate(-3, 5);
    }

    public void checkInterseption(Picture bat, Picture ghost) {
        if(batHitBox(bat).intersects(Character.birdHitBox()) || ghostHitBox(ghost).intersects(Character.birdHitBox())){
            System.out.println("works man");
            System.exit(1);
        }

    }

    public Rectangle batHitBox(Picture bat) {
        rectangle = new java.awt.Rectangle(bat.getX() + 35, bat.getY() + 100, bat.getWidth() - 100, bat.getHeight() - 150);
        return rectangle;
    }

    public Rectangle ghostHitBox(Picture ghost)  {
        rectangle = new java.awt.Rectangle(ghost.getX(), ghost.getY(), ghost.getWidth(), ghost.getHeight());
        return rectangle;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            spawnEnemiesRound2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}


