package org.academiadecodigo.bootcamp.mike.balls.ball;

/**
 * Created by Miguel Carvalho on 17/02/16.
 */
public class NPCBall extends Ball {

    /**
     * Uses Ball Constructor passing the method defaultDraw from representation
     * @param power
     */
    public NPCBall(int power) {
        super(power);
        getRepresentation().defaultDraw();
    }

}
