package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		String name = "";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What is your name?");
		name = scanner.nextLine();
		
		System.out.println("Welcome " + name);
		
		boolean running = true;
		
		while(running) {
			
			System.out.println("What do you want to do?");
			System.out.println("1: Tavern");
			System.out.println("2: Battleground");
			System.out.println("P: Player Stats");
			System.out.println("E: Exit Game");
			
			String selection = scanner.nextLine();
			
			switch(selection) {
			
			case "1":
				System.out.println("You went to the Tavern");
				break;
				
			case "2":
				System.out.println("You went to the Battleground");
				break;
				
			case "P":
				System.out.println("Your name is " + name);
				break;
				
			case "E":
				System.out.println("Exiting Game");
				running = false;
				break;
			
			}
			
		}
		
	}
}
