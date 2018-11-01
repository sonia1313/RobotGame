/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Comparator;

/**
 * This class compares the scores of each user using a Comparator interface 
 *
 * @author Sonia Mathews
 * @version 3
 * @data 3
 */
public class scoresCompare implements Comparator<User>{
/**
 * 
 * @param t user 1 is compared with
 * @param t1 user 2
 * @return score difference
 */
    @Override
    public int compare(User t, User t1) {
        return t1.score - t.score;
    }
    
    
}
