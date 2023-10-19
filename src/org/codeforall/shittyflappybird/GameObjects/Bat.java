/* -> Character;
	Proprieties:
	-- Gravity effect
	-- Score;
	-- Lives; (v2)
 */

package org.codeforall.shittyflappybird.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
//import java.awt.*;

public class Bat extends Picture {

    public static Picture batPic;



    public Bat() {
        batPic = new Picture(100, 100, "Resources/animations/BatAnimation/BatAnimation/image (1).png");

        batPic.draw();
    }

    public void setBatPic() {
        int lastX = batPic.getX();
        System.out.println(lastX);
        int lastY = batPic.getY();
        System.out.println(lastY);
        batPic.delete();
        Bat.batPic = new Picture(lastY,lastX,"Resources/animations/BatAnimation/BatAnimation/DeadBat.png");
        batPic.draw();
    }

    public boolean checkBorder() {
        if (hitBox().getY() < 10) {
            batPic.translate(0, 50);
            return false;
        } else if (hitBox().getY() > 1200) {
            return true;
        }
        return false;
    }

    public void removePicture() {
        batPic.delete();
    }

    public static java.awt.Rectangle hitBox() {
        return new java.awt.Rectangle(batPic.getX(), batPic.getY(), batPic.getWidth(), batPic.getHeight());
    }

    public void moveAnimation() {

    }

    public static void movingAnimation() {
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
}