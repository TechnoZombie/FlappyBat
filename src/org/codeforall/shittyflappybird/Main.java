/*
    g.start()
*/

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {
        Rectangle grid = new Rectangle(0, 0, 650, 1600);
        grid.setColor(Color.PINK);
        grid.draw();
        Picture arena = new Picture(0, 0, "Resources/waterfall.jpg");
        arena.draw();

        EventHandler eventHandler = new EventHandler();
        eventHandler.init();




    }
}
