package loveletter.CartasTests;

import static org.junit.Assert.*;

import java.net.Socket;

import org.junit.Before;
import org.junit.Test;

import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;
import loveletter.Cartas.Baron;
import loveletter.Cartas.Condesa;
import loveletter.Cartas.Guardia;
import loveletter.Cartas.Principe;
import loveletter.Cartas.Rey;
import loveletter.EstadosJugador.FueraDeRonda;

public class BaronTest {

	private Baron baron;
	private Jugador jugadorBaron, JugadorObjetivo;
	private Mazo mazo;
	private Tablero tablero = null;

	@Before
	public void setUp() {
		baron = new Baron();
		jugadorBaron = new Jugador("JugadorBaron",1);
		JugadorObjetivo = new Jugador("JugadorObjetivo", 2);
	}

	@Test
	public void aplicarEfectoAJugadorTests() {
		jugadorBaron.getMano().setManoConCartas(baron);
		JugadorObjetivo.getMano().setManoConCartas(new Guardia());
		baron.aplicarEfectoAJugador(jugadorBaron, JugadorObjetivo, mazo, tablero);
		assertEquals(new FueraDeRonda(), JugadorObjetivo.getEstadoActual());
	}

	@Test
	public void aplicarEfectoAJugador1Tests() {
		jugadorBaron.getMano().setManoConCartas(new Condesa());
		JugadorObjetivo.getMano().setManoConCartas(new Rey());
		baron.aplicarEfectoAJugador(jugadorBaron, JugadorObjetivo, mazo, tablero);
		assertEquals(new FueraDeRonda(), JugadorObjetivo.getEstadoActual());
	}

	@Test
	public void aplicarEfectoAJugador2Tests() {
		jugadorBaron.getMano().setManoConCartas(new Rey());
		JugadorObjetivo.getMano().setManoConCartas(new Condesa());
		baron.aplicarEfectoAJugador(jugadorBaron, JugadorObjetivo, mazo, tablero);
		assertEquals(new FueraDeRonda(), jugadorBaron.getEstadoActual());
	}

	@Test
	public void aplicarEfectoAJugador3Tests() {
		jugadorBaron.getMano().setManoConCartas(new Guardia());
		JugadorObjetivo.getMano().setManoConCartas(new Principe());
		baron.aplicarEfectoAJugador(jugadorBaron, JugadorObjetivo, mazo, tablero);
		assertEquals(new FueraDeRonda(), jugadorBaron.getEstadoActual());
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
