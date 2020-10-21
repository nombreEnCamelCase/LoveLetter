package loveletter.Cartas;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Mazo;

public class Principe extends Carta {
	
	public Principe() {
		this.fuerza = 5;
		this.nombre="Principe";
	}
	
	@Override
	public void aplicarEfectoAJugador(Jugador accionador, Jugador objetivo, Mazo mazo) {
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
