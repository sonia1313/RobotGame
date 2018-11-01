/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * This class implements a Collision Listener in order to monitor the the bullet 
 * interaction, made when player shoots bullets at enemies. it consists of methods 
 * This class is only used in level three of the game.
 * @author Sonia Mathews
 * @version 2
 * @since 2
 */
public class BulletCollision implements CollisionListener {
    private RobotPlayer robotPlayer;
    private Boss boss;
    private UpdateController updateController;
    private int bulletCount;
    /**
     * 
     * @param robotPlayer creates a new bullet collision, that uses Robot Player
     *  since robot player creates bullets 
     */
    public BulletCollision(RobotPlayer robotPlayer) {
        this.robotPlayer = robotPlayer;
   }
/**
 * 
 * @param e This is the collision event that occurs between bullet and object that 
 * it is an instance of. 
 * <p>The method only checks collision between Jumper and Boss enemy. The bullet is destroyed
 * upon collision. </p>
 * 
 */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Jumper ){ //when bullet touches jumper enemy
        e.getReportingBody().destroy();
        e.getOtherBody().destroy();
        
        } 
        if(e.getOtherBody() instanceof Boss){ // when bullet touches Boss enemy
            e.getReportingBody().destroy();
            e.getOtherBody().destroy();
            }

        }
     
       
    }
    

        
    

