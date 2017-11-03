package com.caleb.source.entities.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.caleb.source.entities.SpriteObjects;

public class Test1 extends Tile{
    
    private int x, y;
    private SpriteObjects sprites;
    

    public Test1(SpriteObjects sprites, int xPos, int yPos) {
        super(sprites, xPos, yPos);
        this.sprites = sprites;
        this.x = xPos;
        this.y = yPos;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isSolid() {
        return true;
    }

    public void tick() {
        
    }

    public void render(Graphics graphics, int xOffset, int yOffset) {
        
    }
    
    public BufferedImage getImage() {
        return sprites.test1;
    }

}
