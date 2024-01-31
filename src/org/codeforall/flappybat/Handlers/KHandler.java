package org.codeforall.flappybat.Handlers;

import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.codeforall.flappybat.GameObjects.Bat;

import static java.lang.Thread.sleep;


public class KHandler implements KeyboardHandler, Runnable{

    private boolean isBeingPulled = true;
    public void initKey(){

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

    }

    private void holdOn(int milliseconds) throws InterruptedException {
      Thread.sleep(milliseconds);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
             // isBeingPulled = false;
                if(org.codeforall.flappybat.GameObjects.Bat.isDead){
                    break;
                }
                if(org.codeforall.flappybat.GameObjects.Bat.batPic.getY() < 150){
                    break;
                }
                org.codeforall.flappybat.GameObjects.Bat.batPic.translate(0,-50);
                try {
                    holdOn(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                org.codeforall.flappybat.GameObjects.Bat.batPic.translate(0,-50);
                try {
                    holdOn(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                org.codeforall.flappybat.GameObjects.Bat.batPic.translate(0,-50);
                try {
                    holdOn(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Bat.batPic.translate(0,-50);
                try {
                    holdOn(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // Bat.batPic.translate(0,-200);
               // Bat.batPic.translate(0,5);
               // Bat.movingAnimation();
            //   isBeingPulled = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void setBeingPulled(boolean beingPulled) {
        isBeingPulled = beingPulled;
    }

    @Override
    public void run() {
        initKey();
    }
}