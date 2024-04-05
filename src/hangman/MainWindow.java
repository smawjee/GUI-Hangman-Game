package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainWindow extends JFrame {
	
	private HealthPanel healthPanel;
	private static WordPanel wordPanel;
	private ArrayList<String> wordList;
	private String currentWord;
	private ButtonPanel buttonPanel;
	static Container cpane;

	public static Container getCpane() {
		return cpane;
	}

	public MainWindow()
	{	
		cpane = this.getContentPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,700);
		setTitle("Hangman Game");
		cpane.setLayout(new GridLayout(3,1));
		
		
		healthPanel = new HealthPanel();
		cpane.add(healthPanel,BorderLayout.NORTH);
		setVisible(true);

		wordPanel = new WordPanel();
		cpane.add(wordPanel,BorderLayout.CENTER);
		
		setVisible(true);
		
		buttonPanel = new ButtonPanel(wordPanel);
		cpane.add(buttonPanel,BorderLayout.SOUTH);
		setVisible(true);

		}
	public static void ResetGamePanel()
	{
		cpane.removeAll();
		WordPanel.setCurrentWord(WordPanel.getCurrentWord());
		cpane.add(new HealthPanel());
		cpane.add(new WordPanel());
		cpane.add(new ButtonPanel(wordPanel));
		cpane.revalidate();
		cpane.repaint();
		
	}
	
}
	
	
	
		
				
