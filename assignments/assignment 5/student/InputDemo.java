package student;
import java.util.Scanner;

public class InputDemo {
    Scanner keyboard;
    public String name;
    public int reg_no;
    public int[] marks;

    public void inputData() {
        keyboard = new Scanner(System.in);

        System.out.println("Input name");
        name = keyboard.nextLine();

        System.out.println("Input registration number");

        System.out.println("Insert the number of courses done");
        int n = Integer.parseInt(keyboard.nextLine());

        marks = new int[n];

        for(int i = 0; i < marks.length; i++){
            System.out.println("Insert marks of your course" + (i+1));
            marks[i] = Integer.parseInt(keyboard.nextLine());
        }
    }
}