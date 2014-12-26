package SpriteSheetAnim;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {

    private Image img;
    int i;
    int x, y, bx, by, dx, dy, backgroundX;
    private final int SPEED = 15;
    boolean left, right, up, down;
    ImageIcon p1 = new ImageIcon("Lucario1.png");// Looking Left
    ImageIcon p2 = new ImageIcon("Lucario2.png");// Looking Right
    int imgWidth = p1.getIconHeight();
    int imgHeight = p2.getIconWidth();
    Image arnRunning_R[] = new Image[2];
    Rectangle r;

    public Player() {
        r = new Rectangle();
        x = 550;
        y = 200;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        arnRunning_R[0] = p1.getImage();
        arnRunning_R[1] = p2.getImage();
    }
    public Rectangle getRect(){
        r.setBounds(x, y, imgWidth, imgHeight);
        return r;    
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        img = arnRunning_R[i];
        return img;
    }

    public void keyPressed(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_A) {
            i=0;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_D) {
            i=1;
            dx = SPEED;
        } else if (code == KeyEvent.VK_W) {
            dy = -SPEED;
        } else if (code == KeyEvent.VK_S) {
            dy = SPEED;
        }

    }
    public void keyReleased(KeyEvent w) {
        dy = 0;
        dx = 0;
    }

}
