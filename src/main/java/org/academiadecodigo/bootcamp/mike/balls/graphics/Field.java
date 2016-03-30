package org.academiadecodigo.bootcamp.mike.balls.graphics;

import org.academiadecodigo.bootcamp.mike.balls.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by Miguel Carvalho on 2/14/16.
 */
public class Field {

    public static int width;
    public static int height;

    private Field() {}

    /**
     * Initialising a Field for a Normal Game
     */
    public static void init1() {
        Picture background = new Picture(0, 0, "/" + Game.size + ".png");
        background.draw();
        Field.width = background.getWidth();
        Field.height = background.getHeight();
    }

    /**
     * Initialising a Field for a Not so Normal Game
     */
    public static void init2() {
        Picture background = new Picture(0, 0, "/" + Game.size + ".png");
        background.draw();
        Field.width = background.getWidth();
        Field.height = background.getHeight();
    }

}
