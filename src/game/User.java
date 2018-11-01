/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *This class stores the name and score of each user who completes the game
 * @author Sonia Mathews
 * @version 3
 * @since 3
 */
public class User {
    String name;
    int score;
    /**
     * 
     * @param name of the User playing the game
     * @param score of the User after finishing game 
     */
    public User(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
    
}
