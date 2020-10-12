package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;

public class Princesa extends Carta {
	
	public Princesa() {
		this.fuerza = 8;
		this.nombre="Princesa";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
		accionador.getEstadoActual().perderRonda();
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
