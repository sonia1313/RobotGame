/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *This class creates a jumper enemy that upon collision with player, looses a live.
 * @author Sonia Mathews
 * @version 2
 * @since 2
 */
public class Jumper extends Walker {
    /**
     * the fields needs to create a jumper enemy
     */
private static final Shape jumperUpperShape = new PolygonShape(
            -0.866f,-0.993f, -1.142f,0.121f, 0.024f,0.846f, 1.138f,-0.187f, 0.836f,-0.978f);
 private static final float density = 0.5f;
 private static final BodyImage jumperImage =
        new BodyImage("data/jumper-jump.png", 2.0f);                     
    public Jumper(World w) {
        super(w,jumperUpperShape);         
        
         SolidFixture fixture = new SolidFixture(this, jumperUpperShape, density);
                fixture.setRestitution(1);
                addImage(jumperImage);

         
        
         
    }

    
}
