package loveletter.Cartas;

import java.util.List;

import loveletter.Carta;
import loveletter.Jugador;

public class Baron extends Carta {
	
	
	public Baron() {
		this.fuerza = 3;
		this.nombre="Baron";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo) {
		int fuerzaAccionador = accionador.getMano().getCartaActual().getFuerza(),
			fuerzaObjetivo = objetivo.getMano().getCartaActual().getFuerza();
		
		// Podria ser accionador.screen
		accionador.verCartasDeMano(objetivo.getMano());
		objetivo.verCartasDeMano(accionador.getMano());
		
		if(fuerzaAccionador > fuerzaObjetivo)
			objetivo.getEstadoActual().perderRonda();
		else if(fuerzaAccionador < fuerzaObjetivo)
			accionador.getEstadoActual().perderRonda();
		
		//Empate si igualan fuerzas.
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
