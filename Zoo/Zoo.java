package fop.w5zoo;

public class Zoo {
	private Vivarium[] vivaria;

    public Zoo(Vivarium[] vivaria)
    {
        this.vivaria = vivaria;
    }
    public String toString()
    {
        return "{" + vivaria.toString() + "}";
    }
    public int getCost()
    {
        int sumOfTotalCosts = 0;
        for (int i = 0; i < vivaria.length; i++) {
            sumOfTotalCosts = sumOfTotalCosts + vivaria[i].getCost();
        }
        return sumOfTotalCosts;
    }
}
