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

        t.start(); //Remove comentário para haver som de fundo

       // Picture menu = new Picture(10, 10, "Resources/Background_SS.jpg");

        Picture menu = new Picture(10, 10, "Resources/start111.png");
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
            //enemiesFactory.createEnemies();
            enemiesFactory.scheduleEnemiesCreating(10, 2000);
            Enemies[] enemies = enemiesFactory.getArrayEnemies();

            /*for (int i = 0; i < enemies.length; i++) {
                enemies[i].drawPicture();*/
            while(currentState == State.PLAY) {
                for (int i = 0; i < enemies.length; i++) {
                    if (enemies[i] != null) {
                        //  enemies[i].move();
                    }

                    // checkAllBounds();//criar em engine ou enemies, wtv
                    if (bat.checkBorder()) {
                        removeAll();
                        currentState = State.OVER;
                        gameOver();
                    }
                    enemies[i].newSpawn();
                }
                //if(batAllCollision){
                //criar  em engine
                //  gameOver();
                //}
                /*while (enemies[i].checkBounds()) {

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
                    if (bat.checkBorder()) {

                    }
                    if (enemies[i].checkCollision(bat.hitBox())) {
                        i = enemies.length - 1;
                        currentState = State.OVER;
                        gameOver();*/
            }
        }
    }



    public void gameOver() {

        if (currentState == State.OVER) {
            soundHandle.runEndMusic(); //runs evil laugh when character dies

            //sets bat pic to dead bat and holds the screen for 5 seconds until game over screen
            bat.setBatPic();
            /*bat.draw();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            removeAll();
            bat.removePicture();


            new Picture(10,10,"Resources/Background_ES.jpg").draw();
           // soundHandle.runEndMusic(); //placeholder for endscreen music

           // new Picture(10,10,"Resources/Background_ES.jpg").draw();
            soundHandle.loadEndAudio(); //loads end audio


            new Picture(10, 10, "Resources/gameover.png").draw();
            try {
                Thread.sleep(4000);
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

 /*   public void createMultipleEnemiesDelayed(EnemiesFactory factory, int numEnemies, long delay) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> {
            factory.createMoreEnemies(numEnemies);
            Enemies[] enemies = factory.getArrayEnemies();
            for (int i = 0; i < numEnemies; i++) {
                enemies[i].drawPicture();
            }
        }, delay, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
    }
*/

    public enum State {
        MENU,
        PLAY,
        OVER;
    }

}