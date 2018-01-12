import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int[] a = new int[10];
		
		for(int i = 0; i < a.length; i++)
			a[i] = Integer.parseInt(keyboard.nextLine());
		
		int max = a[0], min = a[0];
		
		for(int i = 0; i < a.length; i++){
			if(a[i] > max) max = a[i];
			if(a[i] < min) min = a[i];
		}
		
		System.out.println("Min: "+min);
		System.out.println("Max: "+max);
	}
}