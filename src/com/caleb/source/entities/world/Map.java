package com.caleb.source.entities.world;

import java.awt.Graphics;
import com.caleb.source.entities.Entity;
import com.caleb.source.entities.SpriteObjects;
import com.caleb.source.entities.tiles.*;
import com.caleb.source.main.Main;

public class Map extends Entity{
    
    int xOffset, yOffset, k = 0;
    SpriteObjects sprites;
        
    public int[][] map = {   //2d array map
            {1,0,1,0,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,0,2,2,2,2,2,2,2,2,2,2},
            {0,1,2,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,0,2,2,2,2,2,2,2,2,2,2},
            {0,1,2,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,0,2,2,2,2,2,2,2,2,2,2},
            {0,1,2,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,0,2,2,2,2,2,2,2,2,2,2},
            {0,1,2,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0}
        };
    
    public Tile[][] objectMap;
    
    public Map(SpriteObjects sprites, int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.sprites = sprites;
        
        objectMap = new Tile[map.length][map[0].length];
        
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0) {
                    objectMap[j][i] = new Rock(sprites, i*Main.TILESIZE, j*Main.TILESIZE);
                }
                if (map[j][i] == 1) {
                    objectMap[j][i] = new Test1(sprites, i*Main.TILESIZE, j*Main.TILESIZE);
                }
                if (map[j][i] == 2) {
                    objectMap[j][i] = new Test2(sprites, i*Main.TILESIZE, j*Main.TILESIZE);
                }
                
            }
        }
    }
    
    //i and j are y and x respectfully (flipped from what seems normal)
    public void render(Graphics graphics, int xOffset, int yOffset) {   //Draws the map using the array above. Its indexes are the position (inverted), and the values indicate what tile it is
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {                
                graphics.drawImage(objectMap[j][i].getImage(), (i*Main.TILESIZE) + xOffset, (j*Main.TILESIZE) + yOffset, Main.TILESIZE, Main.TILESIZE, null);
            }
        }
    }


    public void tick() {
        
    }
}
