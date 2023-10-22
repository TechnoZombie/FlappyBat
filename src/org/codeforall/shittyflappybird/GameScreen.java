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
import org.codeforall.shittyflappybird.GameObjects.Bat;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen {

    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 900;
    public static Picture arena;
    private Text scoreText;
    private Text scoreName;
    private Text scoreName2;
    private int score;
    private int highScore;

    public void backgroundImage() {
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
        scoreName = new Text(990, 30, "AVOIDED DEATH FOR");
        scoreName.setColor(Color.ORANGE);
        scoreName.grow(80, 30);
        scoreName.draw();


        // this is creating and initializing the score text number
        scoreText = new Text(1035, 95, String.valueOf(score));
        scoreText.setColor(Color.ORANGE);
        scoreText.grow(60, 60);
        scoreText.draw();

        scoreName2 = new Text(1010, 160, "SECONDS");
        scoreName2.setColor(Color.ORANGE);
        scoreName2.grow(60, 30);
        scoreName2.draw();
        // this is a task to update the score every 5 seconds
        Timer timer = new Timer();
        timer.schedule(new UpdateScoreTask(), 2000, 1000);
    }

    public void removeBackGround() {
        arena.delete();
    }

    public GameScreen() {
        score = 0;
        highScore = 0;
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
            if (Bat.isDead) {
            } else {
                // this is incrementing the score by 1 every 5 seconds
                updateScore(1);
            }
        }
    }

}