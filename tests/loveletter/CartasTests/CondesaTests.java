package loveletter.CartasTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.net.Socket;

import loveletter.Jugador;
import loveletter.Cartas.*;
import loveletter.Mazo;
import loveletter.Tablero;

import org.junit.Before;
import org.junit.Test;

public class CondesaTests {
	private Condesa condesa;
	private Rey rey;
	private Jugador jugador, contrincante;
	private Mazo mazo;
	private Tablero tablero = null;

	@Before
	public void setUp() {
		condesa = new Condesa();
		rey = new Rey();

		jugador = new Jugador("condesa", 1);
		contrincante = new Jugador("contrincante", 2);

	}

	@Test
	public void constructorTests() {

		assertEquals(7, condesa.getFuerza());
		assertEquals("Condesa", condesa.getNombre());
	}

	@Test
	public void requerirVictimaTests() {
		assertFalse(condesa.requiereVictima());
	}

	@Test
	public void requiereJugadorAccionadorTests() {
		assertFalse(condesa.requiereJugadorAccionador());
	}

	@Test
	public void aplicarEfectoAJugadorTests() {
		jugador.getMano().setManoConCartas(rey);
		jugador.getMano().setManoConCartas(condesa);
		condesa.aplicarEfectoAJugador(jugador, contrincante, mazo, tablero);
		assertEquals(jugador.getMano().getCartaActual(), rey);
	}
}
