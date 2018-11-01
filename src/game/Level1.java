package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Image;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Level 1 of the game
 * @author SoniaMathews
 * @version 2
 * @since 2
 * 
 */
public class Level1 extends GameLevel {
    /**
     * the variables needed to create level 1
     */

    private World world;

    private RobotPlayer robotPlayer;
  
    
    private SoundClip gameMusic;       
    private static final int NUM_GEMS = 1;

    /**
     * Populate the world.
     *
     * @param game 
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        Body ground = new StaticBody(this, new BoxShape(100.0f, 20.0f));
        ground.setPosition(new Vec2(0.0f, -30.0f));
        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        //Body platform1 = new StaticBody(this, boxShape);
        //platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-6, -6.5f));
        
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(7, -2.5f));

        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(-5.5f, 1f));

        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(5.5f, 5.5f));

        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(13, 11));

        //make gems 
        
        for (int i = 0; i < 8; i++) {
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(i * 3 - 5, 10));
            gem.addCollisionListener(new Pickup(getPlayer()));
        }

    }
  /**
   * 
   * @return Vec2 in order to set the position of the player in level 1
   */
    @Override
    public Vec2 startPosition() {
        return new Vec2(4, -10);
    }
/**
 * 
 * @return Vec2 in order to set the check point i.e. the flag object, at the end of level 1
 */
    @Override
    public Vec2 flagPosition() {
        return new Vec2(15, 13);
    }
/**
 * 
 * @return boolean only allows the user to pass through level 1 given that at least one gem has been 
 * collected.
 */
    @Override
    public boolean isCompleted() {
        return getPlayer().getGemCount() >= NUM_GEMS;
    }

/**
 * 
 * @return SoundCliip sets the background music for level 1
 */
    @Override
    public SoundClip setSoundForLevel() {
        return music();   
      
    }
    /**
     * 
     * @return SoundClip to play the background music looped for level 1
     */
    public SoundClip music() {
    
    
    try{
    
    gameMusic = new SoundClip("data/AlienReservePower.wav"); //specfic sound file for level 1
    gameMusic.loop();
    }catch (UnsupportedAudioFileException|IOException|LineUnavailableException e){
        System.out.print(e);
    }
        return gameMusic;
    
    
    
    
    }
    /**
     * 
     * @return SoundClip that stops the background music from playing when level is complete
     */
    @Override
    public SoundClip stopSoundForLevel() {
        gameMusic.stop();
        return gameMusic; //stop music
    }
    
    
    
    }


