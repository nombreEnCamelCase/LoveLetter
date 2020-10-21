package loveletterTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mano;
import loveletter.Mazo;
import loveletter.Cartas.Guardia;
import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.EnJuego;

public class JugadorTests {

	private Jugador jugador;
	private Mazo mazo;
	@Before
	public void setUp() {
		jugador = new Jugador("Jugador");
		mazo = new Mazo();
	}
	
	@Test
	public void puntajeConstruidoOKTests() {
		assertEquals(0, jugador.getPuntaje());
	}
	
	@Test
	public void nombreConstruidoOKTests() {
		assertEquals("Jugador",jugador.getNombre());
	}
	
	@Test
	public void manoConstruidaOKTests() {
		assertEquals(new Mano().getClass(), jugador.getMano().getClass());
	}
	
	@Test
	public void prepararseParaJugarTests() {
		assertEquals(new EnEspera(), jugador.getEstadoActual());
		jugador.prepararseParaJugar();
		assertEquals(new EnJuego(), jugador.getEstadoActual());
	}
	
	@Test
	public void preparacionInicialTests() {
		///probamos que agregue una carta a la mano sin importar cual porq es random
		jugador.getMano().agregarCarta(mazo);
		assertEquals(new Guardia().getClass().getSuperclass(),jugador.getMano().getCartaActual().getClass().getSuperclass());
	}

}
