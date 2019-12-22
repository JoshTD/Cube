package com.company;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Viewer extends JFrame {
    public Cube cube;
    public Container pane;
    public JPanel renderPanel;
    public JSlider vSlider;

    public Viewer(Cube c) {
        cube = c;
        setSize(800, 800);
        pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        renderPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics gr) {
                Graphics2D g = (Graphics2D)gr;
                g.translate(getWidth()/2, getHeight()/2);
                g.setColor(Color.white);
                g.fillRect(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());
                g.setColor(Color.black);
                //cube.draw(g);
                cube.drawPers(g,600);
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);
        vSlider = new JSlider(SwingConstants.VERTICAL,-90,90,0);
        pane.add(vSlider, BorderLayout.EAST);
        vSlider.addChangeListener(lambda -> {
            int step = vSlider.getValue();
            cube.rotate(0, 0, step);
            pane.repaint();
        });
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /*@Override
    public void paint(Graphics gr)
    {
        Graphics2D g = (Graphics2D)gr;
        g.translate(getWidth()/2, getHeight()/2);
        g.setColor(Color.white);
        g.fillRect(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());
        g.setColor(Color.black);
        //cube.draw(g);
        cube.drawPers(g,600);
    }*/
    public void paint()
    {
        paint(getGraphics());
    }

}
