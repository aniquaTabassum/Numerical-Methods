
import java.util.Scanner;

public class Main {

    static int[] coef;

    public static double horner(double value, int degree) {
        double result = coef[0];
        for (int i = 1; i <= degree; ++i) {
            result = result * value + coef[i];
        }
        return result;

    }

    public static double f(double x) {
        return x * x * x - 4 * x * x + x + 6;
    }

    public static double derivative(double x) {
        return 3 * x * x - 8 * x + 1;
    }

    public static double error(double x1, double x0) {
        return java.lang.Math.abs((x1 - x0) / x0);
    }

    public static void main(String[] args) {
        System.out.println("Enter the degree of the equation: ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        coef = new int[n + 1];
        System.out.println("Enter the coeffeceients:");
        for (int i = 0; i <= n; i++) {
            coef[i] = sc.nextInt();
        }
        double x0 = 0;
        double e = 0.00001;
        double fx0 = 1;
        double fPrimeX0 = 1;
        double x1 = sc.nextDouble();
        double determinedError = 1;
        while (determinedError > e) {
            System.out.println("entered");
            x0 = x1;
            fx0 = horner(x0, n);
            fPrimeX0 = derivative(x0);
            x1 = x0 - (fx0 / fPrimeX0);
            determinedError = error(x1, x0);

        }
        System.out.println("The root is " + x0);
    }
}
