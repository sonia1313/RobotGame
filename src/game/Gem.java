/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import static game.Octopus.octopusSound;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *This class creates a new gem object, its main purpose is to act as a collectable item. The player collects gems and score increase.
 * @author Sonia Mathews
 * @version 1
 * @since 1
 */
public class Gem extends Walker  {
      private RobotPlayer robotPlayer;
       private static SoundClip gemSound;

    private static final Shape gemShape = new PolygonShape(0.271f,0.425f, 0.506f,0.194f, 0.503f,0.036f, 
            0.014f,-0.455f, -0.509f,0.04f, -0.51f,0.191f, -0.272f,0.423f);
        private static final BodyImage gemImage = 
                new BodyImage("data/gem-1.png",1.0f);
        static {
        try {
           gemSound = new SoundClip("data/successfull.wav"); //creates a specific gem sound when player collects gem
           System.out.println("Loading gem sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }   
        /**
         * 
         * @param world as gem is created here
         */
        public Gem(World world){
                super(world,gemShape);
                addImage(gemImage);
        
    }
/**
 * the override function enables only gem sound to play when gem is destroyed, accessed from Body class 
 */
    @Override
    public void destroy() {
        gemSound.play();
        super.destroy(); 
    }
        

    
}
