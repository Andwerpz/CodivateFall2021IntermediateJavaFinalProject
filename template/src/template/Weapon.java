package template;

import java.util.HashMap;

public class Weapon {
	
	private static HashMap<Integer, String> weaponNames = new HashMap<Integer, String>() {{
		put(1, "Short Sword");
	}};
	
	private static HashMap<Integer, Integer> weaponAttacks = new HashMap<Integer, Integer>() {{
		put(1, 5);
	}};
	
	private static HashMap<Integer, String> weaponDescriptions = new HashMap<Integer, String>() {{
		put(1, "Every adventurer recieves a short sword upon graduation from adventurer academy");
	}};

	private int type;
	
	private String name;
	private int attack;
	
	private String description;
	
	public Weapon(int type) {
		this.type = type;
		this.name = weaponNames.get(this.type);
		this.attack = weaponAttacks.get(this.type);
		this.description = weaponDescriptions.get(this.type);
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String toString() {
		String output = this.name + "\nDamage: " + this.attack + "\n" + this.description;
		return output;
	}
	
}
