
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Main {
    static double xSum;
    static double ySum;
    static double x2Sum;
    static double xySum;
    static double n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            xSum+=x;
            ySum+=y;
            xySum += (x*y);
            x*=x;
            x2Sum+= x;
        }
        System.out.println(xSum+" "+ySum+" "+x2Sum+" "+xySum);
        double tempX2 = n*x2Sum;
        double tempx = xSum*xSum;
        double denm = tempX2 - tempx;
        if(denm == 0)
        {
            System.out.println("Not possible");
            return;
        }
        double tempxy = n*xySum;
        double xAndY = xSum*ySum;
        tempxy-=xAndY;
        double b = tempxy/denm;
        
        double a1 = ySum/n;
        double a2 = xSum/n;
        a2*=b;
        double a = a1-a2;
        System.out.printf("%.1f x + %.1f",a,b);
    }
}
