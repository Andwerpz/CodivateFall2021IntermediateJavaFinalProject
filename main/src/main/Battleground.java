package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Battleground {

	public static void main(Player player) {
		
		System.out.println("You enter the battleground");
		
		Scanner scanner = new Scanner(System.in);
		
		boolean running = true;
		
		while(running) {
			
			System.out.println("What do you want to do?");
			System.out.println("1: Buy Something");
			System.out.println("2: Fight Monsters");
			System.out.println("P: Player Stats");
			System.out.println("E: Exit Battleground");
			
			String selection = scanner.nextLine();
			
			switch(selection) {
			
			case "1":
				Battleground.shop(player);
				break;
				
			case "2":
				Battleground.fightMonsters(player);
				break;
				
			case "P":
				System.out.println(player.toString());
				break;
				
			case "E":
				System.out.println("Exiting Battleground");
				running = false;
				break;
			
			}
			
		}
		
	}
	
	public static void shop(Player player) {
		
		System.out.println("You went to the shop");
		
		ArrayList<Item> shopInventory = new ArrayList<Item>();
		shopInventory.add(new Item(1));
		
		boolean running = true;
		
		Scanner scanner = new Scanner(System.in);
		
		while(running) {
			
			System.out.println("What do you want to buy?");
			
			for(int i = 0; i < shopInventory.size(); i++) {
				System.out.println((i + 1) + ": " + shopInventory.get(i).getName());
			}
			
			System.out.println("E: Exit Shop");
			
			String selection = scanner.nextLine();
			
			if(selection.equals("E")) {
				System.out.println("Exiting shop");
				break;
			}
			
			int which = Integer.parseInt(selection);
			
			if(which >= 1 && which <= shopInventory.size()) {
				player.addItem(shopInventory.get(which - 1));
				shopInventory.remove(which - 1);
			}
			
		}
		
	}
	
	public static void fightMonsters(Player player) {
		
		System.out.println("A monster approaches");
		
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		
		for(int i = 0; i < 3; i++) {
			int level = (int) (Math.random() * 10) + 1;
			monsters.add(new Monster(1, level));
		}
		
		Scanner scanner = new Scanner(System.in);
		
		boolean running = true;
		
		while(running) {
			
			System.out.println("A group of " + monsters.size() + " approaches. What do you want to do?");
			System.out.println("1: Attack");
			System.out.println("2: Heal");
			System.out.println("3: Look at Monster");
			System.out.println("P: Player Stats");
			System.out.println("E: Run Away");
			
			String selection = scanner.nextLine();
			
			switch(selection) {
			
			case "1":
				System.out.println("Which monster do you want to attack?");
				for(int i = 0; i < monsters.size(); i++) {
					System.out.println((i + 1) + ": " + 
							monsters.get(i).getName() + " " + 
							monsters.get(i).getHealth() + "/" + monsters.get(i).getMaxHealth() + " " +
							"(L" + monsters.get(i).getLevel() + ")");
				}
				
				int whichEnemy = Integer.parseInt(scanner.nextLine());
				
				if(whichEnemy >= 1 && whichEnemy <= monsters.size()) {
					monsters.get(whichEnemy - 1).takeDamage(player.getAtk());
					System.out.println("You hit the monster for " + player.getAtk() + " HP");
					if(monsters.get(whichEnemy - 1).getHealth() <= 0) {
						System.out.println("You've defeated the " + monsters.get(whichEnemy - 1).getName());
						monsters.remove(whichEnemy - 1);
					}
				}
				break;
				
			case "2":
				System.out.println("You don't know how to heal");
				break;
				
			case "3":
				//System.out.println(monster.toString());
				break;
				
			case "P":
				System.out.println(player.toString());
				break;
				
			case "E":
				System.out.println("You ran away");
				running = false;
				break;
			
			}
			
			if(monsters.size() <= 0) {
				System.out.println("You've defeated all the monsters!");
				running = false;
			}
			
		}
		
	}
	
}
