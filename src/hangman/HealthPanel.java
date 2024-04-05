package hangman;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

	public class HealthPanel extends JPanel {
	private static JLabel[] lifeLabels = new JLabel[7];
	
	private static int incorrGuess;
	public  HealthPanel()
	{
		
		incorrGuess=0;
		 setLayout(new GridLayout(1,7,4,2));
		 
		 for(int i = 0;i < lifeLabels.length; i++ )
		 {
			 lifeLabels[i] = new JLabel((i+1)+"",JLabel.CENTER);
			 Font font = new Font("SANS SERIF",Font.BOLD, 42);
			 lifeLabels[i].setFont(font);
			 lifeLabels[i].setBackground(Color.GREEN);
			 lifeLabels[i].setOpaque(true);
			 add(lifeLabels[i]);
			 
			 
		 }
		 
	 }
	 public static boolean removeLife()
	 {
		 incorrGuess++;
		 System.out.println(incorrGuess+" "+lifeLabels.length);
		 lifeLabels[lifeLabels.length-incorrGuess].setBackground(Color.red);
		 
		 if(incorrGuess<lifeLabels.length ) {
			 
			 return true;
			 
		 }else{
			 return false;
		 }
		 
	 }
	}
	
	

	
	