import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Insert a number");
        int n = Integer.parseInt(keyboard.nextLine());
        for(int i = 0; i < n; i++) {
            for(int j = n; j > i; j--) System.out.print(j + " ");
            System.out.println();
        }
    }
}