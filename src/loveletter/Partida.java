package loveletter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partida {

	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private List<Ronda> rondasPasadas = new LinkedList<Ronda>();
	private Ronda rondaActual;
	// Manejar los puntajes por aca.
	public Partida() {
		
	}
	
	public void comenzarJuego() {
		// Chequea que exista la cantidad minima de jugadores.
		if(this.jugadores.size()>1)
			this.rondaActual = new Ronda(this.jugadores); // Agrega los jugadores de la partida a ronda actual.
		else
			System.out.println("No se puede iniciar");
		
		this.rondaActual.comenzar();
	}
	
	// De alguna manera, partida se deberia enterar cuando ronda termina, y asi agregarla a la lista de rondas pasadas.
	// Sirve rondas pasadas? Podria chequiar si existe algun jugador con mas de 5 simbolos y sino vuelvo a crear otra ronda.
	
	public Jugador buscarGanadorDePartida() {
		// To do buscar entre todos los jugadores de la ronda y ver si alguno llego al limite de los puntos necesarios para ganar.
		return jugadores.get(0);
	}
}
