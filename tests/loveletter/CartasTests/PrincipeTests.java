package loveletter.CartasTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import loveletter.Jugador;
import loveletter.Cartas.Princesa;
import loveletter.Cartas.Principe;
import loveletter.EstadosJugador.FueraDeRonda;

import org.junit.Before;
import org.junit.Test;

public class PrincipeTests {
	private Principe principe;
	private Jugador jugador, contrincante;

	@Before
	public void setUp() {
		principe = new Principe();
		jugador = new Jugador("condesa");
		contrincante = new Jugador("contrincante");
	}
	
	@Test
	public void constructorTests() {
		
		assertEquals(5, principe.getFuerza());
		assertEquals("Principe", principe.getNombre());
	}
	
	@Test
	public void requerirVictimaTests() {
		assertTrue(principe.requiereVictima());
	}
	
	@Test
	public void requiereJugadorAccionadorTests() {
		assertTrue(principe.requiereJugadorAccionador());
	}
	
	@Test
	public void aplicarEfectoAJugadorTests() {
		jugador.getMano().setManoConCartas(new Principe());
		contrincante.getMano().setManoConCartas(new Princesa());
		principe.aplicarEfectoAJugador(jugador,contrincante);
		assertEquals(new FueraDeRonda(), contrincante.getEstadoActual());
	}
	
}
