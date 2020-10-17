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
	
	
	///testeo de mazo, para el contains involucra el equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Carta carta = (Carta) obj;
		if (obj.equals(carta) && (this.fuerza == carta.fuerza) && (this.nombre == carta.nombre)) {
			return true;
		} else {
			return false;
		}

	}
	
}
