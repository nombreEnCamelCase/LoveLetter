package loveletter.CartasTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import loveletter.Cartas.Princesa;

import org.junit.Before;
import org.junit.Test;

public class PrincesaTests {
	private Princesa princesa;

	@Before
	public void setUp() {
		princesa = new Princesa();
	}
	
	@Test
	public void constructorTests() {
		
		assertEquals(8, princesa.getFuerza());
		assertEquals("Princesa", princesa.getNombre());
	}
	
	@Test
	public void requerirVictimaTests() {
		assertFalse(princesa.requiereVictima());
	}
	
	@Test
	public void requiereJugadorAccionadorTests() {
		assertFalse(princesa.requiereJugadorAccionador());
	}
}
