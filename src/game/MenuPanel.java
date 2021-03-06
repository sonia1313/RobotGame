/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *This class acts the main menu screen that player interacts with when game starts
 * The class uses javax swing controls.
 * @author Sonia Mathews
 * @version 3
 * @since 3
 */

public class MenuPanel extends javax.swing.JPanel {
    /**
     * variables needed to create a main menu
     */
Game game;
GameLevel world;
/**
     * Creates new form MenuPanel
     */
    public MenuPanel(Game game) {
        initComponents();
        this.game = game;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\Screenshots\\screenshot.176.jpg")); // NOI18N

        setForeground(new java.awt.Color(102, 0, 153));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(null);

        jPanel5.setLayout(null);
        add(jPanel5);
        jPanel5.setBounds(501, 0, 0, 0);

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("  Robo Guy");
        add(jLabel1);
        jLabel1.setBounds(60, 60, 400, 100);

        jButton1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setText("Play!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(220, 330, 90, 31);

        jButton2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 102));
        jButton2.setText("HighScore");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(190, 370, 160, 31);

        jButton3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 102));
        jButton3.setText("Instructions");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(170, 410, 190, 31);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/screenshot.176.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(10, 0, 490, 510);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param evt when user clicks HighScore option in main menu
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        game.createScoreTable();
        
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * 
     * @param evt when user clicks on Instructions Button in main menu
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        game.createInstruction();
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * 
     * @param evt when user clicks play button in main menu
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        game.createGame();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
