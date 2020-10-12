package loveletter;

import loveletter.EstadosJugador.*;

public class Turno {
//	int nroTurno;
	Carta cartaJugada;
	Jugador responsable;
	
	public Turno(Jugador jugador) {
		this.responsable = jugador;
	}

	public boolean jugadorPuedeJugar() {
		// Aca se verifica si el jugador NO ESTA FUERA DE PARTIDA, lo pasamos estado EN JUEGO y lo dejamos ejecutar su turno.
		if(this.responsable.getEstadoActual().equals(new EnEspera())|| this.responsable.getEstadoActual().equals(new Inmune())){
			// Lo dejo ejecutar el turno.
			this.responsable.prepararseParaJugar();
			return true;
		}
		return false;
	}
	
	public void setCartaJugada(Carta carta) {
		this.cartaJugada = carta;
	}
	
}
