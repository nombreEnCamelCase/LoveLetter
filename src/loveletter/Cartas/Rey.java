package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mano;
import loveletter.Mazo;
import loveletter.Tablero;

public class Rey extends Carta {

	public Rey() {
		this.fuerza = 6;
		this.nombre="Rey";
		this.imgUri = "assets/cards/rey.png";
		
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
		Mano aux = accionador.getMano();
		
		// Intercambio
		accionador.intercambiarMano(objetivo.getMano());
		objetivo.intercambiarMano(aux);
		
		tablero.remplazarCartaEnMano(accionador.getMano().getCartaActual());
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
