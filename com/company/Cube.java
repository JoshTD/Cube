package com.company;
import java.awt.*;

public class Cube {
    private Facet[] facets;
    public Cube()
    {
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0), new R3Vector(0,1,0));
        facets[1] = new Facet(new R3Vector(1,0,1), new R3Vector(1,1,1), new R3Vector(1,1,0), new R3Vector(1,0,0));
        facets[2] = new Facet(new R3Vector(0,0,0), new R3Vector(0,1,0), new R3Vector(0,1,1), new R3Vector(0,0,1));
        facets[3] = new Facet(new R3Vector(0,0,0), new R3Vector(0,0,1), new R3Vector(1,0,1), new R3Vector(1,0,0));
        facets[4] = new Facet(new R3Vector(0,1,0), new R3Vector(1,1,0), new R3Vector(1,1,1), new R3Vector(0,1,1));
        facets[5] = new Facet(new R3Vector(0,0,1), new R3Vector(0,1,1), new R3Vector(1,1,1), new R3Vector(1,0,1));
        facets[0].setColor(Color.blue);
        facets[1].setColor(Color.yellow);
        facets[2].setColor(Color.orange);
        facets[3].setColor(Color.red);
        facets[4].setColor(Color.green);
        facets[5].setColor(Color.magenta);
    }
    public void scale(double k)
    {
        for (Facet facet: facets)
        {
            facet.scale(k);
        }
    }
    public void translate(double dx, double dy, double dz)
    {
        for (Facet facet: facets)
        {
            facet.translate(dx, dy, dz);
        }
    }
    public void rotate(double ux, double uy, double uz)
    {
        for (Facet facet: facets)
        {
            facet.rotate(ux, uy, uz);
        }
    }
    public void draw(Graphics2D g)
    {
        for (Facet facet: facets)
        {
            facet.draw(g);
        }
    }
    public void drawPers(Graphics2D g, double p)
    {
        for (Facet facet: facets)
        {
            facet.drawPers(g, p);
        }
    }
}
