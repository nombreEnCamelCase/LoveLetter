package loveletter.Graphics;

import loveletter.Carta;
import loveletter.Jugador;

public class LayoutCarta {
	protected Carta cartaContenida = null;
	protected Jugador duenio = null;
	protected int coordX;
	protected int coordY;
	private final int coordY_head = 230;
	private final int coordX_head = 220;
	
	public LayoutCarta() {
		this.coordX = coordX_head;
		this.coordY = coordY_head;
	}
	
	public LayoutCarta(int coordX) {
		this.coordX = coordX;
		this.coordY = coordY_head;
	}

	public LayoutCarta(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public void setCartaContenida(Carta carta) {
		this.cartaContenida = carta;
	}

	public void setDuenioCarta(Jugador duenio) {
		this.duenio = duenio;
	}

	public Carta getCartaContenida() {
		return this.cartaContenida;
	}

	public Jugador getDuenio() {
		return this.duenio;
	}
	
	public int getCoordX() {
		return this.coordX;
	}

	public int getCoordY() {
		return this.coordY;
	}
}
