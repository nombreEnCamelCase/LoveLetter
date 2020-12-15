package loveletter.Runners;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import loveletter.Screens.ClientStartScreen;

public class RunNewClient {
	
	private final static int PORT = 20000;
	public static void main(String[] args) {
		
		try {
			ClientStartScreen menu = new ClientStartScreen(PORT);
			menu.cargarInterfaz(PORT);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
