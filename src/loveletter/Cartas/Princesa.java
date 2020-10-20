package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;

public class Princesa extends Carta {
	
	public Princesa() {
		this.fuerza = 8;
		this.nombre="Princesa";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo) {
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
