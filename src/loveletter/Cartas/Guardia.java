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
		Carta carta = new Baron(); ///simulo q el accionador intenta adivinar q tiene baron en la mano
		if(carta == objetivo.getMano().getCartaActual()) {
			objetivo.setEstadoActual(objetivo.getEstadoActual().perderRonda());
		}
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
