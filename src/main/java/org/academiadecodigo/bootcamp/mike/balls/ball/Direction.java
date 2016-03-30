package org.academiadecodigo.bootcamp.mike.balls.ball;

import org.academiadecodigo.bootcamp.mike.randongen.RandGen;

/**
 * Created by Miguel Carvalho on 2/14/16.
 */
public enum Direction {
    NW,
    NE,
    SE,
    SW;

    /**
     * Gets a random direction from the Enum's list
     * @return Random Direction
     */
    public static Direction randomDir() {
        int dirIdx = RandGen.randomInt(Direction.values().length-1);
        return Direction.values()[dirIdx];
    }

    /**
     * Change X direction based on it's actual direction
     * @return new Direction
     */
    public Direction changeXDirection() {

        Direction opposite = Direction.NW;

        switch (this) {
            case NW:
                opposite = Direction.NE;
                break;
            case NE:
                opposite = Direction.NW;
                break;
            case SW:
                opposite = Direction.SE;
                break;
            case SE:
                opposite = Direction.SW;
                break;
        }

        return opposite;
    }

    /**
     * Change Y direction based on it's actual direction
     * @return new Direction
     */
    public Direction changeYDirection() {

        Direction opposite = Direction.NW;

        switch (this) {
            case NW:
                opposite = Direction.SW;
                break;
            case NE:
                opposite = Direction.SE;
                break;
            case SW:
                opposite = Direction.NW;
                break;
            case SE:
                opposite = Direction.NE;
                break;
        }

        return opposite;
    }
}
