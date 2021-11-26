package fop.w7geo;

public class RegularPolygon extends BaseArea {
    private int n;
    private double length;

    public RegularPolygon(int n, double length) {
        this.n = n;
        this.length = length;
    }

    public double circumference() {
        return length * n;
    }

    public double area() {
        return n * Math.pow(n, 2) / (4 * Math.tan(Math.PI / n));
    }

    @Override
    public boolean isSquare() {
        if (n == 4)
            return true;
        else
            return false;
    }

    public Square toSquare() {
        if (isSquare() == true)
            return new Square(length);
        else
            return null;
    }
}
