package com.caleb.source.entities;

import java.awt.Graphics;

public class Player extends Tile{
    
    SpriteObjects sprites;
    public int x, y, xOffset, yOffset;
    public boolean up, down, left, right;
    
    public Player(SpriteObjects sprites, int xPos, int yPos, int xOffset, int yOffset) {
        super(sprites, yPos, yPos);
        this.sprites = sprites;
        this.x = xPos;
        this.y = yPos;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        
    }

    public void tick() {
        if (up) {
            y-=8;
            yOffset+=8;
        }
        if (down) {
            y+=8;
            yOffset-=8;
        }
        if (left) {
            x-=8;
            xOffset+=8;
        }
        if (right) {
            x+=8;
            xOffset-=8;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(sprites.player, x + xOffset, y + yOffset, 64, 64, null);        
    }
    
    public void setUp(boolean up) {
        this.up = up;
    }
    
    public boolean getUp() {
        return up;
    }
    
    public void setDown(boolean down) {
        this.down = down;
    }
    
    public boolean getDown() {
        return down;
    }
    
    public void setLeft(boolean left) {
        this.left = left;
    }
    
    public boolean getLeft() {
        return left;
    }
    
    public void setRight(boolean right) {
        this.right = right;
    }
    
    public boolean getRight() {
        return right;
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
    
    public int getXOffset() {
        return xOffset;
    }
    
    public void setXOffset(int xOffset) {
        this.xOffset = xOffset;
    }
    
    public int getYOffset() {
        return yOffset;
    }

    public void setYOffset(int yOffset) {
        this.yOffset = yOffset;
    }
}
