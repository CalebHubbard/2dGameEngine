package com.caleb.source.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.caleb.source.entities.Player;

public class KeyInput implements KeyListener{
    
    Player player;
    
    public KeyInput(Player player) {   //getting the instance of the player
        this.player = player;
    }

    public void keyPressed(KeyEvent e) {   //Basic arrow key movement

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setLeft(true);
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.setRight(true);
        }

        if (key == KeyEvent.VK_UP) {
            player.setUp(true);
        }

        if (key == KeyEvent.VK_DOWN) {
            player.setDown(true);
        }
        
    }

    public void keyTyped(KeyEvent e) {   //Does nothing
        
    }

    public void keyReleased(KeyEvent e) {   //Does nothing
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setLeft(false);
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.setRight(false);
        }

        if (key == KeyEvent.VK_UP) {
            player.setUp(false);
        }

        if (key == KeyEvent.VK_DOWN) {
            player.setDown(false);
        }
    }
    
}
