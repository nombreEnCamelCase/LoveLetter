package loveletter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.Estado;
import loveletter.EstadosJugador.FueraDeRonda;

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
	//public Carta realizarJugada(ArrayList<Jugador> jugadoresDisponibles, Mazo mazo) {
	//todos los efectos de la carta tienen que traer el mazo this.mazo
	//a todas las cartas
	//agregar el mazo aplicar efecto, tira error en todas las cartas, se modifica eso, solo en las que usa el mazo
	//Se agraga argumento mazo, solo tiene sentido con carta principe y condesa
	public Carta realizarJugada(ArrayList<Jugador> jugadoresDisponibles, Mazo mazo) {
		Carta cartaJugada = jugarCartaRandom();
		if(cartaJugada.requiereVictima()) // Si el efecto de la carta seleccionada por el jugador requiere victima
			cartaJugada.aplicarEfectoAJugador(this,seleccionarVictima(jugadoresDisponibles, cartaJugada.requiereJugadorAccionador()), mazo); // Selecciono victima y se la mando al efecto de la carta.
		else
			cartaJugada.aplicarEfectoAJugador(this,this, mazo); // Si no requiere victima, soy yo el objetivo.
		
		return cartaJugada; // Devuelvo la carta jugada unicamente para guardarla en turno y saber en que momento se uso, quien la uso y tenerla como historial en el tablero.
	}
	
	public Jugador seleccionarVictima(ArrayList<Jugador> jugadoresDisponibles, boolean incluyeActual) {
		// Accion de jugador al elegir una carta.
		// Recibo los jugadores disponibles EXCEPTO el actual.
		// Creo un aux para agregarme como parametro.
		ArrayList<Jugador> aux = new ArrayList<>(); 
		for (Jugador e : jugadoresDisponibles) {
			aux.add(e);
		}

		if(!incluyeActual) { ///agrege este if para que lo remueva si no lo incluye por el boolean
			aux.remove(this);
		}
		
		// Mostrar el listado de aux para que el usuario seleccione.
		return seleccionarVictimaRandom(aux);
	}
	
	private Jugador seleccionarVictimaRandom(ArrayList<Jugador> jugadoresDisponibles) {
		
		//return jugadoresDisponibles.get(0);
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
	
	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
	}
	
	public Mano getMano() {
		return this.mano;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void prepararseParaJugar() {
		this.estadoActual = this.estadoActual.comenzarTurno();
	}
	
	public void terminarTurno() {
		this.estadoActual = this.estadoActual.terminarTurno();
	}
	
	public void preparacionInicial(Mazo mazo) {
		this.puntaje = 0;
		this.mano = new Mano();
		this.mano.agregarCarta(mazo);
	}
	
	// Simula seleccion del usuario
	public Carta jugarCartaRandom() {
		return this.mano.jugarCarta(null);
	}
	

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
