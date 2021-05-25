/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author siv_m
 */
public class MenuLookDemo {
    
    JTextArea output;
    
    public MenuLookDemo(){
        createUI();
    }
    private void createUI(){
        JFrame frame = new JFrame("Menu Look Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(250, 250, 400, 200);
        frame.setPreferredSize(new Dimension(400,200));

        frame.setContentPane(initContentPane());
        frame.setJMenuBar(initMenu());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private Container initContentPane(){
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
        output = new JTextArea(5,30);
        output.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(output);
        
        contentPane.add(scrollpane, BorderLayout.CENTER);
        return contentPane;
    }
    
    private JMenuBar initMenu(){
        MenuLookAction mla = new MenuLookAction(this.output);
        JMenuBar menubar = new JMenuBar();
        menubar.setOpaque(true);
        menubar.setBackground(new Color(154, 165, 127));
        menubar.setPreferredSize(new Dimension(200,20));
        
        
        
        JMenu a_menu = new JMenu("A Menu");
        a_menu.setMnemonic(KeyEvent.VK_A);
        a_menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items.");
        
        // a group of JMenuItems
        JMenuItem m11 = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
        m11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        m11.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        a_menu.add(m11);
        m11.addActionListener(mla);
        
        JMenuItem m12 = new JMenuItem("Both text and icon", new javax.swing.ImageIcon(getClass().getResource("/img/middle.gif")));
        m12.setMnemonic(KeyEvent.VK_B);
        a_menu.add(m12);
        m12.addActionListener(mla);
        
        JMenuItem m13 = new JMenuItem(new javax.swing.ImageIcon(getClass().getResource("/img/middle.gif")));
        m13.setMnemonic(KeyEvent.VK_D);
        a_menu.add(m13);
        m13.addActionListener(mla);
        
        a_menu.addSeparator();
        
        
        JRadioButtonMenuItem m14 = new JRadioButtonMenuItem("A radio button menu item");
        m14.setSelected(true);
        m14.setMnemonic(KeyEvent.VK_R);
        JRadioButtonMenuItem m15 = new JRadioButtonMenuItem("Another one");
        m15.setMnemonic(KeyEvent.VK_O);
        
        ButtonGroup group = new ButtonGroup();
        group.add(m14);
        group.add(m15);
        
        a_menu.add(m14);
        a_menu.add(m15);
        m14.addActionListener(mla);
        m15.addActionListener(mla);
        
        a_menu.addSeparator();
        
        JCheckBoxMenuItem m16 = new JCheckBoxMenuItem("A check box menu item");
        m16.setMnemonic(KeyEvent.VK_C);
        
        JCheckBoxMenuItem m17 = new JCheckBoxMenuItem("Another one");
        m17.setMnemonic(KeyEvent.VK_H);
        a_menu.add(m16);
        a_menu.add(m17);
        m16.addItemListener(mla);
        m17.addItemListener(mla);
        
        a_menu.addSeparator();
        
        JMenu submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);
        JMenuItem m18 = new JMenuItem("An item in the submenu");
        m18.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(m18);
        a_menu.add(submenu);
        
        
        JMenu another_menu = new JMenu("Another Menu");
        another_menu.setMnemonic(KeyEvent.VK_N);
        another_menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
        
                
                
        menubar.add(a_menu);
        menubar.add(another_menu);
        
        return menubar;
        
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> { new MenuLookDemo(); });
    }
    
}

class MenuLookAction implements ActionListener, ItemListener {
    
    JTextArea textarea;
    
    MenuLookAction(JTextArea ta){
        textarea = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        String s = "Action event detected."
                   + "\n"
                   + "    Event source: " + source.getText() + "\n"
                   + "    Instance of : " + getClassName(source);
        System.out.println(s);
        String choice = source.getText();
        if(choice.equals("A text-only menu item")){
            System.exit(0);
        }
        textarea.append(s+"\n");
    }
    
    protected String getClassName(Object o){
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex+1);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        String s = "Item event detected." + "\n"
                   + "    Event source: " + source.getText() + "\n"
                   + "    Instance of : " + getClassName(source) + "\n"
                   + "    New state   : " + ((e.getStateChange() == ItemEvent.SELECTED) ? "Selected" : "Unselected");
        System.out.println(s);
        textarea.append(s+"\n");
    }
    
}
