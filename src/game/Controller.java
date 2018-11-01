package game;

import city.cs.engine.*;
import java.awt.Image;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Key handler to control a Walker.
 *@author Sonia Mathews
 * @version 1
 * @since 1
 *
 */
public class Controller extends KeyAdapter {

    private static final float JUMPING_SPEED = 8;
    private static final float WALKING_SPEED = 4;


    private Walker body;
    

    public Controller(Walker body) {
        this.body = body;
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e description of the key event,
     * <p> The user can move left, right and jump using the assigned keyboard
     * controls. </p>
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);

        } else if (code == KeyEvent.VK_UP) { // up = jump
            Vec2 v = body.getLinearVelocity();
            body.jump(JUMPING_SPEED);

            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.applyImpulse(new Vec2(0, 20));

            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // left key = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // right key = walk right
        }
//        

    }

    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_1) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_2) {
            body.stopWalking();
        }
    }
/**
 * Allows control on the player body as it moves between levels
 * @param body returns the robot Player object
 */
    public void setBody(Walker body) {
        this.body = body;
    }


}
