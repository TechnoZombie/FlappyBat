/*
-> GameScreen / Backdrop wtv;
    Requirements:
    --Move background;
    --show current score;
    --show current lives; (v2)
 */

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class GameScreen {

    // chamar o bird
    private Character bird;

    // chamar os obstacles

    private int score;

    private int highScore;


    public void gridmaker() {
        Rectangle grid = new Rectangle(10, 10, 2000, 1200);
        grid.setColor(Color.CYAN);
        grid.draw();

        // picture ainda não existe, adicionar mais tarde
        Picture arena = new Picture(10, 10, "Resources/2background-city.jpeg");
        arena.draw();
    }

    public GameScreen() {

        score = 0;
        highScore = 0;

        bird = new Character();


    }

    // if condition, se o passaro nao colidir com as pipes/obstacles
    // o score é aumentado em 1

    /*public void updateGameState() {
        if (!bird.collidesWith(obstacle)) {
            updateScore(1);
        }
    }*/

    public void updateScore(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;
        }
    }

    // usar quando dermos restart ao game=
    public void resetScore() {
        score = 0;
    }

}