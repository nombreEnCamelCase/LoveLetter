package loveletter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.Estado;

public class Jugador {
	
	private String nombre;
	
	private int puntaje; //simbolo de afecto
	
	private Estado estadoActual = new EnEspera();
	
	Mano mano;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntaje=0;
		mano = new Mano();
	}
	
	public Carta realizarJugada(ArrayList<Jugador> jugadoresDisponibles) {
		Carta cartaJugada = jugarCartaRandom();
		
		if(cartaJugada.requiereVictima()) // Si el efecto de la carta seleccionada por el jugador requiere victima
			cartaJugada.aplicarEfectoAJugador(seleccionarVictima(jugadoresDisponibles)); // Selecciono victima y se la mando al efecto de la carta.
		else
			cartaJugada.aplicarEfectoAJugador(this); // Si no requiere victima, soy yo el objetivo.
		// A veces la carta tiene un efecto con la victima implicita como el due�o de la misma.
		this.estadoActual.terminarTurno();
		
		return cartaJugada; // Devuelvo la carta jugada unicamente para guardarla en turno y saber en que momento se uso, quien la uso y tenerla como historial en el tablero.
	}
	
	private Jugador seleccionarVictima(ArrayList<Jugador> jugadoresDisponibles) {
		// Accion de jugador al elegir una carta.
		return seleccionarVictimaRandom(jugadoresDisponibles);
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
	
	public void prepararseParaJugar() {
		this.estadoActual.comenzarTurno();
	}
	
	public void preparacionInicial(Carta carta) {
		this.puntaje = 0;
		recibirCarta(carta);
	}
	
	// Simula seleccion del usuario
	private Carta jugarCartaRandom() {
		return this.mano.jugarCarta();
	}
	
	public void recibirCarta(Carta carta) {
		this.mano.agregarCarta(carta);
	}
	
	public Carta descartarCarta() {// Sin efecto.
		 Carta cartaDescartada = this.mano.removerCarta();
		return cartaDescartada;
	}
	
	// El tema esta en que si efecto de carta debe decirle al jugador cuando agarrar del mazo, el efecto deberia conocer el mazo para
	// que el pueda retirar y darle una carta.
	
	

}
