package template;

import java.util.Scanner;

public class Tavern {
	public static void main() {
		
		Scanner fin = new Scanner(System.in);
		boolean running = true;
		System.out.println("You enter the bustling tavern");
		
		while(running) {
			System.out.println("What would you like to do?");
			System.out.println("1: Buy Something");
			System.out.println("2: Play the piano");
			System.out.println("E: Exit Tavern");
			
			String selection = fin.nextLine();
			
			switch(selection) {
			case "1":
				break;
				
			case "2":
				System.out.println("You sit down at the piano");
				for(int i = 0; i < 3; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(". ");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("You realize that you don't know how to play the piano");
				break;
				
			case "E":
				running = false;
				break;
			}
		}
		
	}
}
