package loveletter.CartasTests;

import static org.junit.Assert.*;

import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;
import loveletter.Cartas.Baron;
import loveletter.Cartas.Rey;
import loveletter.Cartas.Sacerdote;

import org.junit.Before;
import org.junit.Test;

public class ReyTests {
	private Rey rey;
	private Jugador jugador;
	private Jugador contrincante;
	private Mazo mazo;
	private Tablero tablero=null;

	@Before
	public void setUp() {
		rey = new Rey();
		jugador = new Jugador("jugador",1);
		contrincante = new Jugador("contrincante",2);
		mazo = new Mazo();
	}
	
	@Test
	public void aplicarEfectoTests() {
		jugador.getMano().setManoConCartas(new Baron());
		contrincante.getMano().setManoConCartas(new Sacerdote());
		rey.aplicarEfectoAJugador(jugador, contrincante, mazo, tablero);
		assertEquals(new Baron(), contrincante.getMano().getCartaActual());
		assertEquals(new Sacerdote(), jugador.getMano().getCartaActual());
	}
	
	@Test
	public void constructorTests() {
		
		assertEquals(6, rey.getFuerza());
		assertEquals("Rey", rey.getNombre());
	}
	
	@Test
	public void requerirVictimaTests() {
		assertTrue(rey.requiereVictima());
	}
	
	@Test
	public void requiereJugadorAccionadorTests() {
		assertFalse(rey.requiereJugadorAccionador());
	}
}
