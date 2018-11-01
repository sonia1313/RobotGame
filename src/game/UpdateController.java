/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import static game.Octopus.octopusSound;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * This class acts as KeyHandler to allow player to shoot bullets from level 3
 * onwards
 *
 * @author Sonia Mathews
 * @version 2
 * @since 2
 */
public class UpdateController extends KeyAdapter {

    private RobotPlayer robotPlayer;
    /**
     * radius of bullet shape of bullet is circle
     *
     */
    private static final float RADIUS = 0.1f;
    private static final Shape bulletShape
            = new CircleShape(RADIUS);
    private static final BodyImage bulletImage
            = new BodyImage("data/shot-1.png", RADIUS);

    private DynamicBody ball;
    private Walker body;
    private static SoundClip bulletSound;

    public UpdateController(Walker body) {
        this.body = body;
    }

    static { //sound is called only once 
        try {
            bulletSound = new SoundClip("data/bullet.wav");//creates a specific bullet sound when player shoots 
            System.out.println("Loading bullet sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param e when a user presses space bar a bullet will appear from
     * RobotPlayer
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_SPACE) {
            // drawBullet();
            drawBullet();
            bulletSound.play(); //make sound here
        }

    }

    /**
     *
     * @param body for UpdateController
     */
    public void setBody(Walker body) {
        this.body = body;
    }

    /**
     * a bullet is a dynamic body
     * contains a collision listener that calls to BulletCollision 
     * bullet is set Linear Velocity 
     * bullet applies a force to targeted object 
     */
    public void drawBullet() {
        ball = new DynamicBody(body.getWorld(), bulletShape);
        ball.addCollisionListener((CollisionListener) new BulletCollision(robotPlayer));
        ball.setPosition(body.getPosition());
        ball.setLinearVelocity(new Vec2(15, 5));
        ball.applyForce(new Vec2(1, 4));

    }

}
