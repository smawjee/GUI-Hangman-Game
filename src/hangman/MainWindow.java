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

public class MainWindow extends JFrame implements WindowListener {
	
	private HealthPanel healthPanel;
	private WordPanel wordPanel;
	private ArrayList<String> wordList;
	private String currentWord;
	Container cpane;



	
	
	
	public MainWindow()
	{	
		cpane = this.getContentPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("Hangman Game");
		cpane.setLayout(new GridLayout(2,1));
		
		
		
		 healthPanel = new HealthPanel();
		cpane.add(healthPanel,BorderLayout.NORTH);
		setVisible(true);

		wordPanel = new WordPanel();
		cpane.add(wordPanel,BorderLayout.SOUTH);
		
		setVisible(true);
		
		
	

		
		
		
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