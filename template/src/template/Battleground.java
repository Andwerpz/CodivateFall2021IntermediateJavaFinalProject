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
		int enemyAmt = (int) (Math.random() * 5) + 1;
		
		for(int i = 0; i < enemyAmt; i++) {
			enemies.add(Enemy.getRandomEnemy(player.getLevel()));
		}
		
		System.out.println("\nA group of " + enemyAmt + " enemies approach you\n");
		
		while(running) {
			
			
			//choose a random enemy out of the group for idle description
			int chosenEnemy = (int) (Math.random() * enemies.size());
			System.out.println(enemies.get(chosenEnemy).getIdleDescription());
			
			System.out.println("What do you want to do?");
			System.out.println("1: Attack");
			System.out.println("2: Show Enemy Description");
			System.out.println("3: Run Away");
			System.out.println("4: Player Stats");
			
			String selection = fin.nextLine();
			
			switch(selection) {
			case "1":
				boolean selected = false;
				int selectedEnemy = -1;
				while(!selected) {
					System.out.println("Attack which enemy?");
					for(int i = 0; i < enemies.size(); i++) {
						Enemy e = enemies.get(i);
						System.out.println((i + 1) + ": " + e.getName() + " " + e.getHealth() + "/" + e.getMaxHealth());
					}
					String input = fin.nextLine();
					selectedEnemy = Integer.parseInt(fin.nextLine());
					selectedEnemy --;
					if(selectedEnemy >= 0 && selectedEnemy < enemies.size()) {
						selected = true;
					}
				}
				enemies.get(selectedEnemy).takeDamage(player.getAttack());
				if(enemies.get(selectedEnemy).getHealth() <= 0) {
					System.out.println(enemies.get(selectedEnemy).getName() + " has died");
					enemies.remove(selectedEnemy);
				}
				break;
				
			case "2":
				selected = false;
				selectedEnemy = -1;
				while(!selected) {
					System.out.println("Look at which enemy?");
					for(int i = 0; i < enemies.size(); i++) {
						Enemy e = enemies.get(i);
						System.out.println((i + 1) + ": " + e.getName() + " " + e.getHealth() + "/" + e.getMaxHealth());
					}
					selectedEnemy = Integer.parseInt(fin.nextLine());
					selectedEnemy --;
					if(selectedEnemy >= 0 && selectedEnemy < enemies.size()) {
						selected = true;
					}
				}
				System.out.println(enemies.get(selectedEnemy));
				break;
				
			case "3":
				System.out.println("You run away");
				running  = false;
				break;
				
			case "4":
				System.out.println(player);
				break;
			}
			
			System.out.println();
			
			if(enemies.size() == 0) {
				System.out.println("All the enemies have been slain");
				running = false;
			}
		}
		
	}
}
