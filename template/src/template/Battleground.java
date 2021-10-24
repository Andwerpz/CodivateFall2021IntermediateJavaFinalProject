package template;

import java.util.Scanner;

public class Battleground {
	public static void main() {
		
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
				System.out.println("Nobody wants to fight you");
				break;
				
			case "E":
				running = false;
				break;
			}
		}
		
		
	}
}
