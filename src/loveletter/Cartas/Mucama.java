package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.EstadosJugador.Inmune;
import loveletter.Mazo;
import loveletter.Tablero;

public class Mucama extends Carta {

	public Mucama() {
		this.fuerza = 4;
		this.nombre="Mucama";
		this.imgUri = "assets/cards/mucama.png";
		
		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
		//accionador.getEstadoActual().obtenerInmunidad();
		accionador.setEstadoActual(accionador.getEstadoActual().obtenerInmunidad());
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
