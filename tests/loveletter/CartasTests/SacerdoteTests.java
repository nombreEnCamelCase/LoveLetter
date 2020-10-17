package loveletter.CartasTests;

import static org.junit.Assert.*;
import loveletter.Cartas.Sacerdote;

import org.junit.Before;
import org.junit.Test;

public class SacerdoteTests {
	private Sacerdote sacerdote;

	@Before
	public void setUp() {
		sacerdote = new Sacerdote();
	}
	
	@Test
	public void constructorTests() {
		
		assertEquals(2, sacerdote.getFuerza());
		assertEquals("Sacerdote", sacerdote.getNombre());
	}
	
	@Test
	public void requerirVictimaTests() {
		assertTrue(sacerdote.requiereVictima());
	}
	
	@Test
	public void requiereJugadorAccionadorTests() {
		assertFalse(sacerdote.requiereJugadorAccionador());
	}
	
}
