import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please give a number");
		int num = keyboard.nextInt();
		
		while(num > 0) {
			int temp = num % 10;
			num /= 10;
			System.out.print(temp);
		}
	}
}