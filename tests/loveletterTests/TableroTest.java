package loveletterTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import loveletter.Jugador;
import loveletter.Turno;

public class TableroTest {
	int tamanioLista,tamaniovacio;
	
	@Before
	public void setUp() {
		Jugador jugador1= new Jugador("nombre1");
		Jugador jugador2= new Jugador("nombre2");
		
		List<Turno> listadeTurnos = new LinkedList<Turno>();
		List<Turno> listaVacia= new LinkedList<Turno>();
		Turno turno= new Turno(jugador1);
		Turno turno2= new Turno(jugador2);
		listadeTurnos.add(turno);
		listadeTurnos.add(turno2);
		tamaniovacio=listaVacia.size();
		tamanioLista=listadeTurnos.size();
	}
	
	@Test
	public void addTurnoPasadoTest() {
		
		assertEquals(2, tamanioLista);
		assertEquals(0,tamaniovacio);
		
	}

}
