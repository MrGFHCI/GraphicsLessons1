/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 *
 */
public class PanBoard extends JPanel implements ActionListener {
    
    private Timer timer;
    private Craft craft;
    private ArrayList<Alien> alAliens;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 1200;
    private final int B_HEIGHT = 600;
    private final int DELAY = 15;

    private final int[][] arnPos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };

    public PanBoard() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        craft = new Craft(ICRAFT_X, ICRAFT_Y);
        initAliens();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initAliens() {
        alAliens = new ArrayList<>();
        for (int[] p : arnPos) {
            alAliens.add(new Alien(p[0], p[1]));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ingame) {
            drawObjects(g);
        } else {
            drawGameOver(g);
        }

        //Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (craft.isVisible()) {
            g.drawImage(craft.getImage(), craft.getX(), craft.getY(),
                    this);
        }

        ArrayList<Missile> alMissiles = craft.getMissiles();

        for (Missile m : alMissiles) {
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }
        for (Alien a : alAliens) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Aliens left: " + alAliens.size(), 5, 15);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inGame();
        updateCraft();
        updateMissiles();
        updateAliens();
        checkCollisions();
        repaint();
    }

    private void inGame() {
        
        if (!ingame) {
            timer.stop();
        }
    }

    private void updateCraft() {

        if (craft.isVisible()) {
            craft.move();
        }
    }

    private void updateMissiles() {

        ArrayList<Missile> alMissiles = craft.getMissiles();
        for (int i = 0; i < alMissiles.size(); i++) {
            Missile m = alMissiles.get(i);
            if (m.isVisible()) {
                m.move();
            } else {
                alMissiles.remove(i);
            }
        }
    }

    private void updateAliens() {

        if (alAliens.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < alAliens.size(); i++) {
            Alien a = alAliens.get(i);
            if (a.isVisible()) {
                a.move();
            } else {
                alAliens.remove(i);
            }
        }
    }

    public void checkCollisions() {
        Rectangle rCraft = craft.getBounds();
        for (Alien alien : alAliens) {
            Rectangle rAlien = alien.getBounds();
            if (rCraft.intersects(rAlien)) {
                craft.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }
        ArrayList<Missile> alMissiles = craft.getMissiles();
        for (Missile m : alMissiles) {
            Rectangle rMissile = m.getBounds();
            for (Alien alien : alAliens) {
                Rectangle rAlien = alien.getBounds();
                if (rMissile.intersects(rAlien)) {
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
    
}
