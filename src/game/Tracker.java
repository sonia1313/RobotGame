package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 * @author Sonia Mathews
 * @version 2
 * @since 2
 */
public class Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Body body;
/**
 * 
 * @param view of the level
 * @param body in the world
 */
    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    @Override
    public void preStep(StepEvent e) {
    }
/**
 * 
 * @param e make sure view is at the centre based on the position of player 
 */
    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition()));
    }
    
}
