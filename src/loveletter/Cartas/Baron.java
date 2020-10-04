package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;

public class Baron extends Carta {
	
	@Override
	public Carta efecto(Jugador jugador) {
		return this;
	}
	
	@Override
	public boolean requiereVictima() {
		return true;
	}
}
