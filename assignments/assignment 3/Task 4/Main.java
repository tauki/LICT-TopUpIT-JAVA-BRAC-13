import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int input;
		do {
			System.out.println("Select: \n1. to play.\n2. to quit if you're a queer");
			input = Integer.parseInt(keyboard.nextLine());
			if(input == 1) play(keyboard);
		}while(input != 2);
	}
	
	public static void play(Scanner keyboard) {
		int life = 3;
		Random r = new Random();
		int n = r.nextInt(10) + 1;
		boolean won = false;
		for(int i = 0; i < life; i++) {
			System.out.println("Guess a number or your wife dies!");
			int input = Integer.parseInt(keyboard.nextLine());
			if(input < n) System.out.println("Your wife lost a limb, think bigger");
			else if(input > n) System.out.println("Your wife lost a finger, think less");
			else if(input == n){
				won = true;
				if(i == 0) System.out.println("Great! You won.");
				else if(i == 2) System.out.println("Bravo! You won");
				else System.out.println("You won");
			}
		}
		if(!won) System.out.println("ALAS! YOU LOST...");
	}
}