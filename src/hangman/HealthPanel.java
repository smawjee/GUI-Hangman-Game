package hangman;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HealthPanel extends JPanel {
private ArrayList<JLabel>lifeLabels;
	
	public HealthPanel()
	{
		setLayout(new GridLayout(1,7,4,1));
		lifeLabels = new ArrayList<>();
		for(int i = 1; i <= 7; i++)
		{
			JLabel lifeLabel = new JLabel(String.valueOf(i));
			lifeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lifeLabel.setBackground(Color.GREEN);
			lifeLabel.setOpaque(true);
			add(lifeLabel);
			lifeLabels.add(lifeLabel);
		
		}
	}
		public boolean removeLife()
		{
			for (JLabel lifeLabel : lifeLabels)
			{
			if (lifeLabel.getForeground() == Color.GREEN)
			{
				lifeLabel.setForeground(Color.GREEN);
				return true;
				
			}
			
			lifeLabel.setForeground(Color.RED);
			
			
			}
			return false;
		}
	
	
	public void reset()
	{
		for (JLabel lifeLabel : lifeLabels)
		{
		
		
			lifeLabel.setForeground(Color.GREEN);
		
	}
	
		}
	}
	


