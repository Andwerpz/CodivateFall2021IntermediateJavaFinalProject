package template;

import java.util.ArrayList;

public class Player {
	
	private int maxHealth = 20;
	
	private String name;
	private int health;
	private int gold;
	private int level;	//leveling up makes it so that you can use higher leveled equipment
	private int exp;
	
	private ArrayList<Item> inventory;
	
	private boolean weaponEquipped;
	private int equippedWeapon;
	private boolean armorEquipped;
	private int equippedArmor;
	
	public Player(String name) {
		this.name = name;
		this.health = this.maxHealth;
		this.gold = 0;
		this.level = 1;
		this.exp = 0;
		
		this.inventory = new ArrayList<Item>();
		this.inventory.add(new Item(1));
		this.inventory.add(new Item(2));
		this.equippedWeapon = 0;
		this.equippedArmor = 1;
		this.armorEquipped = true;
		this.weaponEquipped = true;
	}
	
	public void heal(int healAmt) {
		this.health += healAmt;
		this.health = Math.max(this.health, this.maxHealth);
		System.out.println("You were healed for " + healAmt + " HP. Your current health is " + this.health);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAttack() {
		return this.inventory.get(equippedWeapon).getAttack();
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	public ArrayList<Item> getInventory() {
		return this.inventory;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getExp() {
		return this.exp;
		
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public void addExp(int exp) {
		this.exp += exp;
		if(this.exp >= this.getExpToNextLevel()) {
			this.exp -= this.getExpToNextLevel();
			this.level ++;
			System.out.println("You Leveled Up! You are now level " + this.level);
		}
	}
	
	public void addGold(int gold) {
		this.gold += gold;
	}
	
	public int getExpToNextLevel() {
		int expToNextLevel = (int) (Math.pow(this.level, 2)) * 10 - this.level;
		return expToNextLevel;
	}
	
	public String toString() {
		String output = "";
		output += "Level: " + this.level + "\n";
		output += "HP: " + this.getHealth() + "/" + this.getMaxHealth() + "\n";
		output += "ATK: " + this.getAttack() + "\n";
		output += "Gold: " + this.getGold() + "\n";
		output += "EXP: " + this.getExp() + "/" + (this.getExpToNextLevel()) + "\n";
		
		if(this.weaponEquipped && this.equippedWeapon >= 0 && this.equippedWeapon < this.inventory.size()) {
			output += "\n" + "Equipped Weapon:" + "\n";
			output += this.inventory.get(this.equippedWeapon);
		}
		
		if(this.armorEquipped && this.equippedArmor >= 0 && this.equippedArmor < this.inventory.size()) {
			output += "\n" + "Equipped Armor:" + "\n";
			output += this.inventory.get(this.equippedArmor);
		}
		 
		return output;
	}
	
}
