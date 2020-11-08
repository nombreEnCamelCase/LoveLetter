package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Mazo;
import loveletter.Tablero;
import loveletter.Jugador;

public class Guardia extends Carta {
	
	public Guardia() {
		this.fuerza = 1;
		this.nombre="Guardia";
		this.imgUri = "assets/cards/guardia.png";
		
		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}
	
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
		Carta carta = new Baron(); ///simulo q el accionador intenta adivinar q tiene baron en la mano
		if(carta == objetivo.getMano().getCartaActual()) {
			objetivo.setEstadoActual(objetivo.getEstadoActual().perderRonda());
		}
	}
	
	@Override
	public boolean requiereVictima() {
		return true;
	}
	
	@Override
	public boolean requiereJugadorAccionador() {
		return false;
	}
	
}
