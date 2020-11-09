package loveletterTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Partida;
import loveletter.Ronda;
import loveletter.Cartas.Condesa;
import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.FueraDeRonda;

public class RondaTests {

	private Ronda ronda;
	private Partida partida;
	
	@Before
	public void setUp() {
		partida = new Partida();
		ronda = new Ronda(partida.getJugadores());
	}
	
	@Test
	public void quedaUnSoloJugadorTests() {
		ronda.getJugadoresEnJuego().get(0).setEstadoActual(new FueraDeRonda());
		ronda.getJugadoresEnJuego().get(1).setEstadoActual(new FueraDeRonda());
		ronda.getJugadoresEnJuego().get(2).setEstadoActual(new FueraDeRonda());
		assertTrue(ronda.quedaUnSoloJugador());
		
	}
	
	@Test
	public void quedaMasDeUnJugadorTests() {
		ronda.getJugadoresEnJuego().get(0).setEstadoActual(new FueraDeRonda());
		ronda.getJugadoresEnJuego().get(1).setEstadoActual(new FueraDeRonda());
		assertFalse(ronda.quedaUnSoloJugador());
		
	}
	
	@Test
	public void quedanCartasEnMazoTests() {
		assertTrue(ronda.quedanCartasEnMazo());
	}
	
	@Test
	public void jugadorPuedeJugarTests() {
		ronda.getJugadoresEnJuego().get(0).setEstadoActual(new EnEspera());
		assertTrue(ronda.jugadorPuedeJugar(ronda.getJugadoresEnJuego().get(0)));
	}
	
	@Test
	public void jugadorNOPuedeJugarTests() {
		ronda.getJugadoresEnJuego().get(0).setEstadoActual(new FueraDeRonda());
		assertFalse(ronda.jugadorPuedeJugar(ronda.getJugadoresEnJuego().get(0)));
	}
	
	@Test
	public void finalizaRonda_retornaUnJugadorGanadorTests() {
		// Arrange
		Jugador ganadorResponse;
		Jugador dummyJugador = new Jugador("Fede",1);
		
		// Act
		ganadorResponse = ronda.comenzar();
		System.out.println("El ganador de ronda es: "+ ganadorResponse.getNombre());
		// Assert
		assertEquals(dummyJugador.getClass(), ganadorResponse.getClass());
	}
	
	@Test
	public void jugadorTieneCondesaEnLaManoTests() {
		Jugador j1 = new Jugador("fede",1);
		j1.getMano().setManoConCartas(new Condesa());
		assertTrue(ronda.jugadorPoseeCondesa(j1));
		
	}
	
	

	

}
