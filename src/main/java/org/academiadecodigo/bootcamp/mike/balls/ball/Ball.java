package org.academiadecodigo.bootcamp.mike.balls.ball;

import org.academiadecodigo.bootcamp.mike.balls.graphics.Representation;

/**
 * Created by Miguel Carvalho on 2/14/16.
 */
abstract public class Ball {

    /**
     * All Instance Variables
     */
    private Representation representation;
    private int power;
    private boolean destroyed;

    /**
     * Ball Constructor. A power(radius) must be passed so we can
     * instantiate a new representation.
     * @param power It's the Ball "radius"
     */
    public Ball(int power) {
        this.power = power;
        representation = new Representation(power);
    }

    /**
     * Destroying a Ball reset it's power to 0, deletes it's representation
     * and set destroyed to true
     */
    public void destroy() {
        power = 0;
        representation.delete();
        destroyed = true;
    }

    /**
     * Representation Getter
     * @return representation
     */
    public Representation getRepresentation() {
        return representation;
    }

    /**
     * Destroyed Getter
     * @return destroyed state
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Checks if ball not destroyed and calls representation move method
     */
    public void move() {

        if (isDestroyed()) {
            return;
        }
        representation.move();
    }

    /**
     * Using pythagoras theorem to calculate the distance between 2 balls
     * center position and checking it the hypotenuse is smaller then the
     * sum of both radius
     * @param otherBall Ball to check against
     * @return a boolean
     */
    public boolean checkCollision(Ball otherBall) {

        /** If any ball is destroyed, do nothing */
        if (otherBall.isDestroyed() || isDestroyed()) {
            return false;
        }

        /**
         * Calculating the distance between balls central points
         * using the hypotenuse of the square triangle between them
         */
        int b1X = representation.getPos().getX();
        int b1Y = representation.getPos().getY();
        int b2X = otherBall.representation.getPos().getX();
        int b2Y = otherBall.representation.getPos().getY();

        int dX = Math.abs(b1X - b2X);
        int dY = Math.abs(b1Y - b2Y);

        double hyp = Math.sqrt( (Math.pow(dX, 2)) + (Math.pow(dY, 2)) );

        int b1Radius = representation.getRadius();
        int b2Radius = otherBall.representation.getRadius();

        if (hyp < (b1Radius + b2Radius)) {

            /** If the balls have the same power do nothing */
            if (power == otherBall.power) {
                return false;
            }

            /**
             * If one have higher power, destroy the other one
             * add half the other ball's power to the biggest one
             * and update the representation to match the new power
             */
            if (power > otherBall.power) {
                power += otherBall.power/2;
                representation.grow(otherBall.power/2);
                otherBall.destroy();
                return true;
            } else if (power < otherBall.power) {
                otherBall.power += power/2;
                otherBall.representation.grow(power/2);
                destroy();
                return true;
            }
        }

        /** If no collision detected */
        return false;
    }

}
