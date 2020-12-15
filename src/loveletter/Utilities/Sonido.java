package loveletter.Utilities;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido {

	private Clip sonido;
	public Sonido(String path){

        File a = new File(path);
        try {
        	this.sonido = AudioSystem.getClip();
			this.sonido.open(AudioSystem.getAudioInputStream(a));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public void comenzar() {
		this.sonido.start();
	}
	
	public void detener() {
		this.sonido.stop();
	}
	
}
