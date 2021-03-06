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
		String cartaObjetivo = tablero.esperarSeleccionCartaObjetivo();
		//System.out.println(cartaObjetivo + " => estoy aplicando efecto");
		if(objetivo != null) {
			if( objetivo.getMano().getCartaActual().getNombre().equals(cartaObjetivo) ) {
				tablero.resultadoEfectoGuardia(accionador, objetivo, "Correcto", cartaObjetivo);
				//ver si enviar cartaObjetivo como parametro a la ventana 
				objetivo.setEstadoActual(objetivo.getEstadoActual().perderRonda());
			}
			else 
				tablero.resultadoEfectoGuardia(accionador, objetivo, "Incorrecto", cartaObjetivo);
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
