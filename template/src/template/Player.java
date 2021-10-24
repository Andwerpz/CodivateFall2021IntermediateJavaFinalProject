package template;

public class Player {
	
	private String name;
	private int health;
	private int attack;
	private int gold;
	
	public Player(String name) {
		this.name = name;
		this.health = 20;
		this.attack = 5;
		this.gold = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		String output = "";
		output += "Health: " + this.health + "\n";
		output += "Attack: " + this.attack + "\n";
		output += "Gold: " + this.gold + "\n";
		return output;
	}
	
}
