package dneves;

import java.util.List;
import java.util.ArrayList;

public class VacationCalculator {

    private int totalNights = 5;

    public static void main(String[] args) {
        // write your code here
        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float japanCost = vc.calculateVacationCost(Destination.Japan);
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico);
        float europeCost = vc.calculateVacationCost(Destination.Europe);

        // Print the cost...
        System.out.format(String.format("Total cost for trip to Japan:  $%.2f%n", japanCost));
        System.out.format(String.format("Total cost for trip to Mexico: $%.2f%n", mexicoCost));
        System.out.format(String.format("Total cost for trip to Europe: $%.2f%n", europeCost));

        System.out.format("The cost of this vacation is %f.%n", japanCost);
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest)
    {
        List<Expense> itinerary = new ArrayList<Expense>();
        itinerary.add(new Cruise(dest));
        itinerary.add(new Dining(dest, totalNights));
        itinerary.add(new Lodging(dest, totalNights));

        float totalCost = tallyExpenses(itinerary);
        return totalCost;
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param  expenses A list of items that implement the Expense interface
     */
    private float tallyExpenses(List<Expense> expenses)
    {
        float totalCost = 0;

        for(Expense e : expenses) {
            totalCost += e.getCost();
        }

        return totalCost;
    }

}
