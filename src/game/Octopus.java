/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionListener;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class creates an octopus enemy that interacts with the player. 
 * it is a dynamic body that is upright.
 * 
 * @author Sonia Mathews 
 * @version 1
 * @since 1
 */
public class Octopus extends Walker {   
   
    /**
     * the variables needed to create an octopus object. 
     * Uses a polygon shape 
     */
    private static final Shape octopusShape = new PolygonShape(
            -0.245f,0.366f, -0.246f,-0.396f, 0.302f,-0.393f, 0.306f,0.299f, -0.033f,0.391f);
    public static SoundClip octopusSound;
   
    public static final BodyImage octopusImage =
        new BodyImage("data/octopus-1.png", 2.25f);
 
  static { //only created once 
        try {
           octopusSound = new SoundClip("data/lostItem.wav"); // specific sound for when player collides with octopus 
           System.out.println("Loading octopus sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
   /**
    * 
    * @param world where octopus enemy is created 
    */
   public Octopus(World world) {
        super(world, octopusShape);
        addImage(octopusImage);   
        
 

    }




}
