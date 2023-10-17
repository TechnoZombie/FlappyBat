/* -> Character;
	Proprieties:
	-- Gravity effect
	-- Score;
	-- Lives; (v2)
 */

package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Character {
    public Rectangle bird;


    public Character() {
        bird = new Rectangle(100, 100, 30, 30);
        bird.setColor(Color.ORANGE);
        bird.fill();

    }


}