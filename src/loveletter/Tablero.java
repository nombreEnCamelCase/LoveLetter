package loveletter;

import java.util.LinkedList;
import java.util.List;

public class Tablero {
	private List<Turno> historialTurnosPasados = new LinkedList<Turno>();
	
	public Tablero() {
		
	}
	
	public void refrescarTablero() {
		// TODO Logica para mostrar el tablero actual con respecto a los turnos pasados.
	}
	
	public void addTurnoPasado(Turno turno) {
		this.historialTurnosPasados.add(turno);
	}
}
