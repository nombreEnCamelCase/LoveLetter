package loveletter;

public abstract class Carta {

	private int fuerza;
	private String efecto; //seguramente sea otro tipo
	private String nombre;
	
	public abstract boolean efecto();//seria llamado por cada carta y 
	///traer el efecto de esa carta llamadora
}
