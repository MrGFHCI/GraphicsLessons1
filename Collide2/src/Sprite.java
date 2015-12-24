/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This is probably a bad place for this code, but I don't want to create another repository
 * @author G basic source: http://zetcode.com/tutorials/javagamestutorial/collision/
 * Full list: http://zetcode.com/tutorials/javagamestutorial/
 */
public class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;
    //protected BufferedImage biImg;

    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        vis = true;
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        
        /*try{
        biImg = ImageIO.read(new File(imageName));
        }catch(IOException ex){
        }*/
        
        
    }

    public Image getImage() {
        return image;
        //return biImg;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
    
    
    

