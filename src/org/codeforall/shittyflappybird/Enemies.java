package org.codeforall.shittyflappybird;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemies extends Picture {

    private Obstacles obstacles;
    public static Picture bat;
    public static Picture ghost;

    public Enemies(){
        bat =  new Picture(300,100, "Resources/morcego.gif");
        ghost = new Picture(300,400, "Resources/ghost.gif");
        bat.draw();
        ghost.draw();
    }

    public static void keepUp(){
        bat.translate(-1, 0);
        ghost.translate(-1, 0);
    }
    
}
