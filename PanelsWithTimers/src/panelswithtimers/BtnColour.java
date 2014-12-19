package PanelsWithTimers;

import javax.swing.*;
import java.awt.*;

public class BtnColour extends JButton // panel definition
{
    private Color c;
    private String sName;

    public BtnColour(String _sName, Color _c) {
        sName = _sName;
        c = _c;
        
        this.setText(sName);
    }
    
    public Color getColour(){
        return c;
        
    }
}