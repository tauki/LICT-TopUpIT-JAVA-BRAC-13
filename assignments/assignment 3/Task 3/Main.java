import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int[a] = new int[Integer.parseInt(keyboard.nextLine())];
		
		for(int i = 0; i < a.length; i++)
			a[i] = Integer.parseInt(keyboard.nextLine());
		
		int sum = 0;
		
		for(int i = 0; i < a.length; i++)
			sum += a[i];
		
		System.out.println("Sum: "+sum);
	}
}