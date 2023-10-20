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
import org.codeforall.shittyflappybird.GameObjects.Bat;

public class GameScreen {
    private Picture arena;


    private int score;
    private int highScore;

    public void backgroundImage() {
        arena = new Picture(10, 10, "Resources/Background_GS.jpg");
        arena = new Picture(10, 10, "Resources/backfinal.png");
        arena.draw();
    }

    public void gridmaker() {
        // picture ainda não existe, adicionar mais tarde

        int sizeX = arena.getHeight(); //grid size fica dinamico com o tamanho da background image puxada no método backgroundImage()
        int sizeY = arena.getWidth();
        Rectangle grid = new Rectangle(10, 10, sizeY, sizeX);
        grid.setColor(Color.CYAN);
        grid.draw();
    }

    public void removeBackGround(){
        arena.delete();
    }

    public GameScreen() {

        score = 0;
        highScore = 0;
       // bird = new Bat();


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