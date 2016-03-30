package org.academiadecodigo.bootcamp.mike.balls.ball;

import org.academiadecodigo.bootcamp.mike.balls.graphics.Field;

/**
 * Created by Miguel Carvalho on 2/14/16.
 */
public class Vector {

    /**
     * All Instance Variables
     */
    private Direction dir;
    private Position pos;

    /**
     * Vector Constructor
     */
    public Vector() {
        pos = new Position();
        dir = Direction.randomDir();
    }

    /**
     * Direction Getter
     * @return Direction
     */
    public Direction getDir() {
        return dir;
    }

    /**
     * Direction Getter
     * @param dir Set a new Direction (NE, NW, SE, SW)
     */
    public void setDir(Direction dir) {
        this.dir = dir;
    }

    /**
     * Position Getter
     * @return Position
     */
    public Position getPos() {
        return pos;
    }

    /**
     * Position Setter
     * @param x coordinate
     * @param y coordinate
     */
    public void setPos(int x, int y) {
        pos.setX(x);
        pos.setY(y);
    }

    /**
     * Checks for border collisions and inverts the Direction on the X or Y axes
     * depending on which border the object is colliding to
     * @param direction Given a set direction
     * @param radius and a radius (accounting for object dimensions)
     */
    public void checkBorder(Direction direction, int radius) {

        /** Check collisions with lateral borders */
        if ((getPos().getX() - radius) == 0 || (getPos().getX() + radius) == Field.width) {
            setDir(direction.changeXDirection());
        }

        /** Check collisions with top and bottom borders */
        if ((getPos().getY() - radius) == 0 || (getPos().getY() + radius) == Field.height) {
            setDir(direction.changeYDirection());
        }

    }

    /**
     * Deletes the Vector by setting its Position and Direction for Garbage Collection (null)
     */
    public void delete() {
        dir = null;
        pos = null;
    }

}
