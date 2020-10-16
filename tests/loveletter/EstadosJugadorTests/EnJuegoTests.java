package loveletter.EstadosJugadorTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.EnJuego;
import loveletter.EstadosJugador.Estado;
import loveletter.EstadosJugador.FueraDePartida;
import loveletter.EstadosJugador.FueraDeRonda;
import loveletter.EstadosJugador.Inmune;


public class EnJuegoTests {

private Estado estado;
	
	@Before
	public void setUp() {
		estado = new EnJuego();

	}
	
	@Test
	public void terminarTurnoTests() {
		assertEquals(new EnEspera(),estado.terminarTurno() );
	}
	
	@Test
	public void salirDePartidaTestS() {
		assertEquals(new FueraDePartida(), estado.salirPartida());
	}
	
	@Test
	public void perderRondaTests() {
		assertEquals(new FueraDeRonda(), estado.perderRonda());
	}
	
	@Test
	public void obtenerInmunidadTests() {
		assertEquals(new Inmune(), estado.obtenerInmunidad());
	}

}
