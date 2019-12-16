package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        double x = 10.1, y = 20.2, z = 30.3;
        R3Vector v = new R3Vector(x, y, z);
        R3Vector v1 = new R3Vector(x+10, y+10, z+10);
        R3Vector v2 = v.sum(v1);
        R3Vector v3 = v.sum(v1).sum(v2);
        R3Vector v4 = v.sum(v1).sum(v2.sum(v3));
        R3Vector v5 = R3Vector.sum(v3, v4);
        R3Vector v6 = R3Vector.sum(v3, v4).sum(v5);
        x = 0; y = 0; z = 0;
        v.print();
        v1.print();
        v2.print();
        v3.print();
        v4.print();
        v5.print();
        v6.print();
        System.out.println(R3Vector.skpr(v1, v2));
        R3Vector v7 = R3Vector.vkpr(v, v1);
        v7.print();
        v2.multiple(5);
        v1.multiple(5);
        v2.print();
        v1.print();
        v1.moveX(-100);
        v1.moveZ(50);
        v1.print();
        R3Vector v0 = new R3Vector(10, 0, 0);
        v0.rotateY(45);
        v0.print();
        v0.rotate(45, 30 ,90);
        v0.print();
        v0.rotateY(90);
        v0.print();
        v0.rotateZ(90);
        Facet f = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0), new R3Vector(0,1,0));
        f.print();
        f.VNormal().print();
        f.print();
        Cube c = new Cube();
        c.scale(200);
        c.translate(-50, -50, -50);
        c.rotate(125,125,125);
        Viewer viewer = new Viewer(c);
    }
}
