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

public class Obstacles extends Rectangle {


    public Rectangle obs1;
    public Rectangle obs2;

    public Obstacles(){
        obs1 = new Rectangle(500,10, 100,  500);
        obs2 = new Rectangle(500, 700,100, 500);


        obs1.setColor(Color.GREEN);
        obs2.setColor(Color.GREEN);
        obs1.fill();
     obs2.fill();
    }
}
