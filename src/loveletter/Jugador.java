package loveletter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.Estado;

public class Jugador {
	
	private String nombre;
	
	
	private Estado estadoActual = new EnEspera();
	
	Mano mano;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		mano = new Mano();
	}
	
	// Es un realizar turno.
	public Carta realizarJugada(ArrayList<Jugador> jugadoresDisponibles) {
		Carta cartaJugada = jugarCartaRandom();
		if(cartaJugada.requiereVictima()) // Si el efecto de la carta seleccionada por el jugador requiere victima
			cartaJugada.aplicarEfectoAJugador(this,seleccionarVictima(jugadoresDisponibles, cartaJugada.requiereJugadorAccionador())); // Selecciono victima y se la mando al efecto de la carta.
		else
			cartaJugada.aplicarEfectoAJugador(this,null); // Si no requiere victima, soy yo el objetivo.
		// A veces la carta tiene un efecto con la victima implicita como el dueño de la misma.
		this.estadoActual.terminarTurno();
		
		return cartaJugada; // Devuelvo la carta jugada unicamente para guardarla en turno y saber en que momento se uso, quien la uso y tenerla como historial en el tablero.
	}
	
	private Jugador seleccionarVictima(ArrayList<Jugador> jugadoresDisponibles, boolean incluyeActual) {
		// Accion de jugador al elegir una carta.
		// Recibo los jugadores disponibles EXCEPTO el actual.
		// Creo un aux para agregarme como parametro.
		ArrayList<Jugador> aux = jugadoresDisponibles;

		if(incluyeActual)
			aux.add(this);
		
		// Mostrar el listado de aux para que el usuario seleccione.
		return seleccionarVictimaRandom(aux);
	}
	
	private Jugador seleccionarVictimaRandom(ArrayList<Jugador> jugadoresDisponibles) {
		try {
			Iterator<Jugador> iter = jugadoresDisponibles.iterator();
			Jugador victimaSeleccionada = iter.next();
			return victimaSeleccionada;
		}catch(Exception e) {
			System.out.println("Fallo al seleccionar jugador random");
		}
		return null;
	}
	
	public Estado getEstadoActual() {
		return this.estadoActual;
	}
	
	
	public Mano getMano() {
		return this.mano;
	}
	
	
	public void prepararseParaJugar() {
		this.estadoActual.comenzarTurno();
	}
	
	public void preparacionInicial(Mazo mazo) {
		this.mano.tomarCarta(mazo);
		//recibirCarta(carta);
	}
	
	// Simula seleccion del usuario
	private Carta jugarCartaRandom() {
		
		return this.mano.jugarCarta(null);
	}
	
//	public void recibirCarta(Carta carta) {
//		this.mano.agregarCarta(carta);
//	}

	public Carta descartarCarta() {// Sin efecto.
		 Carta cartaDescartada = this.mano.descartarCarta();
		return cartaDescartada;
	}
	
	public Mano verCartasDeMano(Mano manoContrincante) {
		return manoContrincante;
	}
	
	public void intercambiarMano(Mano manoContrincante) {
		 this.mano = manoContrincante;
	}
	
	// El tema esta en que si efecto de carta debe decirle al jugador cuando agarrar del mazo, el efecto deberia conocer el mazo para
	// que el pueda retirar y darle una carta.
	
	

}
