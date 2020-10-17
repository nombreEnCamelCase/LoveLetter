package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.EstadosJugador.Inmune;

public class Mucama extends Carta {

	public Mucama() {
		this.fuerza = 4;
		this.nombre="Mucama";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
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
