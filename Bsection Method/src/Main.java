
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = 0;
        double x2 = 0;
        double error = 0.001;
        double f1 = 1;
        double f2 = 1;
        while (f1 * f2 > 0) {
            System.out.println("enter x1 and x2");
            x1 = sc.nextDouble();
            x2 = sc.nextDouble();
            f1 = f(x1);
            f2 = f(x2);
            if (f1 * f2 > 0) {
                System.out.println("Invalid");
            }
        }
        //System.out.println("f1 and f2 is "+f1+" "+f2);
        double root = 1;
        while (root > error) {
            double x0 = (x1 + x2) / 2;
            double f0 = f(x0);

            if (f0 == 0) {
                System.out.println("The root is " + x0);
                return;
            }
            if (f1 * f0 < 0) {
                x2 = x0;
            } else {
                x1 = x0;
            }
            root = r(x1, x2);
            //System.out.println("root is "+root);
        }
        System.out.println("root is " + (x1 + x2) / 2);
    }

    public static double f(double y) {

        return 3 * y - java.lang.Math.cos(Math.toRadians(y)) - 1;
    }

    public static double r(double x1, double x2) {
        return java.lang.Math.abs((x2 - x1) / x2);
    }
}
