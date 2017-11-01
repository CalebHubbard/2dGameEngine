package com.caleb.source.entities;

public abstract class Tile extends Entity{
    
    public Tile(SpriteObjects sprites, int xPos, int yPos) {
    }

    public abstract int getX();
    
    public abstract int getY();

}
