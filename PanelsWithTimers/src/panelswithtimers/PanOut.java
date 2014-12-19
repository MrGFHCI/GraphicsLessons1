package PanelsWithTimers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanOut extends JPanel // panel definition
{

    int nCount;
    String sCount;
    private JLabel lblCount;

    public PanOut() {
        lblCount = new JLabel("0");
        add(lblCount);

    }

    void UpdateLabel(int _nCount) {
        nCount = _nCount;
        sCount = Integer.toString(nCount);
        lblCount.setText(sCount);
    }
}

