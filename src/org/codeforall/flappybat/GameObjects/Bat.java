/* -> Character;
	Proprieties:
	-- org.codeforall.shittyflappybird.Gravity effect
	-- Score;
	-- Lives; (v2)
 */

package org.codeforall.flappybat.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
//import java.awt.*;

public class Bat extends Picture {

    public static Picture batPic;
    public static boolean isDead;

    public Bat() {
        batPic = new Picture(100, 100, "Resources/animations/BatAnimation/image (1).png");
        batPic.grow(-10, -10);
        batPic.draw();
    }

    public static void batDeathAnimation() {
        int lastX = batPic.getY();
        int lastY = batPic.getX();
        batPic.delete();
        batPic = new Picture(lastY, lastX, "Resources/animations/BatAnimation/DeadBat.png");
        batPic.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removePicture() {
        batPic.delete();
    }

    public static Rectangle batHitBox() {
       return new java.awt.Rectangle(batPic.getX(), batPic.getY(), batPic.getWidth(), batPic.getHeight());
    }

    ;
}

   /* public static void movingAnimation() {
        try {
            moveBatAnimation();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void moveBatAnimation() throws InterruptedException {
        batPic.delete();
        Picture b = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (2).png");
        b.draw();
        Thread.sleep(100);
        b.delete();
        Picture c = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (3).png");
        c.draw();
        Thread.sleep(100);
        c.delete();
        Picture d = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (4).png");
        d.draw();
        Thread.sleep(100);
        d.delete();
        Picture e = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (5).png");
        e.draw();
        Thread.sleep(100);
        e.delete();
        Picture f = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (6).png");
        f.draw();
        Thread.sleep(100);
        f.delete();
        Picture g = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (7).png");
        g.draw();
        Thread.sleep(100);
        g.delete();
        Picture h = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (8).png");
        h.draw();
        Thread.sleep(100);
        h.delete();
        Picture i = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (9).png");
        i.draw();
        Thread.sleep(100);
        i.delete();
        Picture j = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (10).png");
        j.draw();
        Thread.sleep(100);
        j.delete();
        batPic = new Picture(100, batPic.getY(), "Resources/animations/BatAnimation/BatAnimation/image (1).png");
        batPic.draw();

    }
}*/
