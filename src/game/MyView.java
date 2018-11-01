/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * This class creates the view of the game. 
 * @author Sonia Mathews 
 * @version 2
 * @since 2
 */
public class MyView extends UserView {
/**
 * the variables use the creates the background image 
 * the background variables represent layers of the image produced 
 * 
 */
    private Image background_0;
    private Image background_1;
    private Image background_2;
    private Image background_3;
    
    private RobotPlayer robotPlayer;
   private SoundClip sound;
   /**
    * 
    * @param world 
    * @param width of the background image
    * @param height of the background image 
    * @param robotPlayer 
    */
    public MyView(World world, int width, int height, RobotPlayer robotPlayer) {

        super(world, width, height);
        this.robotPlayer = robotPlayer;
        background_0 = new ImageIcon("data/skill-desc_0000_foreground.png").getImage();
        background_1 = new ImageIcon("data/skill-desc_0001_buildings.png").getImage();
        background_2 = new ImageIcon("data/skill-desc_0002_far-buildings.png").getImage();
        background_3 = new ImageIcon("data/skill-desc_0003_bg.png").getImage();

    }
    /**
     * 
     * @param g paints the background image according to the width and height of window screen 
     */
    @Override
    protected void paintBackground(Graphics2D g) {
       g.drawImage(background_3, 0, 0, this.getWidth(), this.getHeight(), null);

       g.drawImage(background_2, 0, 0, this.getWidth(), this.getHeight(), null);
       g.drawImage(background_1, 0, 0, this.getWidth(), this.getHeight(), null);
        g.drawImage(background_0, 0, 0, this.getWidth(), this.getHeight(), null);


    }
    /**
     * 
     * @param g paints foreground of the game, this includes score and live count. There are method calls from Robot
     * Player class.
     */
 
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g.setColor(Color.yellow);
        g.drawString ("Score: " + robotPlayer.getGemCount() ,50, 100);
        g.drawString("Lives:" + robotPlayer.getLiveCount(),50,150);
        
        
    }
    /**
     * 
     * @param newRobotPlayer sets the player in this view of the game 
     */
    public void setPlayer(RobotPlayer newRobotPlayer){
        this.robotPlayer = newRobotPlayer; 
    
    }
    /**
     * 
     * @param newSound sets the background sound of the game of this view 
     */
    public void setSound(SoundClip newSound){
       this.sound = newSound;
    
    }

}
