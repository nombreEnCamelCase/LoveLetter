package loveletter.CartasTests;

import static org.junit.Assert.*;
import loveletter.Cartas.Rey;

import org.junit.Before;
import org.junit.Test;

public class ReyTests {
	private Rey rey;

	@Before
	public void setUp() {
		rey = new Rey();
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
