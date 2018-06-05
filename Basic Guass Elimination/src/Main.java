
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

    public static void normalise(int i) {
        double coef = equations.get(i).get(i);
        for (int j = 0; j <= number; j++) {
            temp.add(equations.get(i).get(j));
        }
        //System.out.println(temp);
        for (int j = i; j <= number; j++) {
            double tempCoef = temp.get(j);
            temp.set(j, (tempCoef / coef));
        }
    }
    public static void delete(int i) {
        if(equations.get(i).get(i) == 0)
            return;
        for (int j = i + 1; j < number; j++) {
            normalise(i);
            double tempCoef = equations.get(j).get(i);
            tempCoef *= (-1);
            for (int k = i; k <= 3; k++) {
                double current = temp.get(k);
                temp.set(k, tempCoef * current);
            }
            for (int k = i; k <= 3; k++) {
                double first = temp.get(k);
                first += equations.get(j).get(k);
                equations.get(j).set(k, first);
            }
            temp.removeAllElements();
        }
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
            delete(j);
        }
        for (int i = 0; i < number; i++) {
            System.out.println("");
            for (int j = 0; j < equations.get(i).size(); j++) {
                System.out.print(equations.get(i).get(j) + " ");
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        for (int i = (number - 1); i >= 0; i--) {
            double toStore = equations.get(i).get(number);
            int j = number - 1;
            for (; j >i && i != (number - 1); j--) {
                double currentResult = result[j];
                double currentEqu = equations.get(i).get(j);
                if(currentEqu!=0){
                double product = currentEqu * currentResult;
                toStore -= product;}
            }        
            toStore = toStore / equations.get(i).get(j);
            result[i] = toStore;
        }
        System.out.println("");
        for (int i = 0; i < number; i++) {
            System.out.println((result[i]) + " ");
        }
    }
}
