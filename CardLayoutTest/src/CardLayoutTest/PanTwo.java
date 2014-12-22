/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardLayoutTest;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanTwo extends JPanel{
    JButton btnNext, btnPrev;
    JLabel lblId;
    
    public PanTwo(ActionListener buttonListener){
        lblId = new JLabel("This is panel #2");
        btnNext = new JButton("Next");
        btnPrev = new JButton("Previous");
        add(lblId);
        add(btnNext);
        add(btnPrev);
        btnNext.addActionListener(buttonListener);
        btnPrev.addActionListener(buttonListener);
    }
    
    
    
}
