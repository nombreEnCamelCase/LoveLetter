package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;;

public class Sacerdote extends Carta {

	public Sacerdote() {
		this.fuerza = 2;
		this.nombre="Sacerdote";
		this.imgUri = "assets/cards/sacerdote.png";
		
		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
		if(objetivo!=null) {
			accionador.verCartasDeMano(objetivo.getMano());
			//tablero.mostrarManoContraria (alerta)
			//objetivo.verCartasDeMano(accionador.getMano());
		}
	}
	
	@Override
	public boolean requiereVictima() {
		return true;
	}
	
	@Override
	public boolean requiereJugadorAccionador() {
		return false;
	}
}
