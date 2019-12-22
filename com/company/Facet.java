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
        if (light()) {
            g.draw(path);
        }
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public boolean light()
    {
        if (VNormal().getZ() <= 0)
        {
            return true;
        }
        else return false;
    }
    public void drawPers(Graphics2D g, double p)
    {
        Path2D path = new Path2D.Double();
        double t[] = new double[4];
        R3Vector[] vertex1 = new R3Vector[4];
        for (int i = 0; i < 4; i++)
        {
            t[i] = -p/(vertex[i].getZ()-p);
            vertex1[i] = new R3Vector(vertex[i].getX()*t[i], vertex[i].getY()*t[i], vertex[i].getZ());
        }
        path.moveTo(vertex1[0].getX(), vertex1[0].getY());
        path.lineTo(vertex1[1].getX(), vertex1[1].getY());
        path.lineTo(vertex1[2].getX(), vertex1[2].getY());
        path.lineTo(vertex1[3].getX(), vertex1[3].getY());
        path.lineTo(vertex1[0].getX(), vertex1[0].getY());
        path.closePath();
        Facet facet = new Facet(vertex1[0], vertex1[1], vertex1[2], vertex1[3]);
        if (facet.light()) {
            g.setColor(color);
            g.fill(path);
        }
    }
}
