import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TaxWithholdingCalculator {

    // Return tax rate based on weekly income
    public static double getTaxRate(double income) {
        if (income < 500) {
            return 0.10;
        } else if (income < 1500) {
            return 0.15;
        } else if (income < 2500) {
            return 0.20;
        } else {
            return 0.30;
        }
    }

    // Return a label for the tax bracket
    public static String getTaxBracketLabel(double income) {
        if (income < 500) {
            return "10% (Income < $500)";
        } else if (income < 1500) {
            return "15% ($500 - $1,499.99)";
        } else if (income < 2500) {
            return "20% ($1,500 - $2,499.99)";
        } else {
            return "30% (Income >= $2,500)";
        }
    }

    // Prompt user for a valid non-negative income value
    public static double getValidIncome(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.next());
                if (value < 0) {
                    System.out.println("Income cannot be negative. Please try again.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=".repeat(55));
        System.out.println("       WEEKLY TAX WITHHOLDING CALCULATOR");
        System.out.println("=".repeat(55));

        int numWeeks = 0;
        while (true) {
            System.out.print("\nHow many weeks of income to enter? ");
            try {
                numWeeks = Integer.parseInt(scanner.next());
                if (numWeeks <= 0) {
                    System.out.println("Please enter a positive number of weeks.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }

        List<Double> incomes = new ArrayList<>();
        List<Double> withholdings = new ArrayList<>();
        double totalIncome = 0;
        double totalWithholding = 0;

        for (int i = 1; i <= numWeeks; i++) {
            double income = getValidIncome(scanner, "Enter income for week " + i + ": $"); // FIX: added missing comma
            double taxRate = getTaxRate(income);
            double withholding = income * taxRate;

            incomes.add(income);
            withholdings.add(withholding);
            totalIncome += income;
            totalWithholding += withholding;

            System.out.printf("  Bracket: %s, Tax: $%.2f%n", getTaxBracketLabel(income), withholding);
        }

        if (numWeeks > 0) {
            System.out.println("\n" + "=".repeat(30));
            System.out.printf("Summary (Average per week):%n");
            System.out.printf("Avg Income: $%.2f%n", totalIncome / numWeeks);
            System.out.printf("Avg Withholding: $%.2f%n", totalWithholding / numWeeks);
            System.out.println("=".repeat(30));
        }

        scanner.close();
    }
}
