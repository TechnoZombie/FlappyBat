package org.codeforall.flappybat;

import org.codeforall.flappybat.GameObjects.Bat;

public class Gravity implements Runnable{
    @Override
    public void run() {
            try {
                moveBat();
            } catch (InterruptedException e) {

            }
        }

    public void moveBat() throws InterruptedException {
        while (true) {
            Bat.batPic.translate(0, 40);
            Thread.sleep(70);
        }
    }
}