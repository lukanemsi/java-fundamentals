package fop.w7geo;

public class Circle extends BaseArea {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean isSquare() {
        return false;
    }

    @Override
    public Square toSquare() {
        return null;
    }
}
