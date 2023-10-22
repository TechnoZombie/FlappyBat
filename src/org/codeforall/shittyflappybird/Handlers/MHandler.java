package org.codeforall.shittyflappybird.Handlers;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.codeforall.shittyflappybird.Engine;

public class MHandler implements MouseHandler, Runnable{


    public void initMouse(){

        Mouse mouse = new Mouse(this);
        MouseEvent click = new MouseEvent(1600, 1270, MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(click.getEventType());

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(Engine.currentState == Engine.State.MENU){
            Engine.currentState = Engine.State.PLAY;
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void run() {
        while(Engine.currentState == Engine.State.MENU) {
            initMouse();
        }

    }
}
