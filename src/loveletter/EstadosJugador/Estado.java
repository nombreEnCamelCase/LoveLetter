package loveletter.EstadosJugador;

public class Estado {
	public Estado perderRonda() {
		return this;
	}

	public Estado obtenerInmunidad() {
		return this;
	}

	public Estado salirPartida() {
		return this;
	}
	
	public Estado comenzarTurno() {
		return this;
	}
	
	public Estado terminarTurno() {
		return this;
	}
	
	public Estado reinciar() {
		return this;
	}
	

	@Override
	public boolean equals(Object obj) {
		return obj.getClass().getName().equals(this.getClass().getName());
	}
	
	
}
