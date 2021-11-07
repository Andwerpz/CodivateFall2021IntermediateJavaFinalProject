package main;

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
				System.out.println("The shop was closed");
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
	
	public static void fightMonsters(Player player) {
		
		System.out.println("A monster approaches");
		
		Monster monster = new Monster(10, 2, "Slime", "A blob of jelly");
		
		Scanner scanner = new Scanner(System.in);
		
		boolean running = true;
		
		while(running) {
			
			System.out.println("What do you want to do? Monster HP: " + monster.getHealth());
			System.out.println("1: Attack");
			System.out.println("2: Heal");
			System.out.println("3: Look at Monster");
			System.out.println("P: Player Stats");
			System.out.println("E: Run Away");
			
			String selection = scanner.nextLine();
			
			switch(selection) {
			
			case "1":
				System.out.println("You hit the monster for " + player.getAtk() + " HP");
				monster.takeDamage(player.getAtk());
				break;
				
			case "2":
				System.out.println("You don't know how to heal");
				break;
				
			case "3":
				System.out.println(monster.toString());
				break;
				
			case "P":
				System.out.println(player.toString());
				break;
				
			case "E":
				System.out.println("You ran away");
				running = false;
				break;
			
			}
			
			if(monster.getHealth() <= 0) {
				running = false;
				System.out.println("You've defeated the monster");
			}
			
		}
		
	}
	
}
