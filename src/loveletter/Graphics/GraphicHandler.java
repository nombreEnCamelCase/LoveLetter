package loveletter.Graphics;

import loveletter.Jugador;
import loveletter.Screens.*;

public class GraphicHandler {

	private Jugador propietario;
	private ComponenteGrafico pantalla;
	private VentanaAlerta ventana;
	private VentanaCartas ventanaCarta;
	private VentanaGanadorRonda ventanaRonda;
	private VentanaMostrarManoContraria ventanaSacerdote;

	public GraphicHandler(Jugador owner) {
		this.propietario = owner;
		this.pantalla = new ComponenteGrafico();
	}
	
	public void setVentanaAlerta(VentanaAlerta alerta) {
		this.ventana = alerta;
	}
	
	public VentanaAlerta getVentanaAlerta() {
		return this.ventana;
	}
	
	public void setVentanaCarta(VentanaCartas vcarta) {
		this.ventanaCarta = vcarta;
	}
	
	public VentanaCartas getVentanaCartas() {
		return this.ventanaCarta;
	}
	
	public void setVentanaRonda(VentanaGanadorRonda vronda) {
		this.ventanaRonda = vronda;
	}
	
	public VentanaGanadorRonda getVentanaGanadorRonda() {
		return this.ventanaRonda;
	}
	
	public void setVentanaManoContraria(VentanaMostrarManoContraria vsacerdote) {
		this.ventanaSacerdote = vsacerdote;
	}
	
	public VentanaMostrarManoContraria getVentanaManoContraria() {
		return this.ventanaSacerdote;
	}
	
	public ComponenteGrafico getPantalla() {
		return this.pantalla;
	}
	
	public Jugador getOwner() {
		return this.propietario;
	}
	
	public void setOwner(Jugador owner) {
		this.propietario = owner;
	}

}
