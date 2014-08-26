
import java.util.Set;

import javax.sound.sampled.AudioInputStream;


import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.util.data.audio.AudioPlayer;

public class MarryMain {

	public static void main(String[] args) throws Exception {
		
		MaryInterface marytts = new LocalMaryInterface();
		
//		Set<String> voices = marytts.getAvailableVoices();
//		System.out.println(voices.size());
//		for(int i=0; i < voices.size(); i++){
//			System.out.println(voices.iterator().next());
//		}
//	
		marytts.setVoice(marytts.getAvailableVoices().iterator().next());

		AudioInputStream audio = marytts.generateAudio("Hi, I'm your computer. These are my first words to the world!");
		AudioPlayer player = new AudioPlayer(audio);
		player.start();
		player.join();
	}

}
