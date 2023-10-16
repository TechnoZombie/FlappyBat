/*
    g.start()
*/

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {
        Rectangle grid = new Rectangle(10, 10, 500,700);
        grid.setColor(Color.PINK);
        grid.draw();
      //  Picture arena = new Picture(0, 0, "Resources/waterfall.jpg");
        //arena.draw();
        new Obstacles().tryMove();
       // EventHandler eventHandler = new EventHandler();
        //eventHandler.init();




    }
}
