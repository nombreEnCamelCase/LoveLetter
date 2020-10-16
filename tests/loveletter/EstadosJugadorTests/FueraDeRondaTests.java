package loveletter.EstadosJugadorTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.Estado;
import loveletter.EstadosJugador.FueraDePartida;
import loveletter.EstadosJugador.FueraDeRonda;


public class FueraDeRondaTests {

	private Estado estado;
	
	@Before
	public void setUp() {
		estado = new FueraDeRonda();

	}
	
	@Test
	public void reiniciarTest() {
		assertEquals(new EnEspera(), estado.reinciar());
	}
	
	@Test
	public void salirDePartidaTest() {
		assertEquals(new FueraDePartida(), estado.salirPartida());
	}

}
