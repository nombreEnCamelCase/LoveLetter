package loveletter;

public abstract class Carta {

	int fuerza;
	String efecto; //seguramente sea otro tipo
	String nombre;
	
	public abstract Carta efecto();//seria llamado por cada carta y 
	///traer el efecto de esa carta llamadora
	
	public int getFuerza() {
		return fuerza;
	}
	
	public String getNombre() {
		return nombre;
	}
}
