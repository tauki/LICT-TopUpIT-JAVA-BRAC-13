import java.applet.*;
import java.awt.*;
// this will draw a house
/*<applet code=Main height=500 width=500></applet>*/

public class Main extends Applet {

    public void init() {

    }

    public void paint(Graphics g) {

        int x = 100, y = 200, width = 300, height=200;
        g.setColor(Color.BLUE);
        g.setFont(new Font("ARIAL", Font.BOLD, 30));
        g.drawString("Welcome to GUI", 100, 50);
        g.setColor(Color.BLACK);
        //g.drawLine(200, 200, 300, 300);
        g.drawRect(x, y, width, height);
        //g.fillRect(200, 200, 300, 400);
        //g.drawOval(100, 100, 150, 200);
        //g.setColor(Color.GREEN);
        //g.fillOval(100, 100, 150, 200);
        int X[] = {x, x+width, x+(width/2)};
        int Y[] = {y, y, y/2};
        g.drawPolygon(X, Y, 3);

        g.fillRect(150 ,300, 100, 100);

    }

}