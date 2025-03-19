import java.util.Scanner;

public class ScientificCalculator {
    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("Negative factorial not allowed!");
        long fact = 1;
        for (int i = 1; i <= x; i++) fact *= i;
        return fact;
    }

    public static double naturalLog(double x) {
        if (x <= 0) throw new IllegalArgumentException("Log of non-positive number is not defined.");
        return Math.log(x);
    }

    public static double power(double x, double b) {
        return Math.pow(x, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scientific Calculator Running...");

        while (true) {
            System.out.println("1. Square Root  2. Factorial  3. Logarithm  4. Power  5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                continue;
            }

            double num = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Result: " + squareRoot(num));
                    break;
                case 2:
                    System.out.println("Result: " + factorial((int) num));
                    break;
                case 3:
                    System.out.println("Result: " + naturalLog(num));
                    break;
                case 4:
                    System.out.print("Enter exponent: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid exponent.");
                        scanner.next();
                        continue;
                    }
                    double exp = scanner.nextDouble();
                    System.out.println("Result: " + power(num, exp));
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close();
    }
}
