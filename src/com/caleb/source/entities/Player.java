package com.caleb.source.entities;

import java.awt.Graphics;

public class Player extends Tile{
    
    Graphics graphics;
    SpriteObjects sprites;
    public int x, y, test = 0;
    
    public Player(SpriteObjects sprites, int xPos, int yPos) {
        super(sprites, yPos, yPos);
        this.sprites = sprites;
        this.x = xPos;
        this.y = yPos;
        
    }

    public void tick() {
        
    }

    public void render(Graphics g) {
        g.drawImage(sprites.player, x, y, 64, 64, null);        
    }

    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
}
