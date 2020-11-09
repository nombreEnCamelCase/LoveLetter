package loveletter.Graphics;

import loveletter.Carta;
import loveletter.Jugador;

public class ClickeableCarta extends LayoutCarta {

	// Zona Clickeable
	private double coordXDesde;
	private double coordXHasta;
	private double coordYDesde;
	private double coordYHasta;
	private final int scaleWidth = 335;
	private final int scaleHeight = 460;

	// Las selecciones secundarias, como es seleccionar un jugador de una lista, o
	// un tipo de carta creo que deberian
	// hacerse en SWING en una ventana COMUN con BOTONES.

	public ClickeableCarta(int coordX, int coordY, double desde_x, double hasta_x, double desde_y, double hasta_y) {
		super(coordX, coordY);
		this.coordXDesde = desde_x;
		this.coordXHasta = hasta_x;
		this.coordYDesde = desde_y;
		this.coordYHasta = hasta_y;
	}

	public boolean fuiCliqueada(double x_click, double y_click) {
		
		boolean result = (x_click>=this.coordXDesde && x_click<=this.coordXHasta && y_click>=this.coordYDesde && y_click<=this.coordYHasta);
		if(this.cartaContenida != null)
			return result;
		return false;
	}

	public int getScaleWidth() {
		return this.scaleWidth;
	}

	public int getScaleHeight() {
		return this.scaleHeight;
	}

}
