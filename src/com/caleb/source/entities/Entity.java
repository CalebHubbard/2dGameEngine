package com.caleb.source.entities;

import java.awt.Graphics;

public abstract class Entity {
    
    public abstract void tick();
    
    public abstract void render(Graphics graphics);

}
