package rek.grafiken.RekursiveGrafiken;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class RekursiveGrafiken extends JFrame {
    
    public static void main(String[] args){
        new RekursiveGrafiken();
    }

    public RekursiveGrafiken() throws HeadlessException {
        super("Rekursiv");
        
        add(new Hallo());
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, d.width, d.height);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //HIeR WAR HENDRIKK ... WEar doch Rübu
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    
}
