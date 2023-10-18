/*
    g.start()
*/

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {

        Rectangle rec = new Rectangle();
        rec.fill();

        //O background é chamado na funçao abaixo gamescreen.backgroundImage.jpeg
        //a grid assim pode ficar dinamica ao background size

       // Picture arena = new Picture(10, 10, "resources2/HW-BD.jpeg");
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
