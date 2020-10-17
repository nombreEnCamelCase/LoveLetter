package loveletter.CartasTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import loveletter.Jugador;
import loveletter.Cartas.Baron;

public class BaronTest {

	private Baron baron;
	private Jugador jugadorBaron, jugadorGuardia;
	
	@Before
	public void setUp() {
		baron = new Baron();
		do {
			jugadorBaron = new Jugador("j1");
		}while(jugadorBaron.getMano().getCartaActual()=="Baron");
	}
	
	@Test
	public void aplicarEfectoAJugador() {
		assertEquals(new)
		assertTrue(baron.requiereVictima());		
	}
	

	@Test
	public void requiereVictimaTest() {
		assertTrue(baron.requiereVictima());		
	}
	
	@Test
	public void requiereJugadorAccionador() {
		assertFalse(baron.requiereJugadorAccionador());		
	}

}
