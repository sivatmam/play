/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author siv_m
 */
public class TopLevelDemo{
    
    public TopLevelDemo(){
        createUI();
    }
    public static void main(String[] args){
        
        javax.swing.SwingUtilities.invokeLater(() -> {
          new TopLevelDemo();
        });
    }

    
    public void createUI(){
        JFrame frame = new JFrame("Top Level Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(200,20));
        
        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248,213,131));
        yellowLabel.setPreferredSize(new Dimension(200,180));
        
        frame.setJMenuBar(greenMenuBar);
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
        
    }
}
