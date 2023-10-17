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
    LinkedList<Rectangle> trash = new LinkedList<>();

    public Obstacles() {
        new Enemies();
       // obs1 = new Rectangle(300, 100, 100, 100);
        //obs2 = new Rectangle(300, 400, 100, 100);
       // obs1.setColor(Color.GREEN);
       // obs2.setColor(Color.RED);
        //obs1.fill();
        //obs2.fill();

    }

    public  void tryMove() {
        try {
            move();
        } catch (InterruptedException e) {
            System.out.println("Game is Crashed,oopsie");
        }
    }

    public void move() throws InterruptedException {
        while (obs1.getX() > -70 && obs2.getX() > -70) {
            Thread.sleep(15);
            randomMovement(obs1);
            randomMovement(obs2);
            obs1.fill();
            obs2.fill();
            Enemies.keepUp();
        }
        Enemies.bat=null;
        Enemies.ghost=null;
        obs1.delete();
        obs2.delete();
        trashCompacter(obs1, obs2);
        new Obstacles().tryMove();
    }

    private void trashCompacter(Rectangle ob1, Rectangle ob2) {
        trash.add(ob1);
        trash.add(ob2);
        trash.remove(ob1);
        trash.remove(ob2);
    }

    private void randomMovement(Rectangle obs){
        double i = Math.random();
        if (i > 0.50) {
            obs.translate(-1,5);
        } else
            obs.translate(-1, -5);
    }


}
