package weaver;

public class Lodging implements Expense{
    private Destination dest;
    private int nights;

    public Lodging(Destination dest, int nights) {
        this.dest = dest;
        this.nights = nights;
    }
    @Override
    public float getCost() {

        float cost = 0;

        switch (dest) {
            case Mexico:
                cost = 100 * nights;
                break;
            case Europe:
                cost = (float) 1.1*(200 * nights);
                break;
            case Japan:
                cost = (float) 1.3*(300 * nights);
                break;
        }
        return cost;
    }
}
