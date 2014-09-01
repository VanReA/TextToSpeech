package core;

//import java.util.Set;

import javax.sound.sampled.AudioInputStream;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

public class MarryMain {

	private MaryInterface marytts ;
	private AudioInputStream audioStream;
	private AudioPlayer audioPlayer;
	
	public MarryMain(){
		 try {
			marytts = new LocalMaryInterface();
			marytts.setVoice(marytts.getAvailableVoices().iterator().next());
		} catch (MaryConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void speack (String text2Speack){
		try {
			audioStream = marytts.generateAudio(text2Speack);
			audioPlayer = new AudioPlayer(audioStream);
			audioPlayer.start();
			audioPlayer.join();
		} catch (SynthesisException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args) throws Exception {
//		
//		MaryInterface marytts = new LocalMaryInterface();
//		
////		Set<String> voices = marytts.getAvailableVoices();
////		System.out.println(voices.size());
////		for(int i=0; i < voices.size(); i++){
////			System.out.println(voices.iterator().next());
////		}
////	
//		AudioInputStream audio = marytts.generateAudio("Hi, I'm your computer. These are my first words to the world!");
//		AudioPlayer player = new AudioPlayer(audio);
//		player.start();
//		player.join();
//	}

}
