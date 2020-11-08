package loveletter.Cartas;

import java.io.File;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;

public class Principe extends Carta {
	
	public Principe() {
		this.fuerza = 5;
		this.nombre="Principe";
		this.imgUri = "assets/cards/principe.png";
		
		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
		Carta cartaDescartada = objetivo.getMano().descartarCarta();
		if(cartaDescartada.getNombre() == "Princesa") 
			objetivo.setEstadoActual(objetivo.getEstadoActual().perderRonda());
		else
			objetivo.getMano().agregarCarta(mazo);
	}
	
	@Override
	public boolean requiereVictima() {
		return true;
	}
	
	@Override
	public boolean requiereJugadorAccionador() {
		return true;
	}
}
