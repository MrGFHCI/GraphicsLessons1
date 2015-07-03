
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PanBoard extends JPanel implements ActionListener {

    static boolean drawn = false;
    private Player p;
    private Bullet b;
    private Enemy e;
    //private Enemy2 h;
    private Timer timer;
    private Image background;
    static int nAtk, nLvl, nHp, nCurrxp, nXpgoal, nHit, nHit1;
    static String sName;
    int nChange = 1;

    public PanBoard() {
        super();
        p = new Player();
        b = new Bullet();
        e = new Enemy();
        //h = new Enemy2();
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("background.png");
        background = i1.getImage();
        timer = new Timer(80, this);
        timer.start();

    }
// timer function
    public void actionPerformed(ActionEvent arg0) {
        p.move();
        // e should take the x and y of p.
        e.move(p.getX(), p.getY());
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        g2d.drawImage(e.getImage(), e.getX(), e.getY(), null);
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
