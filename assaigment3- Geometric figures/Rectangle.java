package fop.w7geo;

public class Rectangle extends BaseArea {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double circumference() {
        return (width + height) * 2;
    }

    public double area() {
        return width * height;
    }

    public boolean isSquare() {
        if (height == width)
            return true;
        else
            return false;
    }

    public Square toSquare() {
        if (isSquare() == true)
            return new Square(height);
        else
            return null;
    }
}
