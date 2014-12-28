package SideScroll2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanScroller extends JPanel implements Runnable {

    // Two copies of the background image to scroll
    private Image b1, b2;
    private int nX1 = -100, nX2, nWidth, nY = 0, nDx = -1;

    public PanScroller() {
        try {
            b1 = ImageIO.read(new File("background.png"));
            b2 = ImageIO.read(new File("background.png"));
        } catch (Exception e) {
            System.out.println(e);
        }
        nWidth = b1.getWidth(this);
        nX2 = nX1 + nWidth;
        new Thread(this).start();
        addKeyListener(new Movement());
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                nX1 += nDx;
                nX2 += nDx;
                repaint();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D g2d = (Graphics2D) window;
        // the frame is 550 wide, the bg image is 900 wide

        if (nX1 < -1000) {
            nX1 = nX2 + nWidth; //move it to the far right
        } else if (nX2 < -1000) {
            nX2 = nX1 + nWidth; //move it to the far right
        }
        if (nX2 > 800) {
            nX2 = nX1 - nWidth;
        } else if (nX1 > 800) {
            nX1 = nX2 - nWidth;
        }
        System.out.println(nX1 + " is nX1 and the next is nX2 " + nX2);
        g2d.drawImage(b1, nX1, 0, null);
        g2d.drawImage(b2, nX2, 0, null);
    }

    private class Movement extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent w) {
            nDx = 0;
        }

        @Override
        public void keyPressed(KeyEvent w) {
            int code = w.getKeyCode();
            if (code == KeyEvent.VK_A) {
                nDx = 1;
            }
            if (code == KeyEvent.VK_D) {
                nDx = -1;
            }

        }
    }

}
