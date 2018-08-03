
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aniqua
 */
public class Main {

    static int[] coef;

    public static double f(double x, int degree) {
        double result = coef[0];
        for (int i = 1; i <= degree; i++) {
            result = result * x + coef[i];
        }
        return result;
    }

    public static double error(double x2, double x3) {
        return java.lang.Math.abs((x3 - x2) / x3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the degree: ");
        int degree = sc.nextInt();
        System.out.println("Enter the co efficients: ");
        coef = new int[degree + 1];
        for (int i = 0; i <= degree; i++) {
            coef[i] = sc.nextInt();
        }
        double error = 0.001;
        double e = 1;
        System.out.println("enter x1 and x2");
        double x1;
        double x2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double f2 = f(x2, degree); 
        double f3 = f(x3, degree);
        double f1=0;
        while (e > error) {
            
            x1 = x2;
            f1 = f(x2,degree);
            x2 = x3;
            f2 = f(x3,degree);
            x3 = (f2 * x1 - f1 * x2) / (f2 - f1);
            e = error(x2, x3);
        }
        System.out.println("root is " + x3);
    }
}
