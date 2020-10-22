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

	@Before
	public void setUp() {

		mazo = new Mazo();
	}

	@Test
	public void elMazoTieneGuardiaTests() {
		assertEquals(true, mazo.getMazo().contains(new Guardia()));
	}

	@Test
	public void elMazoTieneBaronTests() {
		assertEquals(true, mazo.getMazo().contains(new Baron()));
	}

	@Test
	public void elMazoTieneSacerdoteTests() {
		assertEquals(true, mazo.getMazo().contains(new Sacerdote()));
	}

	@Test
	public void elMazoTieneMucamaaTests() {
		assertEquals(true, mazo.getMazo().contains(new Mucama()));
	}

	@Test
	public void elMazoTienePrincipeTests() {
		assertEquals(true, mazo.getMazo().contains(new Principe()));
	}

	@Test
	public void elMazoTieneCondesaTests() {
		assertEquals(true, mazo.getMazo().contains(new Condesa()));
	}

	@Test
	public void elMazoTieneReyTests() {
		assertEquals(true, mazo.getMazo().contains(new Rey()));
	}

	@Test
	public void elMazoTienePrincesaTests() {
		assertEquals(true, mazo.getMazo().contains(new Princesa()));
	}

	@Test
	public void consultarCantidadDeMazoTestS() {
		assertEquals(16,mazo.getMazo().size());
	}

	@Test
	public void retirarCartaTest() {
		assertEquals(new Princesa().getClass().getSuperclass(), mazo.retirarCarta().getClass().getSuperclass());
		assertEquals(15, mazo.getMazo().size());
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
