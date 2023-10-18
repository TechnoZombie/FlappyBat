/*
    g.start()
*/

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {


       // Rectangle grid = new Rectangle(10, 10, 640, 1136);
       // grid.setColor(Color.PINK);
       // grid.draw();

        Rectangle rec = new Rectangle();
        rec.fill();

        //new Character().run();
        //Picture arena = new Picture(10, 10, "Resources/waterfall.jpg");

        Picture arena = new Picture(10, 10, "resources2/HW-BD.jpeg");
        arena.draw();

        //Picture arena = new Picture(10, 10, "resources2/background.jpeg");
        //arena.draw();
         GameScreen gameScreen = new GameScreen();
            gameScreen.backgroundImage();
            gameScreen.gridmaker();

        EventHandler eventHandler = new EventHandler();
        Thread t = new Thread(eventHandler);
        t.start();
        Enemies enemy = new Enemies();
        Thread tt = new Thread(enemy);
        tt.start();
        enemy.spawnEnemiesRound1();


    }
}
