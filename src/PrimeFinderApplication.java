import java.util.Arrays;
import java.util.Scanner;

public class PrimeFinderApplication {

    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        double number = inputNumber();
        PrimeFinderApplication.printAllPrimeNumbersLessThanInput(number);
    }

    private static void printAllPrimeNumbersLessThanInput(final double n) {
        boolean[] primeArr = new boolean[(int) (n + 1)];
        Arrays.fill(primeArr, true);
        primeArr[0] = primeArr[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primeArr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primeArr[j] = false;
                }
            }
        }

        for (int k = 2; k <= n; k++) {
            if (primeArr[k]) {
                System.out.printf("%d ", k);
            }
        }
    }

    private static double inputNumber() {
        System.out.println("\nPlease provide a number greater than 1 so that system prints all the smaller prime numbers: ");
        String input;
        double number = 0;

        input = scanner.nextLine();

        try {
            number = Double.parseDouble(input);
            if (number <= 1) {
                System.out.printf("%s is not a valid input. Please provide a number greater than 1.", number);
                System.exit(1);
            }

        } catch (NumberFormatException e) {
            System.out.printf("%s is not a number.", input);
            System.exit(1);
        }
        return number;
    }
}