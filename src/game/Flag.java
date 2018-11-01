/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * This class acts as the checkpoint when user completes a level.
 * It is a static body and contains fixtures, that are attached to a triangle shape.
 *
 * @author Sonia Mathews
 * @version 2
 * @since 2
 */
public class Flag extends StaticBody{
/** 
 * 
 * @param w the flag is added to each level of the game
 */
    public Flag(World w) {
        super(w);
        
        Shape triangleShape = new PolygonShape(-0.44f,0.06f, 1.11f,0.62f, -0.6f,1.25f); //shape of the flag
        Fixture triangleFixture = new SolidFixture(this,triangleShape);
        
        
        addImage(new BodyImage("data/flag.png",3.35f));
    }
    
    
   
}
