package com.company;

import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    private Cube cube;
    public Viewer(Cube c) {
        cube = c;
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics gr)
    {
        Graphics2D g = (Graphics2D)gr;
        g.translate(getWidth()/2, getHeight()/2);
        g.setColor(Color.white);
        g.fillRect(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());
        g.setColor(Color.black);
        //cube.draw(g);
        cube.drawPers(g,600);

    }
}
