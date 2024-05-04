package terst1;

abstract class Character{ //可更改檔名解決
	protected String name;
	protected int health;
	protected int attackPower;
	
	public Character(String name,int health,int attackPower) {
		this.name=name;
		this.health=health;
		this.attackPower=attackPower;
	}
	public void attack(Character other) {
		other.takeDamage(attackPower);
	}
	public void takeDamage(int damage) {
		health-=damage;
		System.out.println(name+"受到"+damage+"傷害，剩餘生命:"+health);
	}
}
class Warrior  extends Character{
	private int defense;
	public Warrior(String name,int health,int attackPower,int defense) {
		super(name,health,attackPower);
		this.defense=defense;
	} 
	public void useShield() {
		defense+=10;
		System.out.println(name+"使用shield，防禦力增至"+defense);
	}
	
	public void display() {
		System.out.println("戰士名稱："+name+"，生命值"+health+"，攻擊力："+attackPower+",防禦力："+defense);
	}
}
class Mage extends Character{
	private int mana;
	public Mage(String name,int health,int attackPower,int mana) {
		super(name,health,attackPower);
		this.mana=mana;
	} 
	public void castSpell(Character other) {
		if(mana>=20) {
			int spellDamage=attackPower*2;
			other.takeDamage(spellDamage);
			mana-=20;
			System.out.println(name+"施放法術，造成"+spellDamage+"傷害");
		}else {
			System.out.println(name+"mana不足");
		}
	}
	public void display() {
		System.out.println("法師名稱："+name+"，生命值"+health+"，攻擊力："+attackPower+",魔力："+mana);
	}
}
public class hw8 {
	public static void main(String[] args) {
		Warrior warrior =new Warrior("戰士A",100,15,5);
		Mage mage=new Mage("法師B",80,10,50);
		
		mage.castSpell(warrior);
		warrior.useShield();
		warrior.attack(mage);
		mage.display();
		warrior.display();
	}
}
