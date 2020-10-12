package loveletter.EstadosJugador;

public class EnEspera extends Estado {

	@Override
	public Estado salirPartida() {
		return new FueraDePartida(); // Si salis del juego
	}
	
	@Override
	public Estado perderRonda() {
		return new FueraDeRonda(); // Si otro jugador hace que pierdas.
	}
	
	// En espera podes ganar la ronda, pero ganar la ronda no existe, el otro pierde.
	// Tecnicamente ganas cuando los demas perdieron jaja.
	// No me parece necesario un estado de ganador.
	
	
	@Override
	public Estado comenzarTurno() {
		return new EnJuego();
	}
	
	
	// Se puede activar la mucama no siendo el turno tuyo? Onda que otro jugador te la active a vos?
	// Se me hace que no.
//	@Override
//	public Estado obtenerInmunidad() {
//		return new Inmune(); // Si tiras la mucama
//	}
	
}
