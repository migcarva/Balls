package org.academiadecodigo.bootcamp.mike.balls.graphics;

import org.academiadecodigo.bootcamp.mike.randongen.RandGen;
import org.academiadecodigo.bootcamp.mike.balls.ball.Direction;
import org.academiadecodigo.bootcamp.mike.balls.ball.Position;
import org.academiadecodigo.bootcamp.mike.balls.ball.Vector;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by Miguel Carvalho on 2/14/16.
 */
public class Representation {

    /**
     * All Instance Variables
     */
    private Ellipse ellipse;
    private Vector vector;
    private int radius;

    /**
     * Representation Constructor. Every instance HAS-A Vector and predefined radius.
     * Vector is positioned in the center of an Ellipse, so we need to get it's min X and Y
     * to draw it using Simple Graphics.
     * @param radius
     */
    public Representation(int radius) {
        this.vector = new Vector();
        this.radius = radius;
        int drawX = vector.getPos().getX() - radius;
        int drawY = vector.getPos().getY() - radius;

        ellipse = new Ellipse(drawX, drawY, radius*2, radius*2);
        ellipse.setColor(getRandColor());
        ellipse.fill();
    }

    /**
     * Default draw method. Will get a randomColor. This method is used for all NPC Balls
     */
    public void defaultDraw() {
        setColor(getRandColor());
        fill();
    }

    /**
     * Color Setter
     * @param color
     */
    public void setColor(Color color) {
        ellipse.setColor(color);
    }

    /**
     * Generate a Random Color in RGB format
     * Avoiding dark colors
     * @return
     */
    private Color getRandColor() {
        int r = RandGen.randomInt(100, 255);
        int g = RandGen.randomInt(100, 255);
        int b = RandGen.randomInt(100, 255);
        return new Color(r, g, b);
    }

    /**
     * Used only for Player Ball
     */
    public void fill() {
        ellipse.fill();
    }

    /**
     * Radius Getter
     * @return
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Direction Setter
     * @param dir
     */
    public void setDir(Direction dir) {
        vector.setDir(dir);
    }

    /**
     * Vector Position Getter
     * @return
     */
    public Position getPos() {
        return vector.getPos();
    }

    /**
     * Method used to update Vector position using Ellipse actualized position
     * Radius must be added to get the central position of the Ellipse
     */
    private void updatePos() {
        vector.setPos((ellipse.getX() + radius), (ellipse.getY() + radius));
    }

    /**
     * Deletes the representation by deleting the ellipse and it's vector
     */
    public void delete() {
        ellipse.delete();
        vector.delete();
    }

    /**
     * Grow an Ellipse by radius
     * Also, updates it radius, position and checks for border collisions
     * @param radius
     */
    public void grow(int radius) {
        ellipse.grow(radius/2, radius/2);
        this.radius += radius/2;
        updatePos();
        vector.checkBorder(vector.getDir(), radius);
    }

    /**
     * Moves the Ellipse in the Direction of its vector
     * Updates the positions and checks for collisions each time it translates
     */
    public void move() {
        switch (vector.getDir()) {
            case NW:
                ellipse.translate(-1,-1);
                updatePos();
                vector.checkBorder(vector.getDir(), radius);
                break;
            case NE:
                ellipse.translate(1,-1);
                updatePos();
                vector.checkBorder(vector.getDir(), radius);
                break;
            case SE:
                ellipse.translate(1,1);
                updatePos();
                vector.checkBorder(vector.getDir(), radius);
                break;
            case SW:
                ellipse.translate(-1,1);
                updatePos();
                vector.checkBorder(vector.getDir(), radius);
                break;
        }
    }

}
