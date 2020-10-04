package loveletter;

import java.util.ArrayList;

public class Mazo {

	private int cantidad;
	private ArrayList<Carta> carta;

	public Mazo() {
		carta.add(new Baron());
		carta.add(new Baron());
		carta.add(new Sacerdote());
		carta.add(new Sacerdote());
		carta.add(new Mucama());
		carta.add(new Mucama());
		carta.add(new Principe());
		carta.add(new Rey());
		carta.add(new Condesa());
		carta.add(new Princesa());
		carta.add(new Guardia());
		carta.add(new Guardia());
		carta.add(new Guardia());
		carta.add(new Guardia());
		carta.add(new Guardia());

	}

}
