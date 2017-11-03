package com.caleb.source.entities.world;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.caleb.source.entities.Entity;
import com.caleb.source.entities.SpriteObjects;
import com.caleb.source.entities.tiles.*;
import com.caleb.source.main.Main;

public class Map extends Entity{
    
    int xOffset, yOffset;
    private List<Tile> tiles = new ArrayList<Tile>();
    
    public Map(SpriteObjects sprites, int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        Tile rock = new Rock(sprites, xOffset, yOffset);
        Tile test1 = new Test1(sprites, xOffset, yOffset);
        Tile test2 = new Test2(sprites, xOffset, yOffset);
        tiles.add(rock);
        tiles.add(test1);
        tiles.add(test2);
    }
    
    

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

    
    //i and j are y and x respectfully (flipped from what seems normal)
    public void render(Graphics graphics, int xOffset, int yOffset) {   //Draws the map using the array above. Its indexes are the position (inverted), and the values indicate what tile it is
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                graphics.drawImage(tiles.get(map[j][i]).getImage(), (i*Main.TILESIZE) + xOffset, (j*Main.TILESIZE) + yOffset, Main.TILESIZE, Main.TILESIZE, null);
            }
        }
    }


    public void render(Graphics graphics) {
        System.out.println("wrong method");
    }


    public void tick() {
        
    }
}
