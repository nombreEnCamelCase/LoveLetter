package loveletter.Cartas;

import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;
import loveletter.Tablero;

public class Baron extends Carta {
	
	
	public Baron() {
		this.fuerza = 3;
		this.nombre="Baron";
		this.imgUri = "assets/cards/baron.png";
		
		try {
			this.bufferedImage = ImageIO.read(new File(imgUri));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al cargar imagen de carta.");
		}
	}

	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo, Tablero tablero) {
		int fuerzaAccionador = accionador.getMano().getCartaActual().getFuerza(),
			fuerzaObjetivo = objetivo.getMano().getCartaActual().getFuerza();
		
		// Podria ser accionador.screen
 
		
		if(fuerzaAccionador > fuerzaObjetivo) {
			objetivo.setEstadoActual(objetivo.getEstadoActual().perderRonda());
		}
		else if(fuerzaAccionador < fuerzaObjetivo)
			accionador.setEstadoActual(accionador.getEstadoActual().perderRonda());
		
		//Empate si igualan fuerzas.
		if(tablero!=null) {
			// El tablero deberia encargarse de recibir esto y saber mostrarselo a quien sea necesario.
			// En este caso como es un solo jugador, deberia ver en pantalla la mano del otro.
			tablero.mostrarEfecto(this);
		}
		// Falta mostrar las cartas a cada jugador.
		// Suponemos que a futuro existira una clase llamada Screen que mostrara lo que esta viendo en vivo el jugador

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
