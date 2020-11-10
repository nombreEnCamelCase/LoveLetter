package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;

public class Principe extends Carta {

	public Principe() {
		this.fuerza = 5;
		this.nombre = "Principe";
		this.imgUri = "assets/cards/principe.png";

		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}

	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
		Carta cartaDescartada = objetivo.getMano().descartarCarta();
		if (cartaDescartada.getNombre() == "Princesa")
			objetivo.setEstadoActual(objetivo.getEstadoActual().perderRonda());
		else {
			if (mazo.consultarCantidad() > 0) { 
				// TODO Hay que analizar bien el caso en que levantes una carta y sea la
				// ultima del mazo y tengas principe y puedas usarlo para hacerle
				// descartar una carta a otro que tiene una sola en la mano y lo dejes
				// sin carta y no entra en la competicion final de fuerzas
				objetivo.getMano().agregarCarta(mazo);
			}
		}

	}

	@Override
	public boolean requiereVictima() {
		return true;
	}

	@Override
	public boolean requiereJugadorAccionador() {
		return true;
	}
}
