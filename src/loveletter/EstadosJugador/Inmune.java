package loveletter.EstadosJugador;

public class Inmune  extends Estado {

	@Override
	public Estado salirPartida() {
		return new FueraDePartida(); // Si salis del juego
	}
	
	@Override
	public Estado perderRonda() {
		return new FueraDeRonda(); // Si otro jugador hace que pierdas.
	}
	
	@Override
	public Estado comenzarTurno() {
		return new EnJuego();
	}
}
