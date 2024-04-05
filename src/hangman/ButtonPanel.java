package hangman;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

	public class ButtonPanel extends JPanel implements ActionListener {
		
		private static JButton[] letterButton ;
		private WordPanel wordPanel; 
	
	public ButtonPanel(WordPanel wordPanel)
	{
		letterButton = new JButton[26];
		this.wordPanel = wordPanel;
		setLayout(new GridLayout(4	,1));
		
		for (char letter = 'A' ; letter <= 'Z'; letter++)
			
			
				
		{
			int index = letter - 'A';
			  letterButton[index] = new JButton(String.valueOf(letter));
			
			letterButton[index].addActionListener(this);
			letterButton[index].setBackground(Color.BLACK);
			letterButton[index].setForeground(Color.WHITE);
			add(letterButton[index]);
		}
	}
	
		public void actionPerformed(ActionEvent e)
		{
			int reply;
			JButton source = (JButton) e.getSource();
			
			String letter = source.getText();
			
			source.setEnabled(false);
			
			
			if(WordPanel.guess(letter)) {
				if(WordPanel.isWordGuessed()) {
					JOptionPane.showInternalMessageDialog(null, "Congrats on guessing the word!");
		            reply = JOptionPane.showConfirmDialog(MainWindow.getCpane(), "Would you like to guess a new word?","Game Over.",JOptionPane.YES_NO_OPTION);
					
					if (reply == JOptionPane.YES_OPTION)
					{
						MainWindow.ResetGamePanel();
					}else {
						System.exit(0);
					}
				}
			}
			
			else {
				if(!HealthPanel.removeLife()) {
					System.out.println(1);
					JOptionPane.showInternalMessageDialog(null, "You failed to guess the word!");
					reply = JOptionPane.showConfirmDialog(MainWindow.getCpane(), "The word to be guessed " + WordPanel.getCurrentWord() +"\nWould you like to start a new game? ","You failed.",JOptionPane.YES_NO_OPTION);
					
					if (reply == JOptionPane.OK_OPTION)
					{
						MainWindow.ResetGamePanel();;
					} else {
						System.exit(0);
					}
				}
			}
			} 
			

			
		
		
		
	}

