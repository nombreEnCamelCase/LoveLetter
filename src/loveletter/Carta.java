package loveletter;

import java.util.List;

public abstract class Carta {

	protected int fuerza;
	protected String nombre;
	// Siempre recibo el 1ero como el accionador del efecto y el segundo el objetivo del efecto en caso de que tenga.
	protected abstract void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo);
	protected abstract boolean requiereVictima();
	protected abstract boolean requiereJugadorAccionador();
	//seria llamado por cada carta y 
	///traer el efecto de esa carta llamadora
	
	public int getFuerza() {
		return fuerza;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
