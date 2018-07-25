
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
    static int currentColum = 0;
    static double f;
    static double x;

    static void createTable() {
        int difference = 1;
        while (table.get((currentColum - 1)).size() != 1) {
            int size = table.get((currentColum - 1)).size();
            table.add(new Vector<Double>());
            for (int i = 0; i < (size - 1); i++) {
                int j = i + difference;
                double toAdd = table.get((currentColum - 1)).get(i + 1) - table.get((currentColum - 1)).get(i);
                double denom = table.get(0).get(j) - table.get(0).get(i);
                toAdd /= denom;
                j += 1;
                table.get(currentColum).add(toAdd);
            }
            currentColum += 1;
            difference += 1;
        }
    }

    public static double getX(int xRow) {
        double toReturn = 1;
        for (int i = 0; i < xRow; i++) {
            double multiply = x - table.get(0).get(i);
            toReturn *= multiply;
        }

        return toReturn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        table = new Vector<Vector<Double>>();
        for (int i = 0; i < 2; i++) {
            table.add(new Vector<Double>());

        }
        int sizeOfTable = sc.nextInt();
        x = sc.nextInt();
        for (int i = 0; i < sizeOfTable; i++) {
            table.get(currentColum).add(sc.nextDouble());
        }
        currentColum += 1;
        for (int i = 0; i < sizeOfTable; i++) {
            table.get(currentColum).add(sc.nextDouble());
        }
        currentColum += 1;

        createTable();
        System.out.println("");
        for (int i = 0; i < table.size(); i++) {
            if (i == 0) {
                System.out.print("X:                            ");
            } else if (i == 1) {
                System.out.print("Y:                            ");
            } else {
                System.out.print((i - 1) + "st order divided difference: ");
            }
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        f = table.get(1).get(0);
        int xIndex = 0;
        for (int i = 2; i < table.size(); i++) {
            double toAdd = getX(i - 1);
            toAdd *= table.get(i).get(0);
            f += toAdd;
        }
        System.out.println("f(" + (int) x + ") is " + f);
    }
}
