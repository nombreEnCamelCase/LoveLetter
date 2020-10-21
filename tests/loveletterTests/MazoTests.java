package loveletterTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loveletter.Carta;
import loveletter.Mazo;
import loveletter.Cartas.Baron;
import loveletter.Cartas.Condesa;
import loveletter.Cartas.Guardia;
import loveletter.Cartas.Mucama;
import loveletter.Cartas.Princesa;
import loveletter.Cartas.Principe;
import loveletter.Cartas.Rey;
import loveletter.Cartas.Sacerdote;

public class MazoTests {

	private Mazo mazo;
	//private Guardia guardia;
	
	@Before
	public void setUp() {
		
		mazo = new Mazo();
		//guardia = new Guardia();
	}
	
	@Test
	public void constructorTest() {
		assertEquals(true,mazo.getMazo().contains(new Guardia()));
		assertEquals(true,mazo.getMazo().contains(new Baron()));
		assertEquals(true,mazo.getMazo().contains(new Sacerdote()));
		assertEquals(true,mazo.getMazo().contains(new Mucama()));
		assertEquals(true,mazo.getMazo().contains(new Principe()));
		assertEquals(true,mazo.getMazo().contains(new Condesa()));
		assertEquals(true,mazo.getMazo().contains(new Rey()));
		assertEquals(true,mazo.getMazo().contains(new Princesa()));
	
		assertEquals(16,mazo.getMazo().size());
		
	}
	
	@Test
	public void retirarCartaTest() {
		assertEquals(16,mazo.getMazo().size());
		assertEquals(new Princesa().getClass().getSuperclass(), mazo.retirarCarta().getClass().getSuperclass());
		assertEquals(15,mazo.getMazo().size());
		assertEquals(new Princesa().getClass().getSuperclass(), mazo.retirarCarta().getClass().getSuperclass());
		assertEquals(14,mazo.getMazo().size());
		assertEquals(new Princesa().getClass().getSuperclass(), mazo.retirarCarta().getClass().getSuperclass());
		assertEquals(13,mazo.getMazo().size());
		assertEquals(new Princesa().getClass().getSuperclass(), mazo.retirarCarta().getClass().getSuperclass());
		assertEquals(12,mazo.getMazo().size());
	}
	
	@Test
	public void consultarCantidadTests() {
		assertEquals(mazo.getMazo().size(), mazo.consultarCantidad());
	}
	
	@Test
	public void prepararParaJuegoTests() {
		mazo.prepararParaJuego();
		assertEquals(15, mazo.getMazo().size());
	}
}
