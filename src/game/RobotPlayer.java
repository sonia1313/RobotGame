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
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class acts as the main player for the game
 * Robot object is created with a PolygonShape 
 * @author Sonia Mathews
 * @version 1
 * @since 1
 */
public class RobotPlayer extends Walker {

    private static final Shape shape = new PolygonShape(-0.62f, 0.52f, -0.71f, 0.15f, -0.73f, -0.43f, -0.15f, -1.56f, 0.24f, -1.56f, 0.63f, -0.34f, 0.41f, 0.58f);

    private static final BodyImage image1
            = new BodyImage("data/player-idle-1.png", 5.25f);
 //shape and image belong to this class class only not an instance of
    private int gemCount;
    private int liveCount;
    /**
     * 
     * @param world 
     */
    public RobotPlayer(World world) {
        super(world, shape);
        addImage(image1);
        gemCount = 0;
        liveCount = 5; // nummber of lives the player has for duration of game 
        
    }
    /**
     * 
     * @return int to get the number of gems player has collected 
     */
    public int getGemCount() {
        return gemCount;
        
    }
 /**
  * increases the gem count by one when player has collected a gem object
  */
    public void incrementGemCount() {
        gemCount++;
        System.out.println("You have this many gems : = " + gemCount);
    }
/**
 * 
 * @return gets the number of lives the player has 
 */
    public int getLiveCount() {
        return liveCount;
    }
 /**
  *  number of lives decrease by one if player is in contact with an enemy object 
  * game ends when player looses all lives
  * note that score is not saved to file only when player completes entire game 
  */
    public void decrementLiveCount(){
        liveCount--;
        if(liveCount == 0){
        System.exit(0); // when number of lives equals 0 the gane ends 
        }
        System.out.println("You have lost a life = " + liveCount);
    }
/**
 * 
 * @param cnt sets the current gem score 
 */
    public void setGemCount(int cnt) {
          gemCount= cnt;
    }
    /**
     * 
     * @param cnt sets the current live count 
     */
    
    public void setLiveCount(int cnt){
       liveCount = cnt;
  }
/**
 * 
 * @param name of the player in a String 
 * @param score of the player in an integer
 * @throws IOException when writing to file reader. 
 */
  public void setHighScore(String name, int score) throws IOException{
      HighScoreWriter highScore = new HighScoreWriter("data/scores.txt");
      highScore.writeHighScore(name, score);
    
  
  }
  

}
