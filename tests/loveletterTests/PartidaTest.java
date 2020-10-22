package loveletterTests;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import loveletter.Jugador;
import loveletter.Partida;


public class PartidaTest {
	
	private Partida partida;
	
	@Test
	public void finalizaPartida_retornaUnJugadorGanadorTests() {
		// Arrange
		Jugador ganadorResponse;
		Jugador dummyJugador = new Jugador("Fede");
		partida = new Partida();
		
		// Act
		ganadorResponse = partida.comenzarJuego();
		
		// Assert
		assertEquals(dummyJugador.getClass(), ganadorResponse.getClass());
	}
	
	@Test
	public void tablaPuntajeConGanador_encuentraGanadorPorPuntaje() {
		// Arrange
		partida = new Partida();
		Jugador jugador1 = new Jugador("Maty");
		Jugador jugador2 = new Jugador("Fede");
		Jugador ganadorPartida;
		Map<Jugador, Integer> tablaPuntaje = new HashMap<Jugador, Integer>();
		tablaPuntaje.put(jugador1, 2);
		tablaPuntaje.put(jugador2, 5);
		partida.setTablaPuntaje(tablaPuntaje);
		
		// Act
		ganadorPartida = partida.buscarganadorDePartidaDePartida();
		
		// Assert
		assertEquals(ganadorPartida.getNombre(), jugador2.getNombre());
	}
	
	@Test
	public void tablaPuntajeConJugadores_sumaPuntajeAUno() {
		// Arrange
		partida = new Partida();
		Jugador jugador1 = new Jugador("Maty");
		Jugador jugador2 = new Jugador("Fede");
		Map<Jugador, Integer> tablaPuntaje = new HashMap<Jugador, Integer>();
		tablaPuntaje.put(jugador1, 2);
		tablaPuntaje.put(jugador2, 4);
		partida.setTablaPuntaje(tablaPuntaje);
		
		// Act
		partida.sumarPuntaje(jugador1);
		
		// Assert
		assertEquals(3, partida.obtenerPuntajeDeJugador(jugador1),0);
	}
	
}
