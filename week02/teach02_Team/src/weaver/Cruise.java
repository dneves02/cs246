package weaver;

public class Cruise implements Expense{

    private Destination country;
    private float cost;

    public Cruise(Destination country) {
        this.country = country;
    }

    @Override
    public float getCost() {

        switch (country) {
            case Mexico:
                cost = 1000;
                break;
            case Europe:
                cost = 2000;
                break;
            case Japan:
                cost = 3000;
                break;
        }
        return cost;
    }
}
