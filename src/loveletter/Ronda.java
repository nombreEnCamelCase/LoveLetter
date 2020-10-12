package loveletter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ronda {
	
	private Mazo mazo;
	// Esta lista de turnosRealizados la uso como historial y para chequear si es posible ejecutar algo en el turno.
	// Cosa de poder mostrar en orden las cartas jugadas.
	private List<Turno> turnosRealizados = new LinkedList<Turno>(); 
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	public Ronda(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.mazo = new Mazo();
	}
	
	// Hay que manejar mejor esto porqeu solo termina cuando no quedan cartas, hay que rechequear estados de los demas jugadores
	public void comenzar() {
		mazo.prepararParaJuego(); // Retiro una carta random del mazo total y mezclo
		prepararJugadores();// Otorgo una carta a cada jugador de forma inicial
		
		// Mientras existan cartas en el mazo
		while(mazo.consultarCantidad()>0 && buscarGanadorDeRonda()==null) {
			// Recorro jugador por jugador
			for (int i = 0; i < this.jugadores.size(); i ++) {
				// Al turno de la ronda lo creo y lo agrego a la lista.
				// Le agrego el jugador.
				Jugador jugadorActual = jugadores.get(i);
				Turno turnoActual = new Turno(jugadorActual);
				if(turnoActual.jugadorPuedeJugar()) {
					// Al jugador se le da una carta.
					///jugadores.get(i).recibirCarta(mazo.retirarCarta());
					
					// El jugador juega una carta de su mano.
					// Ver como pasar todos los jugadores que no sean yo.
					Carta cartaJugada = null;
					if((cartaJugada = jugadorActual.getMano().tomarCarta(this.mazo)).getNombre() == "Condesa")
						cartaJugada.aplicarEfectoAJugador(jugadorActual, null);
					else
						cartaJugada = jugadorActual.realizarJugada(this.jugadores);
					
					//cartaJugada.efecto(Jugadores); // Suponte que le mando la lista de jugadores para que el efecto conosca
					// todos los jugadores disponibles para aplicar el efecto... 
					// La decision de elegir la victima deberia estar en el jugador, por ende creo que el efecto debe ser llamado dentro
					// del jugador.
					
				}
				this.turnosRealizados.add(turnoActual);
				
				
				// Quiza, podriamos decir que la partida una vez arrancada, ya tiene designados los turnos correspondientes a cada jugador.
				// El hecho de que pierda alguno, es indiferente ya que el turno chequeara el estado del jugador en un determinado momento que se ejecute.
				// Y si el estado es viable, hara lo necesairo.
				// El jugador tiene 2 estados para chequear mientras ejecuta el turno, y dos para recibir un ataque/efecto
				//Turno fuera de juego y en juego, y ataque inmune y en juego.
			}
			
			// Luego de una vuelta de turnos, debo rechequear los estados de los jugadores.
			// Se hace arriba en el metodo privado hayGanador.
			
		}

	}
	
	private void prepararJugadores() {
		// A cada uno de los jugadores le doy una carta.
		// Todos los jugadores se crearon en espera y con puntaje cero.
		for(Jugador jugador : this.jugadores) {
			jugador.getMano().tomarCarta(this.mazo);
		}
	}
	
	private Jugador buscarGanadorDeRonda() {
		// Rechequear todos los jugadores a ver si existe solo uno en espera.
		return null;
	}
	
	private int retornarCantidadJugadoresDisponibles() {
		// Todo: hacer la logica para devolver solo los jugadores disponibles y no el total.
		return this.jugadores.size();
	}
}
