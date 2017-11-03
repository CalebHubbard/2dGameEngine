package com.caleb.source.entities;

import java.awt.image.BufferedImage;

public class SpriteObjects {
    
    public BufferedImage player, rock, test1, test2, test3;

    public SpriteObjects() {   //Defines where on a spritesheet a sprite is
        player = Sprite.getSprite(0, 0);
        rock = Sprite.getSprite(1, 0);
        test1 = Sprite.getSprite(2, 0);
        test2 = Sprite.getSprite(3, 0);
    }
    
}
