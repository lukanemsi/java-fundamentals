package fop.w5zoo;

public class Vivarium
{
    private Animal[] inhabitants;
    private int area;
    private int constructionYear;

    public Vivarium(Animal[] inhabitants, int area, int constructionYear)
    {
        this.inhabitants = inhabitants;
        this.area = area;
        this.constructionYear = constructionYear;
    }
    public String toString()
    {
        return "[area: " + area + ", constructionyear: " + constructionYear + ", animals: " + inhabitants.toString() + "]";
    }
    public int getCost()
    {
        int maintenanceCosts;
        int foodCostSum = 0;

        for (int i = 0; i < inhabitants.length; i++)
        {
            foodCostSum = foodCostSum + inhabitants[i].getFoodCost();
        }
        maintenanceCosts = 900 + area * 100 + area * ( constructionYear * 5);

        return maintenanceCosts + foodCostSum;
    }

}
