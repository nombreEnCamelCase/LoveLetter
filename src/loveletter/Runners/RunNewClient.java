package loveletter.Runners;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import loveletter.Screens.ClientStartScreen;

public class RunNewClient {
	

	public static void main(String[] args) {
		
		try {
			ClientStartScreen menu = new ClientStartScreen();
			menu.cargarInterfaz();
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
//		String hostname = "localhost";
//		int port = 20000;
//		
//		try {
//			PlayerClient client = new PlayerClient(hostname, port);
//			client.execute();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
