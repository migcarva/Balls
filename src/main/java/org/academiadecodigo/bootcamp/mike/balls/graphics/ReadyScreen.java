package org.academiadecodigo.bootcamp.mike.balls.graphics;

import org.academiadecodigo.bootcamp.mike.balls.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by miguel on 29/3/16.
 */
public class ReadyScreen implements KeyboardHandler {

    /**
     * All Instance Variables
     */
    private boolean ready;
    private Game game;

    public boolean isReady() {
        return ready;
    }

    /**
     * The SplashScreen Constructor. It'll create a new Keyboard, set all the keys
     * in use, and their events and eventListeners
     */
    public ReadyScreen(Game game) {

        this.game = game;

        Keyboard k = new Keyboard(this);

        KeyboardEvent eventStart = new KeyboardEvent();
        eventStart.setKey(KeyboardEvent.KEY_R);
        eventStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventStart);

    }

    /**
     * This method will set a picture as background, and create a set of ellipses
     * that will work as buttons to select the game type.
     */
    public void init() {

        Picture ready = new Picture(0, 0, "/" + Game.size + ".png");
        ready.draw();

        Text text1 = new Text((ready.getWidth() / 2) - 316, (ready.getHeight() / 2) - 50, "You're the black ball. Bigger balls will eat you. Avoid them!");
        Text text2 = new Text((ready.getWidth() / 2) - 279, (ready.getHeight() / 2), "Try to eat smaller balls by pointing with your mouse in their direction.");
        Text text3 = new Text((ready.getWidth() / 2) - 410, (ready.getHeight() / 2) + 50, "Hit 'R' when ready!! Have fun");

        text1.setColor(Color.WHITE);
        text2.setColor(Color.WHITE);
        text3.setColor(Color.WHITE);

        text1.grow(text1.getWidth()*0.5,text1.getHeight()*0.5);
        text2.grow(text2.getWidth()*0.5,text2.getHeight()*0.5);
        text3.grow(text3.getWidth()*0.5,text3.getHeight()*0.5);

        text1.draw();
        text2.draw();
        text3.draw();

    }

    /**
     * If Left or Right arrow keys are pressed the inner ellipse will change their color
     * showing the user which game type is currently selected
     * After a selection, the Space key will start the game
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            ready = true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
