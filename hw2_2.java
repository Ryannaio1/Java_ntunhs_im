package terst1;

import java.util.Scanner;
import java.util.Random;

public class hw2_2 {
    public static void main(String[] args) {
        Random rand = new Random();
   
        int upperBound = 99;
        int lowerBound = 0;
        int ans = rand.nextInt(upperBound + 1); 
        int guess;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("輸入數字 (" + lowerBound + "-" + upperBound + "): ");
            guess = sc.nextInt();

            if (guess < lowerBound || guess > upperBound) {
                System.out.println("輸入的數字不在範圍內 " + lowerBound + "-" + upperBound + " 。");
            } else if (guess < ans) {
                System.out.println("太小了");
                lowerBound = guess + 1; 
            } else if (guess > ans) {
                System.out.println("太大了");
                upperBound = guess - 1; // 
            } else {
                System.out.println("猜對了");
                break;
            }
        }

        sc.close();
    }
}
