package loveletterTests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.Carta;
import loveletter.Mano;
import loveletter.Cartas.*;

public class ManoTests {
	private Mano mano;
	private Guardia guardia;
	
	@Before
	public void setUp() {
		
		mano = new Mano();
		guardia = new Guardia();
	}
	
	@Test
	public void tomarGuardiaTest() {
		mano.setManoConCartas(new Guardia());
		Carta carta = mano.getCartaActual();
		assertEquals(carta.getNombre(),guardia.getNombre());
	}
	
	@Test
	public void jugarCartaTests() {
		mano.setManoConCartas(new Baron());
		mano.setManoConCartas(new Principe());
		assertEquals(new Baron(), mano.jugarCarta(null));
	}
	
	@Test
	public void tengoCiertaCartaTests() {
		mano.setManoConCartas(new Baron());
		mano.setManoConCartas(new Guardia());
		assertTrue(mano.tengoCiertaCarta(guardia));
	}
	
	@Test
	public void noTengoCiertaCartaTests() {
		mano.setManoConCartas(new Baron());
		mano.setManoConCartas(new Guardia());
		assertFalse(mano.tengoCiertaCarta(new Principe()));
	}
	
	@Test
	public void obtenerMayorFuerzaTests() {
		mano.setManoConCartas(new Principe());
		mano.setManoConCartas(new Condesa());
		assertEquals(7, mano.obtenerMayorFuerza());
	}

}
