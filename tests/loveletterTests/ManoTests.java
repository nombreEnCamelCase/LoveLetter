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

}
