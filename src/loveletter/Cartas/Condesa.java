package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;

public class Condesa extends Carta {
	public Condesa() {
		this.fuerza = 7;
		this.nombre = "Condesa";
		this.imgUri = "assets/cards/condesa.png";
		
		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}

	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
//		if(accionador.getMano().getCartaActual().getNombre() == "Rey" || accionador.getMano().getCartaActual().getNombre() == "Principe")
//			accionador.getMano().jugarCarta(this);

		if (accionador.getMano().tengoCiertaCarta(new Rey()) || accionador.getMano().tengoCiertaCarta(new Principe()))
			accionador.getMano().jugarCarta(this);

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
