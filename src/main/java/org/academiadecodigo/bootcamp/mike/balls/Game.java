package org.academiadecodigo.bootcamp.mike.balls;

import org.academiadecodigo.bootcamp.mike.balls.graphics.ReadyScreen;
import org.academiadecodigo.bootcamp.mike.randongen.RandGen;
import org.academiadecodigo.bootcamp.mike.balls.ball.Ball;
import org.academiadecodigo.bootcamp.mike.balls.ball.NPCBall;
import org.academiadecodigo.bootcamp.mike.balls.ball.PlayerBall;
import org.academiadecodigo.bootcamp.mike.balls.graphics.Field;
import org.academiadecodigo.bootcamp.mike.balls.graphics.SplashScreen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by Miguel Carvalho on 2/14/16.
 */
public final class Game {

    // Game Size available options are: small, med and big
    public static String size = "med";

    public static int maxBalls;
    public static int minRadius;
    public static int maxRadius;
    public static int delay;

    private int gameType = 0;

    private SplashScreen splashScreen;
    private ReadyScreen readyScreen;

    private Ball[] balls;


    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    /**
     * Game Constructor. It'll initialise the splash screen
     * and while the game type is not selected will not start
     *
     * @throws InterruptedException
     */
    public Game() throws InterruptedException {
        newGame();
    }

    public void newGame() throws InterruptedException {

        gameType = 0;

        drawSplashScreen(this);

        while (gameType == 0) {
            Thread.sleep(500);
        }

        if (gameType == 1) {
            drawReadyScreen(this);
        } else if (gameType == 2) {
            drawReadyScreen(this);
        }

        while (!readyScreen.isReady()) {
            Thread.sleep(500);
        }

        if (readyScreen.isReady() && gameType == 1) {
            maxBalls = 14;
            minRadius = 20;
            maxRadius = 30;
            delay = 16;
            Field.init1();
        } else if (readyScreen.isReady() && gameType == 2) {
            maxBalls = 300;
            minRadius = 4;
            maxRadius = 6;
            delay = 10;
            Field.init2();
        }
        init();
    }

    public void drawSplashScreen(Game game) {
        splashScreen = new SplashScreen(game);
        splashScreen.init();
    }

    public void drawReadyScreen(Game game) {
        readyScreen = new ReadyScreen(game);
        readyScreen.init();
    }

    /**
     * Method to initialise the Game, populating the an array of balls
     * with the player ball and all other balls
     * Also, this method will show a countdown before game starts
     *
     * @throws InterruptedException
     */
    public void init() throws InterruptedException {

        balls = new Ball[maxBalls];

        Thread.sleep(500);

        String[] counter = {"Get Ready", "Set", "GO!"};

        for (String aCounter : counter) {
            Text text = new Text(Field.width / 2, Field.height / 2, aCounter);
            text.grow(text.getWidth() * 2, text.getHeight() * 2);
            text.setColor(Color.WHITE);
            text.draw();
            Thread.sleep(1000);
            text.delete();
        }

        balls[0] = new PlayerBall(maxRadius);

        for (int i = 1; i < balls.length; i++) {
            int radius = RandGen.randomInt(minRadius, maxRadius);
            balls[i] = new NPCBall(radius);
        }

        start();

    }

    /**
     * Method to start the game, moving all balls and checking for collisions
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        int totalBalls = balls.length + 1;

        if (gameType == 1) {
            while (!balls[0].isDestroyed() || totalBalls > 2 ) {
                Thread.sleep(delay);
                for (Ball b1 : balls) {
                    b1.move();
                    for (Ball b2 : balls) {
                        if (b1 == b2) {
                            continue;
                        }
                        if (b1.checkCollision(b2)) {
                            totalBalls -= 1;
                        }
                    }
                }
            }
        } else if (gameType == 2) {
            while (totalBalls > 2) {
                Thread.sleep(delay);
                for (Ball b1 : balls) {
                    b1.move();
                    for (Ball b2 : balls) {
                        if (b1 == b2) {
                            continue;
                        }
                        if (b1.checkCollision(b2)) {
                            totalBalls -= 1;
                        }
                    }
                }
            }
        }

        Text text;

        if (balls[0].isDestroyed()) {
            text = new Text(Field.width / 2, Field.height / 2, "Game Over");
        } else {
            text = new Text(Field.width / 2, Field.height / 2, "You're the Winner!!");
        }

        text.setColor(Color.WHITE);
        text.grow(text.getWidth(), text.getHeight());
        text.draw();

        Thread.sleep(3000);

        newGame();

    }
}
