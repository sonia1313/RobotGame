/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class 
 * This class implements a Collision Listener to check when user has reached the checkpoint of the level,
 * indicating that the level is complete
 * This class is used in all levels of the game
 * @author Sonia Mathews
 * @version 2
 * @since 2
 */
public class FlagListener implements CollisionListener {
    private Game game;
    /**
     * 
     * @param game is needed to ensure each level of the contains a listener for each checkpoint
     */
    public FlagListener(Game game){
        this.game = game;
    }

    /**
 * 
 * @param ce This is the collision event that occurs between flag object and player that 
 * 
 * <p>The method is needed to allow player to transition into the next level once it collides with the flag object. A try catch block is needed
 * to handle the method call to setHighScore which generates an IO Exception in game. 
 * </p>
 * 
 */
    @Override
    public void collide(CollisionEvent ce) {
        RobotPlayer robotPlayer = game.getPlayer();
        if(ce.getOtherBody() == robotPlayer && game.isCurrentLevelCompleted()){ //player is going to the next level
            try {
                game.goNextLevel();
            } catch (IOException ex) {
                Logger.getLogger(FlagListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
