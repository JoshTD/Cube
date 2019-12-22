package com.company;

import javax.swing.*;
import javax.swing.event.*;

public class Controller {
    private Cube cube;
    private Viewer viewer;
    private JSlider vSlider;
    public Controller(Cube cube, Viewer viewer)
    {
        this.cube = cube;
        this.viewer = viewer;
        vSlider = viewer.vSlider;
        vSlider.addChangeListener(lambda -> {
            int step = vSlider.getValue();
            cube.rotate(0, 0, step);
            viewer.repaint();
        });
    }
}
