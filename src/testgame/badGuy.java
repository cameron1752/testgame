/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Cammy
 */
public class badGuy {
    int x = 2020;
    private static final int y = 700;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 150;
    
    private TestGame game;
    
    public badGuy(TestGame game) {
        this.game = game;
    }
    
    void move(){
        
        x = x - 3;
        
        if (x < 0){
            x = 1500;
        }
        
    }
    
    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.drawLine(0, 850, game.getWidth(), 850);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getTopY(){
        return y;
    }
}
