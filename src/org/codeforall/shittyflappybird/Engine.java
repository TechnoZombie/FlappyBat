/*
-> Mechanics; //engine
	Proprieties:
	-- KHandler;

	Requirements:
	-- Gravity; [y will always --; keyboard will y++]
 */

package org.codeforall.shittyflappybird;


import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.codeforall.shittyflappybird.GameObjects.Bat;
import org.codeforall.shittyflappybird.GameObjects.Enemies;
import org.codeforall.shittyflappybird.GameObjects.EnemiesFactory;
import org.codeforall.shittyflappybird.Handlers.EventHandler;
import org.codeforall.shittyflappybird.Handlers.KHandler;
import org.codeforall.shittyflappybird.Handlers.MHandler;

import java.util.LinkedList;

public class Engine {

    public static State currentState = State.MENU;
    public static Bat bat;
    GameScreen gameScreen = new GameScreen();
    EventHandler soundHandle = new EventHandler();
    Thread t = new Thread(soundHandle);
    LinkedList<Enemies> list = new LinkedList<>();

    public void start() {
        //t.start(); //REmove comentário para haver som de fundo
        Picture menu = new Picture(10, 10, "resources2/background.jpeg");
        menu.draw();
        MHandler mHandler = new MHandler();
        mHandler.initMouse();
        while (currentState == State.MENU) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        menu.delete();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (currentState == State.PLAY) {
            gameScreen.backgroundImage();
            gameScreen.gridmaker();
            bat = new Bat();
            KHandler kHandler = new KHandler();
            Thread t = new Thread(kHandler);
            t.start();
            EnemiesFactory enemiesFactory = new EnemiesFactory();
            enemiesFactory.createEnemies();
            Enemies[] enemies = enemiesFactory.getArrayEnemies();
            for (int i = 0; i < enemies.length; i++) {
                enemies[i].drawPicture();
                while (enemies[i].checkBounds()) {
                    enemies[i].move();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    enemies[i].hitBox();
                    if(bat.checkBorder()){
                        list.add(enemies[i]);
                        currentState = State.OVER;
                        gameOver();
                    }
                    if (enemies[i].checkCollision(bat.hitBox())) {
                        System.out.println("aiaiai meu deus");
                        i = enemies.length - 1;
                        currentState = State.OVER;
                        gameOver();
                    }
                }
                enemies[i].newSpawn();
                System.out.println("bu frances");
            }
        }
    }
        public void gameOver(){
        if (currentState == State.OVER) {
            gameScreen.removeBackGround();
            removeAll();
            bat.removePicture();
            new Picture(10,10,"Resources/waterfall.jpg").draw();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentState = State.MENU;
            start();
        }
    }

    public void removeAll() {
        for (Enemies enemies : list) {
            list.add(enemies);
            enemies.removePicture();
            list.remove(enemies);
        }
    }


    public enum State {
        MENU,
        PLAY,
        OVER;
    }

    ;


}
