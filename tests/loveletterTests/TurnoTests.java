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
		turno = new Turno(jugador);
	}

	// 1)PUEDO PROBAR SI EN VERDAD LE PASO JUGADOR Y CARTA
	// 2)PRUEBO SI RESPONSABLE TOMA BIEN EL JUGADOR
	// 3)PRUEBO SI CARTA JUGADA TOMA BIEN LA CARTA
	
	@Test
	public void turnoTest() {
		assertEquals(jugador,turno.getResponsable());
	}
	
	@Test
	public void setCartaJugadaTest() {
		
		assertEquals(null,turno.getCartaJugada());
		
	}
}
