
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Image;
import java.awt.Label;

public class Bullet {

    private Image img;
    int k, nS;
    int EHMin, EWMin;
    int nX, nY , nDx, nDy;
    boolean bShoot= true;
    private final int bSpeed = 80;
    ImageIcon b1 = new ImageIcon("laser1.png");
    ImageIcon b2 = new ImageIcon("laser2.png");
    ImageIcon b3 = new ImageIcon("laser3.png");
    ImageIcon b4 = new ImageIcon("laser4.png");
    //int imgWidth = b1.getIconHeight();
    //int imgHeight = b2.getIconWidth();
    Image arnShooting[] = new Image[4];

    

    public Bullet() {
        
        arnShooting[1] = b1.getImage();
        arnShooting[2] = b2.getImage();
        img = arnShooting[1];
    }

    public void move() {
        // will also be in charge of displaying
        
        nX+=nDx;
        nY+=nDy;
        
            
        
    }
    public void shoot(int _nX, int _nY, int _nDx, int _nDy){
        nX = _nX;
        nY = _nY;
        nDx = _nDx;
        nDy = _nDy;
        //bShoot = false;
        
    }

    public int getX() {
        return nX;
    }

    public int getY() {
        return nY;
    }
    public boolean canShoot(){
        return bShoot;
    }

    public Image getImage() {
        //img = arnShooting[1];
        //if (nCount == 0) {
       //     k = 0;
       //     return img;
       // }
        return img;
    }

    
}
