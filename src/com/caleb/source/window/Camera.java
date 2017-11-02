package com.caleb.source.window;

public class Camera {
    
    private int xOffset, yOffset;
    private boolean xOffsetIncrease, xOffsetDecrease, yOffsetIncrease, yOffsetDecrease;

    public Camera(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    public void tick() {
        if (xOffsetIncrease) {
            xOffset+=8;
        }
        if (xOffsetDecrease) {
            xOffset-=8;
        }
        if (yOffsetIncrease) {
            yOffset+=8;
        }
        if (yOffsetDecrease) {
            yOffset-=8;
        }
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
    
    public void setXOffsetIncrease(boolean xOffsetIncrease) {
        this.xOffsetIncrease = xOffsetIncrease;
    }

    public void setXOffsetDecrease(boolean xOffsetDecrease) {
        this.xOffsetDecrease = xOffsetDecrease;
    }
    
    public void setYOffsetIncrease(boolean yOffsetIncrease) {
        this.yOffsetIncrease = yOffsetIncrease;
    }
    
    public void setYOffsetDecrease(boolean yOffsetDecrease) {
        this.yOffsetDecrease = yOffsetDecrease;
    }
    
}
