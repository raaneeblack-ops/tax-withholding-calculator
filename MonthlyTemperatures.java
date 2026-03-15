import java.util.Scanner;

/**
 * MonthlyTemperatures.java
 * Stores monthly average temperatures for a year using two parallel arrays.
 * Allows the user to query a specific month or view the full year summary.
 */
public class MonthlyTemperatures {

    public static void main(String[] args) {

        // --- Array Declarations ---
        String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };

        double[] temperatures = {
            34.2, 37.8, 48.5, 58.3,
            67.1, 76.4, 82.9, 81.3,
            72.6, 61.0, 48.7, 36.5
        };

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("============================================");
        System.out.println("     Monthly Temperature Lookup Program     ");
        System.out.println("============================================");

        // --- Main Loop ---
        while (keepRunning) {
            System.out.println("\nEnter a month name (e.g., January), 'year' for full summary, or 'quit' to exit:");
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            // --- Decision: quit ---
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                keepRunning = false;

            // --- Decision: year summary ---
            } else if (input.equalsIgnoreCase("year")) {
                displayYearSummary(months, temperatures);

            // --- Decision: specific month ---
            } else {
                displayMonth(input, months, temperatures);
            }
        }

        scanner.close();
    }

    /**
     * Searches for the entered month and prints its temperature.
     */
    static void displayMonth(String input, String[] months, double[] temperatures) {
        boolean found = false;

        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(input)) {
                System.out.printf("%n  Month      : %s%n", months[i]);
                System.out.printf("  Avg Temp   : %.1f°F%n", temperatures[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("  Month not recognized. Please enter a full month name (e.g., March).");
        }
    }

    /**
     * Displays all 12 months with their temperatures, then shows
     * the yearly average, the highest monthly average, and the lowest.
     */
    static void displayYearSummary(String[] months, double[] temperatures) {
        double total = 0;
        double highest = temperatures[0];
        double lowest  = temperatures[0];
        int    highIdx = 0;
        int    lowIdx  = 0;

        System.out.println("\n============================================");
        System.out.println("          Full Year Temperature Report      ");
        System.out.println("============================================");
        System.out.printf("  %-12s  %s%n", "Month", "Avg Temp (°F)");
        System.out.println("  ------------  -------------");

        // --- Loop: accumulate stats and print each month ---
        for (int i = 0; i < months.length; i++) {
            System.out.printf("  %-12s  %.1f°F%n", months[i], temperatures[i]);
            total += temperatures[i];

            if (temperatures[i] > highest) {
                highest = temperatures[i];
                highIdx = i;
            }
            if (temperatures[i] < lowest) {
                lowest = temperatures[i];
                lowIdx = i;
            }
        }

        double yearlyAvg = total / temperatures.length;

        System.out.println("  ------------  -------------");
        System.out.printf("  %-12s  %.1f°F%n", "Yearly Avg", yearlyAvg);
        System.out.printf("%n  Highest Avg  : %s at %.1f°F%n", months[highIdx], highest);
        System.out.printf("  Lowest Avg   : %s at %.1f°F%n",  months[lowIdx],  lowest);
        System.out.println("============================================");
    }
}
