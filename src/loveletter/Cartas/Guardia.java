package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;

public class Guardia extends Carta {
	
	public Guardia() {
		this.fuerza = 1;
		this.nombre="Guardia";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
		
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
