
import com.sun.javafx.fxml.BeanAdapter;
import java.util.Scanner;

class Main {

    static int degree;
    static int[] coefficients;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the degree of the equation: ");
        degree = sc.nextInt();
        coefficients = new int[degree + 1];
        System.out.println("enter the co efficients from highest degree: ");
        for (int i = 0; i <=degree; i++) {
            coefficients[i] = sc.nextInt();
        }
        double x1 = 0;
        double x2 = Integer.MIN_VALUE;
        double error = 0.001;
        double f1 = 1;
        double f2 = 1;
        double a = 0;
        double b = 0;
        System.out.println("Enter the value of a and b");
        a = sc.nextDouble();
        b = sc.nextDouble();
        System.out.println("Enter the value of incremental interval: ");
        double delX = sc.nextDouble();
        while (x2 < b) {
            boolean found = false;
            x1 = a;
            x2 = x1 + delX;
            f1 = f(x1);
            f2 = f(x2);
            if (f1 * f2 < 0) {
                double root = 1;

                while (root > error) {
                    f1 = f(x1);
                    f2 = f(x2);
                    double x0 = (x1 + x2) / 2;
                    double f0 = f(x0);
                    found = true;
                    if (f0 == 0) {
                        System.out.println("The root is " + x0);
                        break;
                    }
                    if (f1 * f0 < 0) {
                        x2 = x0;
                    } else {
                        x1 = x0;
                    }
                    root = r(x1, x2);
                    //System.out.println("root is "+root);
                }
                if (found == true) {
                    System.out.println("root between "+x1+" and "+x2+" is " + (x1 + x2) / 2);
                }

            }
            a = x2;

        }
        //System.out.println("f1 and f2 is "+f1+" "+f2);

    }

    public static double f(double value) {
         double result = coefficients[0];
        for (int i = 1; i <= degree; ++i) {
            result = result * value + coefficients[i];
        }
        return result;

    }

    public static double r(double x1, double x2) {
        return java.lang.Math.abs((x2 - x1) / x2);
    }
}
