package template;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner fin = new Scanner(System.in);
		
		System.out.println("What is your name?");
		
		String name = fin.nextLine();
		Player player = new Player(name);
		
		System.out.println("Hello, " + player.getName());
		
		boolean running = true;
		
		while(running) {
			System.out.println("What would you like to do?");
			System.out.println("1: Tavern");
			System.out.println("2: Battleground");
			System.out.println("P: Player Stats");
			System.out.println("E: Exit Game");
			
			String selection = fin.nextLine();
			
			switch(selection) {
			case "1":
				Tavern.main();
				break;
				
			case "2":
				Battleground.main(player);
				break;
				
			case "P":
				System.out.println(player);
				break;
				
			case "E":
				running = false;
				break;
			}
		}
		
		System.out.println("Exiting Game");
		
	}
}
