package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return p;
    }

    public boolean exist(double ap, double bp, double cp) {
        if ((ap + bp) > cp & (ap + cp) > bp & (cp + bp) > ap) {
            return true;
        } else {
            return false;
        }
    }

    public double area() {
        double result = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);

            double areaTriangle = sqrt(p * (p - ab) * (p - ac) * (p - bc));
            result = areaTriangle;
        }
        return result;
    }
}