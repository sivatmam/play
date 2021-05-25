/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author siv_m
 */
public class HelloWorldSwing implements Runnable {
    
        
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,350));
        frame.add(panel);
        frame.setBounds(30, 30, 700, 350);
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        
        frame.setJMenuBar(initMenu());
        frame.pack();
        frame.setVisible(true);
    }
    
    private static JMenuBar initMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new MenuAction());
        file.add(quit);
        menuBar.add(file);
        return menuBar;
                
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        System.out.println("Hello");
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//          public void run(){
//              createAndShowGUI();
//          }
//        });
        javax.swing.SwingUtilities.invokeLater(new HelloWorldSwing());
    }

    @Override
    public void run() {
        createAndShowGUI();
    }
    
}

class MenuAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if(choice.equals("Quit")){
            System.exit(0);
        }
    }
    
}
