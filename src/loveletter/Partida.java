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
	// Es necesario rondas pasadas? Verificar.
	private List<Ronda> rondasPasadas = new LinkedList<Ronda>();
	private int puntajeGanadorDePartida;
	private Ronda rondaActual;
	private Jugador ganadorDePartida=null;

	public Partida() {
 
		// Se crea una nueva partida, deberian pasarle los jugadores, pero lo
		// harcodeamos aca.
		Jugador jugador1 = new Jugador("Maty",1);
		Jugador jugador2 = new Jugador("Fede",2);
		Jugador jugador3 = new Jugador("Javi",3);
		Jugador jugador4 = new Jugador("Nahu",4);
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);

		// Creamos una "Tabla de puntajes"
		tablaPuntaje.put(jugador1, 0);
		tablaPuntaje.put(jugador2, 0);
		tablaPuntaje.put(jugador3, 0);
		tablaPuntaje.put(jugador4, 0);
		puntajeGanadorDePartida = 40;
	}
	 

	public Jugador comenzarJuego() {
		// Chequea que exista la cantidad minima de jugadores.
		Jugador ganadorRonda;
		
		// TODO: Falta contemplar en el while que los jugadores sean los necesarios para jugar y no esten desconectados.
		while ((ganadorDePartida = buscarganadorDePartidaDePartida()) == null) {
			
			if (this.jugadores.size() > 1) {
				this.rondaActual = new Ronda(this.jugadores); // Agrega los jugadores de la partida a ronda actual.
				ganadorRonda = this.rondaActual.comenzar();
				sumarPuntaje(ganadorRonda);
			}
			else
				System.out.println("No se puede iniciar");
		}
		
		mostrarPremio();
		
		return ganadorDePartida;
	}

	// De alguna manera, partida se deberia enterar cuando ronda termina, y asi
	// agregarla a la lista de rondas pasadas.
	// Sirve rondas pasadas? Podria chequiar si existe algun jugador con mas de 5
	// simbolos y sino vuelvo a crear otra ronda.

	public Jugador buscarganadorDePartidaDePartida() {

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

	public void sumarPuntaje(Jugador ganadorDeRonda) {
		// Busco al ganador de ronda en la tabla y le incremento 1;
		tablaPuntaje.computeIfPresent(ganadorDeRonda, (k, v) -> v + 1);
	}
	
	private void mostrarPremio() {
		System.out.println("El ganador es: "+ this.ganadorDePartida.getNombre());
		
		System.out.println("Tabla de puntajes\n----------------\n");
		for (Jugador jugador : this.jugadores) {
			System.out.println("Jugador: "+jugador.getNombre()+" Puntaje: "+this.tablaPuntaje.get(jugador));
		}
		
		
	}
	
	public ArrayList<Jugador> getJugadores(){
		return this.jugadores;
	}
	
	public Ronda getRondaActual() {
		return this.rondaActual;
	}
	
	public Jugador getGanadorDePartida() {
		return this.ganadorDePartida;
	}
	
	public void setTablaPuntaje(Map<Jugador, Integer> tablaPuntaje) {
		this.tablaPuntaje = tablaPuntaje;
	}

	public int  obtenerPuntajeDeJugador(Jugador jugador) {
		return this.tablaPuntaje.get(jugador);
	}
	
	public void setPuntajeGanador(int valor) {
		this.puntajeGanadorDePartida = valor;
	}
	
	public int getPuntajeGanador() {
		return this.puntajeGanadorDePartida;
	}
}
