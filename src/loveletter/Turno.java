package loveletter;

import loveletter.EstadosJugador.*;

public class Turno {
//	int nroTurno;
	Carta cartaJugada;
	Jugador responsable;
	
	public Turno(Jugador jugador) {
		this.responsable = jugador;
	}

	
	public void setCartaJugada(Carta carta) {
		this.cartaJugada = carta;
	}
	
}
