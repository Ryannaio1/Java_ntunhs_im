package terst1;

import java.util.Scanner;
import java.lang.Math;

public class hw1 {
    static double pv;
    static double fv;
    static final double interest = 0.05;
    static int interval;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input pv: ");
        pv = scanner.nextDouble();
        System.out.print("input interval: ");
        interval = scanner.nextInt();
        fv = pv * Math.pow((1 + interest), interval);
        System.out.println("My pv is " + pv + " and after " + interval + " year it would be " + String.format("%.2f", fv));
        scanner.close();
    }
}
