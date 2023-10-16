package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class EventHandler implements KeyboardHandler {

    Obstacles pipes;
    Character bird = new Character();

    EventHandler(){
         pipes = new Obstacles();
    }

    public void init() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent start = new KeyboardEvent();
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        start.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(start);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_W);
        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_S);
        kb.addEventListener(down);
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                pipes.obs1.translate(-20, 0);
                pipes.obs2.translate(-20,0);
                break;
            case KeyboardEvent.KEY_W:
                bird.bird.translate(0, -50);
                break;
            case KeyboardEvent.KEY_S:
                bird.bird.translate(0, 50);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
