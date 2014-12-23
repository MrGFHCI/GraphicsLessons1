package MoveImage;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PanBoard extends JPanel implements ActionListener {

    static boolean drawn = false;
    Rectangle rB, rE, rP; // rectangles for the 3 sprites.
    private Player p;
    private Enemy e;
    private Timer timer;
    private Image background;
    static String sName;
    Label JLabel;
    int nChange = 1;

    public PanBoard() {
        //super();
        p = new Player();
        e = new Enemy();
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("Background.png");
        background = i1.getImage();
        timer = new Timer(80, this);
        timer.start();

    }

    public void actionPerformed(ActionEvent arg0) {
        //Label();
        p.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        g2d.drawImage(e.getImage(), e.getX(), e.getY(), null);
        isHit();
    }

    boolean isHit() {
        rB = p.getRect();
        rE = e.getRect();
        if (rB.intersects(rE)) {
            System.out.println("HIT");
            return true;
            
        } else {
            return false;
        }

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
