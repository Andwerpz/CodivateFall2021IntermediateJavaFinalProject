package template;

import java.util.ArrayList;
import java.util.Scanner;

public class Battleground {
	
	public static void main(Player player) {
		
		Scanner fin = new Scanner(System.in);
		boolean running = true;
		System.out.println("The sound of swords clashing intensifies as you draw closer to the battleground");
		
		while(running) {
			System.out.println("What would you like to do?");
			System.out.println("1: Buy Something");
			System.out.println("2: Fight Monsters");
			System.out.println("E: Exit Battleground");
			
			String selection = fin.nextLine();
			
			switch(selection) {
			case "1":
				break;
				
			case "2":
				fightMonsters(player);
				break;
				
			case "E":
				running = false;
				break;
			}
		}
		
	}
	
	public static void fightMonsters(Player player) {
		
		boolean running = true;
		Scanner fin = new Scanner(System.in);
		
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		int enemyAmt = 1;
		
		for(int i = 0; i < enemyAmt; i++) {
			enemies.add(Enemy.getRandomEnemy());
		}
		
		System.out.println("A group of " + enemyAmt + " enemies approach you");
		
		while(running) {
			System.out.println(enemies.get(enemies.size() - 1).getIdleDescription() + "\n");
			System.out.println("What do you want to do?");
			System.out.println("1: Attack");
			System.out.println("2: Show Enemy Description");
			System.out.println("3: Run Away");
			System.out.println("4: Player Stats");
			
			String selection = fin.nextLine();
			
			switch(selection) {
			case "1":
				enemies.get(enemies.size() - 1).takeDamage(player.getAttack());
				System.out.println("The " + enemies.get(enemies.size() - 1).getName() + " took " + player.getAttack() + " damage and now has " + enemies.get(enemies.size() - 1).getHealth() + " HP");
				break;
				
			case "2":
				System.out.println(enemies.get(enemies.size() - 1));
				break;
				
			case "3":
				System.out.println("You run away");
				running  = false;
				break;
				
			case "4":
				System.out.println(player);
				break;
			}
		}
		
	}
}
