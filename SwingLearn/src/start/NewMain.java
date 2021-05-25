/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 *
 * @author siv_m
 */
public class NewMain {
    
    public NewMain(){
        createUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getClassName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CelsiusFahrenheitConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CelsiusFahrenheitConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CelsiusFahrenheitConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CelsiusFahrenheitConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        javax.swing.SwingUtilities.invokeLater(() -> {
          new NewMain();
        });
    }
    
    private void createUI(){
        JFrame myframe = new JFrame("Tomato Soup");
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLayout(new FlowLayout());
        myframe.add(initPanel(0,200,0));
        myframe.add(initPanel(200,0,0));
        myframe.add(initPanel(0,0,200));
        myframe.add(initScroll());
        myframe.setJMenuBar(initMenu());
        myframe.pack();
        myframe.setVisible(true);
        
    }
    
    private JScrollPane initScroll(){
        javax.swing.JScrollPane mysp = new javax.swing.JScrollPane();
        javax.swing.JTree myjt = new javax.swing.JTree();
        mysp.setViewportView(myjt);
        return mysp;
    }
    
    private JPanel initPanel(int b, int g, int r){
        JPanel mypanel = new JPanel();
        mypanel.setBackground(new Color(b,g,r));
        mypanel.setBounds(0,0,200,200);
        mypanel.setPreferredSize(new Dimension(200,200));
        return mypanel;
    }
    
    private JMenuBar initMenu(){
        JMenuBar mymenu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new MenuAction());
        file.add(quit);
        mymenu.add(file);
        return mymenu;
    }
    
}


