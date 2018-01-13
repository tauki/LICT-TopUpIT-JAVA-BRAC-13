import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input a sentence to count the number of words: ");
        String[] input = keyboard.nextLine().split(" ");
        System.out.println("Number of words: " + input.length);
    }
}