package fop.w7geo;

public class Square extends BaseArea {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double circumference() {
        return length * 4;
    }

    public double area() {
        return Math.pow(length, 2);
    }

    public boolean isSquare() {
        return true;
    }

    public Square toSquare() {
        return this;
    }
}
