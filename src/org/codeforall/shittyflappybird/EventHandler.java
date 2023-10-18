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

      /*  KeyboardEvent upRelease = new KeyboardEvent();
        upRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upRelease.setKey(KeyboardEvent.KEY_W);
        kb.addEventListener(upRelease);*/

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_S);
        kb.addEventListener(down);

    }

    public void setBeingPulled(boolean beingPulled) {
        isBeingPulled = beingPulled;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
/*             setBeingPulled(false);
               System.out.println("PRESS - GRAVITY ON? " + isBeingPulled);
               bird.bird.translate(0, -40);
               setBeingPulled(true);
               System.out.println("RELEASE - GRAVITY ON? " + isBeingPulled);*/
                break;
            case KeyboardEvent.KEY_W:
                setBeingPulled(false);
                System.out.println("PRESS - GRAVITY ON? " + isBeingPulled);
                bird.bird.translate(0, -40);
                setBeingPulled(true);
                System.out.println("RELEASE - GRAVITY ON? " + isBeingPulled);
                break;
            case KeyboardEvent.KEY_S:
                bird.bird.translate(0, 30);
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    /*        int keyCode = keyboardEvent.getKey();
            if (keyCode == KeyboardEvent.KEY_W) {
                setBeingPulled(true);
                System.out.println("RELEASED GRAVITY ON? " + isBeingPulled);
            }*/
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