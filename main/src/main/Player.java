package main;

import java.util.ArrayList;

public class Player {

	private int health;
	private int atk;
	private int gold;
	private String name;
	
	private ArrayList<Item> inventory;
	
	private int equippedWeapon;
	private int equippedArmor;
	
	public Player(int health, int atk, int gold, String name) {
		this.health = health;
		this.atk = atk;
		this.gold = gold;
		this.name = name;
		
		this.inventory = new ArrayList<Item>();
		
		this.inventory.add(new Item(1));
		this.inventory.add(new Item(2));
		
		equippedWeapon = 0;
		equippedArmor = 1;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getAtk() {
		return this.inventory.get(this.equippedWeapon).getAtk();
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String viewInventory() {
		String out = "";
		for(Item i : this.inventory) {
			out += i.toString();
			out += "\n";
		}
		return out;
	}
	
	public void addItem(Item i) {
		this.inventory.add(i);
	}
	
	public String toString() {
		String output = "";
		output += this.getName() + "\n";
		output += "Health: " + this.getHealth() + "\n";
		output += "Atk: " + this.getAtk() + "\n";
		output += "Gold: " + this.getGold() + "\n\n";
		
		output += "Inventory: \n";
		output += this.viewInventory();
		
		return output;
	}
	
}
