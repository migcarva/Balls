package org.academiadecodigo.bootcamp.mike.balls.graphics;

import org.academiadecodigo.bootcamp.mike.balls.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by Miguel Carvalho on 17/02/2016.
 */
public class SplashScreen implements KeyboardHandler {

    /**
     * All Instance Variables
     */
    private Ellipse normalIn;
    private Ellipse notNormalIn;
    private Color color1;
    private Color color2;
    private Game game;

    private int selection;

    /**
     * The SplashScreen Constructor. It'll create a new Keyboard, set all the keys
     * in use, and their events and eventListeners
     */
    public SplashScreen(Game game) {

        this.game = game;

        Keyboard k = new Keyboard(this);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventLeft);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventRight);

        KeyboardEvent eventStart = new KeyboardEvent();
        eventStart.setKey(KeyboardEvent.KEY_SPACE);
        eventStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventStart);

    }

    /**
     * This method will set a picture as background, and create a set of ellipses
     * that will work as buttons to select the game type.
     */
    public void init() {

        Picture splash = new Picture(0, 0, "/splash.png");
        splash.draw();

        Ellipse normal = new Ellipse(128, 103, 40, 40); normal.setColor(Color.WHITE); normal.fill();
        Ellipse normalOut = new Ellipse(128, 103, 40, 40); normalOut.setColor(Color.BLACK); normalOut.draw();
        Ellipse notNormal = new Ellipse(972, 547, 40, 40); notNormal.setColor(Color.BLACK); notNormal.fill();
        Ellipse notNormalOut = new Ellipse(972, 547, 40, 40); notNormalOut.setColor(Color.WHITE); notNormalOut.draw();

        normalIn = new Ellipse(138, 113, 20, 20); color1 = Color.BLACK; normalIn.setColor(color1); normalIn.fill();
        notNormalIn = new Ellipse(982, 557, 20, 20); color2 = Color.WHITE; notNormalIn.setColor(color2); notNormalIn.fill();

        Text text = new Text((splash.getWidth() / 2) - 175, splash.getHeight() - 50, "Use right and left arrows to select a game mode. Space to start.");
        text.setColor(Color.WHITE);
        text.draw();
    }

    /**
     * If Left or Right arrow keys are pressed the inner ellipse will change their color
     * showing the user which game type is currently selected
     * After a selection, the Space key will start the game
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            normalIn.setColor(Color.MAGENTA);
            color1 = Color.MAGENTA;
            normalIn.fill();
            notNormalIn.setColor(Color.WHITE);
            notNormalIn.fill();
            selection = 1;

        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            normalIn.setColor(Color.BLACK);
            normalIn.fill();
            notNormalIn.setColor(Color.MAGENTA);
            color2 = Color.MAGENTA;
            notNormalIn.fill();
            selection = 2;

        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (selection == 1) {
                game.setGameType(1);
            } else if (selection == 2) {
                game.setGameType(2);
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
