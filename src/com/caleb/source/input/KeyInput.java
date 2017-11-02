package com.caleb.source.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.caleb.source.entities.Player;
import com.caleb.source.window.Camera;

public class KeyInput implements KeyListener{
    
    Player player;
    
    Camera camera;
    
    public KeyInput(Player player, Camera camera) {   //getting the instance of the player
        this.player = player;
        this.camera = camera;
    }

    public void keyPressed(KeyEvent e) {   //Basic arrow key movement

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setLeft(true);
            camera.setXOffsetIncrease(true);
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.setRight(true);
            camera.setXOffsetDecrease(true);
        }

        if (key == KeyEvent.VK_UP) {
            player.setUp(true);
            camera.setYOffsetIncrease(true);
        }

        if (key == KeyEvent.VK_DOWN) {
            player.setDown(true);
            camera.setYOffsetDecrease(true);
        }
        
    }

    public void keyTyped(KeyEvent e) {   //Does nothing
        
    }

    public void keyReleased(KeyEvent e) {   //Does nothing
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setLeft(false);
            camera.setXOffsetIncrease(false);
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.setRight(false);
            camera.setXOffsetDecrease(false);
        }

        if (key == KeyEvent.VK_UP) {
            player.setUp(false);
            camera.setYOffsetIncrease(false);
        }

        if (key == KeyEvent.VK_DOWN) {
            player.setDown(false);
            camera.setYOffsetDecrease(false);
        }
    }
    
}
