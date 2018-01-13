import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input the sentence:");
        String[] sentence = keyboard.nextLine().split(" ");
        System.out.println("Input the word to check:");
        String check = keyboard.nextLine();
        int count = 0;
        for(String word: sentence) {
            if(word.equalsIgnoreCase(check)) count++;
        }
        System.out.println("Your given word appeared " + count + " time(s)");
    }
}