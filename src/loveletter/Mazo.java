package loveletter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import loveletter.Cartas.*;
import java.util.Collections;
import java.util.Iterator;

public class Mazo {
	
	private List<Carta> cartas = new LinkedList<Carta>();
	
	public Mazo() {
		// Aca el mazo deberia preparar las cartas necesarias para el juego. 
		// Creo que es un factory, para crear varios tipos de cartas
		// Pero como la cantidad y tipo no varia, lo dejamos fijo
		this.cartas.add(new Guardia());
		this.cartas.add(new Guardia());
		this.cartas.add(new Guardia());
		this.cartas.add(new Guardia());
		this.cartas.add(new Guardia());
		this.cartas.add(new Sacerdote());
		this.cartas.add(new Sacerdote());
		this.cartas.add(new Baron());
		this.cartas.add(new Baron());
		this.cartas.add(new Mucama());
		this.cartas.add(new Mucama());
		this.cartas.add(new Principe());
		this.cartas.add(new Principe());
		this.cartas.add(new Rey());
		this.cartas.add(new Condesa());
		this.cartas.add(new Princesa());
	}
	
	public void prepararParaJuego() {
		// Preparar el mazo significa eliminar una carta random del mazo.
		this.cartas.remove(new Random().nextInt(16));
		// Mezclo cartas
		Collections.shuffle(this.cartas);
	}
	
	public Carta retirarCarta() {
		// Retirar una carta aleatoria del mazo y devolverla.
		try {
			Iterator<Carta> iter = this.cartas.iterator();
			Carta cartaObtenida = iter.next();
			this.cartas.remove(cartaObtenida);
			return cartaObtenida;
		}catch(Exception e) {
			System.out.println("Fallo al retirar carta");
		}
		return null;

	}
	
	public int consultarCantidad() {
		return this.cartas.size();
	}
	
}
