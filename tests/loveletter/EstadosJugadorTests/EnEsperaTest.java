package loveletter.EstadosJugadorTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.EnJuego;
import loveletter.EstadosJugador.Estado;
import loveletter.EstadosJugador.FueraDePartida;
import loveletter.EstadosJugador.FueraDeRonda;


public class EnEsperaTest {

private Estado estado;
	
	@Before
	public void setUp() {
		estado = new EnEspera();

	}
	
	@Test
	public void salirDePartidaTest() {
		assertEquals(new FueraDePartida(), estado.salirPartida());
	}
	
	@Test
	public void perderRondaTests() {
		assertEquals(new FueraDeRonda(), estado.perderRonda());
	}
	
	@Test
	public void comenzarJuegoTests() {
		assertEquals(new EnJuego(),estado.comenzarTurno());
	}

}
