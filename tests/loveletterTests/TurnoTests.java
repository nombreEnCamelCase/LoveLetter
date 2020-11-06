package loveletterTests;

import static org.junit.Assert.*;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Partida;
import loveletter.Ronda;
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
		turno = new Turno(jugador);	
	}

	@Test
	public void turnoTest() {
		assertEquals(jugador, turno.getResponsable());
	}

	@Test
	public void setCartaJugadaTest() {
		assertEquals(null, turno.getCartaJugada());
	}
	

}
