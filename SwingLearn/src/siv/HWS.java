/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siv;

import javax.swing.*;

/**
 *
 * @author siv_m
 */
public class HWS implements Runnable {
    
//    public static void main(String[] args){
//        System.out.println("Hello World!");
//    }
    public static void main(String[] args){
        
//        SwingUtilities.invokeLater(new Runnable() {
//          public void run(){
//              createAndShowGUI();
//          }
//        });
        SwingUtilities.invokeLater(new HWS());
    }  
    
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void run() {
        createAndShowGUI();
    }
    
    
}
