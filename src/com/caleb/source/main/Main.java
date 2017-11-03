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
    public Camera camera;
    
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
            camera = new Camera(0, 0);
            map = new Map(0, 0);
            player = new Player(sprites, (this.getWidth() / 2) - 32, (this.getHeight() / 2) - 32);
            keyInput = new KeyInput(player, camera);
            addKeyListener(keyInput);
            created = true;
        }
        /////////////////////////////////////////////////
        
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        map.render(graphics, camera.getXOffset(), camera.getYOffset());
        player.render(graphics, camera.getXOffset(), camera.getYOffset());
        
        /////////////////////////////////////////////////
        graphics.dispose();
        bs.show();
    }
    
    public void tick() {   //Called during run method, Runs game logic, currently does nothing
        
        player.tick();
        map.tick();
        camera.tick();
        
        if (player.getX() <= this.getWidth() / 2) {
            camera.setXOffset(0); 
        }
        if (player.getY() <= this.getHeight() / 2) {
            camera.setYOffset(0);
        }
        if (player.getX() >= (map.map[0].length*TILESIZE) - (this.getWidth() / 2)) {
            camera.setXOffset(-((map.map[0].length*TILESIZE) - (this.getWidth())));
        }
        if (player.getY() >= (map.map.length*TILESIZE) - (this.getHeight() / 2)) {
            camera.setYOffset(-((map.map.length*TILESIZE) - (this.getHeight())));
        }
        
        
        if (player.getX() <= 0) {
            player.setX(0);
        }
        if (player.getY() <= 0) {
            player.setY(0);
        }
        if (player.getX() >= (map.map[0].length*TILESIZE) - 64) {
            player.setX((map.map[0].length*TILESIZE) - 64); 
        }
        if (player.getY() >= (map.map.length*TILESIZE) - 64) {
            player.setY((map.map.length*TILESIZE) - 64); 
        }
        
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
    


