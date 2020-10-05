package weaver;

import java.util.ArrayList;
import java.util.List;

public class VacationCalculator {

    public static void main(String[] args) {
        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        int nights = 5;
        float japanCost = vc.calculateVacationCost(Destination.Japan, nights);
        float europeCost = vc.calculateVacationCost(Destination.Europe, nights);
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico, nights);
        System.out.println("Cost for cruise to Japan: $" + japanCost);
        System.out.println("Cost for cruise to Europe: $" + europeCost);
        System.out.println("Cost for cruise to Mexico: $" + mexicoCost);
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest, int nights)
    {
        Cruise myCruise = new Cruise(dest);
        Dining dine = new Dining(dest, nights);
        Lodging lodge = new Lodging(dest, nights);

        List<Expense> expense = new ArrayList<>();
        expense.add(myCruise);
        expense.add(dine);
        expense.add(lodge);

        return tallyExpenses(expense);
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param  expenses A list of items that implement the Expense interface
     * @return          the total cost calculated by the items
     */
    float tallyExpenses(List<Expense> expenses)
    {
        float totalExpense = 0;
        for (Expense expense : expenses) {
            totalExpense += expense.getCost();
        }
        return totalExpense;
    }

}
