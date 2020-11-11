package loveletter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import loveletter.Cartas.Baron;
import loveletter.Graphics.ComponenteGrafico;
import loveletter.Graphics.VentanaAlerta;

//public class Tablero extends JFrame implements Runnable  {
public class Tablero{
	private List<Turno> historialTurnosPasados = new LinkedList<Turno>();
	private Turno turnoEnCurso;
	private ComponenteGrafico pantalla;
	private VentanaAlerta ventana;

	public Tablero() {
		this.pantalla = new ComponenteGrafico();
		// this.ventana = new VentanaAlerta();
	}

	public void refrescarTablero() {
		// TODO Logica para mostrar el tablero actual con respecto a los turnos pasados.
	}

	public void esperarAccion() {
		this.pantalla.realizarTransicion();
	}

	public void addTurnoPasado(Turno turno) {
		this.historialTurnosPasados.add(turno);
	}

	public void setTurnoEnCurso(Turno turno) {
		this.turnoEnCurso = turno;
	}

	public void preparacionInicial() {
		this.pantalla.init();

//		this.pantalla.run();
	}

	/*
	 * TODOS LOS MOSTRAR TIENEN QUE TENER UN WHILE HASTA NO TERMINAR LA TRANSICION
	 * NO PARA.
	 */

	public void mostrarEfectoRecibirCarta(Carta carta) {
		// this.pantalla.realizarTransicion(carta,1);
		// Setear la carta en una de las dos posiciones clickeables de la pantalla.
	}

	public void mostrarEfecto(Carta carta) {

	}

	
	
	public Carta esperarSeleccionCarta() {
		Carta carta = this.pantalla.retornarCartaSeleccionada();
		this.pantalla.refrescarSeleccionDeCarta();
		return carta;
	}

	public void mostrarCartaApoyadaEnTablero(Carta carta) {
				// Mostrar transicion.
				this.pantalla.quitarCartaDeMano(carta);
				// Mostrar transicion
				this.pantalla.setCartaEnTablero(carta);
	}

	public Jugador esperarSeleccionVictima(ArrayList<Jugador> jugadores) {
		this.ventana = new VentanaAlerta(jugadores);
		this.ventana.setVisible(true);
		Jugador respuesta = null;

		while ((respuesta = this.ventana.getJugadorVictima()) == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.ventana.setVisible(false);
		return respuesta;
	}
	
	public Jugador esperarSeleccionVictima() {
		return new Jugador("Fede",1);
	}

	public void agregarCartaAPantalla(Carta carta) {
		this.pantalla.setCartasEnMano(carta);
	}
	
	public void refrescaPantallaPorTurno() {
		this.pantalla.limpiarMano();
		this.pantalla.mostraPantallaCambioTurno();
	}

	public void remplazarCartaEnMano(Carta carta) {
		this.pantalla.remplazarManoEnPantalla(carta);
		
	}

	public void agregarJugadoresAPantalla(ArrayList<Jugador> jugadores) {
		this.pantalla.ponerJugadoresEnPantalla(jugadores);
		
	
	public void limpiarPantalla() {
		this.pantalla.limpiarContenido();
	}
	
	public void cerrarPantalla() {
		this.pantalla.cerrarPantalla();
	}
}
