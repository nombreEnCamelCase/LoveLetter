package loveletter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mano {
	private List<Carta> cartasEnMano = new LinkedList<Carta>();

	public Mano() {

	}

	public Mano(Carta carta) {
		cartasEnMano.add(carta);
	}

	public void setManoConCartas(Carta carta) {
		cartasEnMano.add(carta);
	}
//<<<<<<< HEAD
//	
//=======
//
//>>>>>>> master
	public Carta jugarCarta(Carta carta) {
		if (carta == null)
			return jugarCartaRandom();
		this.cartasEnMano.remove(carta);
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
		return this.cartasEnMano.listIterator().next();
	}

	public boolean tengoCiertaCarta(Carta carta) {
		for (Carta cart : this.cartasEnMano) {
			if (cart.equals(carta))
				return true;
		}
		return false;
	}

	public int obtenerMayorFuerza() {
		int max = 0;
		for (Carta cart : this.cartasEnMano) {
			if (max < cart.getFuerza())
				max = cart.getFuerza();

		}

		return max;
	}

	/// el programa deberia dejarnos elegir cual de las dos cartas en mano
	/// podemos tirar, de manera grafica. por ahora lo hicimos random
	private Carta descartarCartaRandom() {
//		Carta cartaObtenida = this.cartasEnMano.get(0);
//		this.cartasEnMano.remove(cartaObtenida);
//		return cartaObtenida;
		
		try {
			Iterator<Carta> iter = this.cartasEnMano.iterator();
			Carta cartaObtenida = iter.next();
			this.cartasEnMano.remove(cartaObtenida);
			return cartaObtenida;
		} catch (Exception e) {
			System.out.println("Fallo al retirar carta 0: "+ e);
		}
		return null;
	}

	private Carta jugarCartaRandom() {
		
//		Carta cartaObtenida = this.getCartaActual();
//		this.cartasEnMano.remove(cartaObtenida);
//		return cartaObtenida;
		
		try {
			Iterator<Carta> iter = this.cartasEnMano.iterator();
			Carta cartaObtenida = iter.next();
			this.cartasEnMano.remove(cartaObtenida);
			return cartaObtenida;
		} catch (Exception e) {
//<<<<<<< HEAD
			System.out.println("Fallo al retirar carta");//por que podria fallar?
//=======
			System.out.println("Fallo al retirar carta 1" + e);
//>>>>>>> master
		}
		return null;
	}
	
	public int cantCartas() {
		return this.cartasEnMano.size();
	}

}
