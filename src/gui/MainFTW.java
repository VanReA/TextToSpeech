package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.MarryMain;
import dataBase.GoogleSearchEngine;
import dataBase.SearchIntoWeb;

public class MainFTW {

	final SearchIntoWeb genreSearch = new SearchIntoWeb();
	final GoogleSearchEngine searchEngine = new  GoogleSearchEngine();
	final MarryMain speakLady = new MarryMain();
	
	String text2Speack = "";
	List<String> dummyList = new ArrayList<String>();
	
	public void shit(String movieTitle){
		dummyList = genreSearch.movieGenres(searchEngine.getMovieURL(movieTitle));
		for(String genre :  dummyList)
			text2Speack = text2Speack + ", " + genre;
		speakLady.speack(text2Speack);
		text2Speack = "";
		System.out.println("END!");
	}
	
	public void GUI(){
		
		
		JFrame theWindow = new JFrame("Talking AI");
		theWindow.setLayout(null);
		theWindow.setSize(700, 350);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 0, 700, 350);
	    panel.setLayout(null);

//	    JTextField resultBox = new JTextField();
//	    resultBox.setBounds(15, 271, 530, 30);
	    
	    final JTextField talkingTextBox = new JTextField();
	    talkingTextBox.setBounds(15, 271, 530, 30);
	    
	    JButton sendButton = new JButton("Talk!");
	    sendButton.setBounds(570, 270, 130, 70);
	    sendButton.setSize(110, 30);
	    sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shit(talkingTextBox.getText());
			}
		});

	    panel.add(sendButton);
	    panel.add(talkingTextBox);
	    
	    
	    theWindow.add(panel);
	    theWindow.setVisible(true);
	    
	}
	public static void main(String[] args) {

		MainFTW startGUI = new MainFTW();
		startGUI.GUI();
		
	}

}
