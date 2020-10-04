package loveletter.EstadosJugador;

public class FueraDeRonda extends Estado {

	@Override
	public Estado reinciar() {
		return new EnEspera(); // Si los jugadores siempre son los mismos y sus estados persisten, entonces deberia poder reinciar el estado de fuera de ronda
	}
	
	@Override
	public Estado salirPartida() {
		return new FueraDePartida(); // Si salis del juego
	}
	
}
