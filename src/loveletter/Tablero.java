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
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import loveletter.Cartas.Baron;
import loveletter.Graphics.ComponenteGrafico;


//public class Tablero extends JFrame implements Runnable  {
public class Tablero extends JFrame {
	private List<Turno> historialTurnosPasados = new LinkedList<Turno>();
	private Turno turnoEnCurso;
	private ComponenteGrafico pantalla;
	
	public Tablero() {
		this.pantalla = new ComponenteGrafico();
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
	 *  TODOS LOS MOSTRAR TIENEN QUE TENER UN WHILE HASTA NO TERMINAR LA TRANSICION NO PARA.
	 * */
	
	public void mostrarEfectoRecibirCarta(Carta carta) {
		
	}
	
	public void mostrarEfecto(Carta carta) {
		
	}
	
	public Carta esperarSeleccionCarta() {
		
		return this.pantalla.retornarCartaSeleccionada();
		//return new Baron();
	}
	
	public void mostrarCartaApoyadaEnTablero(Carta carta) {
		
	}
	
	public Jugador esperarSeleccionVictima() {
		return new Jugador("DummyJugador",1);
	}
}
