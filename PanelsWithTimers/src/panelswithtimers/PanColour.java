package PanelsWithTimers;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanColour extends JPanel // panel definition
{   
    PanDisp panDisp;

    public PanColour(PanDisp _panDisp) {
        panDisp = _panDisp;      
        setLayout(new GridLayout(3, 1));
        // notice now that I created a new BtnColour class that takes the name and 
        // the color variable. Look at the BtnColour class which extends JButton
        BtnColour btnRed = new BtnColour("Red", Color.red);
        BtnColour btnBlue = new BtnColour("Blue", Color.blue);
        BtnColour btnYellow = new BtnColour("Yellow", Color.yellow);
        add(btnRed);
        add(btnBlue);
        add(btnYellow);
        class ColourChangeListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                // I get the source of the click, and then I can find out what color has been assigned 
                //to that button.
                BtnColour btn = (BtnColour)event.getSource();
                Color c = btn.getColour();
                panDisp.UpdateBackground(c);
            }
        }
        ActionListener colourChangeListener = new ColourChangeListener();
        // all 3 buttons call the same listener
        btnRed.addActionListener(colourChangeListener);
        btnBlue.addActionListener(colourChangeListener);
        btnYellow.addActionListener(colourChangeListener);
        
        
    }/*
     public void paintComponent(Graphics g) {

     g.drawString("Colour", 50, 50);
        
     }*/

}