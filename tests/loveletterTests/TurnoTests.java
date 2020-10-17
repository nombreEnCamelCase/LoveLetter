package loveletterTests;
import static org.junit.Assert.*;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Turno;
import loveletter.Cartas.Guardia;

import org.junit.Before;
import org.junit.Test;

public class TurnoTests {
	private Turno turno;
	private Jugador jugador;
	
	@Before
	public void setUp() {
		jugador = new Jugador("nombre de jugador");
		turno = new  Turno(jugador);
	}
	
	@Test
	public void puedeJugarTest() {
		assertTrue(turno.jugadorPuedeJugar());
	}
	
	@Test
	public void noPuedeJugarTest() {
		jugador.setEstadoActual(jugador.getEstadoActual().perderRonda());
		assertFalse(turno.jugadorPuedeJugar());
	}
	
}
