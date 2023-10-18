package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import static java.lang.Thread.sleep;

public class EventHandler implements KeyboardHandler, Runnable {
    boolean isBeingPulled = true;
    private Character bird = new Character();


    public synchronized void init() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent start = new KeyboardEvent();
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        start.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(start);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_W);
        kb.addEventListener(up);
    }

    public void setBeingPulled(boolean beingPulled) {
        isBeingPulled = beingPulled;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                setBeingPulled(false);
                bird.bird.translate(0, -120);
                setBeingPulled(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        }

    @Override
    public void run() {
        init();
        // gravidade
        while (isBeingPulled) {
            bird.bird.translate(0, 10); // increase v1 para ter mais gravidade

            try {
                sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}