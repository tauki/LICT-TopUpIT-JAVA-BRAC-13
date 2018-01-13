package student;

public class AvgDemo extends TotalDemo {
    float avg;

    public void calculateAvg() {
        avg = total/marks.length;
    }
}