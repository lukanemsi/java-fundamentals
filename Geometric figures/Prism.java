package fop.w7geo;

public abstract class Prism {
    private double height;
    private BaseArea base;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public BaseArea getBase() {
        return base;
    }

    public void setBase(BaseArea base) {
        this.base = base;
    }
    public double surface(){
        return height * base.circumference() * 2*base.area();
    }
    public double volume(){
        return base.area() * height / 2;
    }
    public boolean isCube(){
        if(base.isSquare() == true )
            return true;
        else
            return false;
    }
}


