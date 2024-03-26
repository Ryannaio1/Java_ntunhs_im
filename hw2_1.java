package terst1;

import java.util.Scanner;

public class hw2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        System.out.println("開始健康診斷...");

        System.out.println("發燒？(y/n)");
        answer = scanner.nextLine();
        switch (answer.toLowerCase()) {
            case "y":
                System.out.println("咳嗽？(y/n)");
                answer = scanner.nextLine();
                if ("y".equalsIgnoreCase(answer)) {
                    System.out.println("疲倦？(y/n)");
                    answer = scanner.nextLine();
                    if ("n".equalsIgnoreCase(answer)) {
                        System.out.println("血壓升高？(y/n)");
                        answer = scanner.nextLine();
                        if ("y".equalsIgnoreCase(answer)) {
                            System.out.println("口乾？(y/n)");
                            answer = scanner.nextLine();
                            if ("y".equalsIgnoreCase(answer)) {
                                System.out.println("結論：肝病");
                            } else {
                            	 System.out.println("結論：其他系統");
                            }
                        } else {
                            System.out.println("盜汗？(y/n)");
                            answer = scanner.nextLine();
                            if ("y".equalsIgnoreCase(answer)) {
                                System.out.println("結論：肺病");
                            } else {
                            	System.out.println("結論：其他系統");
                            }
                        }
                    } else {
                    	System.out.println("結論：感冒");
                    }
                } else {
                	System.out.println("結論：其他系統");
                }
                break;
            case "n":
                System.out.println("結論：正常健康  寶寶");
                break;
            default:
                System.out.println("輸入錯誤，請輸入y或n。");
                break;
        }

        scanner.close();
    }
}