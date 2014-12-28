/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SideScroll2;
import java.awt.Component;
import javax.swing.JFrame;


public class FraRunner extends JFrame{
    
    public FraRunner() {
        super("Scrolling Background Demo");
        setSize(550, 250);
 
        PanScroller back = new PanScroller();
        ((Component)back).setFocusable(true);
        getContentPane().add(back);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new FraRunner();
    }
    
    
}
