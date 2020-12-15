package loveletter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import loveletter.Screens.VentanaGanadorPartida;

public class Partida {

	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Map<Jugador, Integer> tablaPuntaje = new HashMap<Jugador, Integer>();
	public static Map<String, Jugador> connectionsList = new HashMap<String, Jugador>();
	// Es necesario rondas pasadas? Verificar.
	private int puntajeGanadorDePartida;
	private Ronda rondaActual;
	private Jugador ganadorDePartida = null;
	private Tablero tablero;

	private VentanaGanadorPartida ventana;

	public Partida(int puntajeGanador) {

		// Se crea una nueva partida, deberian pasarle los jugadores, pero lo
		// harcodeamos aca.
//		Jugador jugador1 = new Jugador("Maty", 1);
//		Jugador jugador2 = new Jugador("Fede", 2);
//		Jugador jugador3 = new Jugador("Javi", 3);
//		Jugador jugador4 = new Jugador("Nahu", 4);
//		this.jugadores.add(jugador1);
//		this.jugadores.add(jugador2);
//		this.jugadores.add(jugador3);
//		this.jugadores.add(jugador4);

		// Creamos una "Tabla de puntajes"
		
//		this.tablaPuntaje.put(jugador1, 0);
//		this.tablaPuntaje.put(jugador2, 0);
//		this.tablaPuntaje.put(jugador3, 0);
//		this.tablaPuntaje.put(jugador4, 0);
//		this.puntajeGanadorDePartida = 2;
		this.puntajeGanadorDePartida = puntajeGanador;
		
		this.tablero = new Tablero();

	}

	public Jugador comenzarJuego() {
		// El chequeo de la cantidad minima deberia hacerse antes de esto, no deberia comenzar el juego si no hay al menos dos.
		Jugador ganadorRonda;
		inicializarTablaPuntaje();
		
		// TODO: Falta contemplar en el while que los jugadores sean los necesarios para
		// jugar y no esten desconectados.
		while ((ganadorDePartida = buscarganadorDePartidaDePartida()) == null) {

			if (this.jugadores.size() > 1) {
				this.rondaActual = new Ronda(this.jugadores, this.tablero); // Agrega los jugadores de la partida a
																			// ronda actual.
				ganadorRonda = this.rondaActual.comenzar();
				sumarPuntaje(ganadorRonda);
				sumarSimbolosDeAfecto(ganadorRonda);
			
				System.out.println("Gano la ronda: "+ganadorRonda.getNombre());
			}
			else
				System.out.println("No se puede iniciar");
		}

		mostrarPremio();
		ventanaGanador();

		return ganadorDePartida;
	}

	private void ventanaGanador() {
		ventana = new VentanaGanadorPartida(jugadores, ganadorDePartida, tablaPuntaje);
		this.ventana.setVisible(true);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void sumarSimbolosDeAfecto(Jugador ganador) {
		int total = ganador.getPuntaje() + 1;
		for(Jugador j : this.jugadores) {
			if(j.getNombre() == ganador.getNombre()) {
				j.setPuntaje(total);
			}
		}
	}

	public void sumarPuntaje(Jugador ganadorDeRonda) {
		// Busco al ganador de ronda en la tabla y le incremento 1;
		tablaPuntaje.computeIfPresent(ganadorDeRonda, (k, v) -> v + 1);
	}

	private void mostrarPremio() {
		System.out.println("El ganador es: " + this.ganadorDePartida.getNombre());

		System.out.println("Tabla de puntajes\n----------------\n");
		for (Jugador jugador : this.jugadores) {
			System.out.println("Jugador: " + jugador.getNombre() + " Puntaje: " + this.tablaPuntaje.get(jugador));
		}

		this.tablero.cerrarPantalla();

		System.out.println("Termino partida!");

	}

	public ArrayList<Jugador> getJugadores() {
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

	public int obtenerPuntajeDeJugador(Jugador jugador) {
		return this.tablaPuntaje.get(jugador);
	}

	public void setPuntajeGanador(int valor) {
		this.puntajeGanadorDePartida = valor;
	}

	public int getPuntajeGanador() {
		return this.puntajeGanadorDePartida;
	}
	
	public void addNewPlayer(Jugador jugador) {
		Partida.connectionsList.put(jugador.getNombre(), jugador);
		this.jugadores.add(jugador);
	}
	
	private void inicializarTablaPuntaje() {
		for(Jugador jugador : this.jugadores) {
			this.tablaPuntaje.put(jugador, 0);
		}
	}
	
}


