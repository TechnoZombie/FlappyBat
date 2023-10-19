package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Random;

public class EnemiesFactory {
    public  Enemies[] arrayEnemies = new Enemies[40];

    public  void createEnemies() {
        for (int i = 0; i < arrayEnemies.length; i++) {
            int random = (int) Math.ceil(Math.random() * 10);
            if (random > 5) {
                arrayEnemies[i] = new Death();
            } else {
                arrayEnemies[i] = new Ghost();
            }
        }
    }

    public  Enemies[] getArrayEnemies(){
        return arrayEnemies;
    }
}
