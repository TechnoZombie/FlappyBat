package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class EnemiesFactory {

    int numberOfEnemies = 0;
    public static Enemies[] enemyArray;

    public void createEnemies() {
        for (int i = 0; i < numberOfEnemies; i++) {
            int random = (int) Math.ceil(Math.random() * 10);
            if (random > 5) {
                Death death = new Death();
               // death.drawPicture();
                enemyArray[i] = death;
            } else {
                Ghost ghost = new Ghost();
               // ghost.drawPicture();
                enemyArray[i] = ghost;
            }
        }
    }

    public void setEnemyNumber(int numberOfEnemies){
        this.numberOfEnemies = numberOfEnemies;
        enemyArray = new Enemies[numberOfEnemies];
    }
}

