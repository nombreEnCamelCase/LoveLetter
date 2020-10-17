package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;

public class Condesa extends Carta {
	public Condesa() {
		this.fuerza = 7;
		this.nombre="Condesa";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
//		if(accionador.getMano().getCartaActual().getNombre() == "Rey" || accionador.getMano().getCartaActual().getNombre() == "Principe")
//			accionador.getMano().jugarCarta(this);
		
		if(accionador.getMano().tengoCiertaCarta(new Rey())| accionador.getMano().tengoCiertaCarta(new Principe()))
			accionador.getMano().jugarCarta(this);
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
