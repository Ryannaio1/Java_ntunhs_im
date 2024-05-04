package terst1;

public class hw5_1 {
	   
	    private String cardId;
	    private double balance;
	    private int bonus;
	    private static int totalCardNum = 0; 

	   
	    public hw5_1(String cardId, double balance, int bonus) {
	        this.cardId = cardId;
	        this.balance = balance;
	        this.bonus = bonus;
	        totalCardNum++;
	    }

	
	    public String getCardId() {
	        return cardId;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public int getBonus() {
	        return bonus;
	    }

	    public static int getTotalCardNum() {
	        return totalCardNum;
	    }

	   
	    public void addValue(double amount) {
	        if (amount > 0) {
	            this.balance += amount;
	        }
	    }

	    public boolean charge(double amount) {
	        if (amount <= balance) {
	            this.balance -= amount;
	            return true;
	        } else {
	            return false;
	        }
	    }

	
	    public boolean exchangeBonus(int points) {
	        if (points <= bonus) {
	            this.bonus -= points;
	            return true;
	        } else {
	            return false;
	        }
	    }

	
	    public void printDetails() {
	        System.out.println("Card ID: " + cardId);
	        System.out.println("Balance: " + balance);
	        System.out.println("Bonus: " + bonus);
	    }
	}

