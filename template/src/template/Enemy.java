package template;

import java.util.HashMap;

public class Enemy {
	
	public static final int SLIME = 1;
	
	private static HashMap<Integer, String> enemyNames = new HashMap<Integer, String>() {{
		put(1, "Slime");
	}};
	
	private static HashMap<Integer, Integer> enemyHealths = new HashMap<Integer, Integer>() {{
		put(1, 10);
	}};
	
	private static HashMap<Integer, Integer> enemyAttacks = new HashMap<Integer, Integer>() {{
		put(1, 1);
	}};
	
	private static HashMap<Integer, String> enemyDescriptions = new HashMap<Integer, String>() {{
		put(1, "A small blob of gelatinous fluid. It poses no threat");
	}};
	
	private static HashMap<Integer, String> enemyIdleDescriptions = new HashMap<Integer, String>() {{
		put(1, "The SLIME blobs up and down, uncertain of its next move");
	}};
	
	private int type;
	
	private int maxHealth;
	
	private String name;
	private int health;
	private int attack;
	private String description;
	private String idleDescription;
	
	public Enemy(int type) {
		
		this.type = type;
		
		this.name = enemyNames.get(type);
		this.maxHealth = enemyHealths.get(type);
		this.health = this.maxHealth;
		this.attack = enemyAttacks.get(type);
		this.description = enemyDescriptions.get(type);
		this.idleDescription = enemyIdleDescriptions.get(type);
	}
	
	public String getIdleDescription() {
		return this.idleDescription;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	public void takeDamage(int damage) {
		this.health -= damage;
		System.out.println("The " + this.name + " took " + damage + " damage and now has " + this.health + " HP");
	}
	
	public String toString() {
		return this.name + ":\n" + 
			"HP: " + this.health + "\n" +
			"ATK: " + this.attack + "\n" +
			this.description + "\n";
	}
	
	public static Enemy getRandomEnemy() {
		return new Enemy(Enemy.SLIME);
	}
	
}
