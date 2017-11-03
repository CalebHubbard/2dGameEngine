package com.caleb.source.entities.tiles;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.caleb.source.entities.Entity;
import com.caleb.source.entities.SpriteObjects;

public abstract class Tile extends Entity{
    
    public Tile(SpriteObjects sprites, int xPos, int yPos) {
    }

    public abstract int getX();
    
    public abstract int getY();
    
    public abstract boolean isSolid();

    public abstract BufferedImage getImage();
    
}
