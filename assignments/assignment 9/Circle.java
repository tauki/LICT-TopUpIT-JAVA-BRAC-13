import java.applet.*;
import java.awt.*;
// A ball drop animation
/*<applet code=Circle height=500 width=500></applet>*/

public class Circle extends Applet implements Runnable {
	int x = 100, y=100;
	
	public void init() {
		setBackground(Color.WHITE);
	}
	
	public void start() {
		System.out.println("From Start");
		new Thread(this).start();
	}
	
	public void run() {
		while(true) {
			try{
				update();
				Thread.sleep(500);
			} catch (Exception e) {
				
			}
		}
	}
	
	public void update() {
		if(y< 300) {
			y += 40;
			repaint();
			
		} else {
			while(y!= 100) {
				y-=40;
				repaint();
					

			}
		}
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.red);
		
		g.fillOval(x, y, 50, 50);
	}
}