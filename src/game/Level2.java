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
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 *
 * @author SoniaMathews
 * @version 2
 * @since 2
 */
public class Level2 extends GameLevel {

    /**
     * the variables needed to create level 2
     */

    private static final int NUM_GEMS = 5;
    private Octopus octopus1, octopus2, octopus3, octopus4;
    private SoundClip gameMusic;
    /**
     * Populate the world.
     *
     * @param game 
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Body ground = new StaticBody(this, new BoxShape(100.0f, 20.0f));
        ground.setPosition(new Vec2(0.0f, -30.0f));
        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Shape boxShape2 = new BoxShape(2, 0.2f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 3.5f));
        Body platform2 = new StaticBody(this, boxShape2);
        platform2.setPosition(new Vec2(5, -0.5f));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(-4, -5.5f));
        Body platform4 = new StaticBody(this, boxShape2);
        platform4.setPosition(new Vec2(-3, 9f));

        Body platform5 = new StaticBody(this, boxShape2);
        platform5.setPosition(new Vec2(10, 5));

        //make enemies
        octopus1 = new Octopus(this);
        octopus2 = new Octopus(this);
        octopus3 = new Octopus(this);
        octopus4 = new Octopus(this);
        // octopus.update();

        octopus1.setPosition(new Vec2(-4, -6));
        octopus1.addCollisionListener(new Pickup(getPlayer()));

        octopus2.setPosition(new Vec2(6, -2));
        octopus2.addCollisionListener(new Pickup(getPlayer()));

        octopus3.setPosition(new Vec2(9, 6));
        octopus3.addCollisionListener(new Pickup(getPlayer()));

        octopus4.setPosition(new Vec2(-6, 9));
        octopus4.addCollisionListener(new Pickup(getPlayer()));

        for (int i = 0; i < 5; i++) {
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(i * 3 - 5, 7));
            gem.addCollisionListener(new Pickup(getPlayer()));
        }

    }

    /**
     *
     * @return Vec2 in order to set the position of the player in level 2
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-5, -10);
    }

    /**
     *
     * @return Vec2 in order to set the check point i.e. the flag object, at the
     * end of level 2
     */

    @Override
    public Vec2 flagPosition() {
        return new Vec2(-3, 10.95f);
    }

    /**
     *
     * @return boolean only allows the user to pass through level 2 given that
     * at least one gem has been collected.
     */

    @Override
    public boolean isCompleted() {
        return getPlayer().getGemCount() >= NUM_GEMS;
    }

    /**
     *
     * @return SoundCliip sets the background music for level 2
     */

    @Override
    public SoundClip setSoundForLevel() {
        return music();

    }

    /**
     *
     * @return SoundClip to play the background music looped for level 2
     */
    public SoundClip music() {

        try {

            gameMusic = new SoundClip("data/BackBeat.wav"); //specific sound file for level 2
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
        return gameMusic; //music stops
    }

}
