package fop.w5zoo;

public class Animal
{
    private String name;
    private int foodCost;
    Animal(String name, int foodCosts)
    {
        this.name = name;
        this.foodCost = foodCosts;
    }
    public String toString()
    {
        return "(name: " + name + ", foodcost: " + foodCost + " )";
    }
    public int getFoodCost() {
        return foodCost;
    }

    public String getName() {
        return name;
    }
}
