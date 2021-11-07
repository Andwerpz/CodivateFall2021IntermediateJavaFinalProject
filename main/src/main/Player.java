package main;

public class Player {

	private int health;
	private int atk;
	private int gold;
	private String name;
	
	public Player(int health, int atk, int gold, String name) {
		this.health = health;
		this.atk = atk;
		this.gold = gold;
		this.name = name;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		String output = "";
		output += this.getName() + "\n";
		output += "Health: " + this.getHealth() + "\n";
		output += "Atk: " + this.getAtk() + "\n";
		output += "Gold: " + this.getGold() + "\n";
		
		return output;
	}
	
}
