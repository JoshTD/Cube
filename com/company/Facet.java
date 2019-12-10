package com.company;

import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] vertex;
    Color color;
    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4)
    {
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
    }
    public void print()
    {
        for (int i = 0; i < 3; i++) {
            vertex[i].out();
            System.out.print("---");
            vertex[i+1].out();
            System.out.println();
        }
        vertex[3].out();
        System.out.print("---");
        vertex[0].out();
        System.out.println();
    }
    public R3Vector VNormal()
    {
        return R3Vector.vkpr(R3Vector.toVector(vertex[0], vertex[1]), R3Vector.toVector(vertex[0], vertex[3]));
    }
    public void rotate(double ux, double uy, double uz)
    {
        for (R3Vector v: vertex)
        {
            v.rotate(ux, uy, uz);
        }
    }
    public void scale(double k)
    {
        for (R3Vector v: vertex)
        {
            v.multiple(k);
        }
    }
    public void translate(double dx, double dy, double dz)
    {
        for (R3Vector v: vertex)
        {
            v.move(dx, dy, dz);
        }
    }
    public void draw(Graphics2D g)
    {
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        path.closePath();
        g.draw(path);
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public boolean light()
    {
        if (VNormal().getZ() > 0)
        {
            return false;
        }
        else return true;
    }
    public void drawPers(Graphics2D g, double p)
    {
        Path2D path = new Path2D.Double();
        double t[] = new double[4];
        t[0] = -p/(vertex[0].getZ()-p);
        t[1] = -p/(vertex[1].getZ()-p);
        t[2] = -p/(vertex[2].getZ()-p);
        t[3] = -p/(vertex[3].getZ()-p);
        path.moveTo(vertex[0].getX()*t[0], vertex[0].getY()*t[0]);
        path.lineTo(vertex[1].getX()*t[1], vertex[1].getY()*t[1]);
        path.lineTo(vertex[2].getX()*t[2], vertex[2].getY()*t[2]);
        path.lineTo(vertex[3].getX()*t[3], vertex[3].getY()*t[3]);
        path.lineTo(vertex[0].getX()*t[0], vertex[0].getY()*t[0]);
        path.closePath();
        if (light()) {
            g.setColor(color);
            g.fill(path);
        }
    }
}
