/**
 * Panel that contains all GUI
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class fwCanvas extends JPanel{
	private static int angle;
	private static int speed;
	private static int detTime;
	private static String fType;
	private static String pColor;
	private static boolean ifLaunch = false;
	FireworksMain canvas;
	/*
	 * Constructor which creates and adds all GUI, as well as adds action listeners
	 */
	public fwCanvas(FireworksMain canvas) {
		this.canvas = canvas;
		setLayout(new FlowLayout());
		JComboBox box = new JComboBox();
		JComboBox cBox = new JComboBox();
		cBox.addItem("Red");
		cBox.addItem("Green");
		cBox.addItem("Blue");
		box.addItem("Lines");
		box.addItem("Umbrella");
		box.addItem("Strings");
		box.addItem("PieGraph");
		box.addItem("Spiral");
		box.addItem("Abduction");
		JLabel sfieldLabel = new JLabel("Speed");
		JLabel dfieldLabel = new JLabel("Det Time");
		JLabel afieldLabel = new JLabel("Angle");
		JTextField afield = new JTextField("Enter angle");
		JTextField sfield = new JTextField("Enter speed");
		JTextField dfield = new JTextField("Enter detionation time");
		JButton launch = new JButton("Launch");
		add(box, BorderLayout.SOUTH);
		add(cBox, BorderLayout.SOUTH);
		add(sfieldLabel, BorderLayout.SOUTH);
		add(sfield, BorderLayout.SOUTH);
		add(dfieldLabel, BorderLayout.SOUTH);
		add(dfield, BorderLayout.SOUTH);
		add(afieldLabel, BorderLayout.SOUTH);
		add(afield, BorderLayout.SOUTH);
		add(launch, BorderLayout.SOUTH);
		cBox.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  pColor = box.getSelectedItem() + "";
			  } 
			} );
		box.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  fType = box.getSelectedItem() + "";
			  } 
			} );
		launch.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  ifLaunch = true;
				  canvas.repaint();				  
			  } 
			} );
		
		dfield.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				detTime = Integer.parseInt(dfield.getText());
				
			}
		    });
		dfield.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				dfield.setText(null);	
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				dfield.setText(detTime + "");	
			}

		});
		sfield.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				speed = Integer.parseInt(sfield.getText());
				
			}
		    });
		sfield.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				sfield.setText(null);	
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				sfield.setText(speed + "");	
			}

		});
		afield.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				angle = Integer.parseInt(afield.getText());
				
			}
		    });
		afield.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				afield.setText(null);	
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				afield.setText(angle + "");	
			}

		});
	}

	/*
	 * getter methods for transferring variable information from GUI to graphic canvas 
	 */
	public static int getAngle() {
		return angle;
	}
	public static int getSpeed() {
		return speed;
	}
	public static int getDetTime() {
		return detTime;
	}
	public static boolean isLaunch() {
		return ifLaunch;
	}
	public static String getFtype() {
		return fType;
	}
	public static String getpColor() {
		return pColor;
	}
	
}