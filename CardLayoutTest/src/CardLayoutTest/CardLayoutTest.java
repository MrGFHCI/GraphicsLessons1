package CardLayoutTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  // Packages used in this program imported    

public class CardLayoutTest extends JFrame 
{

    JPanel panMaster;
    CardLayout cardLayout;

    public CardLayoutTest() //This is the CONSTRUCTOR method
    {
        ActionListener buttonListener = new ButtonListener(); // defined below
        setLayout(new FlowLayout()); //Use this for now.
        setSize(810, 510); //Set the size of the JFrame
        setTitle("Generic Card Game"); //Put Title on top of JFrame
        setBackground(Color.yellow);
        setResizable(false);
        
        PanOne panOne = new PanOne(buttonListener);
        PanTwo panTwo = new PanTwo(buttonListener);
        PanThree panThree = new PanThree(buttonListener);

        panMaster = new JPanel(new CardLayout());

        panMaster.add(panOne);
        panMaster.add(panTwo);
        panMaster.add(panThree);
        getContentPane().add(panMaster); 
        setVisible(true); //Make JFrame visible
        cardLayout = (CardLayout) panMaster.getLayout();
        
    }
    class ButtonListener implements ActionListener{
        

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button is pressed");
            String sAction;
            sAction = e.getActionCommand();
            if(sAction.equals("Next")){
                cardLayout.next(panMaster);
                
            }
            if(sAction.equals("Previous")){
                cardLayout.previous(panMaster);
            }
        }
        
    }
    
    public static void main(String args[])
    {    
        CardLayoutTest cardLayoutTest = new CardLayoutTest(); // This calls the constructor and runs it    
    }
}