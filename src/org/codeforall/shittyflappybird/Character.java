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
    private static final int dc = 150;

    public Character() {
        bird = new Picture(100, 100, "Resources/placeholder.png");
        bird.grow(20, 20);
        bird.draw();
    }

    public static Rectangle birdHitBox()  {
        rectangle = new java.awt.Rectangle(bird.getX(), bird.getY(), bird.getWidth()-70, bird.getHeight()-70);
        return rectangle;
    }

    public static void deathAnimation() throws InterruptedException {
        Picture a = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death1.png");
        a.draw();
        Thread.sleep(dc*3);
        a.delete();
        Picture b = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 2.png");
        b.draw();
        Thread.sleep(dc*3);
        b.delete();
        Picture c = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 3.png");
        c.draw();
        Thread.sleep(dc*3);
        c.delete();
        Picture d = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 4.png");
        d.draw();
        Thread.sleep(dc*3);
        d.delete();
        Picture e = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 5.png");
        e.draw();
        Thread.sleep(dc*2);
        e.delete();
        Picture f = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 6.png");
        f.draw();
        Thread.sleep(dc*2);
        f.delete();
        Picture g = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 7.png");
        g.draw();
        Thread.sleep(dc*2);
        g.delete();
        Picture h = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 8.png");
        h.draw();
        Thread.sleep(dc*2);
        h.delete();
        Picture i = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 9.png");
        i.draw();
        Thread.sleep(dc);
        i.delete();
        Picture j = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 10.png");
        j.draw();
        Thread.sleep(dc);
        j.delete();
        Picture k = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 11.png");
        k.draw();
        Thread.sleep(dc);
        k.delete();
        Picture l = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 12.png");
        l.draw();
        Thread.sleep(dc);
        l.delete();
        Picture m = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 13.png");
        m.draw();
        Thread.sleep(dc);
        m.delete();
        Picture n = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 14.png");
        n.draw();
        Thread.sleep(dc);
        n.delete();
        Picture o = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 15.png");
        o.draw();
        Thread.sleep(dc);
        o.delete();
        Picture p = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 16.png");
        p.draw();
        Thread.sleep(dc);
        p.delete();
        Picture q = new Picture(bird.getX(), bird.getY(), "Resources/DeathAnimation/death Animation/death copy 17.png");
        q.draw();
        Thread.sleep(dc);
        q.delete();
    }


}