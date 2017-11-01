package com.caleb.source.entities;

import java.awt.image.BufferedImage;

public class SpriteObjects {
    
    public BufferedImage player;

    public SpriteObjects() {   //Defines where on a spritesheet a sprite is
        player = Sprite.getSprite(0, 0);
    }
    
}
