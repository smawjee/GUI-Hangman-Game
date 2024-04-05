package hangman;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

	public class WordPanel extends JPanel {
		private static JLabel[] wordLabel;
		private static String currentWord;
		
		public static String getCurrentWord() {
			return currentWord;
		}
		public static void setCurrentWord(String currentWord) {
			WordPanel.currentWord = currentWord;
		}

		private static List<String> wordList;
		public WordPanel()
		{
			setLayout(new FlowLayout());
			wordList = readTextFile("WordList.txt");
			currentWord = getRandomWord();
			setCurrentWord(currentWord); 
			System.out.println(currentWord);
			
			initializeLabels(currentWord.length());
			updateDisplay();
			
			 
			
		}
		static String getRandomWord() {
			Random random = new Random();
			return wordList.get(random.nextInt(wordList.size()));
		}
		
		private List<String> readTextFile(String fileName) {
			List<String> wordList = new ArrayList<>();
			try (BufferedReader Reader = new BufferedReader(new FileReader(fileName)))
			{
				String Line;
				while((Line = Reader.readLine()) != null)
				{
					wordList.add(Line);
				}
			} catch (IOException e) {
			e.printStackTrace();
			}
			return wordList;
		}
		
		
		
		private void initializeLabels(int length) {
	        wordLabel = new JLabel[length];
	        Font labelFont = new Font("SANS SERIF",Font.PLAIN, 60);
	       
	        for (int i = 0; i < length; i++) {
	            wordLabel[i] = new JLabel("_");
	            wordLabel[i].setFont(labelFont);
	    
	            add(wordLabel[i]);
	        }
	    }

		public static boolean guess(String letter) {
			boolean correct = false;
			for (int i = 0; i < currentWord.length(); i++) {
				if ( currentWord.substring(i,i + 1).equalsIgnoreCase(letter)) {
					wordLabel[i].setText(letter);
					
					correct = true;
				}
			}
		return correct;
		}

	    public static boolean isWordGuessed() {
	    	guess(currentWord);
	        for (JLabel label : wordLabel) {
	            if (label.getText().equals("_")) {
	            	 
	            	
	            	return false;
	               
	            }
	        }
	        return true;
	    }

	     static void updateDisplay() {
	        for (int i = 0; i < currentWord.length(); i++) {
	            
				wordLabel[i].setText("_");
	        }
	    }
	}

		
		

			
