package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;;

public class Sacerdote extends Carta {

	public Sacerdote() {
		this.fuerza = 2;
		this.nombre="Sacerdote";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo) {
		accionador.verCartasDeMano(objetivo.getMano());
		objetivo.verCartasDeMano(accionador.getMano());
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
