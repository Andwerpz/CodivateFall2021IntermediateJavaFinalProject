package main;

import java.util.HashMap;

public class Item {

	public static final int WEAPON = 0;
	public static final int CONSUMABLE = 1;
	public static final int ARMOR = 2;
	
	//short sword : 1
	//leather armor : 2
	
	public static HashMap<Integer, Integer> itemTypes = new HashMap<Integer, Integer>() {{
		put(1, WEAPON);
		put(2, ARMOR);
	}};
	
	//stores item names
	public static HashMap<Integer, String> itemNames = new HashMap<Integer, String>() {{
		put(1, "Short Sword");
		put(2, "Leather Armor");
	}};
	
	//stores item descriptions
	public static HashMap<Integer, String> itemDescriptions = new HashMap<Integer, String>() {{
		put(1, "Every adventurer never goes anywhere without their trusty short sword");
		put(2, "As long as you get hit in the covered parts, you should be ok");
	}};
	
	public static HashMap<Integer, Integer> itemAtk = new HashMap<Integer, Integer>() {{
		put(1, 15);
	}};
	
	public static HashMap<Integer, Integer> itemDef = new HashMap<Integer, Integer>() {{
		put(2, 10);
	}};
	
	
	
	private int type;
	private String name;
	private String description;
	
	//Weapon stats
	private int atk;
	
	//Armor stats
	private int def;
	
	public Item(int itemId) {
		type = Item.itemTypes.get(itemId);
		name = Item.itemNames.get(itemId);
		description = Item.itemDescriptions.get(itemId);
		
		if(this.type == Item.WEAPON) {
			this.atk = Item.itemAtk.get(itemId);
		}
		
		else if(this.type == Item.ARMOR) {
			this.def = Item.itemDef.get(itemId);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public int getDef() {
		return this.def;
	}
	
	public String toString() {
		String out = "";
		out += this.name + "\n";
		out += this.type + "\n";
		out += this.description + "\n";
		
		if(this.type == Item.WEAPON) {
			out += "ATK: " + this.atk + "\n";
		}
		
		else if(this.type == Item.ARMOR) {
			out += "DEF: " + this.def + "\n";
		}
		
		return out;
	}
	
}
