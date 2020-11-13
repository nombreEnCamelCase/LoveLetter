package loveletter.Graphics;

import loveletter.EstadosJugador.Estado;

public class JugadorGraphics {
	
	private String nombre;
	private Estado estado;
	private int puntaje = 0;
	//private ArrayList<Iconos> iconos; (Ver)

	public JugadorGraphics(String nombre, Estado estado, int puntaje) {
		this.nombre = nombre;
		this.estado = estado;
		this.puntaje = puntaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	
}
