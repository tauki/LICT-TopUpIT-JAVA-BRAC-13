import javax.swing.*;
import java.awt.*;

public class LoginDemo {
    private state = "Register";
    public static void main(String as[]) {
        JFrame form = new Form(state);
        form.setVisible(true);
        form.setSize(400,400);
    }
}
