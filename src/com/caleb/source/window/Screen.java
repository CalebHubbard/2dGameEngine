package com.caleb.source.window;

//This class currently does nothing. Will be used as a camera that follows the player
import java.awt.Graphics;

public class Screen {
    
    int width;
    int height;
    int xOffset = 0;
    int yOffset = 0;
    
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void render(Graphics g) {
        
    }

    public void setXOffset(int xOffset) {
        this.xOffset = xOffset;
    }
    public int getXOffset() {
        return this.xOffset;
    }
    public void setYOffset(int yOffset) {
        this.yOffset = yOffset;
    }
    public int getYOffset() {
        return this.yOffset;
    }
}
