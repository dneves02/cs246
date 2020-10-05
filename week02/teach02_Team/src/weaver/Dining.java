package weaver;

public class Dining implements Expense{
    private Destination dest;
    private int nights;

    public Dining(Destination dest, int nights) {
        this.dest = dest;
        this.nights = nights;
    }
    @Override
    public float getCost() {
        float cost = 0;

        switch (dest) {
            case Mexico:
                cost = 10 * nights;
                break;
            case Europe:
                cost = 20 * nights;
                break;
            case Japan:
                cost = 30 * nights;
                break;
        }
        return cost;
    }
}
