package student;

public class OutputDemo extends GradeDemo {
    public void printOutput() {
        inputData();
        calculateTotal();
        calculateAvg();
        generateGrade();
        System.out.println(Grade);
        //System.err.println(total);
    }
}