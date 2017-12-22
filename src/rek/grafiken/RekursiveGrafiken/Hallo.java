/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rek.grafiken.RekursiveGrafiken;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Schule
 */
public class Hallo extends javax.swing.JPanel {

    private float size = 5;
    private int rek = 1;
    private ExecutorService exe;

    public Hallo() {
        setBackground(new Color(128, 128, 181));
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(2, 21, 60));
        Turtle t = new Turtle(g);
        t.set(getWidth() / 2-50, getHeight() / 2 - 50, 90);
        paintRekursiv2(t, 0);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (exe == null) {
                    exe = Executors.newSingleThreadExecutor();
                    exe.execute(new Runnable() {
                        @Override
                        public void run() {
                            size = (float) (size*Math.pow(0.98D, rek));
                            paintRekursiv2(t, rek = rek + 1);
                            repaint();
                        }
                    });
                    exe = null;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void paintRekursiv2(Turtle t,int rekTiefe){
        if (rekTiefe == rek) {
            return;
        }
        t.draw(size);
        t.rotate(45);
        paintRekursiv2(t, rekTiefe+1);
        t.rotate(-90);
        paintRekursiv2(t, rekTiefe+1);
        t.rotate(45);
    }
    
    public void paintRekursiv1(Turtle t, int rekTiefe, float d) {
        if (rekTiefe == rek) {
            return;
        }
        t.draw((int)(d / 2));
        t.rotate(90);
        t.draw((int)d);
        t.rotate(45);
        t.rotate(180);
        //Kreis 1
        paintRekursiv1(t, rekTiefe + 1, d);
        t.rotate(-180);
        t.rotate(45);
        t.draw((int)d);
        t.rotate(45);
        //Kreis 2
        t.rotate(180);
        paintRekursiv1(t, rekTiefe + 1, d);
        t.rotate(-180);
        t.rotate(45);
        t.draw((int)d);
        t.rotate(90);
        t.draw((int)(d / 2));
        //t.rotate(180);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
