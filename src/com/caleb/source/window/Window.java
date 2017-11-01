package com.caleb.source.window;

import java.awt.Dimension;
import javax.swing.JFrame;

import com.caleb.source.main.Main;

public class Window{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    
    public static JFrame frame = new JFrame();
    
    public Window(Main main) {
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.requestFocus();
        
        main.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.add(main);
        frame.pack();
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        main.start();
        
    }
    
    public JFrame getFrame() {
        return frame;
    }

}
