package hangman;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HealthPanel extends JPanel {
	private ArrayList<JLabel>lifeLabels;
	
	public HealthPanel()
	{
		setLayout(new FlowLayout());
		lifeLabels = new ArrayList<>();
		for(int i = 0; i < 7; i++)
		{
			JLabel lifeLabel = new JLabel("❤");
			lifeLabel.setForeground(Color.GREEN);
			add(lifeLabel);
			lifeLabels.add(lifeLabel);
		}
	}
		public void removeLife()
		{
			for (JLabel lifeLabel : lifeLabels)
			{
			if (lifeLabel.getForeground() == Color.GREEN)
			{
				lifeLabel.setForeground(Color.GREEN);
				
			}
			
			lifeLabel.setForeground(Color.RED);
			break;
			}
		}
	
	
	public void reset()
	{
		for (JLabel lifeLabel : lifeLabels)
		{
		
		
			lifeLabel.setForeground(Color.GREEN);
		
	}
	
		}
	}
	

