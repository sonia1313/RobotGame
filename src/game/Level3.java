/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import city.cs.engine.Walker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 /**
 * Level 3 of the game
 *
 * @author SoniaMathews
 * @version 2
 * @since 2

 */
public class Level3 extends GameLevel {
    
    /**
     * the variables needed to create level 3
     */

    private static final int NUM_GEMS = 5;
    private Jumper jumper1, jumper2, jumper3, jumper4, jumper5, jumper6;
    private Boss boss;
    private SoundClip gameMusic;
    private Timer octopusTimer;
    private Timer gemTimer;
    private Timer jumperTimer;
    Boolean obstacle = true;
    /**
     * Populate the world.
     *
     * @param game 
     */
    public void populate(Game game) {
        super.populate(game);

        Body ground = new StaticBody(this, new BoxShape(100.0f, 20.0f));
        ground.setPosition(new Vec2(0.0f, -30.0f));
        


        jumperTimer = new Timer(100, new ActionListener(){ //creates a new Jumper enemy
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(obstacle == true){
                
                    createJumperObstacle();
                    
                }
                
            }
        });
            
        octopusTimer = new Timer(8000, new ActionListener() { //creates an octopus enemy

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (obstacle == true) {
                    createOctopusObstacle();
                }
            }

        });
    
        gemTimer = new Timer(10000, new ActionListener() { //creates gems

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (obstacle == true) {
                    createGemObstacle();
                }

            }
            
        });
        
     if (obstacle == true) { //initialises timeers 
            octopusTimer.start();
            gemTimer.start();
            jumperTimer.start();

        }
        


        //make boss
        boss = new Boss(this);
        boss.setPosition(new Vec2(80, -10));
        boss.addCollisionListener(new Pickup(getPlayer()));
        
    }
    /**
     *
     * @return Vec2 in order to set the position of the player in level 1
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(1, -10);
    }
     /**
     *
     * @return Vec2 in order to set the check point i.e. the flag object, at the
     * end of level 1
     */
    @Override
    public Vec2 flagPosition() {
        return new Vec2(98, -9);
    }
     /**
     *
     * @return boolean only allows the user to pass through level 1 given that
     * at least one gem has been collected.
     */

    @Override
    public boolean isCompleted() {
        return getPlayer().getGemCount() >= NUM_GEMS;
    }
/**
     *
     * @return SoundCliip sets the background music for level 3
     */
    @Override
    public SoundClip setSoundForLevel() {
        return music();
    }
        /**
     *
     * @return SoundClip to play the background music looped for level 3
     */
    public SoundClip music() {

        try {

            gameMusic = new SoundClip("data/BossRide.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
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
        return gameMusic;
    }
    /**
     * gems are created for player to collect 
     */
    public void createGemObstacle() {


         for (int i = 0; i < 15; i++) {
            Body gem = new Gem (this);
            gem.setPosition(new Vec2(i * 13, 7));
            gem.addCollisionListener(new Pickup(getPlayer())); //handles the collison between gem and player
        }
         gemTimer.stop();
        }

    /**
     * octopuses creates in game level 3 
     */

    public void createOctopusObstacle() {
        for (int i = 3; i < 12; i++) {
            Body octopus = new Octopus (this);
            octopus.setPosition(new Vec2(i * 8, 7));
            octopus.addCollisionListener(new Pickup(getPlayer()));//handles collsion event
        }
        octopusTimer.stop();


    }
    /**
     * creates a jumper in level 3 of game 
     */
    public void createJumperObstacle(){
        jumper1 = new Jumper(this);
        jumper2 = new Jumper(this);
        jumper3 = new Jumper(this);
        jumper4 = new Jumper(this);
        jumper5 = new Jumper(this);
        jumper6 = new Jumper(this);
        
        jumper1.setPosition(new Vec2(5, -4.0f));
        jumper1.jump(DEFAULT_GRAVITY);
        jumper1.addCollisionListener(new Pickup(getPlayer())); //handles collison event

        jumper2.setPosition(new Vec2(15, -4.0f));
        jumper2.jump(DEFAULT_GRAVITY);
        jumper2.addCollisionListener(new Pickup(getPlayer()));

        jumper3.setPosition(new Vec2(37, -4.0f));
        jumper3.jump(DEFAULT_GRAVITY);
        jumper3.addCollisionListener(new Pickup(getPlayer()));

        jumper4.setPosition(new Vec2(45, -4.0f));
        jumper4.jump(DEFAULT_GRAVITY);
        jumper4.addCollisionListener(new Pickup(getPlayer()));

        jumper5.setPosition(new Vec2(60, -4.0f));
        jumper5.jump(DEFAULT_GRAVITY);
        jumper5.addCollisionListener(new Pickup(getPlayer()));
        
        jumper6.setPosition(new Vec2(68, -4.0f));
        jumper6.jump(DEFAULT_GRAVITY);
        jumper6.addCollisionListener(new Pickup(getPlayer()));
        jumperTimer.stop();
    }
    


}
