package org.academiadecodigo.bootcamp.mike.balls.ball;

import org.academiadecodigo.bootcamp.mike.randongen.RandGen;
import org.academiadecodigo.bootcamp.mike.balls.Game;
import org.academiadecodigo.bootcamp.mike.balls.graphics.Field;

/**
 * Created by Miguel Carvalho on 2/14/16.
 */
public class Position {

    /**
     * All Instance Variables
     */
    private int x;
    private int y;

    /**
     * Default constructor, will always get a random position based on
     * Field's width/heigth and Balls Max radius!
     */
    public Position() {
        x = RandGen.randomInt(Game.maxRadius, Field.width - Game.maxRadius);
        y = RandGen.randomInt(Game.maxRadius, Field.height - Game.maxRadius);
    }

    /**
     * Create a new Position using coordinates
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Setters and Getters
     * @return
     */

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
