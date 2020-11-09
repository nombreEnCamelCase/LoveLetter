package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;

public class Princesa extends Carta {
	
	public Princesa() {
		this.fuerza = 8;
		this.nombre="Princesa";
		this.imgUri = "assets/cards/princesa.png";
		
		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
		accionador.getMano().jugarCarta(this);
		accionador.setEstadoActual(accionador.getEstadoActual().perderRonda());
		// Este metod es cuando jugas la carta.
	}
	
	@Override
	public boolean requiereVictima() {
		return false;
	}
	
	@Override
	public boolean requiereJugadorAccionador() {
		return false;
	}
}
