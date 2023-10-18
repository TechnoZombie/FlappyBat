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

    private Picture arena;
    // chamar os obstacles


    private int score;
    private int highScore;

    public void backgroundImage() {
        arena = new Picture(10, 10, "resources2/background.jpeg");
        arena.draw();

    }

    public void gridmaker() {
        // picture ainda não existe, adicionar mais tarde
        // Picture arena = new Picture(10, 10, "resources2/background.jpeg");
        //arena.draw();
        int sizeX = arena.getHeight();
        System.out.println("BG HEIGHT: " + sizeX);
        int sizeY = arena.getWidth();
        System.out.println("BG WIDTH: " + sizeY);

        Rectangle grid = new Rectangle(10, 10, sizeY, sizeX);
        grid.setColor(Color.CYAN);
        grid.draw();


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