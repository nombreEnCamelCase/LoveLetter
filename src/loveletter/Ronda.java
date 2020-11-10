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


	private Tablero tableroActual;
	// Es otra lista propia de ronda.
	private ArrayList<Jugador> jugadoresEnJuego = new ArrayList<Jugador>();
	private Jugador ganadorDeRonda = null;

	public Ronda(ArrayList<Jugador> jugadores,Tablero tablero) {
		this.jugadoresEnJuego = jugadores;
		this.mazo = new Mazo();
		this.tableroActual = tablero;
		this.tableroActual.limpiarPantalla();
		this.tableroActual.preparacionInicial();
//		tableroActual.init();
//		tableroActual.run();
	} 

	public Jugador comenzar() {
		this.mazo.prepararParaJuego(); // Retiro una carta random del mazo total y mezclo
		prepararJugadores();// Otorgo una carta a cada jugador de forma inicial
		// Podriamos hacer una transicion para una carta yendo a cada jugador.
		boolean existeGanador = false;

		while (!existeGanador) {

			// Recorro jugador por jugador
			for (int i = 0; i < this.jugadoresEnJuego.size(); i++) {

				Jugador jugadorActual = jugadoresEnJuego.get(i);

				if (quedanCartasEnMazo() && !quedaUnSoloJugador()) {
					if (jugadorPuedeJugar(jugadorActual)) {

						Turno turnoActual = new Turno(jugadorActual);
						jugadorActual.prepararseParaJugar();
						this.tableroActual.agregarCartaAPantalla(jugadorActual.getMano().getCartaActual());
						
						this.tableroActual.setTurnoEnCurso(turnoActual);

						Carta cartaJugada = jugadorActual.getMano().agregarCarta(this.mazo);
						this.tableroActual.agregarCartaAPantalla(cartaJugada);
						
						if (jugadorPoseeCondesa(jugadorActual)) {
							// Jugar condesa.
							(cartaJugada = new Condesa()).aplicarEfectoAJugador(jugadorActual, jugadorActual, this.mazo, this.tableroActual);
							
						}
						
						if(jugadorActual.getMano().cantCartas()>1) {
							// Esperar por carta seleccionada y accion de jugada
							cartaJugada = jugadorActual.realizarJugada(this.jugadoresEnJuego, this.mazo, this.tableroActual);
							this.tableroActual.mostrarCartaApoyadaEnTablero(cartaJugada);
							///pisa la primera...
						}
						
						jugadorActual.terminarTurno();
						turnoActual.setCartaJugada(cartaJugada);
						this.tableroActual.addTurnoPasado(turnoActual);
						this.tableroActual.refrescaPantallaPorTurno();
						
					}

				} else {
					existeGanador = true;
					break;
				}
				
			}
			
		}
		
		return ganadorDeRonda;
	}

	public void prepararJugadores() {
		// A cada uno de los jugadores le doy una carta.
		// Todos los jugadores se crearon en espera y con puntaje cero.
		for (Jugador jugador : this.jugadoresEnJuego) {
			jugador.preparacionInicial(this.mazo,this.tableroActual);
		}
	}

	public boolean quedanCartasEnMazo() {
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

	public boolean quedaUnSoloJugador() {

		// Logica para recorrer los jugadores en juego y retirar los que perdieron.
		// Con esto creo un array auxiliar que voy llenando solo con los jugadores que
		// tienen un estado habilitado para jugar.
		if (this.jugadoresEnJuego.size() == 1) {
			ganadorDeRonda = jugadoresEnJuego.get(0);
			return true;
		}

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

	public boolean jugadorPoseeCondesa(Jugador jugador) {
		return jugador.getMano().tengoCiertaCarta(new Condesa());
	}

	public ArrayList<Jugador> getJugadoresEnJuego() {
		return this.jugadoresEnJuego;
	}

	public Jugador getGanadorDeRonda() {
		return this.ganadorDeRonda;
	}
}
