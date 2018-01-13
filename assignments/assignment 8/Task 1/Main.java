import java.util.Date;
import java.text.SimpleDateFormat;

public class Main extends Thread {
    public void run(){
        int time = 2*60;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for(int i = 0; i < time; i++){
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            try {
                sleep(1000);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.start();
    }
}