package hangman;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordPanel extends JPanel {
	
	
	private JLabel wordLabel;

	public WordPanel(String Word)
	{
		setLayout(new FlowLayout());
		JLabel	wordLabel = new JLabel();
		initializeWordLabel(Word);
		add(wordLabel);
		
		
	}

	private void initializeWordLabel(String Word) {
		String wordDisplay = "";
		for(int i = 0; i< Word.length();i++)
		{
			wordDisplay += "_";
		}
		wordLabel.setText(wordDisplay);
		
	}
	
	public boolean guess(String letter)
	{
		boolean guessCorrect = false;
		String currentWordDisplay = wordLabel.getText();
		String updatedWordDisplay = "";
		String wordToGuess = null;
		for(int i =0; i < wordToGuess.length(); i++)
		{
			if (wordToGuess.charAt(i) == letter.toUpperCase().charAt(0))
			{
				updatedWordDisplay += letter.toUpperCase().charAt(0);
				guessCorrect = true;
				
			}
			updatedWordDisplay += currentWordDisplay.charAt(i*2);
			updatedWordDisplay += "";
		}
		wordLabel.setText(updatedWordDisplay);
		return guessCorrect;
	}

}
