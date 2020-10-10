package loveletter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mano {
	private List<Carta> cartasEnMano = new LinkedList<Carta>();

	public Carta jugarCarta(Carta carta) {
		if (carta == null)
			return jugarCartaRandom();
		return carta;
	}

	public Carta descartarCarta() {
		return descartarCartaRandom();
	}

	public Carta agregarCarta(Mazo mazo) {
		Carta cartaAgregada = mazo.retirarCarta();
		this.cartasEnMano.add(cartaAgregada);
		return cartaAgregada;
	}

	public Carta getCartaActual() {
		return this.cartasEnMano.get(0);
	}

	private Carta descartarCartaRandom() {
		try {
			Iterator<Carta> iter = this.cartasEnMano.iterator();
			Carta cartaObtenida = iter.next();
			this.cartasEnMano.remove(cartaObtenida);
			return cartaObtenida;
		} catch (Exception e) {
			System.out.println("Fallo al retirar carta");
		}
		return null;
	}

	private Carta jugarCartaRandom() {
		try {
			Iterator<Carta> iter = this.cartasEnMano.iterator();
			Carta cartaObtenida = iter.next();
			this.cartasEnMano.remove(cartaObtenida);
			return cartaObtenida;
		} catch (Exception e) {
			System.out.println("Fallo al retirar carta");
		}
		return null;
	}

}
