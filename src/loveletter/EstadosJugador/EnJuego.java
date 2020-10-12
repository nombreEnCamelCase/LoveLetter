package loveletter.EstadosJugador;


public class EnJuego extends Estado{

	@Override
	public Estado terminarTurno() {
		return new EnEspera(); // Si terminas normalmente el turno
	}
	
	@Override
	public Estado salirPartida() {
		return new FueraDePartida(); // Si salis del juego
	}
	
	@Override
	public Estado perderRonda() {
		return new FueraDeRonda(); // Si tiras la pricesa
	}
	
	@Override
	public Estado obtenerInmunidad() {
		return new Inmune(); // Si tiras la mucama
	}
}
