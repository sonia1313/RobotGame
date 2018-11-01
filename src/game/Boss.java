/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 * This class consists of methods that create the 'Boss' enemy in the game.
 * Boss class is a dynamic body that is upright and rigid. Its main function is to act as an enemy in Level three of the game
 *
 *
 * @author Sonia Mathews, sonia.matheews@city.ac.uk
 * @version 2
 * @since 2
 */
public class Boss extends Walker {
//creates boss shape using Polygon shape
    private static final Shape bossShape = new PolygonShape(-2.21f, 1.75f, -2.49f, -1.84f, -1.17f, -3.0f, -0.69f, -3.0f,
            1.16f, -2.98f, 2.41f, -1.79f, 2.03f, 1.76f);
//declares boss image that is added to the boss shape
    private static final BodyImage bossImage
            = new BodyImage("data/frame-2.png", 6f);
 /**
  * 
  * 
  * @param world the world that Boss enemy will be added in 
  */
    public Boss(World world) {
        super(world, bossShape);
        addImage(bossImage);
    }

}
