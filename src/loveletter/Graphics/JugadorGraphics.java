package loveletter.Graphics;

import loveletter.EstadosJugador.Estado;

public class JugadorGraphics {
	
	private String nombre;
	private Estado estado;
	//private ArrayList<Iconos> iconos; (Ver)

	public JugadorGraphics(String nombre, Estado estado) {
		this.nombre = nombre;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	
}
