
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aniqua Tabassum
 */
public class Main {

    static Vector<Vector<Double>> table;
    static double f;
    static double x;
    static int sizeOfTable;

    public static void findValue() {
        f = 0;
        for (int i = 0; i < sizeOfTable; i++) {
            double xi = table.get(0).get(i);
            double num = 1;
            double denom = 1;
            double divide = 1;
            for (int j = 0; j < sizeOfTable; j++) {
                if (j != i) {
                    double numTemp = x - table.get(0).get(j);
                    num *= numTemp;
                    double denomTemp = xi - table.get(0).get(j);
                    denom *= denomTemp;
                }

            }
            divide = num / denom;
            divide *= table.get(1).get(i);
            f += divide;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        table = new Vector<Vector<Double>>();
        for (int i = 0; i < 2; i++) {
            table.add(new Vector<Double>());

        }
        sizeOfTable = sc.nextInt();
        x = sc.nextInt();
        for (int i = 0; i < sizeOfTable; i++) {
            table.get(0).add(sc.nextDouble());
        }

        for (int i = 0; i < sizeOfTable; i++) {
            table.get(1).add(sc.nextDouble());
        }

        findValue();
        System.out.println("f is " + f);

    }

}
