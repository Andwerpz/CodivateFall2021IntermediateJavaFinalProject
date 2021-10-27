package template;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Item {
	
	public static final int WEAPON = 0;
	public static final int CONSUMABLE = 1;
	public static final int ARMOR = 2;
	
	private static HashMap<Integer, String> typeNames = new HashMap<Integer, String>() {{
		put(WEAPON, "Weapon");
		put(CONSUMABLE, "Consumable");
		put(ARMOR, "Armor");
	}};
	
	//stores the name of the item
	private static HashMap<Integer, String> itemNames = new HashMap<Integer, String>() {{
		put(1, "Short Sword");
		put(2, "Leather Armor");
	}};
	
	//item descriptions
	private static HashMap<Integer, String> itemDescriptions = new HashMap<Integer, String>() {{
		put(1, "Every adventurer never goes anywhere without their trusty short sword");
		put(2, "As long as the enemy hits the covered parts, then you should be ok");
	}};
	
	//item type
	//used for sorting items into separate inventories
	private static HashMap<Integer, HashSet<Integer>> itemType = new HashMap<Integer, HashSet<Integer>>() {{
		put(1, new HashSet<Integer>(Arrays.asList(0, 1)));
		put(2, new HashSet<Integer>(Arrays.asList(2)));
	}};
	
	//stores what happens when you use the item. This will be interpreted differently depending on the item being used.
	
	//how much attack damage does this item possess
	private static HashMap<Integer, Integer> itemAttack = new HashMap<Integer, Integer>() {{
		put(1, 5);
	}};
	
	//if used as a healing item, how much does it heal?
	private static HashMap<Integer, Integer> itemHeal = new HashMap<Integer, Integer>() {{
		put(1, 2);
	}};

	private static HashMap<Integer, Integer> itemDefense = new HashMap<Integer, Integer>() {{
		put(2, 3);
	}};
	
	protected int id;
	protected String name;
	protected String description;
	protected HashSet<Integer> types;
	
	protected int attack;
	protected int heal;
	protected int defense;
	
	//loads items from file
	public static void loadItems() {
		//load the rice package
	}
	
	public Item(int id) {
		this.id = id;
		this.name = Item.itemNames.get(this.id);
		this.description = Item.itemDescriptions.get(this.id);
		this.types = Item.itemType.get(this.id);

		if(Item.itemHeal.containsKey(this.id)) {
			this.heal = Item.itemHeal.get(this.id);
		}
		
		if(Item.itemAttack.containsKey(this.id)) {
			this.attack = Item.itemAttack.get(this.id);
		}
		
		if(Item.itemDefense.containsKey(this.id)) {
			System.out.println("DEF");
			this.defense = Item.itemDefense.get(this.id);
		}
	}
	
	//applies some sort of affect to the player
	public void consume(Player p) {
		if(this.types.contains(Item.CONSUMABLE)) {
			//apply effects onto player
			if(Item.itemHeal.containsKey(this.id)) {
				p.heal(this.heal);
			}
		}
		
		else {
			System.out.println("You cannot consume " + this.name);
		}
	}
	
	//deals some damage to an enemy
	public void attack(Enemy e) {
		if(this.types.contains(Item.WEAPON)) {
			//deal damage to enemy
			if(Item.itemAttack.containsKey(this.id)) {
				e.takeDamage(this.attack);
			}
		}
		else {
			System.out.println("You cannot use " + this.name + " as a weapon");
		}
	} 
	
	public boolean hasAttack() {
		return Item.itemAttack.containsKey(this.id);
	}
	
	public int getAttack() {
		if(this.hasAttack()) {
			return this.attack;
		}
		return -1;
	}
	
	public boolean hasHeal() {
		return Item.itemHeal.containsKey(this.id);
	}
	
	public int getHeal() {
		if(this.hasHeal()) {
			return this.heal;
		}
		return -1;
	}
	
	public boolean hasDefense() {
		return Item.itemDefense.containsKey(this.id);
	}
	
	public int getDefense() {
		if(this.hasDefense()) {
			return this.defense;
		}
		return -1;
	}

	public String toString() {
		String output = this.name + "\n";
		
		for(int i : this.types) {
			output += Item.typeNames.get(i) + ", ";
		}
		output = output.substring(0, output.length() - 2);
		output += "\n";
		
		if(Item.itemAttack.containsKey(this.id)) {
			output += "ATK: " + this.attack + "\n";
		}
		
		if(Item.itemHeal.containsKey(this.id)) {
			output += "Heal: " + this.heal + "\n";
		}
		
		int def = this.getDefense();
		if(def != -1) {
			output += "DEF: " + def + "\n";
		}
		
		
		output += this.description + "\n";	
		
		return output;
	}
	
}
