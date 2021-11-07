package main;

public class Monster {

	private int health;
	private int atk;
	private String name;
	private String description;
	
	public Monster(int health, int atk, String name, String description) {
		this.health = health;
		this.atk = atk;
		this.name = name;
		this.description = description;
	}
	
	public void takeDamage(int damage) {
		this.health -= damage;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String toString() {
		String output = "";
		output += this.getName() + "\n";
		output += "HP: " + this.getHealth() + "\n";
		output += "ATK: " + this.getAtk() + "\n";
		output += this.getDescription() + "\n";
		
		return output;
	}
	
}
