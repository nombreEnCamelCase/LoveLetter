package loveletter.CartasTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;
import loveletter.Cartas.Princesa;
import loveletter.EstadosJugador.FueraDeRonda;

import org.junit.Before;
import org.junit.Test;

public class PrincesaTests {
	private Princesa princesa;
	private Jugador jugador, contrincante;
	private Mazo mazo;
	private Tablero tablero=null;

	@Before
	public void setUp() {
		princesa = new Princesa();
		jugador = new Jugador("princesa",1);
		contrincante = new Jugador("contrincante",2);
	}
	
	@Test
	public void constructorTests() {
		
		assertEquals(8, princesa.getFuerza());
		assertEquals("Princesa", princesa.getNombre());
	}
	
	@Test
	public void requerirVictimaTests() {
		assertFalse(princesa.requiereVictima());
	}
	
	@Test
	public void requiereJugadorAccionadorTests() {
		assertFalse(princesa.requiereJugadorAccionador());
	}
	
	@Test
	public void aplicarEfectoAJugadorTests() {
		princesa.aplicarEfectoAJugador(jugador,contrincante, mazo, tablero);
		assertEquals(new FueraDeRonda(), jugador.getEstadoActual());
	}
}
