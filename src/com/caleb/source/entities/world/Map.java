package com.caleb.source.entities.world;

import java.awt.Color;
import java.awt.Graphics;
import com.caleb.source.entities.Entity;
import com.caleb.source.main.Main;

public class Map extends Entity{

    int[][] map = {   //2d array map
            {1,0,1,0,1},
            {0,1,1,1,0},
            {0,1,2,1,0},
            {0,1,1,1,0},
            {1,0,0,0,1}
        };

    public void tick() {   //Does nothing
        
    }

    
    //i and j are y and x respectfully (flipped from what seems normal)
    public void render(Graphics g) {   //Draws the map using the array above. Its indexes are the position (inverted), and the values indicate what tile it is
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[j][i] == 0) {
                    g.setColor(Color.red);
                    g.fillRect(i*Main.TILESIZE, j*Main.TILESIZE, Main.TILESIZE, Main.TILESIZE);
                    
                } else if (map[j][i] == 1) {
                    
                    g.setColor(Color.green);
                    g.fillRect(i*Main.TILESIZE, j*Main.TILESIZE, Main.TILESIZE, Main.TILESIZE);
                    
                } else if (map[j][i] == 2) {
                    
                    g.setColor(Color.blue);
                    g.fillRect(i*Main.TILESIZE, j*Main.TILESIZE, Main.TILESIZE, Main.TILESIZE);
                    
                }
            }
        }
    }
}
