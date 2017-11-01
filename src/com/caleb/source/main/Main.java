package com.caleb.source.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import com.caleb.source.entities.*;
import com.caleb.source.entities.world.*;
import com.caleb.source.input.KeyInput;
import com.caleb.source.window.*;

@SuppressWarnings("serial")
public class Main extends Canvas implements Runnable{
    
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static final int TILESIZE = 64;
    
    public Graphics graphics;
    public boolean running = false;
    public boolean created = false;
    public Thread thread;
    public BufferStrategy bs;
    public SpriteObjects sprites = new SpriteObjects();
    public Map map;
    public Player player;
    public static Window window;
    public KeyInput keyInput;
    
    public void init() {   //Called as soon as the program runs
        setBackground(Color.BLACK);
    }
    
    public synchronized void start() {   //Called after the frame is made (opens thread)
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
 
    public void render() {   //Called during run method, Draws everything
        bs = this.getBufferStrategy(); 

        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        bs = this.getBufferStrategy();

        graphics = bs.getDrawGraphics();
        
        if (!created) {
            map = new Map();
            player = new Player(sprites, 0, 0);
            keyInput = new KeyInput(player);
            addKeyListener(keyInput);
            created = true;
        }
        /////////////////////////////////////////////////

        map.render(graphics);
        player.render(graphics);
        
        /////////////////////////////////////////////////
        graphics.dispose();
        bs.show();
    }
    
    public void tick() {   //Called during run method, Runs game logic, currently does nothing
        
        player.tick();
        map.tick();
        
    }

    public void run() {   //Big and confusing fps, and tps math
        init();
        
        long lastTime = System.nanoTime();
        double numTicks = 60.0;
        double ns = 1000000000/numTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int tps = 0;
        int fps = 0;

        while(running){
            long currentTime = System.nanoTime();   
            delta += (currentTime - lastTime)/ns;
            lastTime = currentTime;
            while(delta>=1){
                tick();         //Makes sure the game logic runs at the same speed if fps drops
                tps++;
                delta--;
            }
            render();
            fps++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS = " + fps + " TICK = " + tps);
                fps = 0;
                tps = 0;
           }
        }
    }
    
    public static void main(String[] args) {   //Creates the instance of Window
         new Window(new Main());
        
    }
}    
    


