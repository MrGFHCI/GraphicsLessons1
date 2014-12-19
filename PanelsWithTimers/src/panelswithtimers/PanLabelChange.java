package PanelsWithTimers;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanLabelChange extends JPanel // panel definition
{
    PanDisp panDisp;
    String sName;

    public PanLabelChange(PanDisp _panDisp) {
        panDisp = _panDisp;
        JButton btn1 = new JButton("Number 1");
        JButton btn2 = new JButton("Number 2");
        add(btn1);
        add(btn2);

        class LabelChangeListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                JButton btn = (JButton) event.getSource();
                sName = btn.getText(); // gets the text value of the button
                panDisp.UpdateLabel(sName);
            }
        }
        ActionListener labelChangeListener = new LabelChangeListener();
        btn1.addActionListener(labelChangeListener);
        btn2.addActionListener(labelChangeListener);
    }
}
    /*
     public void paintComponent(Graphics g) {

     g.drawString("Label Change", 50, 50);
        
     }*/
