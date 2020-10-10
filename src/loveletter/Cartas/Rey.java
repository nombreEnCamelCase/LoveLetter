package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mano;

public class Rey extends Carta {

	public Rey() {
		this.fuerza = 6;
		this.nombre="Rey";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
		Mano aux = accionador.getMano();
		
		// Intercambio
		accionador.intercambiarMano(objetivo.getMano());
		objetivo.intercambiarMano(aux);
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
