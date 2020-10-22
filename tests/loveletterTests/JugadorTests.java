package loveletterTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mano;
import loveletter.Mazo;
import loveletter.Cartas.Baron;
import loveletter.Cartas.Guardia;
import loveletter.Cartas.Principe;
import loveletter.Cartas.Rey;
import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.EnJuego;

public class JugadorTests {

	private Jugador jugadorAcc;
	private Jugador jugadorObj;
	private Mazo mazo;
	ArrayList<Jugador> JugadoresDisponibles;
	
	@Before
	public void setUp() {
		jugadorAcc = new Jugador("JugadorAcc");
		jugadorObj = new Jugador("JugadorObj");
		JugadoresDisponibles = new ArrayList<Jugador>();
		JugadoresDisponibles.add(jugadorAcc);
		JugadoresDisponibles.add(jugadorObj);
		mazo = new Mazo();
	}
	
	@Test
	public void realizarJugadaTests() {
		
		jugadorAcc.getMano().setManoConCartas(new Baron());
		jugadorAcc.getMano().setManoConCartas(new Rey());
		jugadorObj.getMano().setManoConCartas(new Guardia());
		
		assertEquals(new Baron(),jugadorAcc.realizarJugada(JugadoresDisponibles, mazo));
	}
	
	@Test
	public void seleccionarVictimaTests() {
		assertEquals(new Jugador("fede").getClass(), jugadorAcc.seleccionarVictima(JugadoresDisponibles, true).getClass());
	}
	
	@Test
	public void puntajeConstruidoOKTests() {
		assertEquals(0, jugadorAcc.getPuntaje());
	}
	
	@Test
	public void nombreConstruidoOKTests() {
		assertEquals("JugadorAcc",jugadorAcc.getNombre());
	}
	
	@Test
	public void manoConstruidaOKTests() {
		assertEquals(new Mano().getClass(), jugadorAcc.getMano().getClass());
	}
	
	@Test
	public void prepararseParaJugarTests() {
		assertEquals(new EnEspera(), jugadorAcc.getEstadoActual());
		jugadorAcc.prepararseParaJugar();
		assertEquals(new EnJuego(), jugadorAcc.getEstadoActual());
	}
	
	@Test
	public void preparacionInicialTests() {
		///probamos que agregue una carta a la mano sin importar cual porq es random
		jugadorAcc.getMano().agregarCarta(mazo);
		assertEquals(new Guardia().getClass().getSuperclass(),jugadorAcc.getMano().getCartaActual().getClass().getSuperclass());
	}
	
	@Test
	public void jugarCartaActualTests() {
		jugadorAcc.getMano().setManoConCartas(new Principe());
		jugadorAcc.getMano().setManoConCartas(new Rey());
		assertEquals(new Principe(), jugadorAcc.jugarCartaRandom());
	}

}
