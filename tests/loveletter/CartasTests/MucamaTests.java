package loveletter.CartasTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;
import loveletter.Cartas.Mucama;
import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.EnJuego;
import loveletter.EstadosJugador.Inmune;

public class MucamaTests {

	private Mucama mucama;
	private Jugador jugador;
	private Mazo mazo;
	private Tablero tablero=null;
	
	@Before
	public void setUp() {
		mucama = new Mucama();
		jugador = new Jugador("LoveLotter",1);
	}
	
	@Test
	public void constructorTests() {
		
		assertEquals(4, mucama.getFuerza());
		assertEquals("Mucama", mucama.getNombre());
	}
	
	@Test
	public void requerirVictimaTests() {
		assertFalse(mucama.requiereVictima());
	}
	
	@Test
	public void requiereJugadorAccionadorTests() {
		assertFalse(mucama.requiereJugadorAccionador());
	}
	
	@Test
	public void aplicarEfectoTests() {
		assertEquals(new EnEspera(),jugador.getEstadoActual());
		jugador.prepararseParaJugar();
		jugador.getEstadoActual();
		assertEquals(new EnJuego(), jugador.getEstadoActual());
		mucama.aplicarEfectoAJugador(jugador, null, mazo, tablero);
		assertEquals(new Inmune(), jugador.getEstadoActual());
	}
}
