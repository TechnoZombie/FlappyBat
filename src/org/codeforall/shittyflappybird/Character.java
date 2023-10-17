/* -> Character;
	Proprieties:
	-- Gravity effect
	-- Score;
	-- Lives; (v2)
 */

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
//import java.awt.*;

public class Character extends Picture {
    public  Picture bird;
    public Rectangle rectangle;


    public Character() {
        bird = new Picture(100, 100, "Resources/placeholder.png");
        bird.grow(20, 20);
        bird.draw();

    }

    public void tryHitBox(){
        try {
            birdHitBox();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  void birdHitBox() throws InterruptedException {
        rectangle = new Rectangle(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
        rectangle.draw();
        Thread.sleep(100);
        rectangle.delete();
    }




}