package loveletter.EstadosJugadorTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.EstadosJugador.EnJuego;
import loveletter.EstadosJugador.Estado;
import loveletter.EstadosJugador.FueraDePartida;
import loveletter.EstadosJugador.FueraDeRonda;
import loveletter.EstadosJugador.Inmune;



public class InmuneTest {

	private Estado estado;
	
	@Before
	public void setUp() {
		estado = new Inmune();

	}
	
	@Test
	public void salirDePartidaTest() {
		assertEquals(new FueraDePartida(), estado.salirPartida());
	}
	
	@Test
	public void perderRondaTest() {
		assertEquals(new FueraDeRonda(), estado.perderRonda());
	}
	
	@Test
	public void comenzarTurnoTest() {
		assertEquals(new EnJuego(), estado.comenzarTurno());
	}

}
