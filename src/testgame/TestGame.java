/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Cammy
 * 
 */

public class TestGame extends JPanel {
    
    // creates new instance of our character and badGuy classes
    character character = new character(this);
    badGuy badGuy = new badGuy(this);
    
    public TestGame(){
        
        // adds keyListeners in the game constructor class for key typed, pressed, and released
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
            @Override
            public void keyReleased(KeyEvent e){
                character.keyReleased(e);
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
            @Override
            public void keyPressed(KeyEvent e){
                character.keyPressed(e);
                //throw new UnsupportedOperationException("Not supported yet.");
            }

        });
        setFocusable(true);
    }
    
    private void move(){
    
        character.move();
        badGuy.move();
    }
    
    @Override
    public void paint(Graphics g){
    
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        character.paint(g2d);
        badGuy.paint(g2d);
        
    }
    
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
    
    public static void main(String[] args) throws InterruptedException{
        
        JFrame frame = new JFrame("me swamp");
        TestGame game = new TestGame();
        frame.add(game);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("OK BOOMER");

//        initBaddys(game);

        while (true){

            game.move();
            game.repaint();
            Thread.sleep(10);

        }
    
    }
    
    
}
