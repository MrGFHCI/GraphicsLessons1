
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {

    private Image img;
    int i;
    int x, y, bx, by, dx, dy, backgroundX;
    private final int SPEED = 30;
    boolean left, right, up, down;
    ImageIcon p1 = new ImageIcon("Spaceship left.png");// Looking Left
    ImageIcon p2 = new ImageIcon("Spaceship right.png");// Looking Right
    ImageIcon p3 = new ImageIcon("Spaceship.png");
    ImageIcon p4 = new ImageIcon("Spaceship down.png");
    int imgWidth = p1.getIconHeight();
    int imgHeight = p2.getIconWidth();
    Image arnRunning_R[] = new Image[4];

    public Player() {
        x = 550;
        y = 200;
        dx = 0;
        dy = 0;
        arnRunning_R[0] = p1.getImage();
        arnRunning_R[1] = p2.getImage();
        arnRunning_R[2] = p3.getImage();
        arnRunning_R[3] = p4.getImage();
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
    // these next 2 methods are used to get the direction so that bullet is shot in the right direction.
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }

    public Image getImage() {
        img = arnRunning_R[i];
        return img;
    }

    public void keyPressed(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_A) {
            i = 0;
            dx = -SPEED;
            dy = 0;
        } else if (code == KeyEvent.VK_D) {
            i = 1;
            dy = 0;
            dx = SPEED;
        } else if (code == KeyEvent.VK_W) {
            i = 2;
            dx = 0;
            dy = -SPEED;
        } else if (code == KeyEvent.VK_S) {
            i = 3;
            dx = 0;
            dy = SPEED;
        } else if (code == KeyEvent.VK_H) {// for "halt"
            dx = 0;
            dy = 0;
        }
    }

    public void keyReleased(KeyEvent w) {// nothing is done here.
        int code = w.getKeyCode();

    }
}
