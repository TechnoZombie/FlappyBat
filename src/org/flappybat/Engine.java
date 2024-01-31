/*
-> Mechanics; //engine
	Proprieties:
	-- KHandler;

	Requirements:
	-- org.codeforall.shittyflappybird.Gravity; [y will always --; keyboard will y++]
 */

package org.flappybat;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.flappybat.GameObjects.Bat;
import org.flappybat.Handlers.KHandler;
import org.flappybat.Handlers.MHandler;
import org.flappybat.Handlers.SoundHandler;
import org.flappybat.GameObjects.Enemies;
import org.flappybat.GameObjects.EnemiesFactory;


import java.util.LinkedList;

public class Engine {


    public static State currentState = State.MENU;
    GameScreen gameScreen = new GameScreen();
    LinkedList<Enemies> list = new LinkedList<>();
    Rectangle border = new Rectangle(1200, 10, 200, 2000);
    public SoundHandler soundHandler = new SoundHandler("/Resources/Sound/FreakShort.wav");


    public void start() {
        soundHandler.play();
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
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (currentState == State.PLAY) {
            gameScreen.backgroundImage();
            gameScreen.gridmaker();
            new Bat();
            Gravity gravity = new Gravity();
            Thread tt = new Thread(gravity);
            tt.start();
            KHandler kHandler = new KHandler();
            kHandler.initKey();
            EnemiesFactory enemiesFactory = new EnemiesFactory();
            enemiesFactory.setEnemyNumber(100);
            enemiesFactory.createEnemies();
         /*   border.setColor(Color.WHITE);
            border.fill();*/
            for (Enemies enemy : EnemiesFactory.enemyArray) {
                enemy.drawPicture();
                if (enemy.getPicture() == null) {
                    break;
                }
                while (!enemy.checkBounds()) {
                    enemy.tryMove();
                    if (enemy.checkIntersection()) {
                        Bat.isDead = true;
                        gameOver();
                        break;
                    }
                    if (Bat.batPic.getY() > 980) {
                        Bat.isDead = true;
                        gameOver();
                        break;
                    }
                }
            }
            if(currentState == State.OVER){

            }
        }
    }

    public void gameOver() {
        currentState = State.OVER;
        Bat.batDeathAnimation();
        removeAll();
        Bat.removePicture();
        soundHandler.close();
        SoundHandler soundHandler1 = new SoundHandler("/Resources/Sound/EvilLaugh.wav");
        soundHandler1.play();
        Picture gameOver = new Picture(10, 10, "Resources/gameover.png");
        gameOver.draw();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.exit(0);
    }

    private void removeAll() {
        for (Enemies enemies : EnemiesFactory.enemyArray) {
            list.add(enemies);
            if (enemies.getPicture() == null) {

            }
            enemies.removePicture();
            list.remove(enemies);
        }
    }

    public enum State {
        MENU,
        PLAY,
        OVER;
    }

}
