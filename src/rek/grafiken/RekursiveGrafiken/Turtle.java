package rek.grafiken.RekursiveGrafiken;

import java.awt.Graphics;

public class Turtle {
    
    private Graphics g;
    
    private double x = 0,z = 0,rot = 0;
    
    public Turtle(Graphics g){
        this.g = g;
    }
    
    public void draw(float length){
        double d = Math.toRadians(rot);
        double x1 = x+length*Math.sin(d);
        double z1 = z+length*Math.cos(d);
        g.drawLine((int)x, (int)z, (int)x1, (int)z1);
        x = x1;
        z = z1;
    }
    
    public void set(int x,int z,float rot){
        this.x = x;
        this.z = z;
        this.rot = rot;
    }
    
    public void rotate(float degrees){
        rot += degrees;
        rot %= 360;
    }

    public Graphics getGraphics() {
        return g;
    }
    
}
