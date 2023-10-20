package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EnemiesFactory {
    public Enemies[] arrayEnemies = new Enemies[100];

    public void createEnemies() {
        for (int i = 0; i < arrayEnemies.length; i++) {
            int random = (int) Math.ceil(Math.random() * 10);
            if (random > 5) {
                Death death = new Death();
                arrayEnemies[i] = death;
                death.drawPicture();
            } else {
                Ghost ghost = new Ghost();
                arrayEnemies[i] = ghost;
                ghost.drawPicture();
            }
        }
    }

    private void putInArray(Enemies enemy) {
        for (int i = 0; i < arrayEnemies.length; i++) {
            if (arrayEnemies[i] == null) {
                arrayEnemies[i] = enemy;
            }
        }
    }
//a razao do delay é criar 1 esperar x segundos e criar outro,o loopque tinhas criava todose depois apareciam todos ao mm tempo,o array so os coloca na lista para os conseguirmos acederno engine
    // entao esse metodo é em vao, nos queremos é criar mais do 1 aomm tempo
    //criar vários ao mesmo tempo,não é criar logos os 50, percorrem o ecra e acaba o jogo, temos de criar 1 e enquanto ele anda criamos mais,para aparecer vários durante o tempo de jogo
    public void createMoreEnemies(int numberOfEnemies) {
            int random = (int) Math.ceil(Math.random() * 10);
            if (random > 5) {
                Death death = new Death();
                putInArray(death);
                death.drawPicture();
                Thread t = new Thread(death);
                t.start();
                //death.move();
            } else {
                Ghost ghost = new Ghost();
                putInArray(ghost);
                ghost.drawPicture();
                Thread t = new Thread(ghost);
                t.start();
                //ghost.move();
            }
        }


    public void scheduleEnemiesCreating(int numberOfEnemies, long delay) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                createMoreEnemies(numberOfEnemies);
            }
        }, delay);
    }


    public Enemies[] getArrayEnemies() {
        return arrayEnemies;
    }
}
