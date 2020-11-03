import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int numCompanies = scanner.nextInt();
        int[] data = new int[numCompanies];

        // get yearly incomes
        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextInt();
        }

        // find max tax
        int maxTaxedCompany = 0;
        double maxTax = 0;
        for (int i = 0; i < data.length; i++) {
            double income = data[i];
            double taxPercent = scanner.nextDouble() / 100;
            double tax = income * taxPercent;
            if (tax > maxTax) {
                maxTax = tax;
                maxTaxedCompany = i + 1;
            }
        }

        System.out.println(maxTaxedCompany);
    }
}