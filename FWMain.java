/**
 * Main class, used to call the other classes. Run application from here.
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
public class FWMain {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame("frame");
		FireworksMain panel = new FireworksMain();
		fwCanvas canvas = new fwCanvas(panel);	
		frame.add(canvas, BorderLayout.NORTH);
		frame.add(panel,BorderLayout.CENTER);
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
