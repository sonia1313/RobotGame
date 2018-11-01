package game;

import city.cs.engine.*;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.PopupMenu;
import static java.awt.SystemColor.window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import sun.applet.Main;

/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;


    private MyView view;
    private int level;
    private RobotPlayer robotPlayer;
    private Controller controller;
    private UpdateController updateController;
    final JFrame frame = new JFrame("Event handling");
    JFrame debugView;
    Container mainMenu = new MenuPanel(this);

    /**
     * Initialise a new Game.
     */
    public Game() {

        frame.add(mainMenu);
        // quit the application when the game window is closed

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();

    }
    /**
     * Creates the game after the main menu screen
     */

    public void createGame() {
        frame.remove(mainMenu);
        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        //make a view
        view = new MyView(world, 500, 500, world.getPlayer());
        view.setZoom(31);

      
        // display the view in a frame
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.SOUTH);

        // display the world in the window
        frame.add(view);
        // size the game window to fit the world view
        frame.pack();
      
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        frame.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        view.setSound(world.getSound());
        //allows a camera view to follow the path of the player
        world.addStepListener(new Tracker(view, world.getPlayer()));

        
        // start!
        world.start();

    }
    /**
     * pauses the game, when pause button in control panel is clicked
     */
    public void pause() {
        world.stop();
    }
    /**
     * 
     * @return this player of the game
     */
    public RobotPlayer getPlayer() {
        return world.getPlayer();
    }
    /**
     * 
     * @return a method call isCompleted when player has completed a level
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
/**
 * 
 * @throws IOException when there is method call of setHighScore()
 * <p> This method updates the view of the player, live count and gem count as player moves up each level
 * It also manages the sound changes across each level and updates to new background music. </p>
 */
    public void goNextLevel() throws IOException {
        world.stop();
        world.stopSoundForLevel(); //stops sound for previous level before moving up
        RobotPlayer oldRobot = world.getPlayer(); //inorder to get new copy of the player for each level

        if (level == 3) {
            String name = showInputDialog(); //user has to input name after completion of the game            
            oldRobot.setHighScore(name, oldRobot.getGemCount());
            System.exit(0);
        } else if (level == 1) {

            level++;
            //get a new world
            world = new Level2();

            //fill it with bodies
            world.populate(this);

            //switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            view.setPlayer(world.getPlayer());//updates player
            view.setSound(world.getSound());//updates sound
            view.setZoom(31);
            world.getPlayer().setGemCount(oldRobot.getGemCount());//updates gem count
            world.getPlayer().setLiveCount(oldRobot.getLiveCount());//updates live count

            world.addStepListener(new Tracker(view, world.getPlayer()));//updates tracker

            world.start();

        } else if (level == 2) {
            level++;
            //get a new world
            world = new Level3();
            //fill it with bodies
            world.populate(this);

            //switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            view.setPlayer(world.getPlayer());
            view.setSound(world.getSound());

            world.getPlayer().setGemCount(oldRobot.getGemCount()); 

            world.getPlayer().setLiveCount(oldRobot.getLiveCount());

            updateController = new UpdateController(world.getPlayer());
            frame.addKeyListener(updateController);

            updateController.setBody(world.getPlayer());

            view.setZoom(31);

            world.addStepListener(new Tracker(view, world.getPlayer()));

            world.start();

        }

    }
/**
 * this method creates the instruction panel, when user clicks the instruction button in main menu
 */
    public void createInstruction() {
        InstructionPanel instructionPanel = new InstructionPanel();
        JFrame frame = new JFrame();
        frame.add(instructionPanel);
        frame.setVisible(true);
        frame.pack();

    }
    /**
     * 
     * @return String to validate user input by checking if name field is not empty and is in the correct format 
     */   
    private String showInputDialog() {
        String inputValue = JOptionPane.showInputDialog("Please enter your name");

        if (inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]*")) {
            inputValue = showInputDialog();
        }

        return inputValue;
    }
    /**
     * this method creates the high score list. It consists of the top ten scores.
     * A try and catch block is used to handle the IO exception by the HighScoreReader
     */

    public void createScoreTable() {

        ScorePanel scorePanel = new ScorePanel();
        JFrame frame = new JFrame();
        frame.add(scorePanel);
        frame.setVisible(true);
        frame.pack();

        try {
            HighScoreReader highScore = new HighScoreReader("data/scores.txt");
            highScore.readScores();
            highScore.outputScores(scorePanel.getTextArea()); //loads data to JTextArea in ScorePanel

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 
     * @param args creates a new Game
     */
    public static void main(String[] args) {
        new Game();

    }
}
