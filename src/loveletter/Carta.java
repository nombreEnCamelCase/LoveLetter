package loveletter;

public abstract class Carta {

	protected int fuerza;
	protected String nombre;
	
	public abstract Carta efecto(Jugador victima);
	public abstract boolean requiereVictima();
	//seria llamado por cada carta y 
	///traer el efecto de esa carta llamadora
	
	public int getFuerza() {
		return fuerza;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
