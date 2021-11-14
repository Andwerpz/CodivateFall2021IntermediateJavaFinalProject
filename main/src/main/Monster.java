package main;

import java.util.HashMap;

public class Monster {
	
	private static HashMap<Integer, String> enemyNames = new HashMap<Integer, String>() {{
		put(1, "Slime");
	}};
	
	private static HashMap<Integer, Integer> enemyHealths = new HashMap<Integer, Integer>() {{
		put(1, 10);
	}};
	
	private static HashMap<Integer, Integer> enemyAttacks = new HashMap<Integer, Integer>() {{
		put(1, 1);
	}};
	
	private static HashMap<Integer, Integer> enemyExp = new HashMap<Integer, Integer>() {{
		put(1, 10);
	}};
	
	private static HashMap<Integer, Integer> enemyGold = new HashMap<Integer, Integer>() {{
		put(1, 3);
	}};
	
	private static HashMap<Integer, String> enemyDescriptions = new HashMap<Integer, String>() {{
		put(1, "A small blob of gelatinous fluid. It poses no threat");
	}};
	
	private static HashMap<Integer, String> enemyIdleDescriptions = new HashMap<Integer, String>() {{
		put(1, "The SLIME blobs up and down, uncertain of its next move");
	}};

	private int level;
	private int maxHealth;
	private int health;
	private int atk;
	private String name;
	private String description;
	
	private int exp;
	private int gold;
	
	public Monster(int id, int level) {
		
		this.level = level;
		
		double scale = Math.sqrt(level);
		
		this.health = (int) (Monster.enemyHealths.get(id) * scale);
		this.maxHealth = health;
		this.atk = (int) (Monster.enemyAttacks.get(id) * scale);
		
		this.name = Monster.enemyNames.get(id);
		this.description = Monster.enemyDescriptions.get(id);
		
		this.exp = (int) (Monster.enemyExp.get(id) * scale);
		this.gold = (int) (Monster.enemyGold.get(id) * scale);
	}
	
	public void takeDamage(int damage) {
		this.health -= damage;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
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
	
	public int getLevel() {
		return this.level;
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
