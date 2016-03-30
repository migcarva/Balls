package org.academiadecodigo.bootcamp.mike.balls.ball;

import org.academiadecodigo.bootcamp.mike.balls.graphics.Representation;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by Miguel Carvalho on 17/02/16.
 */
public class PlayerBall extends Ball implements MouseHandler {

    /**
     * All Instance Variables
     */
    private Representation representation;
    private boolean destroyed;
    private Mouse m;

    /**
     * Player Ball will not have a default representation but instead
     * set it's color to Black as to differentiate from NPC balls
     * Also, this constructor will also implements a Mouse and Mouse Clicked events
     * @param power
     */
    public PlayerBall(int power) {
        super(power);
        this.representation = getRepresentation();
        representation.setColor(Color.BLACK);
        representation.fill();

        m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void move() {
        super.move();
    }

    /**
     * Sets a new direction based on mouse clicked position
     * Checks it's actual position with the clicked position
     * @param clickedPos
     */
    public void setDirection(Position clickedPos) {
        Position actualPos = representation.getPos();

        if (destroyed) {
            m = null;
        }

        if (clickedPos.getX() > actualPos.getX()) {
            if (clickedPos.getY() > actualPos.getY()) {
                representation.setDir(Direction.SE);
                move();
            } else {

            representation.setDir(Direction.NE);
            move();
            }
        } else if (clickedPos.getX() < actualPos.getX()) {
            if (clickedPos.getY() > actualPos.getY()) {
                representation.setDir(Direction.SW);
                move();
            } else {

            representation.setDir(Direction.NW);
            move();
            }
        }
    }

    /**
     * On Mouse Click creates a new Position from it's X and Y
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        setDirection(new Position((int) e.getX(), (int) e.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
