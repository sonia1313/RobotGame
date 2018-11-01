/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Graphics2D;
import java.awt.Image;
import org.jbox2d.common.Vec2;

/**
 *This is base class that is used on all the levels.
 * @author Sonia Mathews 
 * @version 2
 * @since 2
 * 
 */
public abstract class GameLevel extends World {
    /**
     * the main variables that are used across all levels
     */
    RobotPlayer robotPlayer;
    private World world;
    private Image background;
    private SoundClip sound;
    
    
    /**
     * 
     * @return SoundClip type to ensure sound plays on each 
     */
    public SoundClip getSound(){
    
       return setSoundForLevel();
    }
    
    /**
     * 
     * @return RobotPlayer type to get the the player of the current level 
     */
    public RobotPlayer getPlayer(){
        return robotPlayer;
    }
    

    //levels include robotPlayer's start position and flag position    
    public void populate(Game game){
    robotPlayer = new RobotPlayer(this);
    robotPlayer.setPosition(startPosition());
    Flag flag = new Flag(this);
    flag.setPosition(flagPosition());
    flag.addCollisionListener(new FlagListener(game)); //handles collision event between flag and player
    
    
    }
    /**
     * 
     * @return Vec2 type to set the starting position of the player
     */
    public abstract Vec2 startPosition();
   /**
    * 
    * @return Vec2 type to set the flagPosition of each level
    */
    public abstract Vec2 flagPosition();
    
    /**
     * 
     * @return boolean type to check whether level is complete or not
     */
    
    
    public abstract boolean isCompleted();
    /**
     * 
     * @return SoundClip to set a new background sound for each level
     */
   
    public abstract SoundClip setSoundForLevel(); 
    
    /**
     * 
     * @return SoundCliip to stop the background sound playing after each level is complete
     */
    public abstract SoundClip stopSoundForLevel();



}
