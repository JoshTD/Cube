package com.company;

public class R3Vector {
    private double x, y, z;
    public R3Vector(double x, double y, double z)
    {
        this.x = x; this.y = y; this.z = z;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getZ()
    {
        return z;
    }
    public R3Vector sum(R3Vector v)
    {
        return new R3Vector(x + v.x, y + v.y, z + v.z);
    }
    public static R3Vector sum(R3Vector v1, R3Vector v2)
    {
        return new R3Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }
    public void print()
    {
        System.out.println("x = " + x + ", y = " + y +  ", z = " + z);
    }
    public double length()
    {
        return Math.sqrt(x*x + y*y + z*z);
    }
    public static double cos(R3Vector v1, R3Vector v2)
    {
        return ((v1.x*v2.x + v1.y*v2.y + v1.z*v2.z) / (v1.length()*v2.length()));
    }
    public static double skpr(R3Vector v1, R3Vector v2)
    {
        return v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
    }
    public static R3Vector vkpr(R3Vector v1, R3Vector v2)
    {
        return new R3Vector(v1.y*v2.z - v1.z*v2.y, v1.z*v2.x - v1.x*v2.z, v1.x*v2.y - v1.y*v2.x);
    }
    public void multiple(double k)
    {
        x *= k;
        y *= k;
        z *= k;
    }
    public void moveX(double dx)
    {
        x += dx;
    }
    public void moveY(double dy)
    {
        y += dy;
    }
    public void moveZ(double dz)
    {
        z += dz;
    }
    public void move(double dx, double dy, double dz)
    {
        moveX(dx);
        moveY(dy);
        moveZ(dz);
    }
    public void rotateX(double deg)
    {
        double y0; double z0;
        y0 = y * Math.cos(Math.toRadians(deg)) + z * Math.sin(Math.toRadians(deg));
        z0 = z * Math.cos(Math.toRadians(deg)) - y * Math.sin(Math.toRadians(deg));
        y = y0; z = z0;
    }
    public void rotateY(double deg)
    {
        double x0; double z0;
        x0 = x * Math.cos(Math.toRadians(deg)) + z * Math.sin(Math.toRadians(deg));
        z0 = z * Math.cos(Math.toRadians(deg)) - x * Math.sin(Math.toRadians(deg));
        x = x0; z = z0;
    }
    public void rotateZ(double deg)
    {
        double x0; double y0;
        x0 = x * Math.cos(Math.toRadians(deg)) + y * Math.sin(Math.toRadians(deg));
        y0 = y * Math.cos(Math.toRadians(deg)) - x * Math.sin(Math.toRadians(deg));
        x = x0; y = y0;
    }
    public void rotate(double ux, double uy, double uz)
    {
        rotateX(ux);
        rotateY(uy);
        rotateZ(uz);
    }
    public void out()
    {
        System.out.print("(" + x + ", " + y +  ", " + z + ")");
    }
    public static R3Vector toVector(R3Vector v1, R3Vector v2)
    {
        return new R3Vector(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
    }
}
