/**
 * Panel which draws fireworks and trajectory 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class FireworksMain extends JPanel {
	private static final long serialVersionUID = 1L;
	private static Color color;
	private static int lastX;
	private static int lastY;
	/*
	 * paint method, paints all graphics on panel
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		if(fwCanvas.isLaunch()) {
			String c = fwCanvas.getpColor();
			if(c.equals("Red"))
				color = color.RED;
			else if(c.equals("Blue"))
				color = color.BLUE;
			else if(c.equals("Green"))
				color = color.GREEN;
		}

		if (fwCanvas.isLaunch()) {
			drawPath(g, fwCanvas.getSpeed(), fwCanvas.getAngle(), fwCanvas.getDetTime()); //if button is pressed, drawpath based on GUI inputs 
			switch (fwCanvas.getFtype()) { //switch statements for firework type selection
			case "Lines":
				drawExplosionA(g);
				break;
			case "Umbrella":
				drawExplosionB(g);
				break;
			case "Strings":
				drawExplosionC(g);
				break;
			case "PieGraph":
				drawExplosionD(g);
				break;
			case "Spiral":
				drawExplosionE(g);
				break;
			case "Abduction":
				drawExplosionF(g);
				break;
			default:
				drawExplosionA(g);
				break;
			}

		}
	}

	/*
	 * calculates given y coordinate based on time angle and speed
	 */
	public static double calcY(double angle, double time, double speed) {
		return (speed * Math.sin(Math.toRadians(angle)) * time) - (5 * time * time);
	}
	/*
	 * calculates given x coordinate based on time angle and speed
	 */
	public static double calcX(double angle, double time, double speed) {
		return speed * Math.cos(Math.toRadians(angle)) * time;
	}
	
	/*
	 * draws trajectory of firework based on speed and angle, stops once detTime has been reached
	 */
	public void drawPath(Graphics g, int speed, int angle, int detTime) {
		g.setColor(color);
		int h = getHeight() - 1;
		lastX = 0;
		lastY = 0;
		loop: for (int i = 0; i <= detTime; i++) {
			int x2 = (int) (calcX(angle, (double) i, speed));
			int y2 = (int) (calcY(angle, (double) i, speed));
			if (y2 < 0)//detonates on ground if it reaches it before detTime
				break loop;
			System.out.print("\nx2: " + x2 + " y2:" + y2 + " ");
			g.drawLine(lastX, h - lastY, x2, h - y2);
			lastX = x2;
			lastY = y2;
		}
		System.out.print("last x = " + lastX);
		System.out.print("last y = " + lastY);

	}
	/*
	 * One of 6(A-F) firework types. Each draws a unique graphic 
	 */
	public void drawExplosionA(Graphics g) { //draws a bunch of fun colored lines
		int h = getHeight() - 1;
		for (int i = 0; i < 360; i++) {
			int red = (int) (255 * Math.random());
			int green = (int) (255 * Math.random());
			int blue = (int) (255 * Math.random());
			Random r = new Random();
			Random r2 = new Random();
			int len = r.nextInt(50 + 1 + 50) - 50;
			int len2 = r2.nextInt(50 + 1 + 50) - 50;
			g.setColor(new Color(red, green, blue));
			g.drawLine(lastX, h - lastY, lastX + len, h - lastY + len2);
		}
	}

	public void drawExplosionB(Graphics g) {  //draws a colorful umbrella of fireworks over the crowd
		int h = getHeight() - 1;
		for (int i = 0; i < 360; i++) {
			int red = (int) (255 * Math.random());
			int green = (int) (255 * Math.random());
			int blue = (int) (255 * Math.random());
			int r = (int) (360 * Math.random());
			g.setColor(new Color(red, green, blue));
			g.fillArc(lastX - r, h - lastY, 100, 50, r, 35);
		}
	}

	public void drawExplosionC(Graphics g) { //creates many colorful "BOOM"'s in the sky
		int h = getHeight() - 1;
		for (int i = 0; i < 15; i++) {
			int red = (int) (255 * Math.random());
			int green = (int) (255 * Math.random());
			int blue = (int) (255 * Math.random());
			int r = (int) (25 * Math.random());
			int r2 = (int) (25 * Math.random());
			g.setColor(new Color(red, green, blue));
			g.drawString("BOOM", lastX + r, h - lastY + r2);
		}
	}

	public void drawExplosionD(Graphics g) { //creates a colorful pie chart in the sky
		int h = getHeight() - 1;
		for (int i = 0; i < 360; i++) {
			int red = (int) (255 * Math.random());
			int green = (int) (255 * Math.random());
			int blue = (int) (255 * Math.random());
			int r = (int) (360 * Math.random());
			g.setColor(new Color(red, green, blue));
			g.fillArc(lastX, h - lastY, 100, 50, r, 35);
		}
	}

	public void drawExplosionE(Graphics g) {//creates a bunch of colorful circles in the sky
		int h = getHeight()-1;
		int w = getWidth()-1;
		for(int i = 0; i<=20; i++) {
			int red = (int) (255 * Math.random());
			int green = (int) (255 * Math.random());
			int blue = (int) (255 * Math.random());
			g.setColor(new Color(red,green,blue));
			g.drawOval(lastX - 5*i, h-lastY -5*i, 10*i, 10*i);
		}


	}
	public void drawExplosionF(Graphics g) { //creates circles which go down the to the ground, much like an alien abduction 
		int h = getHeight()-1;
		int width = 20;
		int height = 20;
		int startAngle = 0;
		int arcAngle = 180;
		int depth = 10;
		for (int i = 0; i < 15; i++) {
			int red = (int) (255 * Math.random());
			int green = (int) (255 * Math.random());
			int blue = (int) (255 * Math.random());
			if (i % 2 == 0) {
				lastY = lastY - depth;
				width = width + 2 * depth;
				height = height + 2 * depth;
				g.setColor(new Color(red,green,blue));
				g.drawArc(lastX, lastY+height, width, height, startAngle, -arcAngle);
			} else {
				lastX = lastX - 2 * depth;
				lastY = lastY - depth;
				width = width + 2 * depth;
				height = height + 2 * depth;
				g.setColor(new Color(red,green,blue));
				g.drawArc(lastX, lastY+height, width, height, startAngle, arcAngle);
			}
		}

	}
}
