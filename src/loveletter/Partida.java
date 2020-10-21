package loveletter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Partida {

	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Map<Jugador, Integer> tablaPuntaje = new HashMap<Jugador, Integer>();
	private List<Ronda> rondasPasadas = new LinkedList<Ronda>();
	private int puntajeGanadorDePartida;
	private Ronda rondaActual;
	private Jugador ganadorDePartida=null;

	public Partida() {
 
		// Se crea una nueva partida, deberian pasarle los jugadores, pero lo
		// harcodeamos aca.
		Jugador jugador1 = new Jugador("Maty");
		Jugador jugador2 = new Jugador("Fede");
		Jugador jugador3 = new Jugador("Javi");
		Jugador jugador4 = new Jugador("Nahu");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);

		// Creamos una "Tabla de puntajes"
		tablaPuntaje.put(jugador1, 0);
		tablaPuntaje.put(jugador2, 0);
		tablaPuntaje.put(jugador3, 0);
		tablaPuntaje.put(jugador4, 0);
		puntajeGanadorDePartida = 5;
	}

	public void comenzarJuego() {
		// Chequea que exista la cantidad minima de jugadores.
		while ((ganadorDePartida = buscarganadorDePartidaDePartida()) == null) {
			
			// TODO Fijarse si 
			if (this.jugadores.size() > 1)
				this.rondaActual = new Ronda(this.jugadores); // Agrega los jugadores de la partida a ronda actual.
			else
				System.out.println("No se puede iniciar");

			sumarPuntaje(this.rondaActual.comenzar());
		}
		
		mostrarPremio();
	}

	// De alguna manera, partida se deberia enterar cuando ronda termina, y asi
	// agregarla a la lista de rondas pasadas.
	// Sirve rondas pasadas? Podria chequiar si existe algun jugador con mas de 5
	// simbolos y sino vuelvo a crear otra ronda.

	private Jugador buscarganadorDePartidaDePartida() {

		Map.Entry<Jugador, Integer> maxEntry = null;

		 // Trae el VALOR MAXIMO DE PUNTAJE de un jugador de la tabla.
		for (Map.Entry<Jugador, Integer> entry : tablaPuntaje.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}

		if (this.puntajeGanadorDePartida == maxEntry.getValue())
			return maxEntry.getKey();
		return null;
	}

	private void sumarPuntaje(Jugador ganadorDeRonda) {
		// Busco al ganador de ronda en la tabla y le incremento 1;
		tablaPuntaje.computeIfPresent(ganadorDeRonda, (k, v) -> v + 1);
	}
	
	private void mostrarPremio() {
		// Hacer algo con el this.ganadorDePartida;
	}
	
	public ArrayList<Jugador> getJugadores(){
		return this.jugadores;
	}

}
