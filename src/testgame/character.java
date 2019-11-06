/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
/**
 *
 * @author Cammy
 */
public class character {
    private static final int DIAMETER = 30;
    int x = 100;
    int y = 820;
    int xa = 0;
    int ya = 0;
    int count = 0;
    private TestGame game;
    
    public character(TestGame game) {
        
        this.game = game;
    
    }
    
    void move(){
        
        if (x + xa > 0 && x + xa < game.getWidth()-DIAMETER){
            x = x + xa;
        }
        
        if (y + ya > 0 && y + ya < 820){
            if (y > 600){
                y = y + ya;
            } else{
                ya = 3;
                y = y + ya;
            }
            
            
        }
        if (collision()){
            game.gameOver();
        }
    }
    
    private boolean collision() {
        return game.badGuy.getBounds().intersects(getBounds());
    }
    
    public void paint(Graphics2D g){
        
        g.fillOval(x, y, DIAMETER, DIAMETER);
        System.out.println("x: " + x + " xa: " + xa + " y: " + y + " ya: " + ya);
        
    }
    
    public Rectangle getBounds(){
        
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
    
    
    public void keyReleased(KeyEvent e){
        
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            xa = 0;
        }

    }
    
    public void keyPressed(KeyEvent e){
    
        if (e.getKeyCode() == KeyEvent.VK_A){
            xa = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            xa = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            
            ya = -3;
        }
        
        
    }
}
