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

import java.awt.*;
//import java.awt.*;

public class Character extends Picture {
    public static Picture bird;
    public static java.awt.Rectangle rectangle;


    public Character() {
        bird = new Picture(100, 100, "Resources/placeholder.png");
        bird.grow(20, 20);
        bird.draw();

    }

    public static Rectangle birdHitBox()  {
        rectangle = new java.awt.Rectangle(bird.getX(), bird.getY(), bird.getWidth()-70, bird.getHeight()-70);
        return rectangle;
    }




}