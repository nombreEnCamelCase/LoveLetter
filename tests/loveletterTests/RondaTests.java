package loveletterTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.Jugador;
import loveletter.Partida;
import loveletter.Ronda;

public class RondaTests {

	private Ronda ronda;
	private Partida partida;
	
	@Before
	public void setUp() {
		partida = new Partida();
		ronda = new Ronda(partida.getJugadores());
		
	}
	
	
	@Test
	public void retornaUnJugadorGanadorTests() {
		assertEquals(new Jugador("Fede").getClass(), ronda.comenzar());
	}
	
	@Test
	public void jugadorPuedeJugarTests() {
		assertTrue(ronda.jugadorPuedeJugar(ronda.getJugadoresEnJuego().get(0)));
	}

	

}
