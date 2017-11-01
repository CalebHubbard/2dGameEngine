package com.caleb.source.entities.world;

import java.awt.Color;
import java.awt.Graphics;
import com.caleb.source.entities.Entity;
import com.caleb.source.main.Main;

public class Map extends Entity{
    
    int xOffset, yOffset;
    
    public Map(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    int[][] map = {   //2d array map
            {1,0,1,0,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,0,2,2,2,2,2,2,2,2,2,2},
            {0,1,2,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0}
        };

    public void tick() {   //Does nothing
        
    }

    
    //i and j are y and x respectfully (flipped from what seems normal)
    public void render(Graphics graphics, int xOffset, int yOffset) {   //Draws the map using the array above. Its indexes are the position (inverted), and the values indicate what tile it is
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0) {
                    graphics.setColor(Color.red);
                    graphics.fillRect((i*Main.TILESIZE) + xOffset, (j*Main.TILESIZE) + yOffset, Main.TILESIZE, Main.TILESIZE);
                    
                } else if (map[j][i] == 1) {
                    
                    graphics.setColor(Color.green);
                    graphics.fillRect((i*Main.TILESIZE) + xOffset, (j*Main.TILESIZE) + yOffset, Main.TILESIZE, Main.TILESIZE);
                    
                } else if (map[j][i] == 2) {
                    
                    graphics.setColor(Color.blue);
                    graphics.fillRect((i*Main.TILESIZE) + xOffset, (j*Main.TILESIZE) + yOffset, Main.TILESIZE, Main.TILESIZE);
                    
                }
            }
        }
    }


    public void render(Graphics graphics) {
        System.out.println("wrong method");
    }
}
