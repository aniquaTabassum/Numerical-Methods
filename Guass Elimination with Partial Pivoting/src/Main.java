
import com.sun.javafx.fxml.BeanAdapter;
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

    static Vector<Vector<Double>> equations;
    static int number;
    static Vector<Double> temp;
    static double[] result;
    static double highest;
    static int pivot;
    static int flag;
    static double error;

    public static void findPivot(int i) {
        highest = equations.get(i).get(i);
        pivot = i;
        for (int j = i; j < number; j++) {
            if (java.lang.Math.abs(equations.get(j).get(i)) > highest) {
                highest = java.lang.Math.abs(equations.get(j).get(i));
                pivot = j;
            }
        }
    }

    public static void swapRows(int i) {

        Vector<Double> changeingPivot = new Vector<Double>();
        for (int k = 0; k <= number; k++) {
            changeingPivot.add(equations.get(i).get(k));
        }
        for (int k = 0; k <= number; k++) {
            equations.get(i).set(k, equations.get(pivot).get(k));
        }
        for (int k = 0; k <= number; k++) {
            equations.get(pivot).set(k, changeingPivot.get(k));
        }
    }

    public static void setPivot(int i) {
        findPivot(i);
        if (pivot != i) {
            swapRows(i);
        }
    }

    public static void initialiseTemp(int i) {
        for (int j = 0; j <= number; j++) {
            temp.add(equations.get(i).get(j));
        }
    }

    public static void normaliseTemp(int i, double coef) {
        for (int j = i; j <= number; j++) {
            double tempCoef = temp.get(j);
            temp.set(j, (tempCoef / coef));
        }
    }

    public static void normalise(int i) {
        double coef = equations.get(i).get(i);
        initialiseTemp(i);
        normaliseTemp(i, coef);
    }

    public static void multiplyTheNormalised(int i, int j) {
        double tempCoef = equations.get(j).get(i);
        tempCoef *= (-1);
        for (int k = i; k <= 3; k++) {
            double current = temp.get(k);
            temp.set(k, tempCoef * current);
        }
    }

    public static void deleteTheCoeffs(int i, int j) {
        for (int k = i; k <= 3; k++) {
            double first = temp.get(k);
            first += equations.get(j).get(k);
            equations.get(j).set(k, first);
            if (java.lang.Math.floor(first) != first) {
                flag = 1;
            }
        }
    }

    public static void toInteger(int i, int j) {
        double convertToInteger = equations.get(i).get(i);
        for (int k = i; k <= 3; k++) {
            double multiply = equations.get(j).get(k);
            equations.get(j).set(k, multiply * convertToInteger);
        }
    }

    public static void delete(int i) {
        if (equations.get(i).get(i) == 0) {
            return;
        }
        for (int j = i + 1; j < number; j++) {
            normalise(i);
            flag = 0;
            multiplyTheNormalised(i, j);
            deleteTheCoeffs(i, j);
            temp.removeAllElements();
            if (flag == 0) {
                return;
            }
            toInteger(i, j);
        }
    }

    public static void backTrack(int i) {
        double toStore = equations.get(i).get(number);
        int j = number - 1;
        for (; j > i && i != (number - 1); j--) {
            double currentResult = result[j];
            double currentEqu = equations.get(i).get(j);
            if (currentEqu != 0) {
                double product = currentEqu * currentResult;
                toStore -= product;
            }
        }
        toStore = toStore / equations.get(i).get(j);
        toStore = checkForError(toStore);
        result[i] = toStore;
    }

    public static double checkForError(double toStore) {
        double checkingError = toStore - (java.lang.Math.floor(toStore));
        if (checkingError < error) {
            toStore = java.lang.Math.floor(toStore);
        } else {
            checkingError = (java.lang.Math.ceil(toStore)) - toStore;
            if (checkingError < error);
            toStore = java.lang.Math.ceil(toStore);
        }
        return toStore;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of equations: ");
        number = sc.nextInt();
        equations = new Vector<Vector<Double>>(number);
        for (int i = 0; i < number; i++) {
            equations.add(new Vector<Double>());
        }
        result = new double[number + 1];
        temp = new Vector<Double>();
        System.out.println("enter the coefficients");
        for (int i = 0; i < number; i++) {
            for (int j = 0; j <= 3; j++) {
                equations.get(i).add(sc.nextDouble());
            }
        }
        for (int j = 0; j < number - 1; j++) {
            setPivot(j);
            delete(j);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        error = 0.00001;
        for (int i = (number - 1); i >= 0; i--) {
            backTrack(i);
        }
        System.out.println("");
        for (int i = 0; i < number; i++) {
            System.out.println((result[i]) + " ");
        }
    }
}
