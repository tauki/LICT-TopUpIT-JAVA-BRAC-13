package student;

public class GradeDemo extends AvgDemo {
    char Grade = '*';

    public void generateGrade() {
        int n = total/marks.length;

        if(n > 90) Grade = 'A';
        else if(n > 80) Grade = 'B';
        else if(n > 70) Grade = 'C';
        else if(n > 60) Grade = 'D';
        else Grade = 'F';
    }
}