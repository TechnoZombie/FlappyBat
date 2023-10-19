package org.codeforall.shittyflappybird.Handlers;

import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.codeforall.shittyflappybird.Engine;
import org.codeforall.shittyflappybird.GameObjects.Bat;

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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                isBeingPulled = false;
                Bat.batPic.translate(0,-200);
                Bat.batPic.translate(0,5);
               // Bat.movingAnimation();
                isBeingPulled = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void run() {
        initKey();
        while(isBeingPulled){
            Bat.batPic.translate(0, 30); // increase v1 para ter mais gravidade
            try {
                sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}