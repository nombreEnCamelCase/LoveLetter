package loveletter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import loveletter.Cartas.Condesa;
import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.Inmune;

public class Ronda {
	// Esta clase se comportaria como un game manager.
	private Mazo mazo;

	// Esta lista de turnosRealizados la uso como historial y para chequear si es
	// posible ejecutar algo en el turno.
	// Cosa de poder mostrar en orden las cartas jugadas.

	private Tablero tableroActual = new Tablero();
	// Es otra lista propia de ronda.
	private ArrayList<Jugador> jugadoresEnJuego = new ArrayList<Jugador>();
	private Jugador ganadorDeRonda = null;

	public Ronda(ArrayList<Jugador> jugadores) {
		this.jugadoresEnJuego = jugadores;
		this.mazo = new Mazo();
	}

	public Jugador comenzar() {
		this.mazo.prepararParaJuego(); // Retiro una carta random del mazo total y mezclo
		prepararJugadores();// Otorgo una carta a cada jugador de forma inicial
		boolean existeGanador = false;

		while (!existeGanador) {
			
			// Recorro jugador por jugador
			for (int i = 0; i < this.jugadoresEnJuego.size(); i++) {
				
				Jugador jugadorActual = jugadoresEnJuego.get(i);
				Turno turnoActual = new Turno(jugadorActual);

				if (jugadorPuedeJugar(jugadorActual)) {

					jugadorActual.prepararseParaJugar();

					Carta cartaJugada = jugadorActual.getMano().agregarCarta(mazo);
					if (!(existeGanador = !quedanCartasEnMazo())) {
						if (jugadorPoseeCondesa(jugadorActual))
							(new Condesa()).aplicarEfectoAJugador(jugadorActual, jugadorActual,mazo);
						else
							cartaJugada = jugadorActual.realizarJugada(this.jugadoresEnJuego,mazo);

						this.tableroActual.addTurnoPasado(turnoActual);
						existeGanador = quedaUnSoloJugador();
					}
					else break;

				}

			}
		}
		return ganadorDeRonda;
	}

	public void prepararJugadores() {
		// A cada uno de los jugadores le doy una carta.
		// Todos los jugadores se crearon en espera y con puntaje cero.
		for (Jugador jugador : this.jugadoresEnJuego) {
			jugador.preparacionInicial(this.mazo);
		}
	}

	private boolean quedanCartasEnMazo() {
		if (this.mazo.consultarCantidad() == 0) {
			// Logica para devolver el ganadorDeRonda con la carta mas fuerte.
			
			for (int i = 0; i < this.jugadoresEnJuego.size(); i++) {
				if (i == 0 || jugadoresEnJuego.get(i).getMano().obtenerMayorFuerza() > ganadorDeRonda.getMano()
						.obtenerMayorFuerza())
					ganadorDeRonda = jugadoresEnJuego.get(i);
			}
			return false;
		}
		return true;
	}

	private boolean quedaUnSoloJugador() {

		// Logica para recorrer los jugadores en juego y retirar los que perdieron.
		// Con esto creo un array auxiliar que voy llenando solo con los jugadores que
		// tienen un estado habilitado para jugar.

		ArrayList<Jugador> soloEnJuego = new ArrayList<Jugador>();
		for (int i = 0; i < this.jugadoresEnJuego.size(); i++) {
			if (jugadorPuedeJugar(jugadoresEnJuego.get(i)))
				soloEnJuego.add(jugadoresEnJuego.get(i));
		}

		// Si solo agregue a uno, tenemos ganadorDeRonda.
		if (soloEnJuego.size() == 1)
			ganadorDeRonda = soloEnJuego.get(0);
		else
			this.jugadoresEnJuego = soloEnJuego;

		return ganadorDeRonda != null;
	}

	public boolean jugadorPuedeJugar(Jugador actual) {
		// Aca se verifica si el jugador NO ESTA FUERA DE PARTIDA, lo pasamos estado EN
		// JUEGO y lo dejamos ejecutar su turno.
		if (actual.getEstadoActual().equals(new EnEspera()) || actual.getEstadoActual().equals(new Inmune())) {
			// Lo dejo ejecutar el turno.
			return true;
		}
		return false;
	}

	private boolean jugadorPoseeCondesa(Jugador jugador) {
		return jugador.getMano().tengoCiertaCarta(new Condesa());
	}
	
	public ArrayList<Jugador> getJugadoresEnJuego(){
		return this.jugadoresEnJuego;
	}
	
	public Jugador getGanadorDeRonda() {
		return this.ganadorDeRonda;
	}
}
