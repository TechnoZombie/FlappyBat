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

    public Rectangle obs1;
    public Rectangle obs2;
    LinkedList<Rectangle> trash = new LinkedList<>();

    public Obstacles() {
        obs1 = new Rectangle(400, 10, 50, generator());
        obs2 = new Rectangle(400, 400, 50, generator());

        obs1.setColor(Color.GREEN);
        obs2.setColor(Color.GREEN);
        obs1.fill();
        obs2.fill();

    }

    private int generator() {
        int multiplier = (int) (Math.ceil(Math.random() * 100));
        return 250 + multiplier;
    }

    public void tryMove() {
        try {
            move();
        } catch (InterruptedException e) {
            System.out.println("wtf");
        }
    }


    public void move() throws InterruptedException {
        while (obs1.getX() > -50) {
            Thread.sleep(10);
            obs1.translate(-1, 0);
            obs2.translate(-1, 0);
            obs1.fill();
            obs2.fill();
        }
        trashCompacter(obs1, obs2);
        new Obstacles().move();
    }

    private void trashCompacter(Rectangle ob1, Rectangle ob2) {
        trash.add(ob1);
        trash.add(ob2);
        trash.remove(ob1);
        trash.remove(ob2);
    }
}
