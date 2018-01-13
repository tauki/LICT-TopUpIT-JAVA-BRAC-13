package student;

public class TotalDemo extends InputDemo {
    public int total;

    public void calculateTotal() {
        for(int i = 0; i < marks.length; i++) {
            total+= marks[i];
        }
    }
}