package loveletter.CartasTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import loveletter.Jugador;
import loveletter.Cartas.Guardia;

import org.junit.Before;
import org.junit.Test;

public class GuardiaTests {

	private Guardia guardia;
	private Jugador jugador;

	@Before
	public void setUp() {
		guardia = new Guardia();
		jugador = new Jugador("guardia");
	}
	
	@Test
	public void constructorTests() {
		
		assertEquals(1, guardia.getFuerza());
		assertEquals("Guardia", guardia.getNombre());
	}
	
	@Test
	public void requerirVictimaTests() {
		assertTrue(guardia.requiereVictima());
	}
	
	@Test
	public void requiereJugadorAccionadorTests() {
		assertFalse(guardia.requiereJugadorAccionador());
	}
	
}
