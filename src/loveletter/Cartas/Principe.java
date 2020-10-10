package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;

public class Principe extends Carta {
	
	public Principe() {
		this.fuerza = 5;
		this.nombre="Principe";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
		Carta cartaDescartada = objetivo.getMano().descartarCarta();
		if(cartaDescartada.getNombre() == "Princesa") {
			objetivo.getEstadoActual().perderRonda();
		}
		// Falta ver como agarramos una nueva carta en una instancia que no es el comienzo del turno.
		// El mazo vive en ronda.
	}
	
	
	@Override
	public boolean requiereVictima() {
		return true;
	}
	
	@Override
	public boolean requiereJugadorAccionador() {
		return true;
	}
}
