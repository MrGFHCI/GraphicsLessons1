

import javax.swing.*;
import java.awt.Image;

public class Enemy {

    private Image img;
    int k = 0;
    int x, y, dx, dy, xP, yP;
    static int X, Y, I, BX, BY, nHit;
    //int nWidth, nLength, EH, EW, nEXP, nSpawn;
    private final int nSpeed = 5;
    ImageIcon e1 = new ImageIcon("Enemy1.png");
    ImageIcon e2 = new ImageIcon("Enemy2.png");
    int imgWidth = e1.getIconHeight();
    int imgHeight = e2.getIconWidth();
    Image arnEnemy[] = new Image[3];
    int arnHit[] = new int[50];

    public Enemy() {
        dx = 0;
        dy = 0;
        x = 0;
        y = 0;
        //nEXP = 5;
        arnEnemy[0] = e1.getImage();
        arnEnemy[1] = e2.getImage();
    }

    // should take x and y of player and then move accordingly. *********************
    public void move(int _xP, int _yP) {
        xP = _xP;
        yP = _yP;
        x += dx;
        y += dy;
        if (xP > x) {
            dx = nSpeed;
        } else if (xP < x) {
            dx = -nSpeed;
        } else {
            dx = 0;
        }
        if (yP > y) {
            dy = nSpeed;
        } else if (yP < y) {
            dy = -nSpeed;
        } else {
            dy = 0;
        }
    }

    public int getX() {return x; }

    public int getY() {
        return y;
    }

    public Image getImage() {
        if (xP >= x) {
            k = 0;
        }
        if (xP <= x) {
            k = 1;
        }
        img = arnEnemy[k];
        return img;
    }

}
