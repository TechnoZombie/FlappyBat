/*
-> Obstacles;
	Requirements:
	-- method to generate pipes;
	-- randomize size of pipes; (v2)
	-- enough gap for the bird to pass;
	-- not too wide that the bird will always crash;
 */

package org.codeforall.shittyflappybird;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


import java.util.LinkedList;

public class Obstacles extends Rectangle {

    public static Rectangle obs1;
    public static Rectangle obs2;
    private Rectangle obs3;
    private Rectangle obs4;
    LinkedList<Object> trash = new LinkedList<>();
    private Enemies enemies;

    public Obstacles() {
        enemies = new Enemies();
        obs1 = new Rectangle(300, 100, 100, 100);
        obs2 = new Rectangle(300, 400, 100, 100);

    }

    public void tryMove() {
        try {
            move();
        } catch (InterruptedException e) {
            System.out.println("Game is Crashed,oopsie");
        }
    }

    public void move() throws InterruptedException {
        while (obs1.getX() > -70 && obs2.getX() > -70) {
            Thread.sleep(40);
            randomMovement(obs1);
            randomMovement(obs2);
            enemies.keepUp(Enemies.ghost);
            enemies.keepUp(Enemies.bat);
        }
        Enemies.bat.delete();
        Enemies.ghost.delete();
        trashCompacter(Enemies.bat,Enemies.ghost);
        obs1.delete();
        obs2.delete();
        trashCompacter(obs1, obs2);
        new Obstacles().tryMove();
    }

    private void trashCompacter(Object ob1, Object ob2) {
        trash.add(ob1);
        trash.add(ob2);
        trash.remove(ob1);
        trash.remove(ob2);
    }

    public static void randomMovement(Rectangle obs) {
        double i = Math.random();
        if (i > 0.50) {
            obs.translate(-3, 0);
        } else
            obs.translate(-3, 0);
    }


}
