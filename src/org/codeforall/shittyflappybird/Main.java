/*
    g.start()
*/

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.codeforall.shittyflappybird.GameObjects.Enemies;
import org.codeforall.shittyflappybird.Handlers.EventHandler;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        //Rectangle rec = new Rectangle();
        //GameScreen gameScreen = new GameScreen();
       // rec.fill();

        //O background é chamado na funçao abaixo gamescreen.backgroundImage.jpeg
        //a grid assim pode ficar dinamica ao background size

        //Picture arena = new Picture(10, 10, "resources2/HW-BD.jpeg");
        //arena.draw();


            //gameScreen.backgroundImage();
            //gameScreen.gridmaker();


      engine.start();


    }
}
