package loveletter.Graphics;

import loveletter.Carta;
import loveletter.Jugador;

public class ClickeableCarta extends LayoutCarta {

	// Zona Clickeable
	private double coordXDesde;
	private double coordXHasta;
	private double coordYDesde;
	private double coordYHasta;

	// Ubicacion en eje X de las cartas de mano izq y der.
	// Ubicion en eje Y de ambas cartas.
	private static final int coordX_head_izq = 1000;
	private static final int coordX_head_der = 1350;
	private static final int coordY_head = 550;
	private static final int scaleWidth = 335;
	private static final int scaleHeight = 460;

	// Las selecciones secundarias, como es seleccionar un jugador de una lista, o
	// un tipo de carta creo que deberian
	// hacerse en SWING en una ventana COMUN con BOTONES.

	public ClickeableCarta(int nroCartaMano) {
		super((nroCartaMano == 1) ? coordX_head_izq : coordX_head_der, coordY_head);
		if (nroCartaMano == 1) {
			this.coordXDesde = 0.53;
			this.coordXHasta = 0.69;
			this.coordYDesde = 1.02;
			this.coordYHasta = 1.84;
		} else {
			this.coordXDesde = 0.70;
			this.coordXHasta = 0.87;
			this.coordYDesde = 1.02;
			this.coordYHasta = 1.84;
		}

	}

	public ClickeableCarta(int coordX, int coordY, double desde_x, double hasta_x, double desde_y, double hasta_y) {
		super(coordX, coordY);
		this.coordXDesde = desde_x;
		this.coordXHasta = hasta_x;
		this.coordYDesde = desde_y;
		this.coordYHasta = hasta_y;
	}

	public boolean fuiCliqueada(double x_click, double y_click) {

		boolean result = (x_click >= this.coordXDesde && x_click <= this.coordXHasta && y_click >= this.coordYDesde
				&& y_click <= this.coordYHasta);
		if (this.cartaContenida != null)
			return result;
		return false;
	}

	public int getScaleWidth() {
		return ClickeableCarta.scaleWidth;
	}

	public int getScaleHeight() {
		return ClickeableCarta.scaleHeight;
	}

	public int getCoordX_head_der() {
		return ClickeableCarta.coordX_head_der;
	}

	public int getCoordX_head_izq() {
		return ClickeableCarta.coordX_head_izq;
	}

	public int getCoordY_head() {
		return ClickeableCarta.coordY_head;
	}

}
