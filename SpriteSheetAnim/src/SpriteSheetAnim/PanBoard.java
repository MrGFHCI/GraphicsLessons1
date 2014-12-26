package SpriteSheetAnim;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PanBoard extends JPanel implements ActionListener {

    static boolean drawn = false;
    Rectangle rB, rE, rP; // rectangles for the 3 sprites.
    private Player p;
    Sprite s;
    //private Enemy e;
    private Timer timer;
    private Image background;
    static String sName;
    Label JLabel;
    int nChange = 1, nX, nY;
    String sFile;
    BufferedImage biSpriteSheet, biSprite;

    public PanBoard() {
        sFile = "SpriteSheet.jpg";
        nX = 0;
        nY = 0;
        //super();
        p = new Player();
        s = new Sprite();
        s.loadSprite(sName);
        //e = new Enemy();
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("Background.png");
        background = i1.getImage();
        timer = new Timer(60, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent arg0) {
        p.move();
        if(nX>3){ 
            nX = 0;
            nY++;
        }
        if(nY>3) nY =0;       
        biSprite = s.getSprite(nX, nY);
        System.out.println(nX + " " + nY);
        repaint();
        nX++;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        g2d.drawImage(biSprite, 100, 100, null);
    }

    private class Movement extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent w) {
            p.keyReleased(w);
        }

        @Override
        public void keyPressed(KeyEvent w) {
            p.keyPressed(w);
        }
    }
}
