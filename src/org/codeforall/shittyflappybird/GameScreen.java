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
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen {
    private Picture arena;
    private Text scoreText;
    private Text scoreName;


    private int score;
    private int highScore;

    public void backgroundImage() {
        arena = new Picture(10, 10, "Resources/Background_GS.jpg");
        arena = new Picture(10, 10, "Resources/backfinal.png");
        arena.draw();
    }

    public void gridmaker() {
        int sizeX = arena.getHeight();
        int sizeY = arena.getWidth();
        Rectangle grid = new Rectangle(10, 10, sizeY, sizeX);
        grid.setColor(Color.CYAN);
        grid.draw();

        // this is creating and initializing the score text
        scoreName = new Text(1175, 25, "Wave:");
        scoreName.setColor(Color.WHITE);
        scoreName.grow(5,5);
        scoreName.draw();


        // this is creating and initializing the score text number
        scoreText = new Text(1200, 45, String.valueOf(score));
        scoreText.setColor(Color.WHITE);
        scoreText.grow(3,3);
        scoreText.draw();

        // this is a task to update the score every 5 seconds
        Timer timer = new Timer();
        timer.schedule(new UpdateScoreTask(), 5000, 5000);
    }

    public void removeBackGround(){
        arena.delete();
    }

    public GameScreen() {

        score = 0;
        highScore = 0;
        // bird = new Bat();


    }


    public void updateScore(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;
        }
        // this updates the score displayed on the screen
        scoreText.setText(String.valueOf(score));
    }

    // usar quando dermos restart ao game=
    public void resetScore() {
        score = 0;
        // this resets the displayed score to 0
        scoreText.setText("0");
    }

    private class UpdateScoreTask extends TimerTask {
        @Override
        public void run() {
            // this is incrementing the score by 1 every 5 seconds
            updateScore(1);
        }
    }

}