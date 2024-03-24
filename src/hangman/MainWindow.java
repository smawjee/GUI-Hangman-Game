package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainWindow extends JFrame implements WindowListener {
	
	
	
	private ArrayList <JButton> letterButtons;
	
	private int incorrectGuesses;
	private final int maxIncorrectGuesses = 6;
	
	private List<String> wordList;
	private HealthPanel healthPanel;
	Container cpane;
	 String wordToGuess;

	private AbstractButton wordLabel;
	
	public static void main(String[]args)
	
	{
	JFrame frame = new JFrame("Hangman Game");
	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	frame.getContentPane().add(new MainWindow());
	frame.pack();
	frame.setVisible(true);
		
	}
	
	public MainWindow()
	{
		cpane = this.getContentPane();
		setSize(800,400);
		setTitle("Hangman Game");
		cpane.setLayout(new GridLayout(3,1));
		setVisible(true);
		
		healthPanel = new HealthPanel();
		cpane.add(healthPanel,BorderLayout.NORTH);
		setVisible(true);
		
		JPanel wordPanel = new WordPanel(wordToGuess);
		cpane.add(wordPanel,BorderLayout.CENTER);
		wordPanel.setBackground(Color.BLACK);
		setVisible(true);
		
		setLayout(new BorderLayout());
		JLabel wordLabel = new JLabel();
		cpane.add(wordLabel,BorderLayout.CENTER);
		setVisible(true);
	
		loadWordListFromFile();
		startNewGame();
		selectRandomWord();
		
		setVisible(true);
		
		}
	
	
	private List<String> loadWordListFromFile()
	{
		try (BufferedReader reader = new BufferedReader(new FileReader("WordList.txt")))
				{
	List<String> wordList = new ArrayList<>();
				String line;
				while ((line = reader.readLine() ) != null)
				{
					wordList.add(line);
				} if (!wordList.isEmpty()) {
					wordToGuess = wordList.get(new Random().nextInt(wordList.size()));
				}else
					throw new IOException("Word list is empty");
	} catch (IOException e) {
		e.printStackTrace();
	}
		return wordList;
	}
	
	
protected String selectRandomWord() {
		if (!wordList.isEmpty()) {
		wordToGuess = wordList.get(new Random().nextInt(wordList.size()));
		} else {
			System.out.println("List is empty");
		}
		return wordToGuess;
	}
	
	
	protected void startNewGame() {
		wordToGuess = selectRandomWord().toUpperCase();
		String initialDisplay = "";
		for (int i = 0; i < wordToGuess.length(); i++)
		{
			initialDisplay += "_ ";
		}
		wordLabel.setText(initialDisplay);
		wordLabel.setForeground(Color.BLACK);;
		incorrectGuesses = 0;
		healthPanel.reset();
		
	}
	
	
	

	

	
	
		private void showWinMessage() {
			System.out.println("Congratulations! You've guessed the word: " + wordToGuess);	
		}
		
		private void showLossMessage()
		{
			System.out.println("You've ran out of guesses. The word was: " + wordToGuess);
		}
		
		public class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				button.setEnabled(false);
				char guessedLetter = button.getText().charAt(0);
				checkGuess(guessedLetter);
				
				
			}

		}
		
		private void checkGuess(char guessedLetter)
		{
			boolean correctGuess = false;
			String updatedDisplay = wordLabel.getText();
			
			for (int i = 0; i < wordToGuess.length();i++)
			{
				if (wordToGuess.charAt(i) == guessedLetter)
				{
					char[] displayChars = updatedDisplay.toCharArray();
					displayChars[i*2] = guessedLetter;
					updatedDisplay = String.valueOf(displayChars);
					correctGuess = true;
				}
			}
			if (!correctGuess) {
				incorrectGuesses++;
				healthPanel.removeLife();
			}
			
			wordLabel.setText(updatedDisplay);
			
			if (updatedDisplay.indexOf("_") == -1) {
				showWinMessage();
				startNewGame();
			} else if (incorrectGuesses == maxIncorrectGuesses) {
				showLossMessage();
				startNewGame();
			}
		}


		
	public List<String> getWordList()
	{
		return wordList;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}