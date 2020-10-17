package loveletter.CartasTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import loveletter.Jugador;
import loveletter.Cartas.*;

import org.junit.Before;
import org.junit.Test;

public class CondesaTests {
	private Condesa condesa;
	private Rey rey;
	private Jugador jugador, contrincante;

	@Before
	public void setUp() {
		condesa = new Condesa();
		rey = new Rey();
		jugador = new Jugador("condesa");
		contrincante = new Jugador("contrincante");
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
		condesa.aplicarEfectoAJugador(jugador,contrincante);
		assertEquals(jugador.getMano().getCartaActual(), rey);
	}
}