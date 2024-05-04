package terst1;

import java.util.Scanner;

public class hw5_1main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	hw5_1 card = new hw5_1("ntunhs001", 1000, 0); 

        while (true) {
            System.out.println("1. 儲值");
            System.out.println("2. 扣款");
            System.out.println("3. 兌換紅利");
            System.out.println("4. 查看明細");
            System.out.println("0. 退出");
            System.out.print("請輸入選項: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("請輸入儲值金額: ");
                    double amountToAdd = scanner.nextDouble();
                    card.addValue(amountToAdd);
                    break;
                case 2:
                    System.out.print("請輸入扣款金額: ");
                    double amountToCharge = scanner.nextDouble();
                    if (!card.charge(amountToCharge)) {
                        System.out.println("餘額不足！");
                    }
                    break;
                case 3:
                    System.out.print("請輸入要兌換的紅利點數: ");
                    int bonusToExchange = scanner.nextInt();
                    if (!card.exchangeBonus(bonusToExchange)) {
                        System.out.println("紅利點數不足！");
                    }
                    break;
                case 4:
                    card.printDetails();
                    break;
                case 0:
                    System.out.println("感謝使用儲值卡系統。");
                    scanner.close();
                    return;
                default:
                    System.out.println("無效的選項！");
            }
        }
    }
}
