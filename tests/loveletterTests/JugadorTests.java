package loveletterTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.Jugador;
import loveletter.Mano;
import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.EnJuego;

public class JugadorTests {

	private Jugador jugador;
	@Before
	public void setUp() {
		jugador = new Jugador("Jugador");
	}
	
	
	@Test
	public void constructorTests() {
		
		assertEquals(0, jugador.getPuntaje());
		assertEquals("Jugador",jugador.getNombre());
		assertEquals(new Mano().getClass(), jugador.getMano().getClass());
	}
	
	@Test
	public void prepararseParaJugarTests() {
		assertEquals(new EnEspera(), jugador.getEstadoActual());
		jugador.prepararseParaJugar();
		assertEquals(new EnJuego(), jugador.getEstadoActual());
	}

}
