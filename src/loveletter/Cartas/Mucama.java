package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;

public class Mucama extends Carta {

	public Mucama() {
		this.fuerza = 4;
		this.nombre="Mucama";
	}
	
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
		accionador.getEstadoActual().obtenerInmunidad();
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
